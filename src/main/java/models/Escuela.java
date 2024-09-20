package models;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Escuela {
    private String nombre;
    private List<Estudiante> estudiantes;

    public Escuela() {

    }

    public Escuela(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void guardarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void borrarEstudiante(Estudiante estudiante) {
        try {
            estudiantes.remove(estudiante);
        } catch (Exception e) {
            System.out.println("No se encuentra el alumno que desea borrar");
        }
    }

    public void actualizarTabla(Estudiante estudiante) {
        for (Estudiante estu : estudiantes) {
            if (estu.getNumMatricula().equals(estudiante.getNumMatricula())) {
                estu.setNombre(estudiante.getNombre());
                estu.setApellido(estudiante.getApellido());
                estu.setTelefono(estudiante.getTelefono());
            }
        }
    }

    public void deleteAll(List<Estudiante> estudiantess) {
        if (!estudiantess.isEmpty()) {
            estudiantes.removeAll(estudiantess);
        }
    }
}
