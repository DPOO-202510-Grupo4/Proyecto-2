package Persona;

public abstract class Persona {
 protected String nombre;
 protected String login;
 protected String password;
public Persona(String nombre, String login, String password) {
	this.nombre = nombre;
	this.login = login;
	this.password = password;
}
 
}
