package madrigal.adriana.tarea03.gestor;

import madrigal.adriana.tarea03.bl.entidades.*;
import madrigal.adriana.tarea03.bl.tipos.TipoAudio;
import madrigal.adriana.tarea03.bl.tipos.TipoContracto;
import madrigal.adriana.tarea03.bl.tipos.TipoNombramiento;
import madrigal.adriana.tarea03.bl.tipos.TipoVideo;
import madrigal.adriana.tarea03.persistencia.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Gestor {

    Connection connection;
    AudioDAO audioDAO = new AudioDAO(connection);
    VideoDAO videoDAO = new VideoDAO(connection);
    TextoDAO textoDAO = new TextoDAO(connection);
    AdminDAO adminDAO = new AdminDAO(connection);
    EstudianteDAO estudianteDAO = new EstudianteDAO(connection);
    ProfesorDAO profesorDAO = new ProfesorDAO(connection);

// gestor conexion
    public Gestor() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_tarea04"
                    , "root", "David07Santi2930");
            this.audioDAO = new AudioDAO(this.connection);
            this.textoDAO = new TextoDAO(this.connection);
            this.videoDAO = new VideoDAO(this.connection);
            this.adminDAO = new AdminDAO(this.connection);
            this.estudianteDAO = new EstudianteDAO(this.connection);
            this.profesorDAO = new ProfesorDAO(this.connection);
        } catch (Exception e) {
            System.out.println("Cant connect to db");
            System.out.println(e.getMessage());
        }
    }
    //metodo para guardar el audio

    public void guardar(LocalDate fechaCompra, boolean restringido, String tema, int duracionAudio, String idiomaAudio, TipoAudio tipoAudio) throws SQLException {
        Audio nuevoAudio = new Audio(fechaCompra,restringido,tema,duracionAudio,idiomaAudio,tipoAudio);
        audioDAO.saveAudio(nuevoAudio);
    }
    //metodo para listar los audio
    public List<Audio> findAllAudio() throws SQLException{
        return audioDAO.findAllAudio();
    }
    //metodo para guardar el texto
    public void guardarTexto(LocalDate fechaCompra, boolean restringido, String tema, String titulo, String nombreAutor, LocalDate fechaPublicacion, int numeroPaginas, String idiomaTexto) throws SQLException {
        Texto nuevoTexto = new Texto(fechaCompra,restringido,tema,titulo,nombreAutor,fechaPublicacion,numeroPaginas,idiomaTexto);
        textoDAO.saveTexto(nuevoTexto);
    }
    //metodo para listar
    public List<Texto> findAllTexto() throws SQLException{
        return textoDAO.findAllTexto();
    }
    //metodo para guardar video
    public void guardarVideo(LocalDate fechaCompra, boolean restringido, String tema, int duracionVideo, String idiomaVideo, String directorVideo, TipoVideo tipoVideo) throws SQLException {
        Video nuevoVideo = new Video(fechaCompra,restringido,tema,duracionVideo,idiomaVideo,directorVideo,tipoVideo);
        videoDAO.saveVideo(nuevoVideo);
    }
    //metodo para listar video
    public List<Video> findAllVideo() throws SQLException{
        return videoDAO.findAllVideo();
    }
    //metodo para ingresar usuarios de administrativo
    public void ingresarAdministrativo(String pNombre, String pApellido, TipoNombramiento pNombramiento, int pCantidadHoras) throws SQLException {
        Administrativo nuevoAdmin = new Administrativo(pNombre,pApellido,pNombramiento,pCantidadHoras);
        adminDAO.salvarAdmin(nuevoAdmin);
    }
    //metodo para listar usuarios administrativos
    public List<Administrativo> findAllAdmin() throws SQLException{
        return adminDAO.findAllAdministrativo();
    }
    //Metodo para ingresar usuario Estidiante
    public void ingresarEstudiante(String nombre, String apellido, String carrera, int creditosMatriculados) throws SQLException{
        Estudiante nuevoEst = new Estudiante(nombre,apellido,carrera,creditosMatriculados);
        estudianteDAO.salvarEstudiante(nuevoEst);
    }
    //Metodo para listar usuario Estudiante
    public List<Estudiante> findAllEstudiante() throws SQLException{
        return estudianteDAO.findAllEstudiante();
    }
    //metodo para ingresar el usuario Profesor
    public void ingresarProfesor(String nombre, String apellido, TipoContracto tipoContrato, LocalDate fechaContratacion) throws SQLException{
        Profesor nuevoProf = new Profesor(nombre,apellido,tipoContrato,fechaContratacion);
        profesorDAO.salvarProfesor(nuevoProf);
    }
    //Metodo que lista el usuario profesor
    public List<Profesor> findAllProfesores() throws SQLException{
        return profesorDAO.findAllProfesor();
    }
}
