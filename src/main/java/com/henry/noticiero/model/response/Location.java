package com.henry.noticiero.model.response;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Location {

    @SerializedName("name")
    private String name;

    @SerializedName("region")
    private String region;

    @SerializedName("country")
    private String country;

    @SerializedName("lat")
    private Double lat;

    @SerializedName("lon")
    private Double lon;

    @SerializedName("tz_id")
    private String tzId;

    @SerializedName("localtime_epoch")
    private Integer localtimeEpoch;

    @SerializedName("localtime")
    private Integer localtime;
}
