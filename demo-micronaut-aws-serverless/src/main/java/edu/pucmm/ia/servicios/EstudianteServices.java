package edu.pucmm.ia.servicios;

import edu.pucmm.ia.encapsulaciones.EstudianteRequest;
import edu.pucmm.ia.encapsulaciones.EstudianteResponse;
import jakarta.inject.Singleton;

@Singleton
public class EstudianteServices {

    /**
     *
     * @param estudianteRequest
     * @return
     */
    public EstudianteResponse procesarEstudiante(EstudianteRequest estudianteRequest){
        EstudianteResponse response = new EstudianteResponse(estudianteRequest);
        response.setMensaje("Estudiante Procesado...");
        return response;
    }
}
