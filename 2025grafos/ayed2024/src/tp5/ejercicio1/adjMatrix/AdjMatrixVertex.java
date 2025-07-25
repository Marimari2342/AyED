package tp5.ejercicio1.adjMatrix;

import tp5.ejercicio1.Vertex;

public class AdjMatrixVertex<T> implements Vertex<T> {
	private T data;
	private int position;
	
	//Constructor del vértices.  Solo se crean desde el grafo.
	AdjMatrixVertex(T data, int position) {
		this.data = data; //Dato del vértice.
		this.position = position; //Posición del vértice.
	}
	
	public T getData() { //Retorna el dato del vértice.
		return this.data;
	}
	
	public void setData(T data) { //Reemplaza el dato del vértice.
		this.data = data;
	}

	public int getPosition() { //Retorna la posición del vértice en el grafo.
		return position;
	}

	void setPosition(int position) { //Reemplaza la posición del vértice en el grafo.
		this.position = position;
	}

	void decrementPosition() { //Decrementa la posición del vértice en el grafo.
		this.position--;
	}
}
