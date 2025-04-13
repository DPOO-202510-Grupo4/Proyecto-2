package Tiquetes;

public abstract class ItemVenta {
	private String nombre;
	private Double precioBase;
	private EstrategiaPrecio estrategiaPrecio;
	
public ItemVenta(String nombre, Double precioBase, EstrategiaPrecio estrategiaPrecio) {
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.estrategiaPrecio = estrategiaPrecio;
	}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public Double getPrecioBase() {
	return precioBase;
}

public void setPrecioBase(Double precioBase) {
	this.precioBase = precioBase;
}

public EstrategiaPrecio getEstrategiaPrecio() {
	return estrategiaPrecio;
}

public void setEstrategiaPrecio(EstrategiaPrecio estrategiaPrecio) {
	this.estrategiaPrecio = estrategiaPrecio;
}

public double calcularPrecio() {
	// TODO Auto-generated method stub
	return 0;
}



}
