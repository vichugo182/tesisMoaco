package py.una.pol.moaco.objects;

import java.util.ArrayList;
import java.util.List;

public class Conectado {

	private List<Integer> listaConectados;

	public Conectado() {
		this.listaConectados = new ArrayList<Integer>();
	}

	public List<Integer> getListaConectados() {
		return listaConectados;
	}

	public void setListaConectados(List<Integer> listaConectados) {
		this.listaConectados = listaConectados;
	}
}
