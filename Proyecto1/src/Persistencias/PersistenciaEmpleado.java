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

    private static final String NOMBREARCHIVO = "empleados.txt";

    public void crearArchivo(String nombreArchivo){

        try {
            Files.createDirectories(Paths.get("persistencia"), null);
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()){
                archivo.createNewFile();
            }

        } catch(IOException e){
            System.err.println("Error al crear el archivo: " + nombreArchivo + " " + e.getMessage());
        }

    }

    public void persistencia(String nombre, Persona persistirPersona){

        crearArchivo(nombre);
        guardarEmpleado(persistirPersona);

    }

    public void guardarEmpleado(Persona nombreEmpleado){

        try {
            if (nombreEmpleado instanceof Empleado) {
                Empleado empleado = (Empleado) nombreEmpleado;
                
                // Corregido: Abrir y cerrar BufferedWriter correctamente
                BufferedWriter empleadoEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true));
                String empleadoFormatoTexto = "Nombre: " + empleado.getNombre() + ", Login: " + empleado.getLogin()
                + ", Password: " + empleado.getPassword() +  ", Turno: " + empleado.getTurno();
                
                empleadoEscrito.write(empleadoFormatoTexto);
                empleadoEscrito.newLine();
                empleadoEscrito.close();
            } else {
                System.err.println("El objeto no es un empleado, no se puede guardar.");
            }
        } catch(IOException e){
            System.err.println("No se pudo guardar el empleado");
        }
    }
}
