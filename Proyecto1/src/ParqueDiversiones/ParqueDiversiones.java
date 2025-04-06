package ParqueDiversiones;

import java.util.Arrays;

//import Atracciones.AtraccionCultural;
import Atracciones.AtraccionMecanica;
//import Persistencias.PersistenciaAtraccionCultural;
import Persistencias.PersistenciaAtraccionMecanica;
//import Persistencias.PersistenciaEmpleado;
//import Persona.Empleado;

public class ParqueDiversiones {

    public static void main(String[] args) {






        AtraccionMecanica atraccionMecanica = new AtraccionMecanica(
            "Montaña Rusa",  // ubicacion
            10,  // cupoMax
            Arrays.asList("Seguridad"),  // restricciones
            "Alta",  // exclusividad
            5,  // minEmpleados
            10,  // edadMin
            "Montaña Rusa",  // nombre
            Arrays.asList("Ninguna"),  // restriccionClima
            true,  // deTemporada
            "Alto",  // riesgo
            50,  // pesoMin
            200,  // pesoMax
            150,  // alturaMin
            180   // alturaMax
        );

        // Persistir atracción mecánica
        PersistenciaAtraccionMecanica persistenciaAtraccionMecanica = new PersistenciaAtraccionMecanica();
        persistenciaAtraccionMecanica.persistencia("atracciones_mecanicas.txt", atraccionMecanica);
    }

    }


