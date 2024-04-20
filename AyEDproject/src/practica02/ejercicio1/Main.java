package practica02.ejercicio1;

public class Main {
    public static void main(String[]args){  
        BinaryTree arbol = new BinaryTree<>(4);
        arbol.addLeftChild(new BinaryTree<>(2));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(1));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(3));
        arbol.addRightChild(new BinaryTree<>(6));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(5));
        
        System.out.println("Contar hojas: "+arbol.contarHojas());

        
    }
}
