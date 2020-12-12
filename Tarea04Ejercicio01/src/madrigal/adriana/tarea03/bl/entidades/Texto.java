package madrigal.adriana.tarea03.bl.entidades;

import madrigal.adriana.tarea03.bl.tipos.TiposMateriales;

import java.time.LocalDate;

public class Texto extends Materiales {

    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
    private int numeroPaginas;
    private String idiomaTexto;

    public Texto(){
        super();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getIdiomaTexto() {
        return idiomaTexto;
    }

    public void setIdiomaTexto(String idiomaTexto) {
        this.idiomaTexto = idiomaTexto;
    }

    public Texto(LocalDate fechaCompra, boolean restringido, String tema, String titulo, String nombreAutor, LocalDate fechaPublicacion, int numeroPaginas, String idiomaTexto) {
        super(fechaCompra, restringido, tema);
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
        this.numeroPaginas = numeroPaginas;
        this.idiomaTexto = idiomaTexto;
    }

    @Override
    public String toString() {
        return "Texto{" +
                "titulo='" + titulo + '\'' +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", numeroPaginas=" + numeroPaginas +
                ", idiomaTexto='" + idiomaTexto + '\'' +
                "} " + super.toString();
    }

    @Override
    public String toCSVLine() {
        return this.id + "," + this.fechaCompra + "," + this.restringido + "," + this.tema + "," + this.titulo + "," + this.nombreAutor + "," + this.fechaPublicacion + "," + this.numeroPaginas + "," + this.idiomaTexto;
    }
}
