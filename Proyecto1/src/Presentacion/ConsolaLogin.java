package presentacion;

import java.util.Scanner;

import Persona.GestorPersonas;
import Persona.GestorPersonas.TipoUsuario;

public class ConsolaLogin {

    private void registrarCuentaCliente() {
        Scanner scanner = new Scanner(System.in);
        GestorPersonas gestorPersonas = GestorPersonas.getInstance();

        while (true) {
            System.out.println("\n--- CREAR CUENTA ---");
            System.out.println("Ingrese 0 en cualquier momento para volver al menú principal.");

            System.out.print("Ingrese su nombre completo: ");
            String nombre = scanner.nextLine();
            if (nombre.equals("0")) return;

            System.out.print("Ingrese su login (usuario): ");
            String login = scanner.nextLine();
            if (login.equals("0")) return;

            System.out.print("Ingrese su contraseña: ");
            String contrasena = scanner.nextLine();
            if (contrasena.equals("0")) return;

            if (gestorPersonas.buscarCliente(login) != null) {
                System.out.println("Ya existe una cuenta con ese login.");
                return;
            } else {
                gestorPersonas.registrarCliente(nombre, login, contrasena);
                System.out.println("¡Cuenta creada exitosamente!");
                return;
            }
        }
    }

    public void iniciarSesion() {
        Scanner scanner = new Scanner(System.in);
        GestorPersonas gestor = GestorPersonas.getInstance();

        System.out.println("\n--- INICIAR SESIÓN ---");
        System.out.println("Ingrese 0 como usuario para volver al menú principal.");

        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        if (usuario.equals("0")) return;

        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        TipoUsuario tipo = gestor.validarLogin(usuario, contrasena);

        switch (tipo) {
            case ADMINISTRADOR:
                System.out.println("Bienvenido Administrador.");
                consolaAdministrador.menuAdministrador(scanner);
                break;
            case EMPLEADO:
                System.out.println("Bienvenido Empleado.");
                consolaEmpleado.menuEmpleado(scanner);
                break;
            case CLIENTE:
                System.out.println("Bienvenido Cliente.");
                consolaCliente.menuCliente(scanner);
                break;
            case NO_ENCONTRADO:
                System.out.println("Usuario o contraseña incorrectos.");
                break;
        }
    }

    public static void main(String[] args) {
        boolean volver = false;
        Scanner scanner = new Scanner(System.in);
        ConsolaLogin login = new ConsolaLogin();

        while (!volver) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Crear Cuenta");
            System.out.println("3. Salir");

            String entrada = scanner.nextLine();

            switch (entrada) {
                case "1":
                    login.iniciarSesion();
                    break;
                case "2":
                    login.registrarCuentaCliente();
                    break;
                case "3":
                    volver = true;
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
