package Persona;

import java.util.ArrayList;

public class GestorPersonas {

private ArrayList<Empleado> empleados;
private ArrayList<Turno> turnos;
private Empleado empleado;

public GestorPersonas(ArrayList<Empleado> empleados, ArrayList<Turno> turnos) {
	super();
	this.empleados = empleados;
	this.turnos = turnos;
}

public void registrarEmpleado(Empleado empleado) {
	empleados.add(empleado);
}

public void eliminarEmpleado(Empleado empleado) {
	empleados.remove(empleado);

public void obtenerEmpleado(String login) {
	for (Empleado empleado : empleados) {
		if (empleado.getNombre().equals(login)) {
			System.out.println(empleado.toString());
		}
	}

}