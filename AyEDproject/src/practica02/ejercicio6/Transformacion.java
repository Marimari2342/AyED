package practica02.ejercicio6;

import practica02.ejercicio1y2.BinaryTree;

public class Transformacion {

    private BinaryTree<Integer> arbol;

    public Transformacion(BinaryTree<Integer> unArbol) {
        arbol = unArbol;
    }

    public BinaryTree<Integer> Suma() {
        if(!this.arbol.isEmpty())
            CalcularSuma(arbol);
        return arbol;
    }

    private int CalcularSuma(BinaryTree<Integer>arbol){
        int suma=0;
        if (arbol.isLeaf()){        //Si es una hoja guardo un 0
            suma=arbol.getData();
            arbol.setData(0);
            return suma;
        }                           //Sino calculo suma de hijos derechos e izquierdos
        if (arbol.hasLeftChild())
            suma += CalcularSuma(arbol.getLeftChild());
        if (arbol.hasRightChild())
            suma += CalcularSuma(arbol.getRightChild());
        int aux = arbol.getData();
        arbol.setData(suma);
        return aux+suma;
    }

    //Así llamo al arbol transformado para imprimir resultado
    public BinaryTree<Integer> getArbolT() {
        return arbol;
    }

}
