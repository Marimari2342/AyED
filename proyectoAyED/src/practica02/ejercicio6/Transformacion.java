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