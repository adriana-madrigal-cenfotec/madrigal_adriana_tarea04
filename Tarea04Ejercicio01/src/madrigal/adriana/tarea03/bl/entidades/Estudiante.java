package madrigal.adriana.tarea03.bl.entidades;

public class Estudiante extends Persona {
    private  String carrera;
    private int creditosMatriculados;


    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getCreditosMatriculados() {
        return creditosMatriculados;
    }

    public void setCreditosMatriculados(int creditosMatriculados) {
        this.creditosMatriculados = creditosMatriculados;
    }

    public Estudiante(String nombre, String apellido, String carrera, int creditosMatriculados) {
        super(nombre, apellido);
        this.carrera = carrera;
        this.creditosMatriculados = creditosMatriculados;
    }

    public Estudiante() {
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "carrera='" + carrera + '\'' +
                ", creditosMatriculados=" + creditosMatriculados +
                "} " + super.toString();
    }
    @Override
    public String toCSVLine() {
        return this.id + "," + this.nombre + "," + this.apellido + "," + this.carrera + "," + this.creditosMatriculados;
    }
}
