package py.una.pol.moaco.objects;

public class VirtualLinkDir {

	VirtualNodeDir nodoVirtual;
	Integer requerimientoEnlace;
	Integer cantidadSlots;
	
	public VirtualLinkDir() {
		nodoVirtual = new VirtualNodeDir();
	}

	public VirtualNodeDir getNodoVirtual() {
		return nodoVirtual;
	}

	public void setNodoVirtual(VirtualNodeDir nodoVirtual) {
		this.nodoVirtual = nodoVirtual;
	}

	

	public Integer getRequerimientoEnlace() {
		return requerimientoEnlace;
	}

	public void setRequerimientoEnlace(Integer requerimientoEnlace) {
		this.requerimientoEnlace = requerimientoEnlace;
	}

	public Integer getCantidadSlots() {
		return cantidadSlots;
	}

	public void setCantidadSlots(Integer cantidadSlots) {
		this.cantidadSlots = cantidadSlots;
	}
	
	
}
