package com.alberto.Demo.Alberto.controller;


import com.alberto.Demo.Alberto.dtos.GlobalResponse;
import com.alberto.Demo.Alberto.dtos.response.DtoVuelo;
import com.alberto.Demo.Alberto.entity.EntityVuelo;
import com.alberto.Demo.Alberto.serviceImplements.VuelosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vuelos")
public class ControllerVuelo {
    //localhost:8080/api/v1/vuelos

    @Autowired
    private final VuelosServiceImpl vuelosServiceImpl;
    @Autowired
    public ControllerVuelo(VuelosServiceImpl vuelosServiceImpl) {
        this.vuelosServiceImpl = vuelosServiceImpl;
    }

    // Get listar todos los vuelos

    @GetMapping
    public ResponseEntity<List<EntityVuelo>> obtenerTodosLosVuelos() {
        List<EntityVuelo> listaDeVuelos = vuelosServiceImpl.ListarTodoslosVuelos();

        if (listaDeVuelos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listaDeVuelos, HttpStatus.OK);

    }

    // crear nuevo vuelo
    @PostMapping
    public ResponseEntity<GlobalResponse> crearVuelo(@RequestBody DtoVuelo dtoResponseVuelo) {

        if (dtoResponseVuelo == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(vuelosServiceImpl.GuardarNuevoVuelo(dtoResponseVuelo));

    }

    //Búsqueda de vuelos, pudiendo filtrar por origen, destino y número de escalas.

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




    // Codigo de respuesta del servidor - HTTP
    //    202
    //    204
    //    201
    //    404
    //    300




}
