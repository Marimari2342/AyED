# AyED - Practica AB y AG <br> Árboles Binarios, de Expresión y Generales

## 🟠 Punto 1
***Dado un árbol binario T cuyo recorrido postorden es A G F E B J I H C D y su recorrido inorden es A B G E F D J H I C ¿cuántos son los descendientes del nodo “C”?***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

El nodo C tiene 3 descendientes --> D es la raiz. C pertenece al subarbol derecho [SD = J I H C], y por lo visto en el recorrido PostOrden, C es la raiz del subarbol derecho por lo cual J, H, C son descendientes.

</details>

## 🟠 Punto 2

***Defina árbol binario completo y árbol binario lleno. Ejemplifique. ¿Es verdad que todo árbol binario completo es lleno? ¿Y viceversa?***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

* ARBOL BINARIO LLENO: dado un arbol binario **T** de altura **h**, diremos que **T** es lleno si cada nodo interno tiene grado 2 y todas las hojas están en el mismo nivel. 

* ARBOL BINARIO COMPLETO: dado un arbol binario **T** de altura **h**, diremos que **T** es completo si es lleno de altura **h-1** y el nivel **h** se completa de izquierda a derecha.

No todo arbol binario completo es un arbol lleno, pues un arbol completo puede no tener todas las hojas al mismo nivel, pero todos los arboles binarios llenos son completos, especificamente con todo el nivel h completo. 

</details>

## 🟠 Punto 3

***Suponga que para un árbol binario T con N nodos (N>1), el último nodo en postorden es el mismo que el último nodo en inorden, ¿qué se puede concluir?***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

Se puede concluir que el subárbol derecho de T es vacío puesto que se cumple

~~~
PostOrden   --> ......................... R

InOrden     --> (..SubIzq..) R (..SubDer..)
~~~

Como en PostOrden el último nodo SIEMPRE es la raiz, para que se cumpla el enunciado, el árbol no debería tener subarbol derecho.

</details>

## 🟠 Punto 4

***Se han estudiado los distintos recorridos de un árbol binario. Abajo se muestra un código que combina dos de ellos. ¿Cuál es el resultado si se llama con la raíz del árbol de la figura?***

~~~java
public void traverse(ArbolBinario<T> a) { 
    if (!a.esVacio()) {
        System.out.print(a.getDato()); if (a.tieneHijoIzquierdo())
        traverse(a.getHijoIzquierdo()); if (a.tieneHijoDerecho())
        traverse(a.getHijoDerecho()); System.out.print(a.getDato());
    }
}
~~~

![imagen](/AyEDproject/src/recursos/imagen10.png)

<details><summary> <code> Respuesta 🖱 </code></summary><br>

El programa imprime C - A - B - B - A - E - D - D - F - F - E - C

</details>

## 🟠 Punto 5

***Evalúe la siguiente expresión postfija y determine cuál es el resultado.***

~~~
6 5 * 7 3 − 4 8 + * +
~~~

<details><summary> <code> Respuesta 🖱 </code></summary><br>

Esta expresión sería --> **(6*5)+(7-3)*(4+8) = 78**

</details>

## 🟠 Punto 6

***Elija la expresión algebraica almacenada en el siguiente árbol:***

![imagen](/AyEDproject/src/recursos/imagen11.png)

<details><summary> <code> Respuesta 🖱 </code></summary><br>

La expresión sería la d) --> **(((a-b)/c)+(d*e))**

</details>

## 🟠 Punto 7

***¿Cuál es el número mínimo de nodos en un árbol binario completo de altura 4?***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

Un arbol completo de altura 4 con el mínimo número de nodos sólo tiene 1 nodo en el nivel 4. Lo puedo pensar como la suma de un árbol lleno de nivel 3 más el único nodo del nivel 4, entonces:

~~~
Arbol lleno de altura 3 + 1 --> 2^(3+1)-1+1 = 2^4 = 16
~~~

</details>

<p align=center>🟠</p>
<p align=center>🟠</p>
<p align=center>🟠</p>

>[!NOTE]
>
> * ***Para descargar la practica (del 2024) en PDF, click [<code>AQUÍ</code>](https://drive.google.com/file/d/1Z1ls6fbvRF_Txi7E3y9l3MBjc74iTLvF/view?usp=sharing).***


<br>
<br>
<br>


<p><img align="center" src="https://github.com/Marimari2342/Marimari2342/blob/main/firmagith.png" alt="marigit"/></p>
