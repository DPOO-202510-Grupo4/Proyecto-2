package Persistencias;

import Persistencias.*;
import Tiquetes.GestorTiquetes;

public class GestorPersistencia {
	private static GestorPersistencia instancia;
	public void gestorCargaDatos() {
		PersistenciaCliente.cargarDatos();
		PersistenciaAdministrador.cargarDatos();
		PersistenciaEmpleado.cargarDatos();
	}
    public static GestorPersistencia getInstance() {
        if (instancia == null) {
            instancia = new GestorPersistencia();
        }
        return instancia;
    }
}
