package Persistencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Persona.Empleado;
import Persona.Persona;

public class PersistenciaEmpleado {

    private static final String NOMBREARCHIVO = "persistencia/personas/empleados.txt";

    public static void crearArchivo(String nombreArchivo){
        try {
            Files.createDirectories(Paths.get("persistencia/personas"));
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()){
                archivo.createNewFile();
            }
        } catch(IOException e){
            System.err.println("Error al crear el archivo: " + nombreArchivo + " " + e.getMessage());
        }
    }

    public static void persistencia(Empleado persistirPersona){
        crearArchivo(NOMBREARCHIVO);
        guardarEmpleado(persistirPersona);
    }

    public static void guardarEmpleado(Empleado persona){
        if (!(persona instanceof Empleado)) {
            System.err.println("El objeto no es un empleado, no se puede guardar.");
            return;
        }

        Empleado empleado = (Empleado) persona;

        try (BufferedWriter empleadoEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))) {
            String empleadoFormatoTexto = "Nombre: " + empleado.getNombre()
                + ", Login: " + empleado.getLogin()
                + ", Password: " + empleado.getPassword()
                + ", Turnos: " + empleado.getTurnos().toString();
                //+ ", LugarTrabajo: " + empleado.getLugarTrabajo().toString()
                //+ ", RolActual: " + empleado.getRolActual().toString();

            empleadoEscrito.write(empleadoFormatoTexto);
            empleadoEscrito.newLine();

        } catch(IOException e){
            System.err.println("No se pudo guardar el empleado: " + e.getMessage());
        }
    }
}
