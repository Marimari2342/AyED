# AyED - Practica 2


## 🔵 Punto 1
***Considere la siguiente especificación de la clase Java BinatyTree (con la representación hijo izquierdo e hijo derecho).***

***Analice la implementación en JAVA de la clase BinaryTree brindada por la cátedra.***

## 🔵 Punto 2
***Agregue a la clase BinaryTree los siguientes métodos:***

* ***contarHojas():int Devuelve la cantidad de árbol/subárbol hojas del árbol receptor.***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
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
~~~

</details>

* ***espejo(): BinaryTree< T > Devuelve el árbol binario espejo del árbol receptor.***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
public BinaryTree<T> espejo(){
	BinaryTree auxEsp = new BinaryTree<>(this.getData());
	if (this.hasLeftChild())
		auxEsp.addRightChild(this.getLeftChild().espejo());
	if (this.hasRightChild())
		auxEsp.addLeftChild(this.getRightChild().espejo());
	return auxEsp;
}
~~~

</details>

* ***entreNiveles(int n, m) Imprime el recorrido por niveles de los elementos del árbol
receptor entre los niveles n y m (ambos inclusive). (0 ≤ n < m ≤ altura del árbol).***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
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
~~~

</details>

Lo probé con el siguiente árbol (cargado en el main):

![ImagenArbolEjemplo](/AyEDproject/src/recursos/imagen03.png)

## 🔵 Punto 3
***Defina una clase Java denominada ContadorArbol cuya función principal es proveer métodos de validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un BinaryTree</Integer/>. Implemente en dicha clase un método denominado numerosPares() que devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del árbol (divisibles por 2).***

* ***Implemente el método realizando un recorrido InOrden.***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
// InOrder (se procesa hijo izquierdo - raiz - hijo derecho)
public LinkedList<Integer> NumerosParesInOr() {
    LinkedList<Integer> lista = new LinkedList<Integer>();
    if (!arbol.isEmpty()) // Si tengo elemento en el arbol ejecuto
        this.NumerosParesInOrder(arbol, lista);
    return lista;
}

private void NumerosParesInOrder(BinaryTree<Integer> arbol, LinkedList<Integer> lista) {
    if (arbol.hasLeftChild())
        NumerosParesInOrder(arbol.getLeftChild(), lista);
    if (arbol.getData() % 2 == 0)
        lista.add(arbol.getData());
    if (arbol.hasRightChild())
        NumerosParesInOrder(arbol.getRightChild(), lista);
}
~~~

</details>

* ***Implemente el método realizando un recorrido PostOrden.***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
// PostOrden (se procesa hijo izquierdo - hijo derecho - raiz)
public LinkedList<Integer> NumerosParesPostOr() {
    LinkedList<Integer> lista = new LinkedList<Integer>();
    if (!arbol.isEmpty()) // Si tengo elemento en el arbol ejecuto
        this.NumerosParesPostOrder(arbol, lista);
    return lista;
}

private void NumerosParesPostOrder(BinaryTree<Integer> arbol, LinkedList<Integer> lista) {
    if (arbol.hasLeftChild())
        NumerosParesInOrder(arbol.getLeftChild(), lista);
    if (arbol.hasRightChild())
        NumerosParesInOrder(arbol.getRightChild(), lista);
    if (arbol.getData() % 2 == 0)
        lista.add(arbol.getData());
}
~~~

</details>

## 🔵 Punto 4
***Una red binaria es una red que posee una topología de árbol binario lleno. Por ejemplo:***

![RedBinaria](/AyEDproject/src/recursos/imagen04.png)

***Los nodos que conforman una red binaria llena tiene la particularidad de que todos ellos conocen cuál es su retardo de reenvío. El retardo de reenvío se define como el período comprendido entre que un nodo recibe un mensaje y lo reenvía a sus dos hijos.***

***Su tarea es calcular el mayor retardo posible, en el camino que realiza un mensaje desde la raíz hasta llegar a las hojas en una red binaria llena. En el ejemplo, debería retornar 10+3+9+12=34 (Si hay más de un máximo retorne el último valor hallado).***

***Nota: asuma que cada nodo tiene el dato de retardo de reenvío expresado en cantidad de
segundos.***

* ***Indique qué estrategia (recorrido en profundidad o por niveles) utilizará para resolver el problema.***

* ***Cree una clase Java llamada RedBinariaLlena donde implementará lo solicitado en el
método retardoReenvio():int***