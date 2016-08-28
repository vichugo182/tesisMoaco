package py.una.pol.moaco.objects;

import java.util.ArrayList;
import java.util.List;


public class SustrateNetworkDir {
	private List<SustrateNodeDir> listaNodos;
	public enum TypeNetwork{
		USNET,
		NSFNET
	}
	
	TypeNetwork tipo;
	
	public SustrateNetworkDir (){
		this.listaNodos = new ArrayList<SustrateNodeDir>();
	}
	
	public SustrateNetworkDir (TypeNetwork tipo){
		this.tipo = tipo;
	}

	public List<SustrateNodeDir> getListaNodos() {
		return listaNodos;
	}
	

	public void setListaNodos(List<SustrateNodeDir> listaNodos) {
		this.listaNodos = listaNodos;
	}

	public TypeNetwork getTipo() {
		return tipo;
	}

	public void setTipo(TypeNetwork tipo) {
		this.tipo = tipo;
	}
	
	
}
	
	
