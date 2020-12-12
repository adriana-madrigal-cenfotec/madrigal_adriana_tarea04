package madrigal.adriana.tarea03.ui;

import java.io.PrintStream;
import java.util.Scanner;

public class UI {

    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in).useDelimiter("\n");

    public void showMenu(){
        output.println("Bievenido: escoja una opcion:");
        output.println("1. Crear Usuarios");
        output.println("2. Listar Usuarios");
        output.println("3. Crear Material");
        output.println("4. Listar Material");
        output.println("5. Salir");
    }
    public void imprimirMensaje(String mensaje) {
        output.println(mensaje);
    }

    public String leerTexto() {
        return input.next();
    }

    public void menuListarMateriales(){
        output.println("Seleccione la opción que contiene el material que desea listar:");
        output.println("1. Audio");
        output.println("2. Texto");
        output.println("3. Video");
    }


    public void menuListarUsuarios() {
        output.println("Seleccione la opción que contiene el tipo de usuario que desea listar:");
        output.println("1. Administrativo");
        output.println("2. Estudiante");
        output.println("3. Profesor");
    }
}
