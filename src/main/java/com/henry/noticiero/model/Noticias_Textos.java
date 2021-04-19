package com.henry.noticiero.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity(name = "TextosNoticias")
public class Noticias_Textos {
    private String texto;

    public NoticiasEnum noticiasEnum(){
        return NoticiasEnum.TEXTO;
    }
}
