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

**Estrategia:**

* Caso base: Si llegamos a una hoja, simplemente retornamos su retardo.

* Paso recursivo: Para cada nodo interno, llamamos recursivamente a sus hijos izquierdo y derecho para obtener el mayor retardo de esos caminos, sumamos el retardo del nodo actual y devolvemos el valor acumulado.

------------------------

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

Main.java
~~~java
package practica02.ejercicio4;
import practica02.ejercicio1y2.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(10);
        arbol.addLeftChild(new BinaryTree<>(2));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(5));
        arbol.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(7));
        arbol.getLeftChild().getLeftChild().addRightChild(new BinaryTree<>(8));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(4));
        arbol.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(5));
        arbol.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(6));
        arbol.addRightChild(new BinaryTree<>(3));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(9));
        arbol.getRightChild().getLeftChild().addLeftChild(new BinaryTree<>(12));
        arbol.getRightChild().getLeftChild().addRightChild(new BinaryTree<>(8));
        arbol.getRightChild().addRightChild(new BinaryTree<>(8));
        arbol.getRightChild().getRightChild().addLeftChild(new BinaryTree<>(2));
        arbol.getRightChild().getRightChild().addRightChild(new BinaryTree<>(1));

        RedBinariaLlena aLleno = new RedBinariaLlena(arbol);
        System.out.println("El retardo máximo de envio es: "+aLleno.retardoReenvio());
    }
}
~~~

</details>

## 🔵 Punto 5

Implemente una clase Java llamada ProfundidadDeArbolBinario que tiene como variable de instancia un árbol binario de números enteros y un método de instancia sumaElementosProfundidad (int p):int el cuál devuelve la suma de todos los nodos del árbol que se encuentren a la profundidad pasada como argumento.

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

~~~java
package practica02.ejercicio5;

import practica02.ejercicio1y2.BinaryTree;

public class ProfundidadDeArbolBinario {

    // Variable de instancia que almacena el árbol binario de enteros
    private BinaryTree<Integer> arbol;

    /*Constructor que inicializa la instancia de 
    ProfundidadDeArbolBinario con un árbol binario dado*/
    public ProfundidadDeArbolBinario(BinaryTree<Integer> unArbol) {
        arbol = unArbol;
    }

    /**
     * Método que calcula la suma de los elementos del árbol que se encuentran en 
     * una profundidad dada.
     * @param prof la profundidad en la que queremos sumar los nodos.
     * @return la suma de los nodos en la profundidad especificada.
     */
    public int sumaElementosProfundidad(int prof) {
        // Si el árbol no está vacío, inicia el proceso de sumar los elementos.
        if (!arbol.isEmpty()) {
            // Llama a un método auxiliar para realizar el recorrido y sumar los elementos.
            return sumarElementos(arbol, prof, 0);
        } else {
            // Si el árbol está vacío, la suma es 0.
            return 0;
        }
    }

    /**
     * Método recursivo que suma los elementos de un árbol binario a una profundidad dada.
     * @param arbol el árbol binario actual en el que estamos trabajando.
     * @param prof la profundidad que estamos buscando.
     * @param nivel el nivel actual en el que nos encontramos en el recorrido del árbol.
     * @return la suma de los nodos en la profundidad especificada.
     */
    private int sumarElementos(BinaryTree<Integer> arbol, int prof, int nivel) {
        // Si el nivel actual es igual a la profundidad buscada
        if (prof == nivel) {
            // Retorna el valor del nodo actual, ya que estamos en la profundidad deseada.
            return arbol.getData();
        } else {
            int suma = 0; // Variable para acumular la suma de los nodos a la profundidad deseada.

            // Si el nodo actual tiene un hijo izquierdo, seguimos recorriendo el subárbol izquierdo.
            if (arbol.hasLeftChild()) {
                // Llamada recursiva para recorrer el hijo izquierdo, aumentando el nivel en 1.
                suma += sumarElementos(arbol.getLeftChild(), prof, nivel + 1);
            }

            // Si el nodo actual tiene un hijo derecho, seguimos recorriendo el subárbol derecho.
            if (arbol.hasRightChild()) {
                // Llamada recursiva para recorrer el hijo derecho, aumentando el nivel en 1.
                suma += sumarElementos(arbol.getRightChild(), prof, nivel + 1);
            }

            // Retorna la suma de los nodos en los subárboles izquierdo y derecho a la profundidad deseada.
            // No suma el valor del nodo actual si no estamos en la profundidad buscada.
            return suma;
        }
    }
}
~~~

Main.java
~~~java
package practica02.ejercicio5;

import practica02.ejercicio1y2.BinaryTree;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(4);
        arbol.addLeftChild(new BinaryTree<>(2));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(1));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(3));
        arbol.addRightChild(new BinaryTree<>(6));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(5));

        arbol.imprimir();
        System.out.println("");
        ProfundidadDeArbolBinario a = new ProfundidadDeArbolBinario(arbol);
        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese profundidad: ");
        int prof = s.nextInt();
        s.close();
        System.out.println("Suma de elementos a profundidad " + prof + ": " + a.sumaElementosProfundidad(prof));
    }
}
~~~

</details>

## 🔵 Punto 6

Cree una clase Java llamada Transformacion que tenga como variable de instancia un árbol binario de números enteros y un método de instancia suma (): BinaryTree<Integer> el cuál devuelve el árbol en el que se reemplazó el valor de cada nodo por la suma de todos los elementos presentes en su subárbol izquierdo y derecho. Asuma que los valores de los subárboles vacíos son ceros. Por ejemplo:

~~~
   (1)					     (35)	
  /   \					    /    \
(2)    (3)				 (4)     (26)			
  \    / \		 -->	   	   \     /  \
  (4) (5) (6)		       		   (0) (15) (0)
      / \				       /  \
    (7) (8)				     (0)  (0)
~~~

¿Su solución recorre una única vez cada subárbol? En el caso que no, ¿Puede mejorarla para que sí lo haga?

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

~~~java
package practica02.ejercicio6;

import practica02.ejercicio1y2.BinaryTree;

public class Transformacion {

    private BinaryTree<Integer> arbol;

    // Constructor que recibe un árbol binario
    public Transformacion(BinaryTree<Integer> unArbol) {
        arbol = unArbol;
    }

    /**
     * Método que transforma el árbol reemplazando el valor de cada nodo
     * por la suma de los valores de su subárbol izquierdo y derecho.
     */
    public BinaryTree<Integer> suma() {
        if (!this.arbol.isEmpty()) {
            calcularSuma(arbol);  // Inicia el cálculo desde la raíz
        }
        return arbol;  // Devuelve el árbol transformado
    }

    /**
     * Método recursivo que calcula la suma de los elementos de los subárboles
     * y reemplaza el valor del nodo con dicha suma.
     * @param arbol El árbol o subárbol actual en el que estamos trabajando.
     * @return La suma de los valores de los subárboles izquierdo y derecho
     * más el valor del nodo actual.
     */
    private int calcularSuma(BinaryTree<Integer> arbol) {
        if (arbol.isLeaf()) {  // Si el nodo es una hoja, su valor se convierte en 0
            int valorHoja = arbol.getData();
            arbol.setData(0);  // Reemplaza el valor de la hoja con 0
            return valorHoja;  // Devuelve el valor original de la hoja
        }

        int suma = 0;  // Variable para acumular la suma de los hijos

        // Recursivamente suma los valores del subárbol izquierdo (si existe)
        if (arbol.hasLeftChild()) {
            suma += calcularSuma(arbol.getLeftChild());
        }

        // Recursivamente suma los valores del subárbol derecho (si existe)
        if (arbol.hasRightChild()) {
            suma += calcularSuma(arbol.getRightChild());
        }

        arbol.setData(suma);  // Reemplaza el valor del nodo con la suma de sus hijos
        return suma;  // Devuelve la suma total (valor original + suma de hijos)
    }

    // Devuelve el árbol transformado para su impresión o uso posterior
    public BinaryTree<Integer> getArbolT() {
        return arbol;
    }
}
~~~

</details>

------------------------

**Los siguientes ejercicios fueron tomados en parciales, en los últimos años. Tenga en cuenta que:**

* **1. No puede agregar más variables de instancia ni de clase a la clase ParcialArboles.**

* **2. Debe respetar la clase y la firma del método indicado.**

* **3. Puede definir todos los métodos y variables locales que considere necesarios.**

* **4. Todo método que no esté definido en la sinopsis de clases debe ser implementado.**

* **5. Debe recorrer la estructura solo 1 vez para resolverlo.**

* **6. Si corresponde, complete en la firma del método el tipo de datos indicado con signo de “?”.**

------------------------

## 🔵 Punto 7

Escribir en una clase ParcialArboles que contenga UNA ÚNICA variable de instancia de tipo BinaryTree de valores enteros NO repetidos y el método público con la siguiente firma:

~~~java
public boolean isLeftTree (int num)
~~~

El método devuelve true si el subárbol cuya raíz es “num”, tiene en su subárbol izquierdo una cantidad mayor estricta de árboles con un único hijo que en su subárbol derecho. Y false en caso contrario. Consideraciones:

* Si “num” no se encuentra en el árbol, devuelve false.

*  Si el árbol con raíz “num” no cuenta con una de sus ramas, considere que en esa rama hay -1 árboles con único hijo.

Por ejemplo, con un árbol como se muestra en la siguiente imagen:

![imagen](/proyectoAyED/src/recursos/imagen03.png)

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

~~~java
package practica02.ejercicio7;

import practica02.ejercicio1y2.BinaryTree;

public class ParcialArboles {

    // única variable de instancia
    private BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> unArbol) {
        arbol = unArbol;
    }

    // Método para buscar el número pasado en "num" dentro del árbol
    private BinaryTree<Integer> buscar(BinaryTree<Integer> arbol, int num) {
        if (arbol == null || arbol.isEmpty()) {
            return null;  // Si el árbol está vacío, retorna null
        }
        if (num == arbol.getData()) {
            return arbol;  // Si se encuentra el número, devuelve el árbol
        } else {
            BinaryTree<Integer> aux = null;
            if (arbol.hasLeftChild()) {
                aux = buscar(arbol.getLeftChild(), num);  // Busca en el subárbol izquierdo
            }
            if (arbol.hasRightChild() && aux == null) {
                aux = buscar(arbol.getRightChild(), num);  // Busca en el subárbol derecho si no lo encontró en el izquierdo
            }
            return aux;  // Retorna el nodo si lo encuentra, o null
        }
    }

    // Método para evaluar si el subárbol izquierdo tiene más nodos con un único hijo que el derecho
    private boolean evaluar(BinaryTree<Integer> arbol) {
        int izq = -1;  // Inicializo con -1 si el subárbol izquierdo no existe
        int der = -1;  // Inicializo con -1 si el subárbol derecho no existe

        if (arbol.hasLeftChild()) {
            izq = contar(arbol.getLeftChild());  // Cuenta los nodos con un único hijo en el subárbol izquierdo
        }
        if (arbol.hasRightChild()) {
            der = contar(arbol.getRightChild());  // Cuenta los nodos con un único hijo en el subárbol derecho
        }

        return izq > der;  // Verifica si la cantidad en el subárbol izquierdo es mayor
    }

    // Método para contar cuántos nodos en un subárbol tienen un único hijo
    private int contar(BinaryTree<Integer> arbol) {
        int cant = 0;

        if (arbol.hasLeftChild()) {
            cant += contar(arbol.getLeftChild());  // Recursivamente cuenta en el subárbol izquierdo
        }
        if (arbol.hasRightChild()) {
            cant += contar(arbol.getRightChild());  // Recursivamente cuenta en el subárbol derecho
        }

        // Si el nodo tiene solo un hijo, se cuenta
        if ((arbol.hasLeftChild() && !arbol.hasRightChild()) || (!arbol.hasLeftChild() && arbol.hasRightChild())) {
            cant += 1;
        }

        return cant;  // Retorna la cantidad de nodos con un único hijo
    }

    /**
     * Método público que verifica si el subárbol cuya raíz es el nodo con valor "num"
     * tiene más nodos con un único hijo en su subárbol izquierdo que en su subárbol derecho.
     * 
     * @param num valor de la raíz del subárbol a evaluar
     * @return true si el subárbol izquierdo tiene más nodos con un único hijo, false en caso contrario
     */
    public boolean isLeftTree(int num) {
        BinaryTree<Integer> arbolRaiz = buscar(arbol, num);  // Busca el árbol con raíz en "num"
        
        // Si el árbol no se encuentra o está vacío, devuelve false
        if (arbolRaiz == null || arbolRaiz.isEmpty()) {
            return false;
        }

        // Evalúa si el subárbol izquierdo tiene más nodos con un único hijo que el derecho
        return evaluar(arbolRaiz);
    }
}
~~~

</details>

## 🔵 Punto 8

Escribir en una clase ParcialArboles el método público con la siguiente firma:

~~~java
public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2)
~~~

El método devuelve true si arbol1 es prefijo de arbol2, false en caso contrario. Se dice que un árbol binario arbol1 es prefijo de otro árbol binario arbol2, cuando arbol1 coincide con la parte inicial del árbol arbol2 tanto en el contenido de los elementos como en su estructura. Por ejemplo, en la siguiente imagen: arbol1 ES prefijo de arbol2.

![imagenEsPrefijo](/proyectoAyED/src/recursos/imagen04.png)


<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

~~~java
package practica02.ejercicio8;
import practica02.ejercicio1y2.BinaryTree;

public class ParcialArboles {

    public ParcialArboles() {  
    }

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        // Si ambos árboles están vacíos, son prefijos
        if (arbol1.isEmpty() && arbol2.isEmpty()) {
            return true;
        }
        // Si solo uno de los dos está vacío, no pueden ser prefijos
        if (arbol1.isEmpty() || arbol2.isEmpty()) {
            return false;
        }
        // Se pasa al chequeo recursivo para ver si arbol1 es prefijo de arbol2
        return evaluarPrefijo(arbol1, arbol2);
    }

    private boolean evaluarPrefijo(BinaryTree<Integer> a1, BinaryTree<Integer> a2) {
        // Si los datos no coinciden, a1 no es prefijo de a2
        if (!a1.getData().equals(a2.getData())) {
            return false;
        }
        // Chequeo recursivo para el hijo izquierdo
        if (a1.hasLeftChild()) {
            if (!a2.hasLeftChild()) {
                return false;  // Si a1 tiene hijo izquierdo pero a2 no, no es prefijo
            }
            // Evaluar el subárbol izquierdo
            if (!evaluarPrefijo(a1.getLeftChild(), a2.getLeftChild())) {
                return false;
            }
        }
        
        // Chequeo recursivo para el hijo derecho
        if (a1.hasRightChild()) {
            if (!a2.hasRightChild()) {
                return false;  // Si a1 tiene hijo derecho pero a2 no, no es prefijo
            }
            // Evaluar el subárbol derecho
            if (!evaluarPrefijo(a1.getRightChild(), a2.getRightChild())) {
                return false;
            }
        }
        // Si todos los chequeos son satisfactorios, a1 es prefijo de a2
        return true;
    }
}
~~~

</details>


## 🔵 Punto 9

Escribir en una clase ParcialArboles el método público con la siguiente firma:

~~~java
public BinaryTree<?> sumAndDif(BinaryTree<Integer> arbol)
~~~

El método recibe un árbol binario de enteros y devuelve un nuevo árbol que contenga en cada nodo dos tipos de información:

* La suma de los números a lo largo del camino desde la raíz hasta el nodo actual.

* La diferencia entre el número almacenado en el nodo original y el número almacenado en el nodo padre.

Nota: En el nodo raíz considere que el valor del nodo padre es 0.

![imagenSumAndDif](/proyectoAyED/src/recursos/imagen05.png)


<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

ParcialArboles.java

~~~java
package practica02.ejercicio9;
import practica02.ejercicio1y2.BinaryTree;

public class ParcialArboles {

    public BinaryTree<SumaDiferencia> sumAndDif(BinaryTree<Integer> arbol) {
        BinaryTree<SumaDiferencia> arbolN = new BinaryTree<SumaDiferencia>();
        if (!arbol.isEmpty())
            evaluar(arbol, arbolN, 0, 0);
        return arbolN;
    }

    private void evaluar(BinaryTree<Integer> a, BinaryTree<SumaDiferencia> aN, int sum,
            int padre) {
        int actual = a.getData();
        SumaDiferencia aux = new SumaDiferencia(sum + a.getData(), a.getData() - padre);
        aN.setData(aux);
        if (a.hasLeftChild()) {
            aN.addLeftChild(new BinaryTree<SumaDiferencia>());
            evaluar(a.getLeftChild(), aN.getLeftChild(), sum + actual, actual);
        }
        if (a.hasRightChild()) {
            aN.addRightChild(new BinaryTree<SumaDiferencia>());
            evaluar(a.getRightChild(), aN.getRightChild(), sum + actual, actual);
        }
    }
}
~~~

SumaDiferencia.java

~~~java
package practica02.ejercicio9;

public class SumaDiferencia {

    private int suma;
    private int dif;

    public SumaDiferencia(int s, int d) {
        suma = s;
        dif = d;
    }

    public int getSuma() {
        return suma;
    }

    public int getDif() {
        return dif;
    }

    public void setSuma(int s) {
        this.suma = s;
    }

    public void setDif(int d) {
        this.dif = d;
    }

    public String toString() {
        return "Suma: " + suma + " Diferencia: " + dif;
    }
}
~~~

</details>


