/*Interface Vertex<T>
● public T getData()
Retorna el dato del vértice.
● public void setData(T data)
Reemplaza el dato del vértice.
● public int getPosition()
Retorna la posición del vértice en el grafo. */
package tp5.ejercicio1;

public interface Vertex<T> {
	
	/**
	 * @return
	 */
	public T getData(); //Retorna el dato del vértice.

	/**
	 * @param dato
	 */
	public void setData(T data); //Reemplaza el dato del vértice.

	/**
	 * @return
	 */
	public int getPosition(); //Retorna la posición del vértice en el grafo.
}
