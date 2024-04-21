package practica02.ejercicio6;
import practica02.ejercicio1y2.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(4);
        arbol.addLeftChild(new BinaryTree<>(2));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(1));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(3));
        arbol.addRightChild(new BinaryTree<>(6));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(5));

        System.out.print("Arbol sin transformar: ");
        arbol.imprimir();
        System.out.println("");
        Transformacion arbT = new Transformacion(arbol);
        arbT.Suma();
        System.out.print("Arbol transformado: ");
        arbT.getArbolT().imprimir();
    }
}
