package Persistencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import Persona.Empleado;
import Persona.Capacitaciones;
import Atracciones.Atraccion;

public class PersistenciaEmpleado {

    private static final String NOMBREARCHIVO = "persistencia/personas/empleados.csv";

    public static void crearArchivo(String nombreArchivo) {
        try {
            Files.createDirectories(Paths.get("persistencia/personas"));
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + nombreArchivo + " " + e.getMessage());
        }
    }

    public static void persistencia(Empleado persistirPersona) {
        crearArchivo(NOMBREARCHIVO);
        guardarEmpleado(persistirPersona);
    }

    public static void guardarEmpleado(Empleado persona) {
        if (!(persona instanceof Empleado)) {
            System.err.println("El objeto no es un empleado, no se puede guardar.");
            return;
        }

        Empleado empleado = (Empleado) persona;

        try (BufferedWriter empleadoEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))) {
            String empleadoFormatoTexto = empleado.getNombre() + ","
                    + empleado.getLogin() + ","
                    + empleado.getPassword() + ","
                    + empleado.getTurnos().toString();

            if (empleado.getLugarTrabajo() != null) {
                empleadoFormatoTexto += "," + empleado.getLugarTrabajo().getNombre();
            } else {
                empleadoFormatoTexto += ",N/A";
            }

            if (empleado.getRolActual() != null) {
                empleadoFormatoTexto += "," + empleado.getRolActual().getNombre();
            } else {
                empleadoFormatoTexto += ",N/A";
            }

            Capacitaciones capacitaciones = empleado.getCapacitaciones();
            if (capacitaciones != null) {
                empleadoFormatoTexto += "," + capacitaciones.getEsCocinero() + ","
                        + capacitaciones.getEsCajero();

                if (capacitaciones.getCapacitacionAtracciones() != null && !capacitaciones.getCapacitacionAtracciones().isEmpty()) {
                    StringBuilder atraccionesNombres = new StringBuilder();
                    for (Atraccion atraccion : capacitaciones.getCapacitacionAtracciones()) {
                        atraccionesNombres.append(atraccion.getNombre()).append(", ");
                    }
                    empleadoFormatoTexto += "," + atraccionesNombres.toString();
                } else {
                    empleadoFormatoTexto += ",N/A";
                }
            } else {
                empleadoFormatoTexto += ",N/A,N/A,N/A";
            }

            empleadoEscrito.write(empleadoFormatoTexto);
            empleadoEscrito.newLine();

        } catch (IOException e) {
            System.err.println("No se pudo guardar el empleado: " + e.getMessage());
        }
    }
}
