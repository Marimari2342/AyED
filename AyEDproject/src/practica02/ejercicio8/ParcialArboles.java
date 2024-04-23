package practica02.ejercicio8;

import practica02.ejercicio1y2.BinaryTree;

public class ParcialArboles {

    public ParcialArboles() {  
    }

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        if (arbol1.isEmpty() && arbol2.isEmpty()) // Los dos arboles están vacios --> son iguales
            return true;
        else
            return evaluar(arbol1, arbol2);
    }

    private boolean evaluar(BinaryTree<Integer> a1, BinaryTree<Integer> a2) {
        if (a1.getData() != a2.getData())
            return true;
        else {
            boolean aux = true;
            if (a1.hasLeftChild()) {
                if (a2.hasLeftChild())
                    aux = aux && evaluar(a1.getLeftChild(), a2.getLeftChild());
                else
                    return false;
            }
            if (a1.hasRightChild()) {
                if (a2.hasRightChild())
                    aux = aux && evaluar(a1.getRightChild(), a2.getRightChild());
                else
                    return false;
            }
            return aux;
        }
    }
}
