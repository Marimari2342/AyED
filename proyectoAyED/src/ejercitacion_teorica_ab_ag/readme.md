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

raiz --> (2) | subAiz --> (9 3 7 5 1) | subAdr --> (6 8 4)

* subAiz = raiz --> (5) | subAizB --> (9 3 7) | subAdrB --> (1)

* subAizB = raiz (3) | subAizC --> (9) | subAdrC --> (7)

* subAdr = raiz (6) | subAdrB --> (8 4)

* subAdrB = raiz (4) | subAizC --> (8)

El arbol nos queda:

~~~
       (2)
       / \
    (5)   (6)
    / \     \
  (3) (1)   (4)
  / \       /
(9) (7)   (8)
~~~

</details>

## 🔵 Punto 14

En un árbol binario lleno, si hay L hojas, entonces el número total de nodos N es:

a) N = 2*L

b) N = L + 1

c) N = L – 1

**d) N = 2*L – 1**

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

Sabemos que un arbol binario lleno cumple que la cantidad de nodos n = 2^(h+1)-1, donde la cantidad de hojas es L = ( n + 1 ) / 2 --> 2 * L = n + 1 --> 2 * L - 1 = n

Por lo tanto, la respuesta correcta es la (d).

</details>

## 🔵 Punto 15

La siguiente figura muestra un árbol general:

~~~
         (A)
      /   |   \
  (B)    (C)    (D)
  / \          / | \
(E) (F)      (G)(H)(I)
   / | \      |    / \
 (J)(K)(L)   (M) (N) (O)
             / \
           (P) (Q)
~~~

(a) Complete los blancos de las sentencias con la terminología vista en clase.

i. ***(A)*** es la raíz del árbol.

ii. ***(A)*** es padre de B, C y D.

iii. ***(E)*** y ***(F)*** son hermanos, puesto que ambos son hijos de B. 

iv. ***(E),(J),(K),(L),(P),(Q),(N)*** y ***(O)*** son las hojas del árbol.

v. El camino desde A a J es único, lo conforman los nodos ***(A),(B),(F),(J)*** y es de largo ***4 nodos (pero 3 aristas)***.

vi. ***(D)*** es ancestro de P, y por lo tanto ***(P)*** es descendiente de D.

vii. L no es descendiente de C, puesto que no existe ***un camino*** desde C a L.

viii. La profundidad/nivel de C es ***1***, de F es ***2*** y de ***P*** es 4.

ix. La altura de C es ***0*** de ***I*** es 1 y de D es ***3*** (La altura de un nodo se define como el número de nodos en el camino más largo hacia una hoja desde ese nodo).

x. La altura del árbol es 4 (largo del camino entre la ***raiz*** y ***la hoja más profunda***).

----------------------

(b) Aplique los recorridos:

i. en profundidad (preorden, inorden, postorden).

ii. por niveles

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

* preOrden -->   A B E F J K L C D G M P O H I N O

* inOrden -->    E B J F K L A C P M Q G D H N I O 

* postOrden -->  E J K L F B C P O M G H N O I D A

* porNiveles --> A B C D E F G H I J K L M N O P Q 

</details>

## 🔵 Punto 16

¿Cuál es el número mínimo y máximo de nodos de un árbol general completo de altura h y grado k?

<details><summary> <code> Respuesta 🖱 </code></summary><br>

Sea un arbol general completo de altura h y grado k, la cantidad de nodos (n) del arbol cumplo

~~~
(k ^ h + k - 2 ) / ( k - 1 ) <= n <= (k ^ ( h + 1 ) – 1 ) / ( k - 1 )
~~~

Por ejemplo, si el arbol es de altura 2 y grado 3:

~~~
            (a)
       /     |     \
   (b)      (c)      (d)
  / | \    /
(e)(f)(g)(h)
~~~

La cantidad de nodos varía entre:

~~~
(3 ^ 2 + 3 - 2 ) / ( 3 - 1 ) <= n <= (3 ^ ( 2 + 1 ) – 1 ) / ( 3 - 1 )
(9 + 1 ) / 2 <= n < ( 27 - 1 ) / 2
5 <= n <= 13
~~~

En el ejemplo tenemos 8 nodos que pertenece al rango dado.

</details>

## 🔵 Punto 17

El recorrido inorden en un árbol general visita:

a) Primero la mitad de los subárboles hijos, luego la raíz y luego los restantes subárboleshijos.

b) Primero la raíz y luego los subárboles hijos.

c) Primero los subárboles hijos y luego la raíz.

**d) Primero el subárbol hijo más izquierdo, luego la raíz y luego los restantes subárboles hijos.** ✔️ 

<details><summary> <code> Respuesta 🖱 </code></summary><br>

La respuesta correcta es la (d), puesto que el recorrido inorden en un árbol general se define de la siguiente manera:

1. Primero visita el subárbol hijo más izquierdo.

2. Luego visita la raíz del árbol.

3. Finalmente, visita los restantes subárboles (de izquierda a derecha).

</details>

## 🔵 Punto 18

En un árbol general, la profundidad de un nodo n1 es:

**a) La longitud del único camino que existe entre la raíz y el nodo n1.** ✔️

b) La longitud del camino más largo que existe entre el nodo n1 y una hoja.

c) La cantidad de nodos hijos del nodo n1.

d) Ninguna de las otras opciones.

## 🔵 Punto 19

Un árbol general lleno de grado 4, tiene 21 nodos.

a) ¿Cuál es la altura del árbol?

b) Desarrolle el proceso realizado para obtener la respuesta anterior.

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

Sabemos que un arbol lleno de grado k y altura h cumple que la cantidad de nodos es:

* n = (k ^ ( h + 1 ) – 1 ) / ( k - 1 )

Como n = 21 y k = 4, reemplazamos en la ecuación de arriba y despejamos h que va a ser la altura del arbol.

~~~
21 = (4 ^ ( h + 1 ) – 1 ) / ( 4 - 1 )
21 * 3 = 4 ^ ( h + 1 ) – 1
63 + 1 = 4 ^ ( h + 1 )
64 = 4 ^ ( h + 1 )
4 ^ 3 = 4 ^ ( h + 1 )      //como las bases son iguales, igualamos los exponentes
3 = h + 1
h = 2 
~~~

Por lo tanto, la altura del arbol es h = 2.

</details>

## 🔵 Punto 20

¿Cuál es la cantidad mínima de nodos en un árbol general completo de grado 3 y altura 4?

<details><summary> <code> Respuesta 🖱 </code></summary><br>

Sabemos que un arbol general completo de altura h y grado k, cumple que la cantidad de nodos (n) es:

~~~
(k ^ h + k - 2 ) / ( k - 1 ) <= n <= (k ^ ( h + 1 ) – 1 ) / ( k - 1 )
~~~

Si queremos saber la cantidad mínima de nodos de un arbol general completo de grado 3 y altura 4 hacemos:

~~~
n = ( k ^ h + k - 2 ) / ( k - 1 )
n = ( 3 ^ 4 + 3 - 2 ) / ( 3 - 1 )
n = ( 81 + 1 ) / 2
n = 82 / 2
n = 41 
~~~

</details>

## 🔵 Punto 21

Si un árbol general lleno de grado 5 tiene 125 hojas.

a) ¿Cuál es la cantidad de nodos internos del árbol?

b) Desarrolle el proceso realizado para obtener la respuesta anterior.

<details><summary> <code> Respuesta 🖱 </code></summary><br>

Sabemos que un arbol lleno de grado k y altura h cumple que la cantidad de nodos es:

* n = (k ^ ( h + 1 ) – 1 ) / ( k - 1 )

Si el arbol es de grado 5 y tiene 125 hojas, esto significa que en el último nivel tenemos:

(5)(5)(5)....(5) = 125 = 5 ^ n (donde n = nivel). Entonces tenemos 3 niveles en nuestro arbol, pues 5 ^ 3 = 125. 

Para saber la cantidad de nodos internos del arbol entonces sumanos todos los nodos de los niveles anteriores, que será:

x = 5 ^ 2 + 5 ^ 1 + 5 ^ 0 = 25 + 5 + 1 = 31

Por lo tanto, los nodos internos en el árbol dado son 31.

</details>

## 🔵 Punto 22

¿Cuál es la cantidad de nodos en un árbol general COMPLETO de grado 4 y altura 3?

<details><summary> <code> Respuesta 🖱 </code></summary><br>

Sea un arbol general completo de altura h y grado k, la cantidad de nodos (n) del arbol cumple:

~~~
(k ^ h + k - 2 ) / ( k - 1 ) <= n <= (k ^ ( h + 1 ) – 1 ) / ( k - 1 )
~~~

En el caso en que el grado k = 4 y la altura h = 3, se cumple:

~~~
( 4 ^ 3 + 4 - 2 ) / ( 4 - 1 ) <= n <= (4 ^ ( 3 + 1 ) – 1 ) / ( 4 - 1 )
( 64 + 2 ) / 3 <= n <= ( 256 - 1) / 3
66 / 3 <= n <= ( 255 ) / 3
22 <= n <= 85
~~~

Por lo tanto, la respuesta correcta es que la cantidad de nodos será entre 22 y 85, para el arbol dado. 

</details>
