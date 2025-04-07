package Persona;

import java.util.Date;

public abstract class Persona {
 protected String nombre;
 protected String login;
 protected String password;
 protected Date fechaNacimiento;

public Persona(String nombre, String login, String password, Date fechaNacimiento) {
	this.nombre = nombre;
	this.login = login;
	this.password = password;
	this.fechaNacimiento = fechaNacimiento;
	}
 
}
