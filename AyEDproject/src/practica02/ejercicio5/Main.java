package practica02.ejercicio5;

import practica02.ejercicio1y2.BinaryTree;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(4);
        arbol.addLeftChild(new BinaryTree<>(2));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(1));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(3));
        arbol.addRightChild(new BinaryTree<>(6));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(5));

        arbol.imprimir();
        System.out.println("");
        ProfundidadDeArbolBinario a = new ProfundidadDeArbolBinario(arbol);
        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese profundidad: ");
        int prof = s.nextInt();
        s.close();
        System.out.println("Suma de elementos a profundidad " + prof + ": " + a.sumaElementosProfundidad(prof));
    }

}
