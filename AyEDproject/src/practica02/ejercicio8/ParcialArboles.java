package practica02.ejercicio8;

import practica02.ejercicio1y2.BinaryTree;

public class ParcialArboles {

    private BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> unArbol) {
        arbol = unArbol;
    }

    // EN PROCESO
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
        }
    }

}
