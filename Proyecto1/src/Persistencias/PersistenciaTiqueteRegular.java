package Persistencias;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Persona.Cliente;
import Persona.GestorPersonas;
import Tiquetes.CategoriaTiquete;
import Tiquetes.GestorTiquetes;
import Tiquetes.TiqueteRegular;

public class PersistenciaTiqueteRegular {

    private static final String NOMBRE_ARCHIVO = "persistencia/tiquetes/tiquetes_regulares.csv";

    public static void crearArchivo(String nombreArchivo) {
        try {
            Files.createDirectories(Paths.get("persistencia/tiquetes"));
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + nombreArchivo + " " + e.getMessage());
        }
    }

    public static void persistencia(TiqueteRegular tiquete) {
        crearArchivo(NOMBRE_ARCHIVO);
        guardarTiquete(tiquete);
    }

    public static void guardarTiquete(TiqueteRegular t) {
        if (t == null) {
            System.err.println("El tiquete es nulo, no se puede guardar.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            String linea = t.getIdTiquete() + "," +
                           t.getCategoria().getNombre() + "," +
                           t.isUsado() + "," +
                           t.getFecha();
            writer.write(linea);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar el tiquete: " + e.getMessage());
        }
    }

    public static void cargarDatos() throws ParseException {
    GestorTiquetes gestorT = GestorTiquetes.getInstance();
    GestorPersonas gestorP = GestorPersonas.getInstance();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

    try (BufferedReader lector = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
        String linea;
        while ((linea = lector.readLine()) != null) {
            String[] partes = linea.split(",");

            if (partes.length == 7) {
                String idTiquete = partes[0].trim();
                String categoria = partes[1].trim();
                CategoriaTiquete categoriaTiquete = gestorT.buscarCategoria(categoria);
                boolean usado = Boolean.parseBoolean(partes[2].trim());
                String loginCliente = partes[3].trim();
                String nombre = partes[4].trim();
                double precioBase = Double.parseDouble(partes[5].trim());
                Date fecha = formatter.parse(partes[6].trim());

                Cliente cliente = gestorP.buscarCliente(loginCliente);

                if (cliente != null) {
                    TiqueteRegular tiquete = new TiqueteRegular(nombre, precioBase, idTiquete, categoriaTiquete, usado, cliente, fecha);
                    cliente.agregarTiquete(tiquete);
                } else {
                    System.err.println("Cliente no encontrado: " + loginCliente);
                }
            }
        }

    } 
    catch (IOException e) {
        System.err.println("Error al cargar los tiquetes: " + e.getMessage());
    }
}
}
