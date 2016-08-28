package py.una.pol.moaco.objects;

public class LAGDir {
	
	private SustrateNetworkDir redSustrato;	

	public LAGDir() {
	}

	public SustrateNetworkDir getRedSustrato() {
		return redSustrato;
	}

	public void setRedSustrato(SustrateNetworkDir redSustrato) {
		this.redSustrato = redSustrato;
	}
	
	public SustrateNetworkDir generarCapas(Integer n, Integer k) {
		SustrateNetworkDir resp = new SustrateNetworkDir();
		resp.setListaNodos(this.redSustrato.getListaNodos());
		Integer aEmpezar = k + n - 1;
		int totalEnlacesI = 0;
		SustrateNodeDir nodoDestino;
		for (int i =this.redSustrato.getListaNodos().size() - 1; i >= 0; i--) {
			totalEnlacesI = this.redSustrato.getListaNodos().get(i).getListaEnlaces().size();
			for (int j=totalEnlacesI - 1; j>=0; j--) {
				//control para que no salga fuera de rango
				if (aEmpezar < this.redSustrato.getListaNodos().get(i).getListaEnlaces().get(j).getSlots().size()) {
					for (Integer l = k; l <= aEmpezar; l++) {
						/*System.out.println("IdNodo "+ this.redSustrato.getListaNodos().get(i).getId());
						System.out.println("IdSlot "+ this.redSustrato.getListaNodos().get(i).getListaEnlaces().get(j).slots.get(l).getIdSlot());
						System.out.println(this.redSustrato.getListaNodos().get(i).getListaEnlaces().get(j).getSlots().get(l).isOcupado());*/
						if (this.redSustrato.getListaNodos().get(i).getListaEnlaces().get(j).getSlots().get(l).isOcupado()) {
							// Significa que el slot esta ocupado
							resp.getListaNodos().get(i).getListaEnlaces().remove(resp.getListaNodos().get(i).getListaEnlaces().get(j));
							break;
						}
					}
				}
			}
		}
		return resp;
	}
}
