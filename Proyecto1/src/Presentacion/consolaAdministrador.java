package presentacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

import Atracciones.GestorAtracciones;

import java.util.ArrayList;
import java.util.Date;
import Persona.GestorPersonas;
import Persona.Rol;
import Persona.Turno;
import restricciones.RestriccionesCultural;
import restricciones.RestriccionesMecanica;

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
            System.out.println("6. Crear Rol");

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
        Date fecha = null;
		try {
			fecha = sdf.parse(inputFecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
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
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("--- Asignar TAREA ---");
    	
    	System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Tarea: ");
        String tarea = scanner.nextLine();
        GestorPersonas gestor = GestorPersonas.getInstance();
        
        gestor.asignarTarea(login, tarea);
        
    }

    private static void registrarAtraccion() {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("--- Asignar TAREA ---");
    	System.out.println("1. Registar Atracción Mecánica: ");
    	System.out.println("2. Registar Atracción Cultural: ");
    	System.out.println("3. Registar Espectáculo: ");
    	
    	 int opcion = Integer.parseInt(scanner.nextLine());

         switch (opcion) {
             case 1:
            	 registrarAtraccionMecanica();
                 break;
             case 2:
            	 registrarAtraccionCultural();
                 break;
             case 3:
            	 registrarEspectaculo();
                 break;
         }
    }

    private static void registrarEspectaculo() {
    	//TODO por implementar
    }
		
	

    private static void registrarAtraccionCultural() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- CREAR ATRACCIÓN CULTURAL ---");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ubicación: ");
        String ubicacion = scanner.nextLine();

        System.out.print("¿Es de temporada? (y/n): ");
        boolean deTemporada = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("¿Está disponible? (y/n): ");
        boolean disponible = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Capacidad máxima: ");
        int capacidad = Integer.parseInt(scanner.nextLine());

        System.out.print("Mínimo de empleados: ");
        int minEmpleados = Integer.parseInt(scanner.nextLine());

        System.out.println("--- RESTRICCIONES ---");

        ArrayList<String> salud = new ArrayList<>();
        ArrayList<String> clima = new ArrayList<>();

        System.out.print("Exclusividad: ");
        String exclusividad = scanner.nextLine();

        System.out.print("Edad mínima: ");
        int edadMin = Integer.parseInt(scanner.nextLine());

        System.out.print("¿Desea agregar condiciones de salud? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            String condicion;
            do {
                System.out.print("Condición de salud (escriba 'fin' para terminar): ");
                condicion = scanner.nextLine();
                if (!condicion.equalsIgnoreCase("fin")) {
                    salud.add(condicion);
                }
            } while (!condicion.equalsIgnoreCase("fin"));
        }

        System.out.print("¿Desea agregar condiciones climáticas? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            String condicion;
            do {
                System.out.print("Condición climática (escriba 'fin' para terminar): ");
                condicion = scanner.nextLine();
                if (!condicion.equalsIgnoreCase("fin")) {
                    clima.add(condicion);
                }
            } while (!condicion.equalsIgnoreCase("fin"));
        }

        RestriccionesCultural restricciones = new RestriccionesCultural(clima ,exclusividad, edadMin);

        GestorAtracciones gestor = GestorAtracciones.getInstancia();
        gestor.crearAtraccionCultural(ubicacion, nombre, deTemporada, disponible, capacidad, minEmpleados, edadMin, restricciones);

        System.out.println("Atracción cultural registrada con éxito.");
    }
		
	

	private static void registrarAtraccionMecanica() {
		Scanner scanner = new Scanner(System.in);
		Boolean deTemporada = false;
		Boolean disponible = false;
	    System.out.println("--- CREAR ATRACCIÓN MECÁNICA ---");
	    System.out.print("Nombre: ");
	    String nombre = scanner.nextLine();

	    System.out.print("Ubicación: ");
	    String ubicacion = scanner.nextLine();
	    System.out.print("Riesgo: ");
	    String riesgo = scanner.nextLine();
	    
	    System.out.print("Es de temporada? y/n ");
        String deTemp = scanner.nextLine();
        if (deTemp.equalsIgnoreCase("y")) {
        	deTemporada = true;
        }
        System.out.print("Esta disponible? y/n ");
        String disp = scanner.nextLine();
        if (disp.equalsIgnoreCase("y")) {
        	disponible = true;
        }

	    System.out.print("Capacidad máxima: ");
	    int capacidad = Integer.parseInt(scanner.nextLine());
	    
	    System.out.print("Mínimo de empleados: ");
	    int minEmpleados = Integer.parseInt(scanner.nextLine());
	    System.out.println("--- RESTRICCIONES ---");
	    ArrayList<String> salud = new ArrayList<>();
	    ArrayList<String> clima = new ArrayList<>();
	    System.out.print("Exclusividad: ");
	    String exclusividad = scanner.nextLine();
	    System.out.print("altura máxima: ");
	    int alturaMax = Integer.parseInt(scanner.nextLine());
	    System.out.print("altura minima: ");
	    int alturaMin = Integer.parseInt(scanner.nextLine());
	    System.out.print("peso máximo: ");
	    int pesoMax = Integer.parseInt(scanner.nextLine());
	    System.out.print("peso minimo: ");
	    int pesoMin = Integer.parseInt(scanner.nextLine());
	    RestriccionesMecanica restricciones = new RestriccionesMecanica(clima, exclusividad, alturaMin, alturaMax,pesoMin,pesoMax,salud );
	    
	    GestorAtracciones gestor = GestorAtracciones.getInstancia();
	    gestor.crearAtraccionMecanica(ubicacion, nombre, deTemporada, disponible, capacidad, minEmpleados, riesgo, restricciones);
	    System.out.println("Atracción mecánica registrada con éxito.");
	
		
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
    //

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
