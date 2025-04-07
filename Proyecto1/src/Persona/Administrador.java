package Persona;

import java.time.LocalDate;

public class Administrador extends Persona {

	

	public Administrador(String nombre, String login, String password, LocalDate fechaNacimiento) {
		super(nombre, login, password, fechaNacimiento);
	}

	@Override
	public LocalDate getFechaNacimiento() {
		// TODO Auto-generated method stub
		return super.getFechaNacimiento();
	}

	@Override
	public String getLogin() {
		// TODO Auto-generated method stub
		return super.getLogin();
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return super.getNombre();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}
	public void modificarAtracciones() {}
	public void asignarTurnos() {}
	public void asignarRol() {}
	public void asignarTarea() {}
}
