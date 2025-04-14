package Persistencias;

import Persona.Persona;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PersistenciaCliente {

    private static final String NOMBREARCHIVO = "persistencia/personas/clientes.csv";

    public static void crearArchivo() {
        try {
            Files.createDirectories(Paths.get("persistencia/personas"));
            File archivo = new File(NOMBREARCHIVO);
            if (!archivo.exists()) {
                archivo.createNewFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                    writer.write("nombre,login,password");
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + NOMBREARCHIVO + " " + e.getMessage());
        }
    }

    public static void persistencia(Persona cliente) {
        crearArchivo();
        guardarCliente(cliente);
    }

    public static void guardarCliente(Persona cliente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))) {
            String lineaCSV = cliente.getNombre() + "," +
                              cliente.getLogin() + "," +
                              cliente.getPassword();
            writer.write(lineaCSV);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("No se pudo guardar el cliente: " + e.getMessage());
        }
    }
}
