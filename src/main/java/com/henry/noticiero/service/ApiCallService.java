package com.henry.noticiero.service;

import com.google.gson.Gson;
import com.henry.noticiero.model.response.ApiWeatherResponse;
import com.henry.noticiero.model.response.Location;
import com.henry.noticiero.model.response.Main;
import com.henry.noticiero.model.response.OpenWeatherResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

@Service
@Slf4j
public class ApiCallService {

 private static final HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

 @CircuitBreaker(name = "ApiWeather",fallbackMethod = "fallback")
 public ApiWeatherResponse callApi() throws IOException, InterruptedException{

  HttpRequest request =
          HttpRequest.newBuilder().uri(URI.create("http://api.weatherapi.com/v1/current.json?key=7fd1ee64905c60d78c9056bc4e75a2a4&q=Tucuman&aqi=no"))
          .method("GET", HttpRequest.BodyPublishers.noBody()).build();

     HttpResponse<String> response =
             HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
     System.out.println(response.body());

    final ApiWeatherResponse apiWeatherResponse = new Gson().fromJson(response.body(), ApiWeatherResponse.class);
    System.out.println(apiWeatherResponse);

    if(RandomUtils.nextBoolean()){
     throw new IOException("Probando el Circuit Breaker...");
    }

    return apiWeatherResponse;
 }

 private ApiWeatherResponse fallback(final Throwable throwable) throws IOException, InterruptedException{
  log.error(throwable.getStackTrace().toString());

  return ApiWeatherResponse.builder().build();
 }

 @CircuitBreaker(name = "ApiWeather2", fallbackMethod = "fallback2")
 public OpenWeatherResponse callAPI2() throws IOException, InterruptedException{
  HttpRequest request2 = HttpRequest.newBuilder().uri(URI.create("http://api.openweathermap.org/data/2.5/weather?q=tucuman&appid=9b762556d929ff8d3744efa88935e955"))
  .method("GET", HttpRequest.BodyPublishers.noBody()).build();

  HttpResponse<String> response2 = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());
  System.out.println(response2.body());

  final OpenWeatherResponse openWeatherResponse = new Gson().fromJson(response2.body(), OpenWeatherResponse.class);

  if(RandomUtils.nextBoolean()){
   throw new IOException("Probando Circuit Breaker...");
  }
  System.out.println(openWeatherResponse);

  return openWeatherResponse;
 }

 private OpenWeatherResponse fallback2(final Throwable throwable){
  log.error(throwable.getStackTrace().toString());
  Main main = new Main(0d,0d,0d,0d, (double) 0,0);
  return OpenWeatherResponse
          .builder()
          .main(main)
          .name("Se cayeron las dos APIs")
          .build();
 }
}
