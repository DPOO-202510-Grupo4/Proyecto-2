package Persistencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Tiquetes.TiqueteTemporada;

public class PersistenciaTiqueteTemporada {

    private static final String NOMBREARCHIVO = "tiquetes_temporada.txt";

    public void crearArchivo(String nombreArchivo) {
        try {
            Files.createDirectories(Paths.get("persistencia"), null);
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + nombreArchivo + " " + e.getMessage());
        }
    }

    public void persistencia(String nombre, TiqueteTemporada persistirTiqueteTemporada) {
        crearArchivo(nombre);
        guardarTiqueteTemporada(persistirTiqueteTemporada);
    }

    public void guardarTiqueteTemporada(TiqueteTemporada nombreTiqueteTemporada) {
        try {
            // Verificar si el objeto es una instancia de TiqueteTemporada
            if (nombreTiqueteTemporada instanceof TiqueteTemporada) {
                TiqueteTemporada tiqueteTemporada = (TiqueteTemporada) nombreTiqueteTemporada;
    
                // Bloque para escribir el tiquete en el archivo
                try (BufferedWriter tiqueteEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))) {
                    String tiqueteFormatoTexto = tiqueteTemporada.getIdTiquete() + ","
                            + tiqueteTemporada.getCategoria() + ", "
                            + tiqueteTemporada.isUsado() + ", "
                            + tiqueteTemporada.getFechaInicio() + ", "
                            + tiqueteTemporada.getFechaFinal();
    
                    tiqueteEscrito.write(tiqueteFormatoTexto);
                    tiqueteEscrito.newLine();
                } catch (IOException e) {
                    System.err.println("Error al escribir en el archivo: " + e.getMessage());
                }
            } else {
                System.err.println("El objeto no es un Tiquete Temporada, no se puede guardar.");
            }
        } catch (Exception e) {  // Este bloque solo captura otros tipos de excepciones.
            System.err.println("Error general: " + e.getMessage());
        }
    }
    
}

