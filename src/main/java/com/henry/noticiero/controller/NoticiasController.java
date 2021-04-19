package com.henry.noticiero.controller;

import com.henry.noticiero.model.Noticias;
import com.henry.noticiero.model.PaginationResponse;
import com.henry.noticiero.service.NoticiasService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/noticias")
public class NoticiasController {

    private NoticiasService noticiasService;


    @PostMapping
    @Operation(summary = "Dar de alta la noticia")
    public String addNoticia(@RequestBody Noticias noticia) {
        Noticias postNoticia = noticiasService.addNoticia(noticia);
        return ("Noticia creada: " + postNoticia);
    }

    @GetMapping
    @Operation(summary = "Lista de noticias paginadas")
    public PaginationResponse<Noticias> getAll(@RequestParam(value = "size", defaultValue = "20") Integer size,
                                               @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return noticiasService.getAll(page, size);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar la noticia por su id")
    public String deleteNoticia(@PathVariable Integer id){
        noticiasService.deleteWrite(id);
        return("Noticia borrada con el id: "+ id);
    }
}