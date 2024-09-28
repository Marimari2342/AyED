# AyED - Ejercitación de Árboles Binarios, de Expresión y Generales

## 🔵 Punto 1

Dado un árbol binario T cuyo recorrido postorden es A G F E B J I H C D y su recorrido inorden es A B G E F D J H I C ¿cuántos son los descendientes del nodo “C”?

(a) 2 

(b) 1 

**(c) 3** ✔️

(d) ninguna de las anteriores

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

* Recorrido <code>postOrden</code> --> hI - hD - raiz

* Recorrido <code>inOrden</code> --> hI - raiz - hD

Sabiendo esto si el recorrido postOrden devuelve A G F E B J I H C D, entonces D es la raiz. Por lo tanto (mirando recorrido inOrden) 

subArbol_izquierdo = (A B G E F) / raiz = D / subArbol_derecho = (J H I C)

Luego, volviendo a mirar postOrden (A G F E B)(J I H C) la raiz del subArbol_izquierdo es B y del subArbol_derecho es C

Nos queda 

~~~
             D
       /          \
      B            C
    /  \          /
  (A)  (G E F) (J H I)   --> estos son los subarboles que nos quedan del nodo B y C
~~~

**Por lo tanto, el nodo C tiene 3 descendientes (J, H, I).**

</details>

## 🔵 Punto 2

Defina árbol binario completo y árbol binario lleno. Ejemplifique. ¿Es verdad que todo árbol
binario completo es lleno? ¿Y viceversa?

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

* **Árbol Binario Completo:** un árbol binario completo es un árbol en el que todos los niveles, excepto el último, están completamente llenos, y todos los nodos del último nivel están lo más a la izquierda posible. Esto significa que si hay un nivel incompleto, solo faltan nodos al final, no en el medio.

Ejemplo de Árbol Binario Completo:

~~~
       1
      / \
     2   3
    / \  / 
   4   5 6 
~~~

En este caso, el árbol tiene tres niveles, y el último nivel (nivel 3) está lleno desde la izquierda, con nodos 4, 5 y 6.

* **Árbol Binario Lleno:** un árbol binario lleno es un árbol en el que todos los niveles están completamente llenos. Esto significa que cada nodo tiene exactamente 0 o 2 hijos y todos los nodos están en los mismos niveles.

Ejemplo de Árbol Binario Lleno:

~~~
       1
      / \
     2   3
    / \  / \
   4   5 6  7
~~~

En este caso, todos los niveles del árbol están completamente llenos y todos los nodos tienen dos hijos (excepto las hojas).

Un árbol binario completo no necesita estar completamente lleno en todos los niveles, solo en los niveles superiores. Un árbol completo puede tener un nivel incompleto en su parte inferior. Por otro lado, un árbol binario lleno, por definición, cumple con la condición de ser completo, ya que todos sus niveles están llenos.

</details>

## 🔵 Punto 3

Suponga que para un árbol binario T con N nodos (N>1), el último nodo en postorden es el mismo que el último nodo en inorden, ¿qué se puede concluir?

(a) El subárbol izquierdo de T es vacío

**(b) El subárbol derecho de T es vacío** ✔️

(c) Ningún nodo en el árbol tiene dos hijos

(d) Hay a lo sumo 3 nodos en el árbol

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

Sabemos que 

* postOrden = (subAIz)(subADr)(X)

* inOrden = (subAIz)(X)(subADr) 

Si el último nodo en postOrden e inOrden es el mismo (X) podemos concluir que el subArbol derecho de T es vacio.

</details>

## 🔵 Punto 4

Se han estudiado los distintos recorridos de un árbol binario. Abajo se muestra un código que
combina dos de ellos. ¿Cuál es el resultado si se llama con la raíz del árbol de la figura?

~~~
public void traverse(ArbolBinario<T> a) {
    if (!a.esVacio()) {
        System.out.print(a.getDato());
        if (a.tieneHijoIzquierdo())
            traverse(a.getHijoIzquierdo());
        if (a.tieneHijoDerecho())
            traverse(a.getHijoDerecho());
        System.out.print(a.getDato());
    }
}
~~~

~~~
      (C)
     /   \
  (A)     (E)
    \     / \
   (B)  (D) (F)
~~~

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

El código dado combina dos recorridos: preorden y postorden. El método traverse sigue estos pasos:

* Preorden: Imprime el dato del nodo antes de recorrer sus hijos (System.out.print(a.getDato())).

* Recorre el hijo izquierdo (si existe).

* Recorre el hijo derecho (si existe).

* Postorden: Imprime nuevamente el dato del nodo después de recorrer sus hijos (System.out.print(a.getDato())).

Al aplicar el método traverse con la raíz del árbol, el flujo es el siguiente:

~~~
1. Se llama a traverse(C), imprime C.                           --> C
2. Se llama a traverse(A) (hI de C), imprime A.                 --> A
3. Se llama a traverse(B) (hD de A), imprime B.                 --> B           
4. B no tiene hijos, entonces imprime nuevamente B.             --> B
5. Se vuelve a A, se imprime nuevamente A.                      --> A
6. Se vuelve a C, llama a traverse(E) (hD de C), imprime E.     --> E
7. Se llama a traverse(D) (hI de E), imprime D.                 --> D
8. D no tiene hijos, se imprime nuevamente D.                   --> D
9. Se vuelve a E, llama a traverse(F) (hD de E), imprime F.     --> F
10. F no tiene hijos, se imprime nuevamente F.                  --> F
11. Se vuelve a E, se imprime nuevamente E.                     --> E
12. Finalmente, se vuelve a C, y se imprime nuevamente C.       --> C
~~~

El resultado sería la siguiente secuencia de caracteres: C A B B A E D D F F E C

</details>