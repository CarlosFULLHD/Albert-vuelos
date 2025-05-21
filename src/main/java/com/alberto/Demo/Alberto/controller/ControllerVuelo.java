package com.alberto.Demo.Alberto.controller;


import com.alberto.Demo.Alberto.dtos.GlobalResponse;
import com.alberto.Demo.Alberto.dtos.response.DtoVuelo;
import com.alberto.Demo.Alberto.entity.EntityVuelo;
import com.alberto.Demo.Alberto.serviceImplements.VuelosServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Tag(name="API DE VUELOS",description = "endpoint gestion vuelos")
@RestController
@RequestMapping("/vuelos")
public class ControllerVuelo {
    //localhost:8080/vuelos

    @Autowired
    private final VuelosServiceImpl vuelosServiceImpl;
    @Autowired
    public ControllerVuelo(VuelosServiceImpl vuelosServiceImpl) {
        this.vuelosServiceImpl = vuelosServiceImpl;
    }

    // Get listar todos los vuelos

    @Operation(summary = "obtenerTodosLosVuelos")
    @GetMapping
    public ResponseEntity<List<EntityVuelo>> obtenerTodosLosVuelos() {
        List<EntityVuelo> listaDeVuelos = vuelosServiceImpl.ListarTodoslosVuelos();

        if (listaDeVuelos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listaDeVuelos, HttpStatus.OK);

    }

    // crear nuevo vuelo
    @Operation(summary = "crear nuevo vuelo")
    @PostMapping
    public ResponseEntity<GlobalResponse> crearVuelo(@RequestBody DtoVuelo dtoResponseVuelo) {

        if (dtoResponseVuelo == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(vuelosServiceImpl.GuardarNuevoVuelo(dtoResponseVuelo));

    }

    //Búsqueda de vuelos, pudiendo filtrar por origen, destino y número de escalas.

    @Operation(summary = "Búsqueda de vuelos, pudiendo filtrar por origen, destino y número de escalas.")
    //DTOResponseEntityVuelo
    @GetMapping("/search") // ?origen=Madrid&destino=Valencia&numero_de_escalas=2
    public ResponseEntity<List<Object>> search(
            @RequestParam(value = "origen", required = false) String origen,
            @RequestParam(value = "destino", required = false) String destino,
            @RequestParam(value = "numero_de_escalas", required = false) Integer numero_de_escalas) {

        // Listado de resultados finales
        List<Object> response = vuelosServiceImpl.BusquedaDeVuelosFiltrados(origen, destino, numero_de_escalas);
        if(response == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);// 404
        }
        return new ResponseEntity<>(response, HttpStatus.OK);// 200
    }
    //localhost:8080/api/v1/vuelo/destino
    //5. Dar de baja todos los vuelos a un destino determinado.
    // 204 si se elmimna correctamnete
    // 404 si no hay vuelos por eliminar
    // ruta - parametro "Madrid"
    @Operation(summary = "Dar de baja todos los vuelos a un destino determinado.")
    @DeleteMapping("/destino/{destino}")
    public ResponseEntity<?> eliminarVuelo(@PathVariable String destino) {
        vuelosServiceImpl.eliminarVuelosPorDestino(destino);
        return ResponseEntity.noContent().build();
    }




    // Codigo de respuesta del servidor - HTTP
    //    202
    //    204
    //    201
    //    404
    //    300




}
