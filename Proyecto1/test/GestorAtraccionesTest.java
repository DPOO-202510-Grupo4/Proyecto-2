import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import Atracciones.AtraccionMecanica;
import Atracciones.GestorAtracciones;

class GestorAtraccionesTest {


	private GestorAtracciones gestor;

	@BeforeEach
	public void inicializar(){
		gestor = new GestorAtracciones();
	}

	@Test
	public void testRegistrarAtraccionMecanica(){
		AtraccionMecanica atraccionMecanica = mock(AtraccionMecanica.class);
		gestor.registrarAtraccionMecanica(atraccionMecanica);
		assertTrue(gestor.getAtraccionesMecanicas().contains(atraccionMecanica));

	}

	@Test
	public void testAtraccionesMecanicasPorUbicacion(){
		AtraccionMecanica atraccionMecanica1 = mock(AtraccionMecanica.class);
		when(atraccionMecanica1.getUbicacion()).thenReturn("Norte");
		AtraccionMecanica atraccionMecanica2 = mock(AtraccionMecanica.class);
		when(atraccionMecanica2.getUbicacion()).thenReturn("Sur");
		gestor.registrarAtraccionMecanica(atraccionMecanica1);
		gestor.registrarAtraccionMecanica(atraccionMecanica2);
		List<AtraccionMecanica> resultado = gestor.atraccionesMecanicasPorUbicacion("Sur");
		assertEquals(1, resultado.size());
		assertTrue(resultado.contains(atraccionMecanica2));


	}
	

}
