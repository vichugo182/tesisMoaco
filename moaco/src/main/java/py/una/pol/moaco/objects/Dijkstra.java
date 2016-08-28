/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.moaco.objects;

/**
 *
 * @author Jean
 */

/****************************************************
 ***Algoritmo: Dijkstra (One Source Shortest Path)
 ***Tipo: Grafos
 ***Autor: Jhosimar George Arias Figueroa
 ****************************************************/

/*
 EJEMPLO DE INPUT
 5 9
 1 2 7
 1 4 2
 2 3 1
 2 4 2
 3 5 4
 4 2 3
 4 3 8
 4 5 5
 5 3 5
 1
 */
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

	private static final int MAX = 10005; 
	private static final int INF = 1 << 30; 
	private List<Integer> camino = new ArrayList<Integer>();
	private SustrateNetworkDir graph;
	private Double distancia[] = new Double[MAX]; 
	private boolean visitado[] = new boolean[MAX]; 
	private PriorityQueue<NodeDijkstra> Q = new PriorityQueue<NodeDijkstra>();
	private int previo[] = new int[MAX]; // para la impresion de caminos
	private int nodoDestino; //


	public Dijkstra(SustrateNetworkDir  sustrateGraph) {

		this.graph = sustrateGraph;
	}

	public int getNodoDestino() {
		return nodoDestino;
	}

	public void setNodoDestino(int nodoDestino) {
		this.nodoDestino = nodoDestino;
	}



	// función de inicialización
	public void init() {
		for (int i = 0; i <= this.graph.getListaNodos().size(); ++i) {
			this.distancia[i] = new Double (INF); 
			this.visitado[i] = false; 
			this.previo[i] = -1; 
		}
	}

	// Paso de relajacion
	public void relajacion(int actual, int adyacente, Double peso) {
		if (this.distancia[actual] + peso < this.distancia[adyacente]) {
			this.distancia[adyacente] = this.distancia[actual] + peso; 
			this.previo[adyacente] = actual; 
			this.Q.add(new NodeDijkstra(adyacente, new Double (this.distancia[adyacente]))); 
		}
	}

	/**
	 * Impresion del camino mas corto desde el vertice inicial y final
	 * ingresados
	 */
	public List<Integer> print(int destino) {
		if (this.previo[destino] != -1) // si aun poseo un vertice previ
			print(this.previo[destino]); // recursivamente sigo explorando
		this.camino.add(destino);
		System.out.printf("%d ", destino);

		return this.camino;
	}

	public Boolean doDijkstra(int inicial) {
		init();
		this.Q.add(new NodeDijkstra(inicial, new Double (0)));
		this.distancia[inicial] = new Double (0);
		int actual, adyacente;
		while (!this.Q.isEmpty()) {
			actual = this.Q.element().first;
			this.Q.remove();
			if (this.visitado[actual])
				continue; // Si el vértice actual ya fue visitado entonces sigo
							// sacando elementos de la cola
			this.visitado[actual] = true; // Marco como visitado el vértice
											// actual
			// reviso los adyacentes del vertice actual
			Double peso= new Double("1");
			Integer size = this.graph.getListaNodos().get(actual).getListaEnlaces().size();
			for (Integer i = 0; i < size; i++) {
				peso = 1.0;
				adyacente = this.graph.getListaNodos().get(actual).getListaEnlaces().get(i).getnodo().getId() - 1; // id del
																		// vertice
																		// adyacente

				//El peso es igual a la cantidad de slots ocupado
				for(EONSlotDir slot: this.graph.getListaNodos().get(actual).getListaEnlaces().get(i).getSlots()){
					if(slot.isOcupado()){
						peso= peso+1;
					}
				}
				if (!this.visitado[adyacente]) {
					relajacion(actual, adyacente, peso);
				}
			}
		}
		print(this.nodoDestino);
		if (this.camino.size()>0){
			return true;
		}else{
			return false;
		}
		
	}

	public SustrateNetworkDir getGraph() {
		return graph;
	}

	public void setGraph(SustrateNetworkDir graph) {
		this.graph = graph;
	}
	

}
