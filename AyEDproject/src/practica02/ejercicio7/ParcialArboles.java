//EN PROCESO
package practica02.ejercicio7;

import practica02.ejercicio1y2.BinaryTree;

public class ParcialArboles {

    private BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> unArbol) {
        arbol = unArbol;
    }

    private BinaryTree<Integer> Buscar(BinaryTree<Integer> arbol, int num){
        if (num == arbol.getData())
            return arbol;
        else{
            BinaryTree <Integer> aux = new BinaryTree<Integer>();
            if(arbol.hasLeftChild())
                aux = Buscar(arbol.getLeftChild(), num);
            if(arbol.hasRightChild()&&aux.isEmpty())
                aux = Buscar(arbol.getRightChild(), num);
            return aux;
        }
    }

    private boolean Evaluar(BinaryTree<Integer> arbol){
        int izq = -1;
        int der = -1;
        if (arbol.hasLeftChild())
            izq = Contar(arbol.getLeftChild());
        if (arbol.hasRightChild())
            der = Contar(arbol.getRightChild());
        return izq > der;
    }

    private int Contar(BinaryTree<Integer> arbol){
        int cant=0;
        if (arbol.hasLeftChild())
            cant += Contar(arbol.getLeftChild());
        if (arbol.hasRightChild())
            cant += Contar(arbol.getRightChild());
        //Si tengo un unico hijo
        if ((!arbol.hasLeftChild()&&arbol.hasRightChild())||(arbol.hasLeftChild()&&!arbol.hasRightChild()))
            cant+=1;
        return cant;
    }

    public boolean isLeftTree (int num){
        BinaryTree <Integer> arbolRaiz = Buscar(arbol, num); //Busco el arbol con raiz=num
        if (!arbolRaiz.isEmpty() && Evaluar(arbolRaiz))
            return true; 
        else 
            return false;
    }
}
