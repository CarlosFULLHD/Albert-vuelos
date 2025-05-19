package com.alberto.Demo.Alberto.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class GlobalResponse implements Serializable {

    // "vuelo obtenido con exito"
    // "10010"
    // ruta
    // hora del endpoint
    // objeto data
    private String mensaje;
    private Integer estado;
    private String ruta;
    private LocalDateTime hora;
    private Object data;

    public GlobalResponse(String mensaje, Integer estado, String ruta, Object data) {
        this.mensaje = mensaje;
        this.estado = estado;
        this.ruta = ruta;
        this.hora = LocalDateTime.now();
        this.data = data;
    }



}
