package tp5.ejercicio1.adjList;

import java.util.ArrayList;
import java.util.List;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Vertex;

public class AdjListVertex<T> implements Vertex<T> {
	private T data;
	private int position;
	private List<Edge<T>> edges;
	
	//Constructor del vértices. Solamente se crean desde el grafo. 	 
	AdjListVertex(T data, int position) {
		this.data = data;
		this.position = position;
		this.edges = new ArrayList<>();
	}
	
	@Override
	public T getData() { //Retorna el dato del vértice.
		return this.data;
	}

	@Override
	public void setData(T data) { //Reemplaza el dato del vértice.	
		this.data = data;
	}

	@Override
	public int getPosition() { //Retorna la posición del vértice en el grafo.
		return this.position;
	}

	void decrementPosition() { //Decrementa la posición del vértice en el grafo.
		this.position--;
	}

	void connect(Vertex<T> destination) { //Conecta el vértice con el destino sin peso.
		this.connect(destination, 1);
	}

	void connect(Vertex<T> destination, int weight) { //Conecta el vértice con el destino con peso.
		Edge<T> edge = this.getEdge(destination);
		if (edge == null) {
			// se crea solo si no existe
			this.edges.add(new AdjListEdge<>(destination, weight));
		}
	}

	void disconnect(Vertex<T> destination) { //Desconecta el vértice del destino.
		Edge<T> edge = this.getEdge(destination);
		if (edge != null) {
			this.edges.remove(edge);
		}
	}

	public List<Edge<T>> getEdges() { //Retorna la lista de adyacentes al vértice.
		return this.edges;
	}

	//Retorna, si es que existe, la arista hacia el vertice recibido.
	public Edge<T> getEdge(Vertex<T> destination) {
		for (Edge<T> edge : this.edges) {
			if (edge.getTarget() == destination) {
				return edge;
			}
		}
		return null;
	}
}
