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
