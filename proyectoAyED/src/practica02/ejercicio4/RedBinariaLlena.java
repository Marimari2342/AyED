package practica02.ejercicio4;

import practica02.ejercicio1y2.BinaryTree;

public class RedBinariaLlena {

    private BinaryTree<Integer> arbol;

    public RedBinariaLlena(BinaryTree<Integer> unArbol) {
        this.arbol = unArbol;
    }

    public int retardoReenvio() {
        int retardo = 0; //inicializo
        if (!arbol.isEmpty()) //veo que el arbol no este vacio
            retardo = calcularRetardo(arbol); //metodo recursivo
        return retardo;
    }

    private int calcularRetardo(BinaryTree<Integer> arbol) {
        int retL = 0;
        int retR = 0;
        /*llamamos recursivamente a sus hijos izquierdo y 
        derecho para obtener el mayor retardo de esos caminos*/
        if (arbol.hasLeftChild())
            retL = calcularRetardo(arbol.getLeftChild());
        if (arbol.hasRightChild())
            retR = calcularRetardo(arbol.getRightChild());
        /*obtenemos el mayor retardo, sumamos el retardo del 
        nodo actual y devolvemos el valor acumulado */
        return (Math.max(retL, retR)) + arbol.getData();
    }
}
