package Presentacion;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    consolaCliente.menuCliente(scanner);
                    break;
                case 2:
                    consolaEmpleado.menuEmpleado(scanner);
                    break;
                case 3:
                    consolaAdministrador.menuAdministrador(scanner);
                    break;
                case 4:
                    System.out.println("¡Gracias por visitar el parque!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n===== PARQUE TEMÁTICO =====");
        System.out.println("1. Soy cliente");
        System.out.println("2. Soy empleado");
        System.out.println("3. Soy administrador");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
