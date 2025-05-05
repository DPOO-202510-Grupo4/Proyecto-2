package ParqueDiversiones;

import Atracciones.*;
import Persona.*;
import Persistencias.*;
import restricciones.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ParqueDiversiones {

    private ArrayList<AtraccionMecanica> atraccionesMecanicas;
    private ArrayList<AtraccionCultural> atraccionesCulturales;

    public ParqueDiversiones() {
        atraccionesMecanicas = new ArrayList<>();
    }

    public void cargarAtraccionesMecanicas(String rutaArchivo) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                
                String nombre = partes[0];
                String ubicacion = partes[1];
                int cupoMax = Integer.parseInt(partes[2]);
                int minEmpleados = Integer.parseInt(partes[3]);
                boolean deTemporada = Boolean.parseBoolean(partes[4]);

                Temporada temporada = null;
                int i = 5;
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
        parque.cargarAtraccionesMecanicas("persistencia/atracciones/mecanicas.csv");
        parque.cargarAtraccionesCulturales("persistencia/atracciones/culturales.csv");
        parque.cargarEmpleados("persistencia/empleados.csv");
        parque.cargarClientes("persistencia/clientes.csv");
        parque.cargarTiquetes("persistencia/tiquetes.csv");

        parque.getAtraccionesMecanicas().forEach(System.out::println);
        parque.getAtraccionesCulturales().forEach(System.out::println);
        parque.getEmpleados().forEach(System.out::println);
        parque.getClientes().forEach(System.out::println);
        parque.getTiquetes().forEach(System.out::println);
    }
}
