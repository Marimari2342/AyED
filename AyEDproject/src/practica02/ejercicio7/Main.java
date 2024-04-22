package practica02.ejercicio7;

import practica02.ejercicio1y2.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(2);
        // Cargo el arbol ejemplo del ejercicio parcial
        arbol.addLeftChild(new BinaryTree<>(7));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(23));
        arbol.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(-3));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(6));
        arbol.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(55));
        arbol.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(11));
        arbol.addRightChild(new BinaryTree<>(-5));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(19));
        arbol.getRightChild().getLeftChild().addRightChild(new BinaryTree<>(4));
        arbol.getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(18));

        ParcialArboles arbolP = new ParcialArboles(arbol);
        System.out.println("Num 7: " + arbolP.isLeftTree(7));
        System.out.println("Num 2: " + arbolP.isLeftTree(2));
        System.out.println("Num -5: " + arbolP.isLeftTree(-5));
        System.out.println("Num 19: " + arbolP.isLeftTree(19));
        System.out.println("Num -3: " + arbolP.isLeftTree(-3));
    }
}
