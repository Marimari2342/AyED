# AyED - Practica 2

## 🔵 Punto 1

Considere la siguiente especificación de la clase Java BinatyTree(con la representación hijo izquierdo e hijo derecho).

* El constructor BinaryTree(T data) inicializa un árbol con el dato pasado como parámetro y ambos hijos nulos.

* Los métodos getLeftChild():BinaryTree<T> y getRightChild():BinaryTree<T>, retornan los hijos izquierdo y derecho respectivamente del árbol. Si no tiene el hijo tira error.

* El método addLeftChild(BinaryTree<T> child) y addRightChild(BinaryTree<T> child)
agrega un hijo como hijo izquierdo o derecho del árbol.

* El método removeLeftChild() y removeRightChild(), eliminan el hijo correspondiente.

* El método isEmpty() indica si el árbol está vacío y el método isLeaf() indica si no tiene hijos.

* El método hasLeftChild() y hasRightChild() devuelve un booleano indicando si tiene dicho hijo el árbol receptor del mensaje.

a) Analice la implementación en JAVA de la clase BinaryTree brindada por la cátedra.

## 🔵 Punto 2

Agregue a la clase BinaryTree los siguientes métodos:

a) contarHojas():int Devuelve la cantidad de árbol/subárbol hojas del árbol receptor.

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

~~~java
public int contarHojas() {
	int hojas_izq = 0;
	int hojas_der = 0;
	if (this.isEmpty()){
		return 0; //condicion de corte 
	}else if (this.isLeaf()){
		return 1; //es una hoja
	}else {
		if (this.hasLeftChild()){
			hojas_izq = this.getLeftChild().contarHojas();
		}
		if (this.hasRightChild()){
			hojas_der = this.getRightChild().contarHojas();
		}
	}
	return hojas_der + hojas_izq;
}
~~~

</details>

b) espejo(): BinaryTree<T> Devuelve el árbol binario espejo del árbol receptor.

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

~~~java
public BinaryTree<T> espejo(){
	/*Usamos el constructor BinaryTree(T data) para inicializar aux con el dato 
	de la raíz del árbol original.*/
	BinaryTree<T> aux = new BinaryTree(this.getData());
		
	/*Invertimos los hijos*/
	if (this.hasLeftChild()){
		aux.addRightChild(aux.getLeftChild().espejo());
	}       		  
	if (this.hasRightChild()){
		aux.addLeftChild(aux.getRightChild().espejo());
	}
    return aux;
}
~~~

</details>

c) entreNiveles(int n, m) Imprime el recorrido por niveles de los elementos del árbol receptor entre los niveles n y m (ambos inclusive). (0 ≤ n < m ≤ altura del árbol).

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

~~~java
public void entreNiveles(int n, int m){
	// verifico que el arbol no este vacío y n y m sean válidos
	if (this.isEmpty() || n < 0 || m < n){
		return;
	}
	/*usamos una cola para realizar recorrido por niveles. Iniciamos 
	añadiendo el nodo raiz (this). Además iniciamos en el nivel 0 y vamos
	llevando registro de en que nivel estamos para saber cuando imprimir*/
	Queue<BinaryTree> cola = new LinkedList<>();
	cola.add(this);
	int nivel = 0;
		
	while (!cola.isEmpty()){
		int aux = cola.size(); // Número de nodos en el nivel actual
		if (nivel >= n && nivel <= m ) { // Entra al if si esta entre n y m
			System.out.print("Nivel "+nivel+" --> ");
			for (int i=0;i<aux;i++){
				BinaryTree<T> nodo = cola.remove(); //extraigo el nodo en la parte frontal de la cola
				System.out.print(getData()+" "); //imprimo
				if (nodo.hasLeftChild()){
					cola.add(nodo.getLeftChild());
				}
				if (nodo.hasRightChild()){
					cola.add(nodo.getRightChild());
				}
    		}
			System.out.println(); //salto de linea
		} else {	//Si no esta entre n y m solo saco los nodos de la cola
			for (int i=0;i<aux;i++){
				cola.remove();
			}
		}
        nivel++; //avanzo en el nivel del arbol
	}
}
~~~
</details>

