package presentacion;

import java.util.Scanner;

public class consolaEmpleado {

    public static void menuEmpleado(Scanner scanner) {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- MENÚ EMPLEADO ---");
            System.out.println("1. Consultar Turnos");
            System.out.println("2. Consultar Tareas");
            System.out.println("3. Consultar Capacitaciones");
            System.out.println("4. Registrar Venta");
            System.out.println("5. Registrar Tiquete");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    consultarTurnos(scanner);
                    break;
                case 2:
                    consultarTareas(scanner);
                    break;
                case 3:
                    consultarCapacitaciones(scanner);
                    break;
                case 4:
                    registrarVenta(scanner);
                    break;
                case 5:
                    registrarTiquete(scanner);
                    break;
                case 6:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void consultarTurnos(Scanner scanner) {
        System.out.println("\n--- CONSULTAR TURNOS ---");
        
    }

    private static void consultarTareas(Scanner scanner) {
        System.out.println("\n--- CONSULTAR TAREAS ---");
        
    }

    private static void consultarCapacitaciones(Scanner scanner) {
        System.out.println("\n--- CONSULTAR CAPACITACIONES ---");
        
    }

    private static void registrarVenta(Scanner scanner) {
        System.out.println("\n--- REGISTRAR VENTA ---");
        
    }

    private static void registrarTiquete(Scanner scanner) {
        System.out.println("\n--- REGISTRAR TIQUETE ---");
        
    }
}
