package edu.pucmm.ia.controladores;

import edu.pucmm.ia.encapsulaciones.EstudianteRequest;
import edu.pucmm.ia.encapsulaciones.EstudianteResponse;
import edu.pucmm.ia.servicios.EstudianteServices;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import javax.validation.Valid;

@Controller
public class EstudianteController {

    @Inject
    private EstudianteServices estudianteServices;

    @Post
    public EstudianteResponse procesarEstudiante(@Valid @Body EstudianteRequest estudianteRequest){
        return estudianteServices.procesarEstudiante(estudianteRequest);
    }
}
