package Persona;

import Atracciones.Atraccion;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestorPersonas {

private ArrayList<Empleado> empleados;
private ArrayList<Turno> turnos;
private Empleado empleado;
private Atraccion atraccion;

public GestorPersonas(ArrayList<Empleado> empleados, ArrayList<Turno> turnos) {
	super();
	this.empleados = empleados;
	this.turnos = turnos;
}

public void registrarEmpleado(Empleado empleado) {
	this.empleados.add(empleado);
}

public void eliminarEmpleado(Empleado empleado) {
	this.empleados.remove(empleado);
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

public void asignarTurno(Empleado empleado, Turno turno) {
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

public boolean verificarMinimosAtraccion(Atraccion atraccion, LocalDate fecha){
	//TODO
	//Verifica si la atraccion tiene los minimos de empleados asignados para la fecha
	return false;
}

}