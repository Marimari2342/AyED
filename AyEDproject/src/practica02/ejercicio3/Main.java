package practica02.ejercicio3;

import java.util.LinkedList;
import practica02.ejercicio1y2.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(4);
        arbol.addLeftChild(new BinaryTree<>(2));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(1));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(3));
        arbol.addRightChild(new BinaryTree<>(6));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(5));

        arbol.imprimir();
        ContadorArbol miArbol = new ContadorArbol(arbol);

        // Punto3 a)
        LinkedList<Integer> listaInOr = new LinkedList<Integer>();
        listaInOr = miArbol.NumerosParesInOr();

        System.out.print("\n");
        System.out.print("Numeros pares InOrder: ");
        System.out.print(listaInOr);

        // Punto3 b)
        LinkedList<Integer> listaPostOr = new LinkedList<Integer>();
        listaPostOr = miArbol.NumerosParesInOr();

        System.out.print("\n");
        System.out.print("Numeros pares PostOrder: ");
        System.out.print(listaPostOr);
    }
}
