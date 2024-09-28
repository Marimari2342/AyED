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

## 🔵 Punto 5

Evalúe la siguiente expresión postfija y determine cuál es el resultado.

6 5 * 7 3 − 4 8 + * +

**(a) 78** ✔️

(b) 66 

(c) 34 

(d) 44

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

Construcción de un arbol a partir de una expresión postfija

~~~
tomo un carácter de la expresión
mientras ( existe carácter ) hacer
    si es un operando 🡪 creo un nodo y lo apilo.
    si es un operador (lo tomo como la raíz de los dos últimos nodos creados)
        🡪 - creo un nodo R,
    - desapilo y lo agrego como hijo derecho de R
        - desapilo y lo agrego como hijo izquierdo de R
    - apilo R.
    tomo otro carácter
fin
~~~

Entonces:

~~~
          (+)
         /   \
      (*)     (*)
     /   \   /   \
   (6)  (5) (-)   (+)
            / \   / \
          (7) (3)(4)(8) 
~~~

Nos queda = (6 * 5) + [(7 - 3) * (4 + 8)] = 30 + (4 * 12) = 30 + 48 = 78

</details>

## 🔵 Punto 6

Elija la expresión algebraica almacenada en el siguiente árbol:

~~~
        (+)
      /     \
    (/)     (*)
    / \     / \
  (-) (c) (d) (e)
  / \
(a) (b)
~~~

(a) ((a – b / c) + d * e)

(b) (((a – b) / (c + d)) + d * e)

(c) ((a – b / c) + (d * e))

**(d) (((a – b) / c) + (d * e))** ✔️

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

Suponiendo que con el arbol armamos una expresión postfija la respuesta correcta es la (d)

</details>

## 🔵 Punto 7

¿Cuál es el número mínimo de nodos en un árbol binario completo de altura 4? 

(a) 10      

(b) 15      

(c) 12      

(d) 31      

**(e) 16** ✔️

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

Un árbol binario completo es un árbol en el que todos los niveles, excepto el último, están completamente llenos, y todos los nodos del último nivel están lo más a la izquierda posible.

Dado que el número de nodos n de un arbol binario completo de altura h cumple que:

~~~
2^h <= n <= (2^(h+1)-1)
~~~

Podemos decir que el número MINIMO de nodos en un árbol binario de altura 4 es 2^4 = 16

</details>

## 🔵 Punto 9

Construya el árbol de expresión correspondiente a la siguiente expresión infija. 

~~~
( A + ( B * C ) ) * ( D – E )
~~~

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

raiz = * | subAiz = ( A + ( B * C ) ) | subAdr = ( D – E )

~~~
      (*)
    /     \
  (+)     (-)
  / \     / \
(A) (*) (D) (E)
    / \
  (B) (C)
~~~

</details>

## 🔵 Punto 10

Construya el árbol de expresión correspondiente a la siguiente expresión prefija.

~~~
+ + a e / * - b c d f
~~~

¿Cuál es la profundidad del nodo d?

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

Si es operador lo bajo, si no es operador es una hoja

~~~
      (+)
     /   \
  (+)     (/)
  / \     / \
(a) (e) (*) (f)
        / \
      (-) (d)
      / \
    (b) (c)
~~~

La profundidad del nodo d es 3.

La operación que me quedaría sería --> ( a + e ) + { [ ( b - c ) * d ] / f }

</details>

## 🔵 Punto 11

Obtenga la expresión prefija de la siguiente expresión postfija:

~~~
A B C * D - E F / G / - *
~~~

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

Este sería el arbol de expresión.

~~~
    (*)
   /   \
(A)     (-)
       /   \
    (-)     (/)
    / \     / \
  (*) (D)  (/) (G)
  / \      / \
(B) (C)  (E) (F)
~~~

Entonces la expresión prefija sería: * A - - * B C D / / E F G 

</details>

## 🔵 Punto 12

¿Cuál de los siguientes árboles binarios tiene su recorrido inorden BCAD y preorden ABCD?

~~~
Arbol 1    Arbol 2    Arbol 3    Arbol 4
  (A)        (A)        (A)        (A)
  / \        / \          \        / \
(B) (C)    (C) (D)        (B)    (B) (D)
    /      /              / \      \
   (D)   (B)            (C) (D)     (C)
~~~

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

* Recorrido <code>preOrden</code> --> raiz - hI - hD

* Recorrido <code>inOrden</code> --> hI - raiz - hD

Por el recorrido preorden sabemos que la raiz es A, por lo tanto, viendo el recorrido inorden sabemos que subAiz: (B C) | raiz: A | subAdr: D. Podemos descartar entonces los arboles 1 y 3.

Luego volviendo a mirar el recorrido preorden vemos que B va antes que C, por lo tanto descartamoos el arbol 2.

La respuesta es el **Arbol 4**

</details>

## 🔵 Punto 13

Reconstruya el árbol binario T cuyo recorrido preorden es 2 5 3 9 7 1 6 4 8 y su recorrido inorden es 9 3 7 5 1 2 6 8 4.

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>
</details>

## 🔵 Punto 14

En un árbol binario lleno, si hay L hojas, entonces el número total de nodos N es:

a) N = 2*L

b) N = L + 1

c) N = L – 1

d) N = 2*L – 1

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>
</details>