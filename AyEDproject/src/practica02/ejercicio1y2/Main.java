package practica02.ejercicio1y2;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(4);
        arbol.addLeftChild(new BinaryTree<>(2));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(1));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(3));
        arbol.addRightChild(new BinaryTree<>(6));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(5));

        arbol.imprimir();
        System.out.println("Contar hojas: " + arbol.contarHojas());
        BinaryTree<Integer> arbEsp = new BinaryTree<Integer>(0);
        arbEsp = arbol.espejo();
        arbEsp.imprimir();
        arbol.entreNiveles(0, 1);
    }
}
