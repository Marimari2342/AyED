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
