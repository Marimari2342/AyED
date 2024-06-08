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
