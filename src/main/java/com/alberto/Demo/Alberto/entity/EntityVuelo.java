package com.alberto.Demo.Alberto.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vuelos")
public class EntityVuelo {
    // origen, destino, precio, número de escalas, compañía.

    @Id
    @Column(name = "id_vuelos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origen")
    private String origen;

    @Column(name = "destino")
    private String destino;

    @Column(name = "precio")
    private BigDecimal precio;
    //100.4568765487

    @Column(name = "numero_de_escalas")
    private Integer numeroDeEscalas;

    @Column(name = "compania")
    private String compania;

}
