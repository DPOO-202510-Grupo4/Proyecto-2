package presentacion;

import java.util.Scanner;
import Atracciones.GestorAtracciones;
import Atracciones.Atraccion;
import Atracciones.AtraccionCultural;
import Atracciones.AtraccionMecanica;
//import Espectaculos.Espectaculo;

import java.util.ArrayList;

public class consolaCliente {

    public static void menuCliente(Scanner scanner) {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n--- MENÚ CLIENTE ---");
            System.out.println("1. Comprar tiquete");
            System.out.println("2. Consultar historial de compras");
            System.out.println("3. Consultar espectáculos");
            System.out.println("4. Consultar atracciones");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    comprarTiquete(scanner);
                    break;
                case 2:
                    consultarHistorial(scanner);
                    break;
                case 3:
                    //consultarEspectaculos();
                    break;
                case 4:
                    consultarAtracciones(scanner);
                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static void comprarTiquete(Scanner scanner) {
        System.out.println("\nFunción para comprar tiquete (por implementar)");
        
    }

    private static void consultarHistorial(Scanner scanner) {
        System.out.println("\nFunción para consultar historial de compras (por implementar)");
    }

    /*private static void consultarEspectaculos() {
        System.out.println("\n--- ESPECTÁCULOS DISPONIBLES ---");
        GestorAtracciones gestor = GestorAtracciones.getInstancia();

        ArrayList<Espectaculos> espectaculos = gestor.obtenerEspectaculos();
        if (espectaculos.isEmpty()) {
            System.out.println("No hay espectáculos disponibles en este momento.");
        } else {
            for (Espectaculo e : espectaculos) {
                System.out.println(e.toString());
            }
        }
    }*/


        private static void consultarAtracciones(Scanner scanner) {
        System.out.println("\n--- TODAS LAS ATRACCIONES DEL PARQUE ---");
        int i = 1;
        GestorAtracciones gestor = GestorAtracciones.getInstancia();
        ArrayList<AtraccionMecanica> atraccionesMecanicas = gestor.getAtraccionesMecanicas();
        ArrayList<AtraccionCultural> atraccionesCulturales = gestor.getAtraccionesCulturales();

        if (atraccionesMecanicas.isEmpty() && atraccionesCulturales.isEmpty()) {
            System.out.println("No hay atracciones registradas en el sistema.");
        } else {
            for (AtraccionMecanica am : atraccionesMecanicas) {
                System.out.println(i + "." + am.toString());
                i++;
            for (AtraccionMecanica ac : atraccionesMecanicas) {
                System.out.println(i + "." + ac.toString());
                i++;
                }    
        }
      }
    }
 }
