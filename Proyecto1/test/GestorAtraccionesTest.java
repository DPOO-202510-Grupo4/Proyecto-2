import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import Atracciones.Atraccion;
import Atracciones.AtraccionCultural;
import Atracciones.AtraccionMecanica;
import Atracciones.GestorAtracciones;
import Persona.Empleado;
import Tiquetes.GestorTiquetes;
import restricciones.RestriccionesCultural;
import restricciones.RestriccionesMecanica;
import restricciones.Temporada;

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

	@Test
	public void testCrearAtraccionMecanica(){
		RestriccionesMecanica restricciones = mock(RestriccionesMecanica.class);
        Temporada temporada = mock(Temporada.class);

        try (MockedStatic<GestorTiquetes> mocked = mockStatic(GestorTiquetes.class)) {
            GestorTiquetes mockTiquetes = mock(GestorTiquetes.class);
            mocked.when(GestorTiquetes::getInstancia).thenReturn(mockTiquetes);
            when(mockTiquetes.buscarTemporada("Alta")).thenReturn(temporada);

            gestor.crearAtraccionMecanica("Zona A", "Montaña Rusa", true, true, 20, 5, "Alto", restricciones, "Alta");

            List<AtraccionMecanica> lista = gestor.getAtraccionesMecanicas();
            assertEquals(1, lista.size());
            assertEquals("Montaña Rusa", lista.get(0).getNombre());
        }
    }

	@Test
    public void testRegistrarAtraccionCultural() {
        AtraccionCultural atraccion = mock(AtraccionCultural.class);
        gestor.registrarAtraccionCultural(atraccion);
        assertTrue(gestor.getAtraccionesCulturales().contains(atraccion));
    }

	@Test
    public void testAtraccionesCulturalesPorUbicacion() {
        AtraccionCultural a1 = mock(AtraccionCultural.class);
        when(a1.getUbicacion()).thenReturn("Zona B");

        gestor.registrarAtraccionCultural(a1);

        List<AtraccionCultural> resultado = gestor.atraccionesCulturalesPorUbicacion("Zona B");

        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(a1));
    }


    @Test
    public void testCrearAtraccionCultural() {
        RestriccionesCultural restricciones = mock(RestriccionesCultural.class);
        Temporada temporada = mock(Temporada.class);

        try (MockedStatic<GestorTiquetes> mocked = mockStatic(GestorTiquetes.class)) {
            GestorTiquetes mockTiquetes = mock(GestorTiquetes.class);
            mocked.when(GestorTiquetes::getInstancia).thenReturn(mockTiquetes);
            when(mockTiquetes.buscarTemporada("Baja")).thenReturn(temporada);

            gestor.crearAtraccionCultural("Zona C", "Show de Magia", false, true, 100, 2, restricciones, "Baja");

            List<AtraccionCultural> lista = gestor.getAtraccionesCulturales();
            assertEquals(1, lista.size());
            assertEquals("Show de Magia", lista.get(0).getNombre());
        }
    }

	@Test
    public void testAtraccionesPorUbicacion() {
        AtraccionMecanica m = mock(AtraccionMecanica.class);
        when(m.getUbicacion()).thenReturn("Centro");

        AtraccionCultural c = mock(AtraccionCultural.class);
        when(c.getUbicacion()).thenReturn("Centro");

        gestor.registrarAtraccionMecanica(m);
        gestor.registrarAtraccionCultural(c);

        List<Atraccion> resultado = gestor.atraccionesPorUbicacion("Centro");

        assertEquals(2, resultado.size());
    }

	@Test
    public void testAtraccionesDisponibles() {
        AtraccionMecanica m = mock(AtraccionMecanica.class);
        when(m.getUbicacion()).thenReturn("Norte");
        when(m.estaDisponible()).thenReturn(true);

        AtraccionCultural c = mock(AtraccionCultural.class);
        when(c.getUbicacion()).thenReturn("Norte");
        when(c.estaDisponible()).thenReturn(false);

        gestor.registrarAtraccionMecanica(m);
        gestor.registrarAtraccionCultural(c);

        List<Atraccion> disponibles = gestor.atraccionesDisponibles("Norte");

        assertEquals(1, disponibles.size());
        assertTrue(disponibles.contains(m));
    }

	@Test
    public void testPuedeOperar_trueCuandoDisponibleYMinimoEmpleados() {
        Atraccion atraccion = mock(Atraccion.class);
        Date fecha = new Date();

        when(atraccion.estaDisponible()).thenReturn(true);
        when(atraccion.verificarMinimoEmpleados(fecha)).thenReturn(true);

        assertTrue(gestor.puedeOperar(atraccion, fecha));
    }

	@Test
    public void testEmpleadosAsignados_combinadosDeAmbosTipos() {
        Empleado e1 = mock(Empleado.class);
        Empleado e2 = mock(Empleado.class);

        AtraccionMecanica m = mock(AtraccionMecanica.class);
        when(m.getEmpleadosAsignados()).thenReturn(new ArrayList<>(List.of(e1)));

        AtraccionCultural c = mock(AtraccionCultural.class);
        when(c.getEmpleadosAsignados()).thenReturn(new ArrayList<>(List.of(e2)));

        gestor.registrarAtraccionMecanica(m);
        gestor.registrarAtraccionCultural(c);

        List<Empleado> empleados = gestor.empleadosAsignados();
        assertEquals(2, empleados.size());
    }




	}
	


