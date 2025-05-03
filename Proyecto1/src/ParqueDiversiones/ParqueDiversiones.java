package ParqueDiversiones;

import Atracciones.AtraccionMecanica;
import Persona.Empleado;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import restricciones.RestriccionesMecanica;
import restricciones.Temporada;

public class ParqueDiversiones {

    private ArrayList<AtraccionMecanica> atraccionesMecanicas;

    public ParqueDiversiones() {
        atraccionesMecanicas = new ArrayList<>();
    }

    public void cargarAtraccionesMecanicas(String rutaArchivo) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");

                String nombre = partes[1];
                String ubicacion = partes[2];
                int cupoMax = Integer.parseInt(partes[3]);
                int minEmpleados = Integer.parseInt(partes[4]);
                boolean deTemporada = Boolean.parseBoolean(partes[5]);

                Temporada temporada = null;
                int i = 6;
                if (deTemporada) {
                    String nombreTemporada = partes[i++];
                    Date fechaInicio = formatoFecha.parse(partes[i++]);
                    Date fechaFin = formatoFecha.parse(partes[i++]);
                    temporada = new Temporada(fechaInicio, fechaFin, nombreTemporada);
                }

                String riesgo = partes[i++];
                double alturaMin = Double.parseDouble(partes[i++]);
                double alturaMax = Double.parseDouble(partes[i++]);
                double pesoMin = Double.parseDouble(partes[i++]);
                double pesoMax = Double.parseDouble(partes[i++]);

                ArrayList<String> climas = new ArrayList<>();
                while (i < partes.length && !partes[i].equalsIgnoreCase("Exclusiva") && !partes[i].equalsIgnoreCase("Normal")) {
                    climas.add(partes[i++].toLowerCase());
                }

                String exclusividad = partes[i++];
                ArrayList<String> salud = new ArrayList<>();
                while (i < partes.length) {
                    salud.add(partes[i++].toLowerCase());
                }

                RestriccionesMecanica restricciones = new RestriccionesMecanica(
                        climas, exclusividad, alturaMin, alturaMax, pesoMin, pesoMax, salud);

                ArrayList<Empleado> empleados = new ArrayList<>(); // cargar datos de empleados
                AtraccionMecanica mecanica = new AtraccionMecanica(
                        nombre, ubicacion, cupoMax, minEmpleados, deTemporada, temporada, riesgo, restricciones, empleados);

                atraccionesMecanicas.add(mecanica);
            }

        } catch (IOException | ParseException e) {
            System.out.println("Error al cargar atracciones mecánicas: " + e.getMessage());
        }
    }

    public ArrayList<AtraccionMecanica> getAtraccionesMecanicas() {
        return atraccionesMecanicas;
    }

    public static void main(String[] args) {
    
        ParqueDiversiones parque = new ParqueDiversiones();
        parque.cargarAtraccionesMecanicas("Proyecto1/persistencia/atracciones/mecanica.csv");

        parque.getAtraccionesMecanicas().forEach(System.out::println);
    }
}
