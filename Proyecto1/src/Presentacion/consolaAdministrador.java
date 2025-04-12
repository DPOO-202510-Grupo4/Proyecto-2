package presentacion;

import java.util.Scanner;

public class consolaAdministrador {

    public static void menuAdministrador(Scanner scanner) {
        boolean volver = false;
        while (!volver) {
        	//Gestion empleados
            System.out.println("\n--- MENÚ ADMINISTRADOR ---");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Eliminar empleado");
            System.out.println("3. Consultar empleados");
            System.out.println("4. Asignar turno");
            System.out.println("5. Asignar tarea");
            
            //Gestion Atracciones
            System.out.println("6. Registrar Atraccion");
            System.out.println("7. Modificar Atraccion");
            System.out.println("8. Modificar Restricciones");
            System.out.println("9. Ver atracciones");
            //Gestion Tiquetes
            System.out.println("9. Crear Categoria de Tiquete");
            System.out.println("10. Consultar Categorias de Tiquete");
            System.out.println("11. Crear Temporada");
            System.out.println("12. Volver al menú principal");
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
