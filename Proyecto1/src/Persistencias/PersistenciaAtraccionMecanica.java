package Persistencias;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import Atracciones.AtraccionMecanica;
import Atracciones.GestorAtracciones;
import Persona.Empleado;

public class PersistenciaAtraccionMecanica {

    private static final String NOMBREARCHIVO = "persistencia/atracciones/atracciones_mecanicas.txt";

    public void crearArchivo(String nombreArchivo) {
        try {
            Files.createDirectories(Paths.get("persistencia/atracciones"));
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + nombreArchivo + " " + e.getMessage());
        }
    }

    public void persistencia(String nombre, AtraccionMecanica persistirAtraccion) {
        crearArchivo(nombre);
        guardarAtraccion(persistirAtraccion);
    }

    public void guardarAtraccion(AtraccionMecanica atraccion) {
        try (BufferedWriter atraccionEscrita = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))) {

            String empleadosTexto = "";
            List<Empleado> empleados = atraccion.getEmpleadosAsignados();
            for (int i = 0; i < empleados.size(); i++) {
                empleadosTexto += empleados.get(i).getLogin();
                if (i < empleados.size() - 1) {
                    empleadosTexto += ",";
                }
            }

            /* String temporadasTexto = ""; // Comentado por una razón
            List<Temporada> temporadas = atraccion.getDisponibilidad();
            for (int i = 0; i < temporadas.size(); i++) {
                temporadasTexto += temporadas.get(i).getName();
                if (i < temporadas.size() - 1) {
                    temporadasTexto += ",";
                }
            } */

            String restriccionesTexto = "";
            List<String> climas = atraccion.getRestricciones().getClima();
            for (int i = 0; i < climas.size(); i++) {
                restriccionesTexto += climas.get(i);
                if (i < climas.size() - 1) {
                    restriccionesTexto += ",";
                }
            }

            List<String> salud = atraccion.getRestricciones().getSalud();
            if (!climas.isEmpty() && !salud.isEmpty()) {
                restriccionesTexto += "|"; 
            }
            for (int i = 0; i < salud.size(); i++) {
                restriccionesTexto += salud.get(i);
                if (i < salud.size() - 1) {
                    restriccionesTexto += ",";
                }
            }

            restriccionesTexto += ",Altura Minima: " + atraccion.getRestricciones().getAlturaMin();
            restriccionesTexto += ",Altura Maxima: " + atraccion.getRestricciones().getAlturaMax();
            restriccionesTexto += ",Peso Minimo: " + atraccion.getRestricciones().getPesoMin();
            restriccionesTexto += ",Peso Maximo: " + atraccion.getRestricciones().getPesoMax();
            // restriccionesTexto += ",Edad Minima: " + atraccion.getRestricciones().getEdad();

            String atraccionMecanicaFormatoTexto =
                atraccion.getNombre() + "," +
                atraccion.getUbicacion() + "," +
                atraccion.getCupoMax() + "," +
                atraccion.getMinEmpleados() + "," +
                atraccion.getRiesgo() + "," +
                atraccion.isDeTemporada() + "," +
                atraccion.getRestricciones().getExclusividad() + "," +
                // temporadasTexto + "," +
                empleadosTexto + "," +
                restriccionesTexto;

            atraccionEscrita.write(atraccionMecanicaFormatoTexto);
            atraccionEscrita.newLine();

        } catch (IOException e) {
            System.err.println("No se pudo guardar la atraccion: " + e.getMessage());
            
        }
    }
    
    public static void cargarDatos() {
    	GestorAtracciones gestor = GestorAtracciones.getInstancia(); 

        try (BufferedReader lector = new BufferedReader(new FileReader(NOMBREARCHIVO))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    String ubicacion = partes[0].trim();
                    String nombre = partes[1].trim();
                    boolean deTemporada = Boolean.parseBoolean(partes[2].trim()); 
                    boolean disponible = Boolean.parseBoolean(partes[3].trim());
                    int cupoMax = Integer.parseInt(partes[4].trim());
                    int minEmpleados = Integer.parseInt(partes[5].trim());
                    String riesgo = partes[6].trim();
                    String temporadaIn = partes[7].trim(); //AYUDA CON MANEJO DE TEMPORADA
                    gestor.cargarAtraccionMecanica(ubicacion, nombre, deTemporada, disponible,
                           cupoMax, minEmpleados, riesgo, temporadaIn);
                }
            }

        } catch (IOException e) {
            System.err.println("Error al cargar las atracciones mecánicas: " + e.getMessage());
        }

    }
}
