package presentacion;

import java.util.Scanner;
import Atracciones.GestorAtracciones;
import Persona.Cliente;
import Persona.GestorPersonas;
import Tiquetes.CategoriaTiquete;
import Tiquetes.Factura;
import Tiquetes.GestorTiquetes;
import restricciones.Temporada;
import Atracciones.AtraccionCultural;
import Atracciones.AtraccionMecanica;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class consolaCliente {

    public static void menuCliente(Scanner scanner) {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n--- MENÚ CLIENTE ---");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Comprar tiquete");
            System.out.println("3. Consultar historial de compras");
            System.out.println("4. Consultar espectáculos");
            System.out.println("5. Consultar atracciones");
            System.out.println("6. Volver al menú principal");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    crearCuentaCliente(scanner);
                    break;
                case 2:
                    comprarTiquete(scanner);
                    break;
                case 3:
                    consultarHistorial(scanner);
                    break;
                case 4:
                    // consultarEspectaculos();
                    break;
                case 5:
                    consultarAtracciones();
                    break;
                case 6:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static void crearCuentaCliente(Scanner scanner) {
        System.out.println("\n--- CREAR CUENTA DE CLIENTE ---");

        System.out.print("Ingrese su nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su login (usuario): ");
        String login = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        GestorPersonas gestorPersonas = GestorPersonas.getInstance();

        if (gestorPersonas.buscarCliente(login) != null) {
            System.out.println("Ya existe una cuenta con ese login.");
            return;
        }

        gestorPersonas.registrarCliente(nombre, login, contrasena);
        System.out.println("¡Cuenta creada exitosamente!");
    }

    static void comprarTiquete(Scanner scanner) {
        System.out.println("¿Desea un tiquete regular (1) o de temporada (2)?");
        int opcion = Integer.parseInt(scanner.nextLine());

        GestorPersonas gestorPersonas = GestorPersonas.getInstance();
        GestorTiquetes gestorTiquetes = GestorTiquetes.getInstancia();

        System.out.println("Ingrese el login del cliente:");
        String login = scanner.nextLine();

        Cliente cliente = gestorPersonas.buscarCliente(login);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        ArrayList<CategoriaTiquete> categorias = gestorTiquetes.getCategoriasDisponibles();
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías disponibles.");
            return;
        }

        System.out.println("Escoja una categoría:");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + ". " + categorias.get(i).getNombre());
        }

        int indiceCategoria = Integer.parseInt(scanner.nextLine()) - 1;
        if (indiceCategoria < 0 || indiceCategoria >= categorias.size()) {
            System.out.println("Categoría inválida.");
            return;
        }

        String nombreCategoria = categorias.get(indiceCategoria).getNombre();

        if (opcion == 1) {
            System.out.println("Ingrese la fecha del tiquete (formato: dd/MM/yyyy):");
            String fechaTexto = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            try {
                Date fecha = sdf.parse(fechaTexto);
                gestorTiquetes.crearTiqueteRegular(cliente, nombreCategoria, fecha);
                System.out.println("¡Tiquete regular creado con éxito!");
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido.");
            }
        } else if (opcion == 2) {
            ArrayList<Temporada> temporadas = gestorTiquetes.getTemporadas();
            if (temporadas.isEmpty()) {
                System.out.println("No hay temporadas disponibles.");
                return;
            }

            System.out.println("Escoja una temporada:");
            for (int i = 0; i < temporadas.size(); i++) {
                System.out.println((i + 1) + ". " + temporadas.get(i).getName());
            }

            int indiceTemporada = Integer.parseInt(scanner.nextLine()) - 1;
            if (indiceTemporada < 0 || indiceTemporada >= temporadas.size()) {
                System.out.println("Temporada inválida.");
                return;
            }

            Temporada temporada = temporadas.get(indiceTemporada);
            gestorTiquetes.crearTiqueteTemporada(cliente, nombreCategoria, temporada);
            System.out.println("¡Tiquete de temporada creado con éxito!");
        } else {
            System.out.println("Opción inválida.");
        }
    }

    private static void consultarHistorial(Scanner scanner) {
        System.out.print("Ingrese el login del cliente: ");
        String login = scanner.nextLine();

        GestorPersonas gestorPersonas = GestorPersonas.getInstance();
        Cliente cliente = gestorPersonas.buscarCliente(login);

        if (cliente == null) {
            System.out.println("Cliente no encontrado. Verifique el login e intente nuevamente.");
            return;
        }

        ArrayList<Factura> historial = cliente.getHistorialCompras();

        if (historial == null || historial.isEmpty()) {
            System.out.println("El cliente no tiene historial de compras.");
            return;
        }

        System.out.println("\n--- HISTORIAL DE COMPRAS DE " + cliente.getNombre() + " ---");
        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i).toString());
        }
    }

    private static void consultarAtracciones() {
        System.out.println("\n--- TODAS LAS ATRACCIONES DEL PARQUE ---");

        GestorAtracciones gestor = GestorAtracciones.getInstancia();
        ArrayList<AtraccionMecanica> atraccionesMecanicas = gestor.getAtraccionesMecanicas();
        ArrayList<AtraccionCultural> atraccionesCulturales = gestor.getAtraccionesCulturales();

        int contador = 1;

        if (atraccionesMecanicas.isEmpty() && atraccionesCulturales.isEmpty()) {
            System.out.println("No hay atracciones registradas en el sistema.");
        } else {
            for (int i = 0; i < atraccionesMecanicas.size(); i++) {
                System.out.println(contador + ". " + atraccionesMecanicas.get(i).toString());
                contador++;
            }

            for (int i = 0; i < atraccionesCulturales.size(); i++) {
                System.out.println(contador + ". " + atraccionesCulturales.get(i).toString());
                contador++;
            }
        }
    }
}
