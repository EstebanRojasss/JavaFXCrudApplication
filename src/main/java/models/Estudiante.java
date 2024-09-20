package models;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String telefono;
    private String numMatricula;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, String telefono, String numMatricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.numMatricula = numMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }



}
