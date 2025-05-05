package Persistencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Atracciones.AtraccionCultural;
import Persona.Empleado;
import Tiquetes.ItemVenta;
import java.util.List;
import restricciones.Temporada;

public class PersistenciaAtraccionCultural {

    private static final String NOMBREARCHIVO = "persistencia/atracciones/atracciones_culturales.txt";

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

    public void persistencia(String nombre, AtraccionCultural persistirAtraccion) {
        crearArchivo(nombre);
        guardarAtraccion(persistirAtraccion);
    }

    public void guardarAtraccion(AtraccionCultural atraccion) {
        try (BufferedWriter atraccionEscrita = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))) {

            String empleadosTexto = "";
            List<Empleado> empleados = atraccion.getEmpleadosAsignados();
            for (int i = 0; i < empleados.size(); i++) {
                empleadosTexto += empleados.get(i).getLogin();
                if (i < empleados.size() - 1) {
                    empleadosTexto += ",";
                }
            }

            String temporadasTexto = "";
            List<Temporada> temporadas = atraccion.getDisponibilidad();
            for (int i = 0; i < temporadas.size(); i++) {
                temporadasTexto += temporadas.get(i).getName();
                if (i < temporadas.size() - 1) {
                    temporadasTexto += ",";
                }
            }

            String restriccionesTexto = "";
            List<String> climas = atraccion.getRestricciones().getClima();
            for (int i = 0; i < climas.size(); i++) {
                restriccionesTexto += climas.get(i);
                if (i < climas.size() - 1) {
                    restriccionesTexto += ",";
                }
            }
            restriccionesTexto += ",Edad Minima: " + atraccion.getRestricciones().getEdad();

            String atraccionCulturalFormatoTexto =
                atraccion.getNombre() + "," +
                atraccion.getUbicacion() + "," +
                atraccion.getCupoMax() + "," +
                atraccion.getMinEmpleados() + "," +
                atraccion.isDeTemporada() + "," +
                empleadosTexto + "," +
                temporadasTexto + "," +
                restriccionesTexto + "," +
                atraccion.getRestricciones().getExclusividad();

            atraccionEscrita.write(atraccionCulturalFormatoTexto);
            atraccionEscrita.newLine();

        } catch (IOException e) {
            System.err.println("No se pudo guardar la atraccion: " + e.getMessage());
        }
    }
    
    public static void cargarDatos() {
    	GestorAtracciones gestor = GestorAtracciones.getInstance();

        try (BufferedReader lector = new BufferedReader(new FileReader(NOMBREARCHIVO))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    String nombre = partes[0].trim();
                    String login = partes[1].trim();
                    String password = partes[2].trim();
                    String fechaNacimiento = partes[3].trim();
                    gestor.cargarAdministrador(nombre, login, password, fechaNacimiento);
                }
            }

        } catch (IOException e) {
            System.err.println("Error al cargar los administradores: " + e.getMessage());
        }

    }
}