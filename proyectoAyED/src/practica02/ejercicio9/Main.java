package practica02.ejercicio9;

import practica02.ejercicio1y2.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> a = new BinaryTree<Integer>(5);
        a.addLeftChild(new BinaryTree<>(7));
        a.getLeftChild().addLeftChild(new BinaryTree<>(23));
        a.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(-3));
        a.getLeftChild().addRightChild(new BinaryTree<>(6));

        a.imprimir();

        ParcialArboles p = new ParcialArboles();
        p.sumAndDif(a).entreNiveles(0, 3);
    }
}
