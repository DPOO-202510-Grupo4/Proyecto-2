package Persona;

import Atracciones.Atraccion;
import java.time.LocalDate;
import java.util.ArrayList;
import Persistencias.*;
public class GestorPersonas {
	
private static GestorPersonas instanciaUnica;
private ArrayList<Empleado> empleados;
private ArrayList<Turno> turnos;
private ArrayList<Cliente> clientes;
private Empleado empleado;
private Atraccion atraccion;

private GestorPersonas() {
	this.empleados = new ArrayList<>();
    this.turnos = new ArrayList<>();
}

public static GestorPersonas getInstance() {
    if (instanciaUnica == null) {
        instanciaUnica = new GestorPersonas(); 
    }
    return instanciaUnica;
}

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
			System.out.println(empleado.toString());
		}
	}
	return empleado.toString();
}

public ArrayList empleadosPorTipo(String tipo) {
	ArrayList empleadosTipo = new ArrayList<>();
	//TODO
	return empleadosTipo;
}

public ArrayList empleadosDisponibles(LocalDate fecha, String lugar) {
	ArrayList<Empleado> empleadosDisponibles = new ArrayList<>();
	for (Empleado empleado : this.empleados) {
		turnos = empleado.getTurnos();
		for (Turno turno : turnos) {
			if (!turno.getFecha().equals(fecha) && !turno.getLugarTrabajo().equals(lugar)) {
				empleadosDisponibles.add(empleado);
		}
		}
	}
	return empleadosDisponibles;
}

public void asignarTurno(String login, Turno turno) {
	if (empleado.getTurnos().contains(turno)) {
		System.out.println("El empleado ya tiene un turno asignado en esa fecha.");
	} else {
		empleado.getTurnos().add(turno);
	}
}

public ArrayList<Turno> turnosDeEmpleado(Empleado empleado) {
	ArrayList<Turno> turnosEmpleado = new ArrayList<>();
	for (Turno turno : empleado.getTurnos()) {
		turnosEmpleado.add(turno);
	}
	return turnosEmpleado;
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
public void asignarTarea(String login, String Tarea){
	if (empleado.getTareas().contains(Tarea)) {
		System.out.println("El empleado ya tiene esta tarea asignada.");
	} else {
		empleado.getTareas().add(Tarea);
	}
}


public boolean verificarMinimosAtraccion(Atraccion atraccion, LocalDate fecha){
	//TODO
	//Verifica si la atraccion tiene los minimos de empleados asignados para la fecha
	return false;
}

public ArrayList<Empleado> getEmpleados() {
	return empleados;
}

}