package tp5.ejercicio1.adjList;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Vertex;

public class AdjListEdge<T> implements Edge<T> {
	private Vertex<T> target;
	private int weight;
	
	//Crea una arista.  Se invoca desde AdjListGraph.
	AdjListEdge(Vertex<T> target, int weight){
		this.target = target; //Vértice destino
		this.weight = weight; //Peso de la arista
	}
	
	@Override
	public Vertex<T> getTarget() { // Retorna el vértice destino de la arista
		return target;
	}

	@Override
	public int getWeight() { // Retorna el peso de la arista
		return weight;
	}
}
