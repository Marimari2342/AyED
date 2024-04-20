package practica02.ejercicio1y2;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	/*
	 * El constructor BinaryTree(T data) inicializa un árbol con el dato pasado 
	 * como parámetro y ambos hijos nulos.
	 */
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

	/*
	 * Los métodos getLeftChild():BinaryTree<T> y getRightChild():BinaryTree<T>, retornan
	 * los hijos izquierdo y derecho respectivamente del árbol. Si no tiene el hijo tira 
	 * error.
	 */

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

	/*
	 * El método addLeftChild(BinaryTree<T> child) y addRightChild(BinaryTree<T> child)
	 * agrega un hijo como hijo izquierdo o derecho del árbol.
	 */
	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	/*
	 * El método removeLeftChild() y removeRightChild(), eliminan el hijo correspondiente.
	 */
	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	/*
	 * El método isEmpty() indica si el árbol está vacío.
	 */
	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	/*
	 * El método isLeaf() indica si el árbol no tiene hijos.
	 */
	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
	
	/*
	 * El método hasLeftChild() y hasRightChild() devuelve un booleano indicando si
	 * tiene dicho hijo el árbol receptor del mensaje.
	 */
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

	//Metodo para visualizar datos del arbol
	public void imprimir() {
		if (this != null) {
			if (this.hasLeftChild())
				this.getLeftChild().imprimir();
			System.out.print(this.data + " ");
			if(this.hasRightChild())
				this.getRightChild().imprimir();
		}
	}

	//Punto 2a)
	public  int contarHojas() {
	    int hojasizq=0;
		int hojasder=0;
		if (this.isLeaf())
			return 1;		//El arbol no tiene hijos, devuelve 1
		else if (this.isEmpty())
			return 0;		//El arbol esta vacio, devuelve 0
		else {
			if (this.hasLeftChild())
				hojasizq = this.getLeftChild().contarHojas();
			if (this.hasRightChild())
				hojasder = this.getRightChild().contarHojas();
		}
		return hojasder + hojasizq;
	}
	
	// Punto 2b)
    public BinaryTree<T> espejo(){
		BinaryTree auxEsp = new BinaryTree<>(this.getData());
		if (this.hasLeftChild())
			auxEsp.addRightChild(this.getLeftChild().espejo());
		if (this.hasRightChild())
			auxEsp.addLeftChild(this.getRightChild().espejo());
		return auxEsp;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		//verifico que el arbol no este vacío y n y m sean válidos
		if (this.isEmpty() || n < 0 || m < n) 
			return;

		Queue<BinaryTree<T>> cola = new LinkedList();
		cola.add(this);
		int nivel = 0;

		while (!cola.isEmpty()) {
			System.out.print("\n");
			int aux = cola.size();
			if (nivel >= n && nivel <= m) {
				System.out.print("Nivel " + nivel+ " --> ");
				for (int i = 0; i < aux; i++) {
					BinaryTree<T> nodo = cola.remove();
					System.out.print(nodo.getData() + " ");
					if (nodo.hasLeftChild())
						cola.add(nodo.getLeftChild());
					if (nodo.hasRightChild())
						cola.add(nodo.getRightChild());
				}
			} 
			else {
				for (int i = 0; i < aux; i++) {
					cola.remove();
				}
			}
			nivel++;
		}
   }
		
}

