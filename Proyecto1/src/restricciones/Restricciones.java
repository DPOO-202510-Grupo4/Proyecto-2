package restricciones;

import java.util.ArrayList;

public abstract class Restricciones {
	protected ArrayList<String> clima;
	protected String exclusividad;
	
	public Restricciones(ArrayList<String> clima, String exclusividad) {
		this.clima = clima;
		this.exclusividad = exclusividad;
	}
	
}
