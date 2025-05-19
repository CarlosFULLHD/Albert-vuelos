package com.alberto.Demo.Alberto.serviceImplements;

import com.alberto.Demo.Alberto.InterfaceService.InterfaceVueloService;
import com.alberto.Demo.Alberto.dtos.GlobalResponse;
import com.alberto.Demo.Alberto.dtos.response.DtoVuelo;
import com.alberto.Demo.Alberto.entity.EntityVuelo;
import com.alberto.Demo.Alberto.repository.RepositoryVuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class VuelosServiceImpl implements InterfaceVueloService {

    @Autowired
    private final RepositoryVuelo repositoryVuelo;

    @Autowired
    public VuelosServiceImpl(RepositoryVuelo repositoryVuelo) {
        this.repositoryVuelo = repositoryVuelo;
    }

    @Override
    public List<EntityVuelo> ListarTodoslosVuelos() {
        List<EntityVuelo> listaDeVuelos = repositoryVuelo.findAll();

        return List.of((EntityVuelo) listaDeVuelos);
    }

    // Dto RespuestaVuelo

// Recibiendo del DTO
//    private String origen;
//    private String destino;
//    private BigDecimal precio;
//    private String numeroDeEscalas;

    @Override
    public GlobalResponse GuardarNuevoVuelo(DtoVuelo dtoVuelo) {
        EntityVuelo entityVuelo = new EntityVuelo();
        entityVuelo.setOrigen(dtoVuelo.getOrigen());
        entityVuelo.setDestino(dtoVuelo.getDestino());
        entityVuelo.setPrecio(dtoVuelo.getPrecio());
        entityVuelo.setNumeroDeEscalas(dtoVuelo.getNumeroDeEscalas());
        entityVuelo.setCompania(dtoVuelo.getCompania());

        EntityVuelo VueloGuardado = repositoryVuelo.save(entityVuelo);


        GlobalResponse respuesta = new GlobalResponse(
              "El Vuelo ha sido guardado con exito",
              200,
              "VuelosServiceImpl/...",
                VueloGuardado
        );
        return respuesta;
    }

    @Override                                       //Recibiendo parametros
    public List<Object> BusquedaDeVuelosFiltrados(String origen, String destino, Integer numero_de_escalas) {
        List<Object> results = new ArrayList<>();
        // Obtenga todos los datos
        List<EntityVuelo> vuelos = repositoryVuelo.findAll();

        for (EntityVuelo vuelo : vuelos) {
            boolean coincide = true;

            if (origen != null && !vuelo.getOrigen().equalsIgnoreCase(origen)) {
                coincide = false;
            }

            if (destino != null && !vuelo.getDestino().equalsIgnoreCase(destino)) {
                coincide = false;
            }

            if (numero_de_escalas != null && !vuelo.getNumeroDeEscalas().equals(numero_de_escalas)) {
                coincide = false;
            }

            if (coincide) {
                results.add(vuelo); // También puedes hacer toDto(vuelo) si deseas retornar DTOs
            }
        }

        return results;
    }

    @Override
    public EntityVuelo ModificarVuelo(EntityVuelo entityVuelo) {
        return null;
    }



    @Override
    public List<EntityVuelo> listarVuelos() {
        return List.of();
    }

    @Override
    public List<EntityVuelo> BuscarVueloPorNombre(String nombre) {
        return List.of();
    }

    @Override
    public void BuscarVueloPorId(Long id) {

    }
}
