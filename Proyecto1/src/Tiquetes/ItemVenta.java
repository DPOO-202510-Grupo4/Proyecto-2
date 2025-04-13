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

public abstract double calcularPrecio();

}
