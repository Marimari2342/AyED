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

## 🔵 Punto 3

Defina una clase Java denominada <code>ContadorArbol</code> cuya función principal es proveer métodos de validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un <code>BinaryTree<Integer></code>. Implemente en dicha clase un método denominado <code>numerosPares()</code> que devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del árbol (divisibles por 2).

a) Implemente el método realizando un recorrido InOrden.

b) Implemente el método realizando un recorrido PostOrden.

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

~~~java
package practica02.ejercicio3;
import java.util.LinkedList;
import practica02.ejercicio1y2.BinaryTree;


public class ContadorArbol {
    //variable de instancia
    private BinaryTree<Integer> arbol;

    //constructor
    public ContadorArbol(BinaryTree<Integer> unArbol) {
        arbol = unArbol;
    }

    /*Método numerosPares() que devuelve en una estructura 
    adecuada todos los elementos pares del árbol */

    // (a) InOrder (se procesa hijo izquierdo - raiz - hijo derecho)
    public LinkedList<Integer> numerosParesInOr() {
        LinkedList<Integer> lista = new LinkedList<Integer>();
        if (!arbol.isEmpty()) // Si tengo elemento en el arbol ejecuto
            this.numerosParesInOrder(arbol, lista);
        return lista;
    }

    private void numerosParesInOrder(BinaryTree<Integer> arbol, LinkedList<Integer> lista) {
        if (arbol.hasLeftChild())
            numerosParesInOrder(arbol.getLeftChild(), lista);
        if (arbol.getData() % 2 == 0)
            lista.add(arbol.getData());
        if (arbol.hasRightChild())
            numerosParesInOrder(arbol.getRightChild(), lista);
    }

    // (b) PostOrden (se procesa hijo izquierdo - hijo derecho - raiz)
    public LinkedList<Integer> numerosParesPostOr() {
        LinkedList<Integer> lista = new LinkedList<Integer>();
        if (!arbol.isEmpty()) // Si tengo elemento en el arbol ejecuto
            this.numerosParesPostOrder(arbol, lista);
        return lista;
    }

    private void numerosParesPostOrder(BinaryTree<Integer> arbol, LinkedList<Integer> lista) {
        if (arbol.hasLeftChild())
            numerosParesPostOrder(arbol.getLeftChild(), lista);
        if (arbol.hasRightChild())
            numerosParesPostOrder(arbol.getRightChild(), lista);
        if (arbol.getData() % 2 == 0)
            lista.add(arbol.getData());
    }
}
~~~

</details>

## 🔵 Punto 4

Una **RED BINARIA** es una red que posee una topología de árbol binario lleno. Los nodos que conforman una red binaria llena tiene la particularidad de que todos ellos conocen cuál es su retardo de reenvío. El retardo de reenvío se define como el período comprendido entre que un nodo recibe un mensaje y lo reenvía a sus dos hijos.

Su tarea es calcular el mayor retardo posible, en el camino que realiza un mensaje desde la raíz hasta llegar a las hojas en una red binaria llena. (Si hay más de un máximo retorne el último valor hallado).

Nota: asuma que cada nodo tiene el dato de retardo de reenvío expresado en cantidad de segundos.

a) Indique qué estrategia (recorrido en profundidad o por niveles) utilizará para resolver el problema.

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

Para resolver este problema, la estrategia más adecuada sería un recorrido en profundidad utilizando un enfoque PostOrden (izquierda, derecha, raíz).

Puesto que el objetivo es encontrar el mayor retardo acumulado desde la raíz hasta las hojas en una red binaria llena, lo que implica analizar todas las ramas de la red (desde la raíz hasta las hojas); un recorrido en profundidad es la mejor opción porque nos permite explorar cada rama completamente antes de pasar a la siguiente. Esto es útil porque necesitamos sumar los retardos de cada nodo en el camino y así identificar cuál rama tiene el mayor retardo.

Utilizar un recorrido en PostOrden es eficiente para este tipo de problemas, ya que primero calculamos el retardo de los hijos antes de volver al padre. De este modo, cuando llegamos a la raíz, ya sabemos cuál es el retardo acumulado más largo en sus subárboles. En cada paso, comparamos los retardos de los hijos de un nodo y sumamos el mayor retardo al del nodo actual, propagando esta suma hacia la raíz.

* Estrategia:

Caso base: Si llegamos a una hoja, simplemente retornamos su retardo.

Paso recursivo: Para cada nodo interno, llamamos recursivamente a sus hijos izquierdo y derecho para obtener el mayor retardo de esos caminos, sumamos el retardo del nodo actual y devolvemos el valor acumulado.

</details>

b) Cree una clase Java llamada RedBinariaLlena donde implementará lo solicitado en el método retardoReenvio():int

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

~~~java
package practica02.ejercicio4;

import practica02.ejercicio1y2.BinaryTree;

public class RedBinariaLlena {

    private BinaryTree<Integer> arbol;

    public RedBinariaLlena(BinaryTree<Integer> unArbol) {
        this.arbol = unArbol;
    }

    public int retardoReenvio() {
        int retardo = 0; //inicializo
        if (!arbol.isEmpty()) //veo que el arbol no este vacio
            retardo = calcularRetardo(arbol); //metodo recursivo
        return retardo;
    }

    private int calcularRetardo(BinaryTree<Integer> arbol) {
        int retL = 0;
        int retR = 0;
        /*llamamos recursivamente a sus hijos izquierdo y 
        derecho para obtener el mayor retardo de esos caminos*/
        if (arbol.hasLeftChild())
            retL = calcularRetardo(arbol.getLeftChild());
        if (arbol.hasRightChild())
            retR = calcularRetardo(arbol.getRightChild());
        /*obtenemos el mayor retardo, sumamos el retardo del 
        nodo actual y devolvemos el valor acumulado */
        return (Math.max(retL, retR)) + arbol.getData();
    }
}
~~~

</details>