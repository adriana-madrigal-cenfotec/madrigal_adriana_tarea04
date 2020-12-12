package madrigal.adriana.tarea03.bl.entidades;

import madrigal.adriana.tarea03.bl.tipos.TiposMateriales;
import madrigal.adriana.tarea03.interfaces.SereializacionCSV;

import java.time.LocalDate;

public abstract class Materiales extends SereializacionCSV {
    protected TiposMateriales tipo;
    protected int id;
    protected LocalDate fechaCompra;
    protected boolean restringido;
    protected String tema;

    public Materiales(String currentLine) {
        String[] datos = currentLine.split(",");
        this.tipo = TiposMateriales.valueOf(datos[0]);
        this.id = Integer.parseInt(datos[1]);
        this.fechaCompra = LocalDate.parse(datos[2]);
        this.restringido = Boolean.parseBoolean(datos[3]);
        this.tema = datos[4];
    }

    public TiposMateriales getTipo() {
        return tipo;
    }

    public void setTipo(TiposMateriales tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public boolean isRestringido() {
        return restringido;
    }

    public void setRestringido(boolean restringido) {
        this.restringido = restringido;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Materiales(LocalDate fechaCompra, boolean restringido, String tema) {
        this.fechaCompra = fechaCompra;
        this.restringido = restringido;
        this.tema = tema;
    }

    public Materiales() {
    }

    @Override
    public String toString() {
        return "Materiales{" +
                "tipo=" + tipo +
                ", id='" + id + '\'' +
                ", fechaCompra=" + fechaCompra +
                ", restringido=" + restringido +
                ", tema='" + tema + '\'' +
                '}';
    }

}
