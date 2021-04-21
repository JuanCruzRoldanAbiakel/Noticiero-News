package com.henry.noticiero.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity(name = "VideosNoticias")
public class Noticias_Videos extends Noticias {
    private String tituloVideo;
    private String descripcionVideo;
    private String urlVideos;

    @Override
    public NoticiasEnum noticiasEnum(){
        return NoticiasEnum.VIDEO;
    }
}
