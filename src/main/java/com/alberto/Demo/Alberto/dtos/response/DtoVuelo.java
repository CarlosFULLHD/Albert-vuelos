package com.alberto.Demo.Alberto.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
public class DtoVuelo implements Serializable {

    private String origen;
    private String destino;
    private BigDecimal precio;
    private Integer numeroDeEscalas;
    private String compania;




}
