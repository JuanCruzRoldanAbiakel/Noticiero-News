package com.henry.noticiero.model;

public enum NoticiasEnum {

    VIDEO("VideosNoticias"),
    IMAGENES("ImagenesNoticias"),
    TEXTO("TextosNoticias");

    private String descripcion;

    NoticiasEnum(String descripcion){
        this.descripcion = descripcion;
    }

    public static NoticiasEnum find(String valor){
        for(NoticiasEnum noticiasEnum : values()){
            if(noticiasEnum.toString().equalsIgnoreCase(valor)){
                return noticiasEnum;
            }
        }
        throw new IllegalArgumentException(String.format("NoticiasType invalida: %s" , valor));
    }
}
