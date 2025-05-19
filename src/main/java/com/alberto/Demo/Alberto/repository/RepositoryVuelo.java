package com.alberto.Demo.Alberto.repository;

import com.alberto.Demo.Alberto.entity.EntityVuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryVuelo extends JpaRepository<EntityVuelo, Long> {
    // CrudRepository Basico
    // JpaRepository Completo
    // PaginationAndSortingRepository


    //Métodos específicos:
    //Dar de baja todos los vuelos a un destino determinado.
    @Query("DELETE FROM EntityVuelo vuelo WHERE vuelo.destino = :destino")
    void deleteByDestino(@Param("destino") EntityVuelo destino);


    //Búsqueda de vuelos, pudiendo filtrar por origen, destino y número de escalas.
    @Query("SELECT vuelo FROM EntityVuelo vuelo WHERE " +
            "vuelo.origen = :origen AND" +
            " vuelo.destino = :destino AND" +
            " vuelo.numeroDeEscalas =:numero_de_escalas")
    List<EntityVuelo> vueloOrigenDestinoNumEscalas (
        @Param("origen") String origen,
        @Param("destino") String destino,
        @Param("numero_de_escalas") Integer numero_de_escalas);

    // ?origen=Madrid&destino=Valencia&numero_de_escalas=2
    // numero_de_escalas
    // numeroDeEscalas
}
