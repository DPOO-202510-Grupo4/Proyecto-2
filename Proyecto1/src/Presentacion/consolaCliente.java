package presentacion;

import java.util.Scanner;

public class consolaCliente {

    public static void menuCliente(Scanner scanner) {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- MENÚ CLIENTE ---");
            System.out.println("1. Comprar tiquete");
            System.out.println("2. Usar FastPass");
            System.out.println("3. Consultar atracciones");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    System.out.println("Función para comprar tiquete (a implementar)");
                    break;
                case 2:
                    System.out.println("Función para usar FastPass (a implementar)");
                    break;
                case 3:
                    System.out.println("Función para consultar atracciones (a implementar)");
                    break;
                case 4:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
