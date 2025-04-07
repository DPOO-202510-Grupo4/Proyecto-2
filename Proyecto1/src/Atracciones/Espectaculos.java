package Atracciones;
import restricciones.Temporada;
import java.util.ArrayList;

public class Espectaculos {
    private ArrayList<Temporada> horario;
    private String empresaEncargada;

	public ArrayList<Temporada> getHorario() {
		return horario;
	}

	public void setHorario(ArrayList<Temporada> horario) {
		this.horario = horario;
	}

	public String getEmpresaEncargada() {
		return empresaEncargada;
	}

	public void setEmpresaEncargada(String empresaEncargada) {
		this.empresaEncargada = empresaEncargada;
	}

	public Espectaculos(ArrayList<Temporada> horario, String empresaEncargada) {
		this.horario = horario;
		this.empresaEncargada = empresaEncargada;
	}
    
    

}
