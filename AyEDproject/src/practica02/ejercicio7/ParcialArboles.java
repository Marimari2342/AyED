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

    public boolean isLeftTree (int num){
        BinaryTree <Integer> arbolRaiz = Buscar(arbol, num); //Busco el arbol con raiz=num
        
        return true; //luego evaluo lo que pide el ejercicio (metodo evaluar)
    }
}
