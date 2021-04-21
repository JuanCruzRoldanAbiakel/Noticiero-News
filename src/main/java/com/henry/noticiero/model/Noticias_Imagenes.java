package com.henry.noticiero.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity(name = "ImagenesNoticias")
public class Noticias_Imagenes extends Noticias {

    @ElementCollection
    private List<String> urlImagenes;

    @Override
    public NoticiasEnum noticiasEnum(){
        return NoticiasEnum.IMAGENES;
    }
}
