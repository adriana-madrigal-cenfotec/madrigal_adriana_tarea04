package madrigal.adriana.tarea03.bl.entidades;

import madrigal.adriana.tarea03.bl.tipos.TipoContracto;

import java.time.LocalDate;

public class Profesor extends Persona {
    private TipoContracto tipoContrato;
    private LocalDate fechaContratacion;

    public TipoContracto getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContracto tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public Profesor(String nombre, String apellido, TipoContracto tipoContrato, LocalDate fechaContratacion) {
        super( nombre, apellido);
        this.tipoContrato = tipoContrato;
        this.fechaContratacion = fechaContratacion;
    }

    public Profesor() {
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "tipoContrato='" + tipoContrato + '\'' +
                ", fechaContratacion=" + fechaContratacion +
                "} " + super.toString();
    }

    @Override
    public String toCSVLine() {
        return this.id + "," + this.nombre + "," + this.apellido + "," + this.tipoContrato+ "," + this.fechaContratacion;
    }
}
