package Tiquetes;

public abstract class ItemVenta {
	private String nombre;
	private Double precioBase;
	private EstrategiaPrecio estrategiaPrecio;
public abstract double calcularPrecio();
}
