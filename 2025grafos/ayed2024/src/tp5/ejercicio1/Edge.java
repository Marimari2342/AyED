/*Interface Edge<T>
● public Vertex<T> target()
Retorna el vértice destino de la arista.
● public int getWeight()
Retorna el peso de la arista*/
package tp5.ejercicio1;

public interface Edge<T> {
	
	/**
	 * @return
	 */
	public Vertex<T> getTarget(); //Retorna el vértice destino de la arista.
	
	/**
	 * @return
	 */
	public int getWeight(); //Retorna el peso de la arista

}
