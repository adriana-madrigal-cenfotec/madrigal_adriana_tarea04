package madrigal.adriana.tarea03.bl.entidades;

import madrigal.adriana.tarea03.interfaces.SereializacionCSV;

public abstract class Persona extends SereializacionCSV {
    protected int id;
    protected String nombre;
    protected String apellido;

    public Persona(String currentLine) {
        String[] datos = currentLine.split(",");
        this.id = Integer.parseInt(datos[0]);
        this.nombre = datos[1];
        this.apellido = datos[2];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona() {
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }



}
