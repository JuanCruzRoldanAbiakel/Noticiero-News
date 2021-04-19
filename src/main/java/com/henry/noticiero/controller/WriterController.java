package com.henry.noticiero.controller;

import com.henry.noticiero.converter.WriterToWriterDTOConverter;
import com.henry.noticiero.model.Writer;
import com.henry.noticiero.model.dto.WriterDTO;
import com.henry.noticiero.service.WriterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/writer")
public class WriterController {

    @Autowired
    private WriterService writerService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private WriterToWriterDTOConverter writerToWriterDTOConverter;

    @GetMapping
    @Operation(summary = "Lista de Escritores")

    public List<Writer> getWriters(){
        return writerService.getWriters();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Consultar escritor por su ID")
    public Writer getWriter(@PathVariable Integer id){
        return writerService.getWriter(id);
    }

    @GetMapping("/writerDTO/{id}")
    @Operation(summary = "Consulta de escritorDTO por su ID")
    public WriterDTO getWriterDTO(@PathVariable Integer id){
        return conversionService.convert(writerService.getWriter(id), WriterDTO.class);
    }

    @DeleteMapping("/{id")
    @Operation(summary = "Eliminar a un escritor por el id")
    public String deleteWrite(@PathVariable Integer id){
        writerService.deleteWriter(id);
        return ("Escritor borrado con el id: " + id);
    }


}
