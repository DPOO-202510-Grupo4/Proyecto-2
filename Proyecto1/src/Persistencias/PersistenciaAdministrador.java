package Persistencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import Persona.Administrador;

public class PersistenciaAdministrador {

    private static final String RUTA_ARCHIVO = "persistencia/personas/administradores.txt";

    private void crearArchivoSiNoExiste() {
        try {
            Files.createDirectories(Paths.get("persistencia/personas"));
            File archivo = new File(RUTA_ARCHIVO);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public void guardarAdministrador(Administrador admin) {
        crearArchivoSiNoExiste();

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, true))) {
            String linea = String.format(
                "Nombre: %s, Login: %s, Password: %s, FechaNacimiento: %s",
                admin.getNombre(), admin.getLogin(), admin.getPassword(), admin.getFechaNacimiento()
            );
            escritor.write(linea);
            escritor.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar el administrador: " + e.getMessage());
        }
    }
}
