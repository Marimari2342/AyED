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

~~~

</details>

* ***entreNiveles(int n, m) Imprime el recorrido por niveles de los elementos del árbol
receptor entre los niveles n y m (ambos inclusive). (0 ≤ n < m ≤ altura del árbol).***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java

~~~

</details>

Lo probe con el siguiente <details><summary>arbol</summary></details> (cargado en el main):

![ImagenArbolEjemplo](/AyEDproject/src/recursos/imagen03.png)