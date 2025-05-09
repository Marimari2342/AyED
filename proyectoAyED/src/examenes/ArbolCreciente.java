package examenes;

import java.util.LinkedList;
import practica02.ejercicio1y2.BinaryTree;

public class ArbolCreciente {
    //devuelve true si el arbol es creciente o false si no lo es 
    public Boolean esArbolCreciente(BinaryTree<Integer> arbol){
        if(arbol.isEmpty()){ // Hay que aclarar tambien si es null?
            return false;
        }
        //Inicio la cola, agrego el arbol a la cola y nivel 0
        Queue <BinaryTree<Integer>> cola = new LinkedList<>();
        cola.add(arbol);
        int nivelActual=0;

        while (!cola.isEmpty()){    //mientras la cola no este vacia
            int cantNodos = cola.size();
            //Comparo si cantNodos > nivelActual+1 (--> true)
            if (cantNodos < nivelActual+1){
                return false; //no es creciente
            }
            //proceso los nodos y encolo a los hijos
            for(int i=0; i < cantNodos; i++) {
                BinaryTree<Integer> nodo = cola.remove();
                if(nodo.hasLeftChild()) cola.add(nodo.getLeftChild());
                if(nodo.hasRightChild()) cola.add(nodo.getRightChild());
            }
            nivelActual++;
        }
        return true; //si recorri todo sin entrar al false es porque es creciente
    }
}
