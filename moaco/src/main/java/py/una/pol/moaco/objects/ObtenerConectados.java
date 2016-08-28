package py.una.pol.moaco.objects;

import java.util.ArrayList;
import java.util.List;

public class ObtenerConectados {
	
	private List<Conectado> listaConectados;
	
	public ObtenerConectados() {
		this.listaConectados = new ArrayList<Conectado>();
	}

	public List<Conectado> getListaConectados() {
		return listaConectados;
	}


	public void setListaConectados(List<Conectado> listaConectados) {
		this.listaConectados = listaConectados;
	}


	public List<Conectado> obtener(SustrateNetworkDir network, Integer nodoTotalRequest){
		Integer id = 0;
		boolean existeNodo = true;
		//controlar que tenga mas de 0 nodos
		if(network.getListaNodos().size() > 0){
			//recorro los nodos
			for(int i = 0; i < network.getListaNodos().size(); i++){
				existeNodo = true;
				//compruebo si el nodo se encuentra ya agregado en mi objeto lista de Objeto Conectado
				existeNodo = this.comprobarExistenciaId(network.getListaNodos().get(i));
				if(!existeNodo){
					Conectado nodoNuevo = new Conectado();
					List<Integer> lista = new ArrayList<Integer>();
					lista.add(network.getListaNodos().get(i).getId());
					nodoNuevo.setListaConectados(lista);
					listaConectados.add(nodoNuevo);
				}
				//verifico que tenga al menos un enlace
				if( network.getListaNodos().get(i).getListaEnlaces().size() > 0){
					//recorro los enlaces
					for (int j = 0; j < network.getListaNodos().get(i).getListaEnlaces().size(); j++) {
						//si ese id del nodo no existe en listaConectados le agrego al objeto conectado buscando su indice
						if(!this.comprobarExistenciaId( network.getListaNodos().get(i).getListaEnlaces().get(j).getnodo())){
							//paso que busca el id del nodo padre y retorna el indice del array donde se encuentra
							id = this.obtenerIndiceConectado(network.getListaNodos().get(i));
							listaConectados.get(id).getListaConectados().add(network.getListaNodos().get(i).getListaEnlaces().get(j).getnodo().getId());
						}
						this.comprobarExistenciaYUnir(network.getListaNodos().get(i),
								network.getListaNodos().get(i).getListaEnlaces().get(j).getnodo());
					}
				} else {
					//por si sea el primer elemento aislado, como ya cree inicialmente no hace falta agregar mas
					//if(i != 0){
						//si es una lista igual a cero quiere decir que es un nodo aislado
						Conectado aislado = new Conectado();
						List<Integer> listaAislado = new ArrayList<Integer>();
						listaAislado.add(network.getListaNodos().get(i).getId());
						aislado.setListaConectados(listaAislado);
						listaConectados.add(aislado);
					//}
				}
				
			}
			System.out.println("total de conectados " + this.listaConectados.size());
		}
		Integer indice = -1;
		Integer mayor = 0;
		List<Conectado> auxiliar = new ArrayList<Conectado>();
		boolean ordenado = true;
		Integer fin = this.listaConectados.size() - 1;
		Integer j = 0;
		while(ordenado){
			mayor = 0;
			indice = -1;
			for (int i = 0; i < this.listaConectados.size(); i++) {
				if(mayor < this.listaConectados.get(i).getListaConectados().size() && 
						this.listaConectados.get(i).getListaConectados().size() >= nodoTotalRequest ){
					mayor = this.listaConectados.get(i).getListaConectados().size();
					indice = i;
				}
			}
			if(indice != -1){
				auxiliar.add(this.listaConectados.get(indice));
			}
			this.listaConectados.remove(indice);
			
			if(j==fin){
				ordenado = false;
			}
			j++;
		}
		return auxiliar;
	}
	
	//funcion encargada de comprobar que un id de nodo del enlace se encuentra o no en listaConectados
	public boolean comprobarExistenciaId(SustrateNodeDir node){
		for (int j = 0; j < listaConectados.size(); j++) {
			if(listaConectados.get(j).getListaConectados().contains(node.getId())){
				return true;
			}
		}
		return false;
	}
	
	public Integer obtenerIndiceConectado(SustrateNodeDir node){
		for (int j = 0; j < listaConectados.size(); j++) {
			if(listaConectados.get(j).getListaConectados().contains(node.getId())){
				return j;
			}
		}
		return 0;
	}
	
	//funcion encargada de comprobar que un id de nodo del enlace se encuentra o no en listaConectados
	public void comprobarExistenciaYUnir(SustrateNodeDir nodoPadre, SustrateNodeDir nodoEnlace){
		System.out.println("Nodo Origen " + nodoPadre.getId());
		System.out.println("Nodo Destino " + nodoEnlace.getId());
		List<Conectado> fusionar;
		fusionar = new ArrayList<Conectado>();
		fusionar.addAll(listaConectados);
		for (int i = 0; i < fusionar.size(); i++) {
			for (int j = 0; j < fusionar.size(); j++) {
				if(i != j){
					if(fusionar.get(i).getListaConectados().contains(nodoPadre.getId()) && fusionar.get(j).getListaConectados().contains(nodoEnlace.getId())){
						System.out.println("Entro");
						listaConectados.get(i).getListaConectados().addAll(fusionar.get(j).getListaConectados());
						listaConectados.remove(j);
						break;
					}
				}
			}
		}
	}
		
}
