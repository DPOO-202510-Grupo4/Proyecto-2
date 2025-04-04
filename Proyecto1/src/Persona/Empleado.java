package Persona;

public abstract class Empleado extends Persona {
	protected String turno;

	public Empleado(String nombre, String login, String password, String rol) {
		super(nombre, login, password);
	}

}
