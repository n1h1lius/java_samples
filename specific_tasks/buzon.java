package Buzon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Buzon {
    private static final String USUARIOS_FILE = "C:\\Users\\moher\\IdeaProjects\\RAQUEL\\src\\Buzon\\usuarios.txt";
    private static final String MENSAJES_FILE = "C:\\Users\\moher\\IdeaProjects\\RAQUEL\\src\\Buzon\\mensajes.txt";
    private static final Scanner SC = new Scanner(System.in);
    private static void verMensajesPendientes(String username) {  // OPCION 7 DEL MENU
        System.out.println("\n-----------------------------------------------\nMensajes Pendientes\n-----------------------------------------------");

        try (BufferedReader reader = new BufferedReader(new FileReader(MENSAJES_FILE))) {
            String line;
            boolean mensajesEncontrados = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String destinatario = parts[0];
                String mensaje = parts[1];
                String remitente = parts[2];

                if (destinatario.equals(username)) {
                    mensajesEncontrados = true;
                    System.out.println("\nRemitente: " + remitente + "\nMensaje: " + mensaje + "\n--------------------------");}    }

            if (!mensajesEncontrados) {System.out.println("No tienes mensajes pendientes.");}

            else {  // Guardar los mensajes sin el usuario destinatario en un nuevo archivo

                try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(MENSAJES_FILE)))) {writer.print("");}
                catch (IOException e) {System.out.println("\nError al borrar los mensajes pendientes.");}   }   }

        catch (IOException e) {System.out.println("\nError al leer el archivo de mensajes.");}

    }  // OPCION 7 DEL MENU
    private static boolean verificarContrasena(String username, String password) {

        try (BufferedReader reader = new BufferedReader(new FileReader(USUARIOS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String storedUsername = parts[0];
                String storedPassword = parts[2];

                if (storedUsername.equals(username) && storedPassword.equals(password)) {return true;}   }   }
        catch (IOException e) {System.out.println("\nError al leer el archivo de usuarios.");}

        return false;

    }  // METODO DE OPCION 6
    private static void cambiarContrasenaUsuario(String username) {  // OPCION 6 DEL MENU

        System.out.println("\n-----------------------------------------------\nCambio de Contraseña del Usuario\n-----------------------------------------------");

        System.out.print("\nContraseña actual: ");
        String contrasenaActual = SC.nextLine();

        // Verificar si la contraseña actual es correcta
        if (!verificarContrasena(username, contrasenaActual)) {System.out.println("\nLa contraseña actual no es válida.\n"); return;}

        System.out.print("Nueva contraseña: ");
        String nuevaContrasena = SC.nextLine();

        // Actualizar la contraseña en el archivo
        try {
            BufferedReader file = new BufferedReader(new FileReader(USUARIOS_FILE));
            StringBuilder inputBuffer = new StringBuilder();
            String line;

            while ((line = file.readLine()) != null) {
                String[] parts = line.split(":");
                String storedUsername = parts[0];
                String storedPassword = parts[2];

                if (storedUsername.equals(username)) {line = line.replace(":" + storedPassword, ":" + nuevaContrasena);}
                inputBuffer.append(line);
                inputBuffer.append('\n');}

            file.close();

            // Sobrescribir el archivo con la contraseña actualizada
            FileWriter fileWriter = new FileWriter(USUARIOS_FILE);
            fileWriter.write(inputBuffer.toString());
            fileWriter.close();

            System.out.println("\nContraseña actualizada exitosamente.");        }
        catch (IOException e) {System.out.println("\nError al actualizar la contraseña.");}

    }  // OPCION 6 DEL MENU
    private static List<String> obtenerUsuarios() {
        List<String> usuarios = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(USUARIOS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String username = parts[0];

                usuarios.add(username);}        }
        catch (IOException e) {System.out.println("\nError al leer el archivo de usuarios.");}

        return usuarios;
    }  // METODO DE OPCION 5
    private static void enviarMensaje(String remitente) {  // OPCION 5 DEL MENU

        System.out.println("\n-----------------------------------------------\nEnviar Mensaje\n-----------------------------------------------");

        // Obtener la lista de usuarios disponibles
        List<String> usuarios = obtenerUsuarios();

        if (usuarios.isEmpty()) {System.out.println("\nNo hay usuarios disponibles para enviar mensajes."); return;}

        System.out.println("\nUsuarios disponibles:");

        for (String usuario : usuarios) {System.out.println(usuario);}

        System.out.print("\nDestinatario: ");
        String destinatario = SC.nextLine();

        // Verificar si el destinatario es válido
        if (!usuarios.contains(destinatario)) {System.out.println("\nEl destinatario no existe. No se puede enviar el mensaje."); return;}

        System.out.print("\nMensaje: ");
        String mensaje = SC.nextLine();

        // Guardar el mensaje en el archivo
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(MENSAJES_FILE, true)))) {
            writer.println(destinatario + ":" + mensaje + ":" + remitente);
            System.out.println("\nMensaje enviado exitosamente.");}
        catch (IOException e) {System.out.println("\nError al escribir en el archivo de mensajes: " + e.getMessage());}

    }  // OPCION 5 DEL MENU
    private static void listarUsuarios() {  // OPCION 4 DEL MENU
        System.out.println("\n-----------------------------------------------\nListado de Usuarios\n-----------------------------------------------");

        try (BufferedReader reader = new BufferedReader(new FileReader(USUARIOS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("0000")){
                    String[] lineData = line.split(":");
                    String expediente = lineData[0];
                    String nombre = lineData[1];
                    System.out.println("\nNúmero de Expediente: " + expediente + "\nNombre: " + nombre + "\n--------------------------");}   }   }

        catch (IOException e) {System.out.println("\nError al leer el archivo de usuarios.");}
    }  // OPCION 4 DEL MENU
    private static void cambiarContrasenaSuperusuario() {  // OPCION 2 DEL MENU

        System.out.println("\n-----------------------------------------------\nCambio de Contraseña del Superusuario\n-----------------------------------------------");

        System.out.print("Contraseña actual: ");
        String contrasenaActual = SC.nextLine();

        System.out.print("Nueva contraseña: ");
        String nuevaContrasena = SC.nextLine();

        // Actualizar la contraseña en el archivo
        try {
            BufferedReader file = new BufferedReader(new FileReader(USUARIOS_FILE));
            StringBuilder inputBuffer = new StringBuilder();
            String line;

            while ((line = file.readLine()) != null) {
                if (line.startsWith("0000")) {
                    // Comprobamos si la contraseña actual coincide con la guardada
                    String[] lineData = line.split(":");

                    if (lineData[1].equals(contrasenaActual)){
                        lineData[1] = nuevaContrasena;
                        line = String.join(":", lineData);}

                    else {System.out.println("\nLa contraseña actual no es válida.");}}

                inputBuffer.append(line);
                inputBuffer.append('\n');}

            file.close();

            // Sobrescribir el archivo con la contraseña actualizada
            FileWriter fileWriter = new FileWriter(USUARIOS_FILE);
            fileWriter.write(inputBuffer.toString());
            fileWriter.close();

            System.out.println("Contraseña actualizada exitosamente.");            }

        catch (IOException e) {System.out.println("Error al actualizar la contraseña.");}        } // OPCION 2 DEL MENU
    private static boolean usuarioExiste(String expediente) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USUARIOS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String storedExpediente = parts[0];

                if (storedExpediente.equals(expediente)) {return true;}    }    }
        catch (IOException e) {System.out.println("\nError al leer el archivo de usuarios.");}

        return false;
    }  // METODO DE OPCION 1 Y 3
    private static void darDeBajaUsuario() {  // OPCION 3 DEL MENU

        System.out.println("\n-----------------------------------------------\nDar de Baja a un Usuario\n-----------------------------------------------");

        System.out.print("Nombre de usuario: ");
        String username = SC.nextLine();

        // Verificar si el usuario existe
        if (!usuarioExiste(username)) {System.out.println("\nEl usuario no existe. No se puede dar de baja."); return;}

        // Eliminar al usuario del archivo
        try {
            BufferedReader file = new BufferedReader(new FileReader(USUARIOS_FILE));
            StringBuilder inputBuffer = new StringBuilder();
            String line;

            while ((line = file.readLine()) != null) {
                String[] parts = line.split(":");
                String storedUsername = parts[0];

                if (!storedUsername.equals(username)) {
                    inputBuffer.append(line);
                    inputBuffer.append('\n');}            }

            file.close();

            // Sobrescribir el archivo sin el usuario dado de baja
            FileWriter fileWriter = new FileWriter(USUARIOS_FILE);
            fileWriter.write(inputBuffer.toString());
            fileWriter.close();

            System.out.println("\nUsuario dado de baja exitosamente.");      }
        catch (IOException e) {System.out.println("\nError al dar de baja al usuario.");}

    }  // OPCION 3 DEL MENU
    private static void darDeAltaUsuario() {  // OPCIÓN 1 DEL MENÚ

        System.out.println("\n-----------------------------------------------\nDar de Alta a un Nuevo Usuario\n-----------------------------------------------");

        System.out.print("Número de expediente: ");
        String expediente = SC.nextLine();
        System.out.print("Nombre: ");
        String nombre = SC.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = SC.nextLine();

        // Verificar si el usuario ya existe
        if (usuarioExiste(expediente)) {System.out.println("\nEl usuario ya existe. No se puede dar de alta.");return;}

        // Guardar el nuevo usuario en el archivo
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(USUARIOS_FILE, true)))) {
            writer.println("\n" + expediente + ":" + nombre + ":" + contrasena);
            System.out.println("\nUsuario dado de alta exitosamente.");}
        catch (IOException e) {System.out.println("\nError al escribir en el archivo de usuarios: " + e.getMessage());}

    }  // OPCION 1 DEL MENU
    private static boolean iniciarSesion(String username, String password) {

        String storedUsername = "";
        String storedPassword = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(USUARIOS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] lineData = line.split(":");

                if (username.equals("0000")){
                    if (line.startsWith(username)){storedUsername = lineData[0]; storedPassword = lineData[1];}     }

                else{storedUsername = lineData[0]; storedPassword = lineData[2];}

                if (storedUsername.equals(username) && storedPassword.equals(password)) {return true;}    }    }

        catch (IOException e) {System.out.println("\nError al leer el archivo de usuarios.");}
        catch (ArrayIndexOutOfBoundsException e){return false;}

        return false;

    }  // METODO DEL SISTEMA DE LOGIN
    private static String login(){

        String username;
        String password;

        while (true) {
            System.out.print("\nNombre de usuario: ");
            username = SC.nextLine();
            System.out.print("Contraseña: ");
            password = SC.nextLine();

            if (iniciarSesion(username, password)) {
                System.out.println("\nInicio de sesión exitoso. ¡Bienvenido, " + username + "!");
                return username;
            } else {
                System.out.println("\nNombre de usuario o contraseña incorrectos. Intenta nuevamente.");
            }
        }
    }  // SISTEMA DE LOGIN
    private static boolean validarPermisos(String username, int func){

        if (func == 1){  // QUEREMOS QUE SEA SUPERUSER
            if (username.equals("0000")) {return true;}
            else {System.out.println("\nNo tienes permisos para realizar esta acción."); return false;}
        }
        else if (func == 2) {  // NO QUEREMOS QUE SEA SUPERUSER
            if (!username.equals("0000")) {return true;}
            else {System.out.println("\nEsta función solo está disponible para usuarios normales."); return false;}
        }
    return false;
    }  // METODO DEL MENU
    private static void menu(String username){

        String[] opciones = {"Dar de alta un nuevo usuario", "Cambiar contraseña del superusuario", "Dar de baja a un usuario",
                "Listado de usuarios", "Enviar mensaje a un usuario", "Cambiar contraseña del usuario", "Ver mensajes pendientes", "Salir"};

        System.out.println("\n-----------------------------------------------\n¡Bienvenido a la aplicación de gestión de mensajes!\n-----------------------------------------------");
        System.out.println("\nMenú Principal\n-----------------------------------------------");
        for (int i = 0; i < opciones.length; i++) {System.out.println((i + 1) + ". " + opciones[i]);}
        System.out.print("\nElige una opción: ");

        int opcion = SC.nextInt();
        SC.nextLine();

        switch (opcion) {
            case 1 -> {if (validarPermisos(username, 1)) {darDeAltaUsuario();}}
            case 2 -> {if (validarPermisos(username, 1)) {cambiarContrasenaSuperusuario();}}
            case 3 -> {if (validarPermisos(username, 1)) {darDeBajaUsuario();}}
            case 4 -> {if (validarPermisos(username, 1)) {listarUsuarios();}}
            case 5 -> enviarMensaje(username);
            case 6 -> {if (validarPermisos(username, 2)){cambiarContrasenaUsuario(username);}}
            case 7 -> verMensajesPendientes(username);
            case 8 -> {System.out.println("\nCerrando la sesión"); System.exit(1);}
            default -> System.out.println("\nOpción inválida. Inténtalo nuevamente.");}


    }  // MENU PRINCIPAL

    public static void main(String[] args) {

        String username = login();
        while(true){menu(username);}

    }

}
