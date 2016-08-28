package py.una.pol.moaco.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodeMappingDir {
	
	ListMapVRDir listaMapeados;

	public NodeMappingDir() {
		listaMapeados = new ListMapVRDir();
	}

	public ListMapVRDir getListaMapeados() {
		return listaMapeados;
	}

	public void setListaMapeados(ListMapVRDir listaMapeados) {
		this.listaMapeados = listaMapeados;
	}

	public boolean mapearNodos(SustrateNetworkDir sustrato, VirtualNetworkDir request, Integer requerimiento){
		
		List<Boolean> mapeado = new ArrayList<Boolean>();
		SustrateNetworkDir laLRCsub = calcularLaLRC(sustrato);
		VirtualNetworkDir lRCvirtual = calcularLRC(request, requerimiento);
		
		for (int i = laLRCsub.getListaNodos().size() - 1 ; i >= 0; i--) {
			System.out.println("id" + laLRCsub.getListaNodos().get(i).getId() + " LaLRC " + laLRCsub.getListaNodos().get(i).getLaLRC());
		}
		for (int i = lRCvirtual.getNodos().size() - 1 ; i >= 0; i--) {
			System.out.println("id" + lRCvirtual.getNodos().get(i).getId() + " LRC " + lRCvirtual.getNodos().get(i).getLRC());
		}
		
		for (int i = lRCvirtual.getNodos().size() - 1 ; i >= 0; i--) {
			mapeado.add(false);
			for (int j = laLRCsub.getListaNodos().size() - 1 ; j >= 0; j--) {
				if(!laLRCsub.getListaNodos().get(j).getMapeado()){
					if(laLRCsub.getListaNodos().get(j).getCpu() >= lRCvirtual.getNodos().get(i).getCpu() 
							&& laLRCsub.getListaNodos().get(j).getListaEnlaces().size() >= lRCvirtual.getNodos().get(i).getListaEnlaces().size()){
						/*System.out.println("Asigna el nodo sustrato " + laLRCsub.getListaNodos().get(j).getId() +
						" a nodo request " + lRCvirtual.getListaNodos().get(i).getId());
						System.out.println("J " + j + " I " + i);*/
						MapVRDir vrDir = new MapVRDir(laLRCsub.getListaNodos().get(j).getId(), lRCvirtual.getNodos().get(i).getId());
						this.listaMapeados.getMapRequest().add(vrDir);
						break;
					}
				}
			}
		}
		
		for (MapVRDir vrDir : this.listaMapeados.getMapRequest()) {
			System.out.println("Nodo fisico" + vrDir.getIdFisico());
			System.out.println("Nodo request" + vrDir.getIdRequest());
		}
		
		if(this.listaMapeados.getMapRequest().size() == request.getNodos().size()){
			return true;
		} else{
			return false;
		}
		
	}
	
	public SustrateNetworkDir calcularLaLRC(SustrateNetworkDir sustratoNetwork){
		//recorro la lista de nodos
		for(int i = 0; i < sustratoNetwork.getListaNodos().size(); i++){
			//capicidad por grado del nodo
			sustratoNetwork.getListaNodos().get(i).setLaLRC(sustratoNetwork.getListaNodos().get(i).getCpu() * 
					sustratoNetwork.getListaNodos().get(i).getListaEnlaces().size());
			sustratoNetwork.getListaNodos().get(i).setMapeado(false);
		}
		Collections.sort(sustratoNetwork.getListaNodos());
		return sustratoNetwork;
	}
	
	public VirtualNetworkDir calcularLRC(VirtualNetworkDir request, Integer n){
		//recorro la lista de nodos
		for(int i = 0; i < request.getNodos().size(); i++){
			//capicidad por grado del nodo
			request.getNodos().get(i).setLRC(request.getNodos().get(i).getCpu() * n);
		}
		Collections.sort(request.getNodos());
		return request;
	}
}
