package com.henry.noticiero.service;

import com.henry.noticiero.model.Writer;
import com.henry.noticiero.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class WriterService {

    @Autowired
    private WriterRepository writerRepository;


    public List<Writer> getWriters(){
        return writerRepository.findAll();
    }

    public Writer addWriter(Writer writer){
        return writerRepository.save(writer);
    }

    public Writer getWriter(Integer id){
        return writerRepository.findById(id).orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public Writer putWriter(Writer escritor){
        Writer writer = writerRepository.findById(escritor.getId()).orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        Writer editWriter = new Writer();

        editWriter.setId(writer.getId());

        if(escritor.getNombre() != null){
            editWriter.setNombre(escritor.getNombre());
        }
        else{
            editWriter.setNombre(escritor.getNombre());
        }
        if(escritor.getApellido() != null){
            editWriter.setApellido(escritor.getApellido());
        }
        else{
            editWriter.setApellido(escritor.getApellido());
        }
        if(escritor.getDni() != null){
            editWriter.setDni(escritor.getDni());
        }
        else{
            editWriter.setDni(escritor.getDni());
        }
        return writerRepository.save(editWriter);
    }

    public void deleteWriter(Integer id){
        writerRepository.deleteById(id);
    }
}
