package practica02.ejercicio3;

import java.util.LinkedList;
import java.util.Queue;

import practica02.ejercicio1y2.BinaryTree;

public class ContadorArbol {

    private BinaryTree <Integer> arbol; 
    
    public ContadorArbol(BinaryTree <Integer> unArbol){
        arbol=unArbol;
    }
    //EN PROCESO
    public LinkedList NumerosParesInOrder(BinaryTree<Integer>arbol){
        Queue<BinaryTree<Integer>> lista = new LinkedList<>();
        lista.add(arbol);
        
        return lista;
    }


}
