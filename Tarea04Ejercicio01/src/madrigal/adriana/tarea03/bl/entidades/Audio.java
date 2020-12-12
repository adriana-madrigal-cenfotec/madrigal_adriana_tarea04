package madrigal.adriana.tarea03.bl.entidades;

import madrigal.adriana.tarea03.bl.tipos.TipoAudio;

import java.time.LocalDate;

public class Audio extends Materiales {
    private int duracionAudio;
    private String idiomaAudio;
    private TipoAudio tipoAudio;

    public Audio() {
        super();
    }


    public int getDuracionAudio() {
        return duracionAudio;
    }

    public void setDuracionAudio(int duracionAudio) {
        this.duracionAudio = duracionAudio;
    }

    public String getIdiomaAudio() {
        return idiomaAudio;
    }

    public void setIdiomaAudio(String idiomaAudio) {
        this.idiomaAudio = idiomaAudio;
    }

    public TipoAudio getTipoAudio() {
        return tipoAudio;
    }

    public void setTipoAudio(TipoAudio tipoAudio) {
        this.tipoAudio = tipoAudio;
    }

    public Audio(LocalDate fechaCompra, boolean restringido, String tema, int duracionAudio, String idiomaAudio,TipoAudio tipoAudio) {
        super(fechaCompra, restringido, tema);
        this.duracionAudio = duracionAudio;
        this.idiomaAudio = idiomaAudio;
        this.tipoAudio = tipoAudio;
    }

    public void Audio1(String currentLine) {
    }

    @Override
    public String toString() {
        return "Audio{" +
                "duracionAudio=" + duracionAudio +
                ", idiomaAudio='" + idiomaAudio + '\'' +
                ", tipoAudio=" + tipoAudio +
                "} " + super.toString();
    }

    @Override
    public String toCSVLine() {
        return this.id + "," + this.fechaCompra + "," + this.restringido + "," + this.tema + "," + this.duracionAudio + "," + this.idiomaAudio + "," + this.tipoAudio ;
    }
}
