package com.alberto.Demo.Alberto.InterfaceService;

import com.alberto.Demo.Alberto.dtos.GlobalResponse;
import com.alberto.Demo.Alberto.dtos.response.DtoVuelo;
import com.alberto.Demo.Alberto.entity.EntityVuelo;

import java.util.List;

public interface InterfaceVueloService {

    // Que vamos a devolver List<>, Objet
        // Entity
        // DtoResponse


    // Nombre de la funcion
    // Parametros

    // crear un nuevo vuelo con  "Dtovuelo" y usando GlobalResponse
    GlobalResponse GuardarNuevoVuelo(DtoVuelo dtoResponseVuelo);

    //Búsqueda de vuelos, pudiendo filtrar por origen, destino y número de escalas.
    List<Object> BusquedaDeVuelosFiltrados(String origen, String destino, Integer numero_de_escalas );


    // put "Dto modificar vuelo"
    EntityVuelo ModificarVuelo(EntityVuelo entityVuelo);

    // get list all
    List<EntityVuelo> ListarTodoslosVuelos();

    // get by "id"
    List<EntityVuelo> listarVuelos();

    // get parametro "name"
    List<EntityVuelo> BuscarVueloPorNombre(String nombre);

    // delete vuelo "id"
    void BuscarVueloPorId(Long id);


}
