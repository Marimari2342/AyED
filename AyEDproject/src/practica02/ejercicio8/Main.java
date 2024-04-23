package practica02.ejercicio8;

import practica02.ejercicio1y2.BinaryTree;

public class Main {
    public static void main(String[] args) {
        ParcialArboles pref = new ParcialArboles();
        BinaryTree<Integer> a1 = new BinaryTree<Integer>();
        BinaryTree<Integer> a2 = new BinaryTree<Integer>();
        BinaryTree<Integer> a3 = new BinaryTree<Integer>();

        a1.addLeftChild(new BinaryTree<>(7));
        a1.getLeftChild().addLeftChild(new BinaryTree<>(23));
        a1.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(-3));
        a1.getLeftChild().addRightChild(new BinaryTree<>(6));

        a2.addLeftChild(new BinaryTree<>(7));
        a2.getLeftChild().addLeftChild(new BinaryTree<>(23));
        a2.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(-3));
        a2.getLeftChild().addRightChild(new BinaryTree<>(6));
        a2.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(55));
        a2.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(11));
        a2.addRightChild(new BinaryTree<>(-5));

        a3.addLeftChild(new BinaryTree<>(7));
        a3.getLeftChild().addLeftChild(new BinaryTree<>(22));
        a3.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(7));
        a3.getLeftChild().addRightChild(new BinaryTree<>(55));

        System.out.println("arbol1 es prefijo de arbol2: " + pref.esPrefijo(a1, a2));
        System.out.println("arbol1 es prefijo de arbol3: " + pref.esPrefijo(a1, a3));

    }
}
