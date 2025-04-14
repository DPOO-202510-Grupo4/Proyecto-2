package Persistencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import Persona.Administrador;

public class PersistenciaAdministrador {

    private static final String NOMBREARCHIVO = "persistencia/personas/administradores.txt";

    public static void crearArchivo() {
        try {
            Files.createDirectories(Paths.get("persistencia/personas"));
            File archivo = new File(NOMBREARCHIVO);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public static void persistencia(Administrador persistirAdministrador) {
        crearArchivo(); 
        guardarAdministrador(persistirAdministrador);
    }

    public static void guardarAdministrador(Administrador administrador) {
        if (!(administrador instanceof Administrador)) {
            System.err.println("El objeto no es un administrador, no se puede guardar.");
            return;
        }

        try (BufferedWriter administradorEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))) {
            String administradorFormatoTexto = String.format(
                "Nombre: %s, Login: %s, Password: %s, FechaNacimiento: %s",
                administrador.getNombre(),
                administrador.getLogin(),
                administrador.getPassword(),
                administrador.getFechaNacimiento()
            );
            administradorEscrito.write(administradorFormatoTexto);
            administradorEscrito.newLine();
        } catch (IOException e) {
            System.err.println("No se pudo guardar el administrador: " + e.getMessage());
        }
    }
}
