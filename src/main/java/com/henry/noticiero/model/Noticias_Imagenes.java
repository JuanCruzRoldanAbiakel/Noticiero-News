package com.henry.noticiero.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity(name = "ImagenesNoticias")
public class Noticias_Imagenes {

    private List<String> urlImagenes;

    public NoticiasEnum noticiasEnum(){
        return NoticiasEnum.IMAGENES;
    }
}
