package practica02.ejercicio4;
import practica02.ejercicio1y2.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(10);
        arbol.addLeftChild(new BinaryTree<>(2));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(5));
        arbol.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(7));
        arbol.getLeftChild().getLeftChild().addRightChild(new BinaryTree<>(8));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(4));
        arbol.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(5));
        arbol.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(6));
        arbol.addRightChild(new BinaryTree<>(3));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(9));
        arbol.getRightChild().getLeftChild().addLeftChild(new BinaryTree<>(12));
        arbol.getRightChild().getLeftChild().addRightChild(new BinaryTree<>(8));
        arbol.getRightChild().addRightChild(new BinaryTree<>(8));
        arbol.getRightChild().getRightChild().addLeftChild(new BinaryTree<>(2));
        arbol.getRightChild().getRightChild().addRightChild(new BinaryTree<>(1));

        RedBinariaLlena aLleno = new RedBinariaLlena(arbol);
        System.out.println("El retardo máximo de envio es: "+aLleno.retardoReenvio());
    }
}
