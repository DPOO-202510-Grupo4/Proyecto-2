package presentacion;

import java.util.Scanner;

public class consolaEmpleado {

    public static void menuAdministrador(Scanner scanner) {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- MENÚ EMPLEADO ---");
            System.out.println("1. Consultar Turnos");
            System.out.println("2. Consultar Capacitaciones");
            System.out.println("3. Registrar Venta");
            System.out.println("4. Registrar Tiquete");
            System.out.print("Seleccione una opción: ");

            int opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    System.out.println("Función para registrar empleado (a implementar)");
                    break;
                case 2:
                    System.out.println("Función para asignar turno (a implementar)");
                    break;
                case 3:
                    System.out.println("Función para consultar empleados (a implementar)");
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