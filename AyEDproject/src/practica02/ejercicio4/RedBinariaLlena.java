package practica02.ejercicio4;

import practica02.ejercicio1y2.BinaryTree;

public class RedBinariaLlena {

    private BinaryTree<Integer> arbol;

    public RedBinariaLlena(BinaryTree<Integer> unArbol) {
        this.arbol = unArbol;
    }

    public int retardoReenvio() {
        int retardo = 0;
        if (!arbol.isEmpty())
            retardo = calcularRetardo(arbol);
        return retardo;
    }

    private int calcularRetardo(BinaryTree<Integer> arbol) {
        int retL = 0;
        int retR = 0;
        if (arbol.hasLeftChild())
            retL = calcularRetardo(arbol.getLeftChild());
        if (arbol.hasRightChild())
            retR = calcularRetardo(arbol.getRightChild());
        return (Math.max(retL, retR)) + arbol.getData();
    }
}
