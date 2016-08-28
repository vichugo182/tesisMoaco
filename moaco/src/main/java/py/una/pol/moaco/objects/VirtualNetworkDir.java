package py.una.pol.moaco.objects;

import java.util.ArrayList;
import java.util.List;

public class VirtualNetworkDir {

	private List<VirtualNodeDir> nodos;
	
	public VirtualNetworkDir(){
		this.nodos = new ArrayList<VirtualNodeDir>();
	}

	public List<VirtualNodeDir> getNodos() {
		return nodos;
	}

	public void setNodos(List<VirtualNodeDir> nodos) {
		this.nodos = nodos;
	}
	
}
