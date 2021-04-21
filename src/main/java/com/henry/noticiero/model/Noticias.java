package com.henry.noticiero.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "noticiasEnum")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Noticias_Videos.class, name = "VIDEO"),
        @JsonSubTypes.Type(value = Noticias_Imagenes.class, name = "IAMGENES"),
        @JsonSubTypes.Type(value = Noticias_Textos.class, name = "TEXTOS")
        })
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Noticias implements Serializable {
    @Id
    private Integer id;
    private String titulo;
    private String descripcion;

    @AccessType(AccessType.Type.PROPERTY)
    public abstract NoticiasEnum noticiasEnum();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "writer_id")
    private Writer escritorDueño;

}
