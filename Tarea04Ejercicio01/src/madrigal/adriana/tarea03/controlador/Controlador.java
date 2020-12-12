package madrigal.adriana.tarea03.controlador;

import madrigal.adriana.tarea03.bl.entidades.*;
import madrigal.adriana.tarea03.bl.tipos.*;
import madrigal.adriana.tarea03.gestor.Gestor;
import madrigal.adriana.tarea03.ui.UI;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Controlador {

    UI ui = new UI();
    Gestor gestor = new Gestor();

    public void ejecutarPrograma() throws SQLException {
        int opcion = 0;
        do {
            ui.showMenu();
            opcion = Integer.parseInt(ui.leerTexto());
            ejecutarOpcion(opcion);
        }while (opcion != 5);

    }

    private void ejecutarOpcion(int opcion) throws SQLException {
        switch (opcion){
            case 1:
                ui.imprimirMensaje("Ingrese el tipo de usuario a ingresar: ");
                ui.imprimirMensaje("ADMINISTRATIVO,ESTUDIANTE,PROFESOR");
                String tipoUsuario = ui.leerTexto();
                solicitudInfoUsuario(tipoUsuario);
                break;
            case 2:
                listarUsuarios();
                break;
            case 3:
                ui.imprimirMensaje("Ingrese el tipo de material que desea procesar: ");
                ui.imprimirMensaje("TEXTO,AUDIO,VIDEO");
                String tipoMaterial = ui.leerTexto();
                solicitarInfoMateriales(tipoMaterial);
                break;
            case 4:
                listarMateriales();
                break;
            case 5:
                ui.imprimirMensaje("Gracias por usar el sistema");
                break;
            default:
                ui.imprimirMensaje("Opcion invalida");
        }
    }



    private void listarMateriales() throws SQLException {
        int opcion = 0;
        ui.menuListarMateriales();
        opcion = Integer.parseInt(ui.leerTexto());

        switch (opcion){
            case 1:
                List<Audio> audios = gestor.findAllAudio();
                for (Audio unAudio: audios){
                    ui.imprimirMensaje(unAudio.toCSVLine());
                }
                break;
            case 2:
                List<Texto> textos = gestor.findAllTexto();
                for(Texto unTexto: textos){
                    ui.imprimirMensaje(unTexto.toCSVLine());
                }
                break;
            case 3:
                List<Video> videos = gestor.findAllVideo();
                for (Video unVideo: videos){
                    ui.imprimirMensaje(unVideo.toCSVLine());
                }
                break;
            default:
                ui.imprimirMensaje("Opcion invalida");
        }
    }

    private void solicitarInfoMateriales(String tipoMaterial) throws SQLException {
        if (tipoMaterial.equals("AUDIO")){
            ui.imprimirMensaje("Ingrese la fecha de compra");
            LocalDate pfechaCompra = LocalDate.parse(ui.leerTexto());
            ui.imprimirMensaje("Es un material restringido?");
            boolean pRestringido = Boolean.parseBoolean(ui.leerTexto());
            ui.imprimirMensaje("Cual es el tema del audio?");
            String pTema = ui.leerTexto();
            ui.imprimirMensaje("Ingrese la duración del Audio:");
            int pDuracionAudio = Integer.parseInt(ui.leerTexto());
            ui.imprimirMensaje("Ingrese el idioma del audio");
            String pIdiomaAudio = ui.leerTexto();
            ui.imprimirMensaje("Ingrese el tipo de Audio:");
            TipoAudio pTipoAudio = TipoAudio.valueOf(ui.leerTexto());
            gestor.guardar(pfechaCompra,pRestringido,pTema,pDuracionAudio,pIdiomaAudio,pTipoAudio);
        } else if(tipoMaterial.equals("TEXTO")){
            ui.imprimirMensaje("Ingrese la fecha de compra");
            LocalDate pfechaCompra = LocalDate.parse(ui.leerTexto());
            ui.imprimirMensaje("Es un material restringido?");
            boolean pRestringido = Boolean.parseBoolean(ui.leerTexto());
            ui.imprimirMensaje("Cual es el tema del libro?");
            String pTema = ui.leerTexto();
            ui.imprimirMensaje("Ingrese el titulo del libro:");
            String titulo = ui.leerTexto();
            ui.imprimirMensaje("Ingrese el nombre del Autor:");
            String autor = ui.leerTexto();
            ui.imprimirMensaje("Ingrese la fecha en la que se publico el libro");
            LocalDate fechaPub = LocalDate.parse(ui.leerTexto());
            ui.imprimirMensaje("Ingrese el numero de paginas");
            int numeroPaginas = Integer.parseInt(ui.leerTexto());
            ui.imprimirMensaje("Ingrese el idioma en el que se escribio el libro");
            String idioma = ui.leerTexto();
            gestor.guardarTexto(pfechaCompra,pRestringido,pTema,titulo,autor,fechaPub,numeroPaginas,idioma);
        }else if(tipoMaterial.equals("VIDEO")){
            ui.imprimirMensaje("Ingrese la fecha de compra");
            LocalDate pfechaCompra = LocalDate.parse(ui.leerTexto());
            ui.imprimirMensaje("Es un material restringido?");
            boolean pRestringido = Boolean.parseBoolean(ui.leerTexto());
            ui.imprimirMensaje("Cual es el tema del video?");
            String pTema = ui.leerTexto();
            ui.imprimirMensaje("Ingrese la duración del video:");
            int pDuracionVideo = Integer.parseInt(ui.leerTexto());
            ui.imprimirMensaje("Ingrese el idioma del Video");
            String pIdiomaVideo = ui.leerTexto();
            ui.imprimirMensaje("Ingrese el nombre del director del video");
            String pDirector = ui.leerTexto();
            ui.imprimirMensaje("Ingrese el tipo del video:");
            TipoVideo pTipoVideo = TipoVideo.valueOf(ui.leerTexto());
            gestor.guardarVideo(pfechaCompra,pRestringido,pTema,pDuracionVideo,pIdiomaVideo,pDirector,pTipoVideo);
        }
    }

    private void listarUsuarios() throws SQLException {
        int opcion = 0;
        ui.menuListarUsuarios();
        opcion = Integer.parseInt(ui.leerTexto());

        switch (opcion) {
            case 1:
                List<Administrativo> admins = gestor.findAllAdmin();
                for (Administrativo unAdmin : admins) {
                    ui.imprimirMensaje(unAdmin.toCSVLine());
                }
                break;
            case 2:
                List<Estudiante> estudiantes = gestor.findAllEstudiante();
                for (Estudiante unEstudiante : estudiantes) {
                    ui.imprimirMensaje(unEstudiante.toCSVLine());
                }
                break;
            case 3:
                List<Profesor> profesores = gestor.findAllProfesores();
                for (Profesor unProfesor : profesores) {
                    ui.imprimirMensaje(unProfesor.toCSVLine());
                }
                break;
            default:
                ui.imprimirMensaje("Opcion invalida");
        }
    }

    private void solicitudInfoUsuario(String tipoUsuario) throws SQLException {
        if (tipoUsuario.equals("ADMINISTRATIVO")){
            ui.imprimirMensaje("Ingrese el primer nombre:");
            String pNombre = ui.leerTexto();
            ui.imprimirMensaje("Ingrese el apellido:");
            String pApellido = ui.leerTexto();
            ui.imprimirMensaje("Ingrese el tipo de nombramiento:");
            TipoNombramiento pNombramiento = TipoNombramiento.valueOf(ui.leerTexto());
            ui.imprimirMensaje("Ingrese la cantidad de horas:");
            int pCantidadHoras = Integer.parseInt(ui.leerTexto());
            gestor.ingresarAdministrativo(pNombre,pApellido,pNombramiento,pCantidadHoras);
        } else if(tipoUsuario.equals("ESTUDIANTE")){
            ui.imprimirMensaje("Ingrese el primer nombre del estudiante");
            String pNombre = ui.leerTexto();
            ui.imprimirMensaje("Ingrese el apellido del Estudiante");
            String pApellido = ui.leerTexto();
            ui.imprimirMensaje("Ingrese la carrera que cursa el estudiante");
            String pCarrera = ui.leerTexto();
            ui.imprimirMensaje("Ingrese el numero de creditos matriculados");
            int pNumeroCreditos = Integer.parseInt(ui.leerTexto());
            gestor.ingresarEstudiante(pNombre,pApellido,pCarrera,pNumeroCreditos);
        }else if(tipoUsuario.equals("PROFESOR")){
            ui.imprimirMensaje("Ingrese el primer nombre del profesor");
            String pNombre = ui.leerTexto();
            ui.imprimirMensaje("Ingrese el apellido del profesor");
            String pApellido = ui.leerTexto();
            ui.imprimirMensaje("Ingrese el tipo de Contrato");
            TipoContracto pContrato = TipoContracto.valueOf(ui.leerTexto());
            ui.imprimirMensaje("Ingrese la fecha de contratacion");
            LocalDate pfechaContratacion = LocalDate.parse(ui.leerTexto());
            gestor.ingresarProfesor(pNombre,pApellido,pContrato,pfechaContratacion);
        }

    }


}
