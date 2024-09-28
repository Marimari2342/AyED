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