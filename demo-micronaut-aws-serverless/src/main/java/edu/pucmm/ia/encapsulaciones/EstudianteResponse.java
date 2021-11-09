package edu.pucmm.ia.encapsulaciones;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;

import javax.validation.constraints.NotBlank;

@Introspected
public class EstudianteResponse {

    @NonNull
    @NotBlank
    private int matricula;
    @NonNull
    @NotBlank
    private String nombre;
    @NonNull
    @NotBlank
    private String carrera;
    private String mensaje;

    public EstudianteResponse() {
    }

    public EstudianteResponse(EstudianteRequest request){
        matricula = request.getMatricula();
        nombre = request.getNombre();
        carrera = request.getCarrera();
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(@NonNull String carrera) {
        this.carrera = carrera;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
