package py.una.pol.moaco.objects;

import java.util.ArrayList;
import java.util.List;

public class SustrateLinkDir {
	SustrateNodeDir nodo;
	List<EONSlotDir> slots;	
	
	public SustrateLinkDir() {
		nodo = new SustrateNodeDir();
		slots = new ArrayList<EONSlotDir>();
	}
	public SustrateNodeDir getnodo() {
		return nodo;
	}
	public void setnodo(SustrateNodeDir nodo) {
		this.nodo = nodo;
	}
	public List<EONSlotDir> getSlots() {
		return slots;
	}
	public void setSlots(List<EONSlotDir> slots) {
		this.slots = slots;
	}

}
