package Persona;

import Atracciones.Atraccion;
import Persistencias.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class GestorPersonas {

    private static GestorPersonas instanciaUnica;

    private ArrayList<Administrador> administradores;
    private ArrayList<Empleado> empleados;
    private HashMap<String, Cliente> clientes;

    private GestorPersonas() {
        this.empleados = new ArrayList<>();
        this.clientes = new HashMap<>();
    }

    public static GestorPersonas getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new GestorPersonas();
        }
        return instanciaUnica;
    }

    //------------------------ EMPLEADOS ------------------------

    public Empleado crearEmpleadoBasico(String nombre, String login, String password, LocalDate fechaNacimiento) {
        Empleado nuevo = new Empleado(nombre, login, password, fechaNacimiento);
        registrarEmpleado(nuevo);
        return nuevo;
    }

    public void registrarEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
        PersistenciaEmpleado.persistencia(empleado);
    }

    public void eliminarEmpleado(String login) {
        Empleado empleadoAEliminar = null;
        for (Empleado empleado : this.empleados) {
            if (empleado.getLogin().equals(login)) {
                empleadoAEliminar = empleado;
                break;
            }
        }
        if (empleadoAEliminar != null) {
            this.empleados.remove(empleadoAEliminar);
            System.out.println("Empleado con login '" + login + "' eliminado exitosamente.");
        } else {
            System.out.println("Empleado con login '" + login + "' no encontrado.");
        }
    }

    public String obtenerEmpleadoPorID(String login) {
        for (Empleado empleado : this.empleados) {
            if (empleado.getLogin().equals(login)) {
                return empleado.toString();
            }
        }
        return "Empleado no encontrado.";
    }

    public ArrayList<Empleado> empleadosPorTipo(String tipo) {
        ArrayList<Empleado> empleadosTipo = new ArrayList<>();
        // TODO: Implementar filtro por tipo
        return empleadosTipo;
    }

    public ArrayList<Empleado> empleadosDisponibles(LocalDate fecha, String lugar) {
        ArrayList<Empleado> empleadosDisponibles = new ArrayList<>();
        for (Empleado empleado : this.empleados) {
            for (Turno turno : empleado.getTurnos()) {
                if (!turno.getFecha().equals(fecha) && !turno.getLugarTrabajo().equals(lugar)) {
                    empleadosDisponibles.add(empleado);
                }
            }
        }
        return empleadosDisponibles;
    }

    public void asignarTurno(String login, Turno turno) {
        for (Empleado empleado : empleados) {
            if (empleado.getLogin().equals(login)) {
                if (empleado.getTurnos().contains(turno)) {
                    System.out.println("El empleado ya tiene un turno asignado en esa fecha.");
                } else {
                    empleado.getTurnos().add(turno);
                }
                return;
            }
        }
        System.out.println("Empleado no encontrado para asignar turno.");
    }

    public ArrayList<Turno> turnosDeEmpleado(Empleado empleado) {
        return new ArrayList<>(empleado.getTurnos());
    }

    public ArrayList<Empleado> empleadosConCapacitacion(Capacitaciones capacitacion) {
        ArrayList<Empleado> empleadosCapacitacion = new ArrayList<>();
        for (Empleado empleado : this.empleados) {
            if (empleado.getCapacitaciones().contains(capacitacion)) {
                empleadosCapacitacion.add(empleado);
            }
        }
        return empleadosCapacitacion;
    }

    public void asignarTarea(String login, String tarea) {
        for (Empleado empleado : empleados) {
            if (empleado.getLogin().equals(login)) {
                if (empleado.getTareas().contains(tarea)) {
                    System.out.println("El empleado ya tiene esta tarea asignada.");
                } else {
                    empleado.getTareas().add(tarea);
                }
                return;
            }
        }
        System.out.println("Empleado no encontrado para asignar tarea.");
    }

    public boolean verificarMinimosAtraccion(Atraccion atraccion, LocalDate fecha) {
        // TODO: implementar verificación de mínimos
        return false;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    //------------------------ CLIENTES ------------------------

    public void registrarCliente(String nombre, String login,String contrasena) {
    	Cliente nuevoCliente = new Cliente(nombre, login, contrasena);
        clientes.put(nuevoCliente.getLogin(), nuevoCliente);
        PersistenciaCliente.persistencia(nuevoCliente);
    }

    public Cliente buscarCliente(String login) {
        return clientes.get(login);
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    //------------------------ ADMINISTRADORES ------------------------

    public Administrador crearAdministrador(String nombre, String login, String password, LocalDate fechaNacimiento) {
        Administrador nuevoAdministrador = new Administrador(nombre, login, password, fechaNacimiento);
        registrarAdministrador(nuevoAdministrador);
        return nuevoAdministrador;
    }

    public void registrarAdministrador(Administrador administrador) {
        this.administradores.add(administrador);
        PersistenciaAdministrador.persistencia(administrador);  
    }

    public void eliminarAdministrador(String login) {
        Administrador administradorAEliminar = null;
        for (Administrador administrador : this.administradores) {
            if (administrador.getLogin().equals(login)) {
                administradorAEliminar = administrador;
                break;
            }
        }
        if (administradorAEliminar != null) {
            this.administradores.remove(administradorAEliminar);
            System.out.println("Administrador con login '" + login + "' eliminado exitosamente.");
        } else {
            System.out.println("Administrador con login '" + login + "' no encontrado.");
        }
    }

    public Administrador obtenerAdministradorPorID(String login) {
        for (Administrador administrador : this.administradores) {
            if (administrador.getLogin().equals(login)) {
                return administrador;
            }
        }
        System.out.println("Administrador no encontrado.");
        return null;
    }

    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }
}