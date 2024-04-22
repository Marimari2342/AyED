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

<details><summary> <code> Respuesta 🖱 </code></summary><br>

Suponiendo que el dato guardado en cada nodo es el retardo de envío expresado en cantidad de segundos, lo que se me ocurre es realizar un recorrido en profundidad llegando hasta cada hoja y luego comparar cual de todos los caminos es el que retorno un mayor tiempo de retardo posible.

</details>

* ***Cree una clase Java llamada RedBinariaLlena donde implementará lo solicitado en el
método retardoReenvio():int***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
public int retardoReenvio() {
    int retardo = 0;
    if (!arbol.isEmpty()) //veo que el arbol no este vacio
        retardo = calcularRetardo(arbol);
    return retardo;
}

private int calcularRetardo(BinaryTree<Integer> arbol) {
    int retL = 0;
    int retR = 0;
    if (arbol.hasLeftChild())
        retL = calcularRetardo(arbol.getLeftChild());
    if (arbol.hasRightChild())
        retR = calcularRetardo(arbol.getRightChild());
    return (Math.max(retL, retR)) + arbol.getData();
}
~~~

</details>

## 🔵 Punto 5

***Implemente una clase Java llamada ProfundidadDeArbolBinario que tiene como variable de instancia un árbol binario de números enteros y un método de instancia sumaElementosProfundidad (int p):int el cuál devuelve la suma de todos los nodos del árbol que se encuentren a la profundidad pasada como argumento.***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
public int sumaElementosProfundidad(int prof) {
    if (!arbol.isEmpty())
        return sumarElementos(arbol, prof, 0);
    else
        return 0;
}

private int sumarElementos(BinaryTree<Integer> arbol, int prof, int nivel) {
    if (prof == nivel)
        return arbol.getData();
    else {
        int suma = 0;
        if (arbol.hasLeftChild())
            suma += sumarElementos(arbol.getLeftChild(), prof, nivel + 1);
        if (arbol.hasRightChild())
            suma += sumarElementos(arbol.getRightChild(), prof, nivel + 1);
        return suma + arbol.getData();
    }
}
~~~

</details>

## 🔵 Punto 6

***Cree una clase Java llamada Transformacion que tenga como variable de instancia un árbol binario de números enteros y un método de instancia suma (): BinaryTree</Integer/> el cuál devuelve el árbol en el que se reemplazó el valor de cada nodo por la suma de todos los elementos presentes en su subárbol izquierdo y derecho. Asuma que los valores de los subárboles vacíos son ceros. Por ejemplo:***

![EjemploTransformacion](/AyEDproject/src/recursos/imagen05.png)

***¿Su solución recorre una única vez cada subárbol? En el caso que no, ¿Puede mejorarla para que sí lo haga?***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
public BinaryTree<Integer> Suma() {
    if(!this.arbol.isEmpty())
        CalcularSuma(arbol);
    return arbol;
}

private int CalcularSuma(BinaryTree<Integer>arbol){
    int suma=0;
    if (arbol.isLeaf()){        //Si es una hoja guardo un 0
        suma=arbol.getData();
        arbol.setData(0);
        return suma;
    }                           //Sino calculo suma de hijos derechos e izquierdos
    if (arbol.hasLeftChild())
        suma += CalcularSuma(arbol.getLeftChild());
    if (arbol.hasRightChild())
        suma += CalcularSuma(arbol.getRightChild());
    int aux = arbol.getData();
    arbol.setData(suma);
    return aux+suma;
}
~~~

</details>

## EJERCICIOS DE PARCIALES

***Los siguientes ejercicios fueron tomados en parciales, en los últimos años. Tenga en cuenta que:***

![Informacion](/AyEDproject/src/recursos/imagen06.png)

## 🔵 Punto 7
***Escribir en una clase ParcialArboles que contenga UNA ÚNICA variable de instancia de tipo BinaryTree de valores enteros NO repetidos y el método público con la siguiente firma: public boolean isLeftTree (int num).***

***El método devuelve true si el subárbol cuya raíz es “num”, tiene en su subárbol izquierdo una cantidad mayor estricta de árboles con un único hijo que en su subárbol derecho, y false en caso contrario. Consideraciones:***

* ***Si “num” no se encuentra en el árbol, devuelve false.***

* ***Si el árbol con raíz “num” no cuenta con una de sus ramas, considere que en esa rama hay -1 árboles con único hijo.***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java

~~~

</details>

## 🔵 Punto 8

***Escribir en una clase ParcialArboles el método público con la siguiente firma: public boolean esPrefijo(BinaryTree</Integer/> arbol1, BinaryTree</Integer/> arbol2) El método devuelve true si arbol1 es prefijo de arbol2, false en caso contrario. Se dice que un árbol binario arbol1 es prefijo de otro árbol binario arbol2, cuando arbol1 coincide con la parte inicial del árbol arbol2 tanto en el contenido de los elementos como en su estructura. Por ejemplo, en la imagen de abajo el arbol1 es prefijo del arbol2***

![ArbolesPrefijos](/AyEDproject/src/recursos/imagen07.png)

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java

~~~

</details>

## 🔵 Punto 9

***Escribir en una clase ParcialArboles el método público con la siguiente firma: public BinaryTree<?> sumAndDif(BinaryTree<Integer> arbol) El método recibe un árbol binario de enteros y devuelve un nuevo árbol que contenga en cada nodo dos tipos de información:***

* ***La suma de los números a lo largo del camino desde la raíz hasta el nodo actual.***

* ***La diferencia entre el número almacenado en el nodo original y el número almacenado en el nodo padre.***

![Ejemplo](/AyEDproject/src/recursos/imagen08.png)

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java

~~~

</details>