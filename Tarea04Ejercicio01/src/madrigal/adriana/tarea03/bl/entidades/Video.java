package madrigal.adriana.tarea03.bl.entidades;

import madrigal.adriana.tarea03.bl.tipos.TipoVideo;
import madrigal.adriana.tarea03.bl.tipos.TiposMateriales;

import java.time.LocalDate;

public class Video extends Materiales {
    private int duracionVideo;
    private String idiomaVideo;
    private String directorVideo;
    private TipoVideo tipoVideo;

    public Video() {
        super();
    }

    public int getDuracionVideo() {
        return duracionVideo;
    }

    public void setDuracionVideo(int duracionVideo) {
        this.duracionVideo = duracionVideo;
    }

    public String getIdiomaVideo() {
        return idiomaVideo;
    }

    public void setIdiomaVideo(String idiomaVideo) {
        this.idiomaVideo = idiomaVideo;
    }

    public String getDirectorVideo() {
        return directorVideo;
    }

    public void setDirectorVideo(String directorVideo) {
        this.directorVideo = directorVideo;
    }

    public TipoVideo getTipoVideo() {
        return tipoVideo;
    }

    public void setTipoVideo(TipoVideo tipoVideo) {
        this.tipoVideo = tipoVideo;
    }

    public Video(LocalDate fechaCompra, boolean restringido, String tema, int duracionVideo, String idiomaVideo, String directorVideo, TipoVideo tipoVideo) {
        super(fechaCompra, restringido, tema);
        this.duracionVideo = duracionVideo;
        this.idiomaVideo = idiomaVideo;
        this.directorVideo = directorVideo;
        this.tipoVideo = tipoVideo;
    }

    @Override
    public String toString() {
        return "Video{" +
                "duracionVideo=" + duracionVideo +
                ", idiomaVideo='" + idiomaVideo + '\'' +
                ", directorVideo='" + directorVideo + '\'' +
                ", tipoVideo=" + tipoVideo +
                "} " + super.toString();
    }

    @Override
    public String toCSVLine() {
        return this.id + "," + this.fechaCompra + "," + this.restringido + "," + this.tema + "," + this.duracionVideo + "," + this.idiomaVideo + "," + this.directorVideo + "," + this.tipoVideo;
    }
}
