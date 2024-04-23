package practica02.ejercicio8;

import practica02.ejercicio1y2.BinaryTree;

public class Main {
    public static void main(String[] args) {
        ParcialArboles pref = new ParcialArboles();
        BinaryTree<Integer> a1 = new BinaryTree<Integer>();
        BinaryTree<Integer> a2 = new BinaryTree<Integer>();
        BinaryTree<Integer> a3 = new BinaryTree<Integer>();


        
        System.out.println("arbol1 es prefijo de arbol2: " + pref.esPrefijo(a1, a2));
        System.out.println("arbol1 es prefijo de arbol3: " + pref.esPrefijo(a1, a3));

    }
}
