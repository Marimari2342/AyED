package tp2.ejercicio1;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <T> {
	

	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	/*El constructor BinaryTree(T data) inicializa un árbol con el dato pasado 
	como parámetro y ambos hijos nulos. */
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/*Los métodos getLeftChild():BinaryTree<T> y getRightChild():BinaryTree<T>,
	retornan los hijos izquierdo y derecho respectivamente del árbol. Si no 
	tiene el hijo tira error. */
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	/*El método addLeftChild(BinaryTree<T>child) y addRightChild(BinaryTree<T>child)
	agrega un hijo como hijo izquierdo o derecho del árbol. */
	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	/*El método removeLeftChild() y removeRightChild(), eliminan el hijo correspondiente. */
	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	/*El método isEmpty() indica si el árbol está vacío y el método isLeaf() indica si 
	no tiene hijos. */
	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	/*El método hasLeftChild() y hasRightChild() devuelve un booleano indicando si tiene
	dicho hijo el árbol receptor del mensaje. */
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	/*Devuelve la cantidad de árbol/subárbol hojas del árbol receptor.*/
	public  int contarHojas() {
		//mientras no sea hoja, recursivamente contar hojas de los hijos
		if (this.isLeaf()) { //is Leaf --> no tiene hijos
			return 1; // es una hoja
		}
		else {
			int hojas = 0;
			if (this.hasLeftChild()) { //si tiene hijo izquierdo
				hojas += this.getLeftChild().contarHojas(); //contar hojas del subArbol izquierdo
			}
			if (this.hasRightChild()) { //si tiene hijo derecho
				hojas += this.getRightChild().contarHojas(); //contar hojas del subArbol derecho
			}
			return hojas; //retornar la cantidad de hojas
		}
	}
		
		
	/*Devuelve el árbol binario espejo del árbol receptor. */
	public BinaryTree<T> espejo(){
		/*Usamos el constructor BinaryTree(T data) para inicializar aux con el dato 
		de la raíz del árbol original.*/
		BinaryTree<T> espejo = new BinaryTree(this.getData());

		/*Invertimos los hijos*/
		//si el arbol original tiene hD o hI, lo reflejamos en el arbol espejo
		if (this.hasLeftChild()){
			espejo.addRightChild(this.getLeftChild().espejo());
		}       		  
		if (this.hasRightChild()){
			espejo.addLeftChild(this.getRightChild().espejo());
		}
 	   return espejo;
    }

	/* IMPRIMIR --> METODO AUXILIAR */
	/*Imprime el recorrido por niveles de los elementos del árbol receptor. */
	public void imprimirEnOrden() {
		// Recorrido en orden: izquierda, raíz, derecha
		if (this.hasLeftChild()) {
			this.getLeftChild().imprimirEnOrden();
		}
		System.out.print(this.getData() + " "); // Imprimir el dato del nodo actual
		if (this.hasRightChild()) {
			this.getRightChild().imprimirEnOrden();
		}
	}

	/*Imprime el recorrido por niveles de los elementos del árbol receptor entre los 
	niveles n y m (ambos inclusive). (0≤n<m≤altura del árbol) */
	// 0<=n<=m
	public void entreNiveles(int n, int m){
		if (this.isEmpty() || n < 0 || m < n){
			System.out.println("Árbol vacío o niveles inválidos.");
			return;
		}
	
		Queue<BinaryTree<T>> cola = new LinkedList<>();
		cola.add(this);
		int nivel = 0;
	
		while (!cola.isEmpty()) {
			int aux = cola.size();
	
			if (nivel >= n && nivel <= m) {
				System.out.print("Nivel " + nivel + " --> ");
			}
	
			for (int i = 0; i < aux; i++) {
				BinaryTree<T> nodo = cola.remove();
	
				// ✅ Agregamos los hijos siempre, no importa si imprimimos o no
				if (nodo.hasLeftChild()) {
					cola.add(nodo.getLeftChild());
				}
				if (nodo.hasRightChild()) {
					cola.add(nodo.getRightChild());
				}
	
				// ✅ Solo imprimimos si el nivel está entre n y m
				if (nivel >= n && nivel <= m) {
					System.out.print(nodo.getData() + " ");
				}
			}
	
			if (nivel >= n && nivel <= m) {
				System.out.println();
			}
	
			nivel++;
		}
   }	
		
}

