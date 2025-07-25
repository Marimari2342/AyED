package tp5.ejercicio1.adjMatrix;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Vertex;

public class AdjMatrixEdge<T> implements Edge<T> {
	//variables de instancia
	private Vertex<T> target; //Vertice destino
	private int weight; //Peso de la arista.
	
	//Constructor de las aristas.  Solo se crean desde el grafo.
	AdjMatrixEdge(Vertex<T> target, int weight){
		this.target = target;
		this.weight = weight;
	}
	
	@Override
	public Vertex<T> getTarget() { //Devuelve el vertice destino
		return target;
	}

	@Override
	public int getWeight() { //Devuelve el peso de la arista
		return weight;
	}
}
