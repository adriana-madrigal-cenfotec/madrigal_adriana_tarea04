package madrigal.adriana.tarea03.bl.entidades;

import madrigal.adriana.tarea03.bl.tipos.TipoNombramiento;

public class Administrativo extends Persona{

    private TipoNombramiento tipoNombramiento;
    private int cantidadHorasSemanales;

    public Administrativo() {
        super();
    }

    public TipoNombramiento getTipoNombramiento() {
        return tipoNombramiento;
    }

    public void setTipoNombramiento(TipoNombramiento tipoNombramiento) {
        this.tipoNombramiento = tipoNombramiento;
    }

    public int getCantidadHorasSemanales() {
        return cantidadHorasSemanales;
    }

    public void setCantidadHorasSemanales(int cantidadHorasSemanales) {
        this.cantidadHorasSemanales = cantidadHorasSemanales;
    }

    public Administrativo(String nombre, String apellido, TipoNombramiento tipoNombramiento, int cantidadHorasSemanales) {
        super(nombre, apellido);
        this.tipoNombramiento = tipoNombramiento;
        this.cantidadHorasSemanales = cantidadHorasSemanales;
    }

    @Override
    public String toString() {
        return "Administrativos{" +
                "tipoNombramiento='" + tipoNombramiento + '\'' +
                ", cantidadHorasSemanales=" + cantidadHorasSemanales +
                "} " + super.toString();
    }


    @Override
    public String toCSVLine() {
        return this.id + "," + this.nombre + "," + this.apellido + "," + this.tipoNombramiento + "," + this.cantidadHorasSemanales;
    }
}
