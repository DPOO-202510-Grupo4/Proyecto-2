package Presentacion;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Date;
import Persona.GestorPersonas;
import Persona.Rol;
import Persona.Turno;

public class consolaAdministrador {

    public static void menuAdministrador(Scanner scanner) {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n--- MENÚ ADMINISTRADOR ---");

            // Gestión de empleados
            System.out.println("1. Registrar empleado");
            System.out.println("2. Eliminar empleado");
            System.out.println("3. Consultar empleados");
            System.out.println("4. Asignar turno");
            System.out.println("5. Asignar tarea");

            // Gestión de atracciones
            System.out.println("6. Registrar atracción");
            System.out.println("7. Modificar atracción");
            System.out.println("8. Modificar restricciones");
            System.out.println("9. Ver atracciones");

            // Gestión de tiquetes y temporadas
            System.out.println("10. Crear categoría de tiquete");
            System.out.println("11. Consultar categorías de tiquete");
            System.out.println("12. Crear temporada");

            // Salida
            System.out.println("13. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    registrarEmpleado();
                    break;
                case 2:
                    eliminarEmpleado();
                    break;
                case 3:
                    consultarEmpleados();
                    break;
                case 4:
                    asignarTurno();
                    break;
                case 5:
                    asignarTarea();
                    break;
                case 6:
                    registrarAtraccion();
                    break;
                case 7:
                    modificarAtraccion();
                    break;
                case 8:
                    modificarRestricciones();
                    break;
                case 9:
                    verAtracciones();
                    break;
                case 10:
                    crearCategoriaTiquete();
                    break;
                case 11:
                    consultarCategoriasTiquete();
                    break;
                case 12:
                    crearTemporada();
                    break;
                case 13:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void registrarEmpleado() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- REGISTRO DE EMPLEADO ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());

        GestorPersonas gestor = GestorPersonas.getInstance();

        gestor.crearEmpleadoBasico(nombre, login, password, fechaNacimiento);

        System.out.println("Empleado registrado exitosamente.");
    }

    private static void eliminarEmpleado() {
    	Scanner scanner = new Scanner(System.in);

        System.out.println("--- ELIMINACION DE EMPLEADO ---");
        System.out.print("Login: ");
        String login = scanner.nextLine();
        GestorPersonas gestor = GestorPersonas.getInstance();
        gestor.eliminarEmpleado(login);
    }

    private static void consultarEmpleados() {
    	 System.out.println("--- CONSULTAR EMPLEADOS ---");
    	 GestorPersonas gestor = GestorPersonas.getInstance();
    	 //TODO Corregir funcion getEmpleados para imprimir correctamente la lista
    	 System.out.println(gestor.getEmpleados());
    }

    private static void asignarTurno() {
    	Scanner scanner = new Scanner(System.in);
    	Boolean turnoApertura = false;
    	Boolean turnoCierre = false;
    	System.out.println("--- Asignar Turno ---");
    	
    	System.out.print("Login: ");
        String login = scanner.nextLine();
        
        System.out.print("Fecha (YYYY-MM-DD): ");
        String inputFecha = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = sdf.parse(inputFecha);
        
        System.out.print("Turno Apertura: y/n ");
        String turnoAp = scanner.nextLine();
        System.out.print("Turno Cierre: y/n ");
        String turnoCie = scanner.nextLine();
        if (turnoAp.equalsIgnoreCase("y")) {
        	turnoApertura = true;
        }
        if (turnoCie.equalsIgnoreCase("y")) {
        	 turnoCierre = true;
        }
        GestorPersonas gestor = GestorPersonas.getInstance();
        
        Turno turno = new Turno(fecha, turnoApertura, turnoCierre, login);
        gestor.asignarTurno(login, turno);
    }

    private static void asignarTarea() {
        System.out.println("Función para asignar tarea (a implementar)");
    }

    private static void registrarAtraccion() {
        System.out.println("Función para registrar atracción (a implementar)");
    }

    private static void modificarAtraccion() {
        System.out.println("Función para modificar atracción (a implementar)");
    }

    private static void modificarRestricciones() {
        System.out.println("Función para modificar restricciones (a implementar)");
    }

    private static void verAtracciones() {
        System.out.println("Función para ver atracciones (a implementar)");
    }

    private static void crearCategoriaTiquete() {
        System.out.println("Función para crear categoría de tiquete (a implementar)");
    }

    private static void consultarCategoriasTiquete() {
        System.out.println("Función para consultar categorías de tiquete (a implementar)");
    }

    private static void crearTemporada() {
        System.out.println("Función para crear temporada (a implementar)");
    }
}
