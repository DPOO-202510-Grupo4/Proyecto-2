package Persona;

import java.util.Set;

public class Rol {
    private String nombre;
    private Set<String> permisosPermitidos;
    private LugarTrabajo lugar;

    public Rol(String nombre, Set<String> permisosPermitidos, LugarTrabajo lugar) {
        this.nombre = nombre;
        this.permisosPermitidos = permisosPermitidos;
        this.lugar = lugar;
    }

    public boolean tienePermiso(String permiso) {
        return permisosPermitidos.contains(permiso);
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<String> getPermisosPermitidos() {
		return permisosPermitidos;
	}

	public void setPermisosPermitidos(Set<String> permisosPermitidos) {
		this.permisosPermitidos = permisosPermitidos;
	}

	public LugarTrabajo getLugar() {
		return lugar;
	}

	public void setLugar(LugarTrabajo lugar) {
		this.lugar = lugar;
	}

}
