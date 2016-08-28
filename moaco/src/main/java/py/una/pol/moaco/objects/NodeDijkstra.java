package py.una.pol.moaco.objects;

/**
 * 
 * @author ALO
 */
public class NodeDijkstra implements Comparable<NodeDijkstra> {

	int first;
	Double second;

	public NodeDijkstra(int d, Double p) { // constructor
		this.first = d;
		this.second = p;
	}

	public int compareTo(NodeDijkstra other) { 
		if (second > other.second)
			return 1;
		if (second == other.second)
			return 0;
		return -1;
	}

	@Override
	public String toString() {
		return "NodeDijkstra [dest=" + first + ", peso=" + second + "]";
	}
	
	

}
