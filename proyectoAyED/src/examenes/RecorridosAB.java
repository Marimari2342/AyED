package examenes;

import practica02.ejercicio1y2.BinaryTree;

public class RecorridosAB {
    //Acá voy a agregar los recorridos en profundidad y por niveles para AB
    //ponele que quiero imprimir un dato
    //PREORDEN (Raiz - hI - hD)
    public void recorridoPreorden(BinaryTree<Integer> arbol){
        if (!arbol.isEmpty()){
            preorden(arbol);
        }
    }

    private void preorden(BinaryTree<Integer> arbol){
        //CONDICION DE CORTE
        if(arbol.isEmpty()){
           return; 
        }
        //primero la raiz
        System.out.println(arbol.getData());
        //veo si tiene hI
        if (arbol.hasLeftChild()){
            preorden(arbol.getLeftChild());
        }
        //veo si tiene hD
        if (arbol.hasRightChild()){
            preorden(arbol.getRightChild());
        }
    }

    //INORDEN (hI - Raiz - hD)
    public void recorridoInorden(BinaryTree<Integer> arbol){
        if (!arbol.isEmpty()){
            inorden(arbol);
        }
    }

    private void inorden(BinaryTree<Integer> arbol){
        //CONDICION DE CORTE
        if(arbol.isEmpty()){
           return; 
        }
        //primero veo si tiene hI
        if (arbol.hasLeftChild()){
            inorden(arbol.getLeftChild());
        }
        //despues veo la raiz
        System.out.println(arbol.getData());
        //despues veo si tiene hD
        if (arbol.hasRightChild()){
            inorden(arbol.getRightChild());
        }
    }

    //POSTORDEN (hI - hD - Raiz)
    public void recorridoPostorden(BinaryTree<Integer> arbol){
        if (!arbol.isEmpty()){
            postorden(arbol);
        }
    }

    private void postorden(BinaryTree<Integer> arbol){
        //CONDICION DE CORTE
        if(arbol.isEmpty()){
           return; 
        }
        //primero veo si tiene hI
        if (arbol.hasLeftChild()){
            postorden(arbol.getLeftChild());
        }
        //despues veo si tiene hD
        if (arbol.hasRightChild()){
            postorden(arbol.getRightChild());
        }
        //despues veo la raiz
        System.out.println(arbol.getData());
    }

    //POR NIVELES
    public void recorridoNiveles(BinaryTree<Integer> arbol){
        //arbol vacio
        if (arbol.isEmpty()){
            return;
        }
        //creo la cola, meto el arbol, inicio nivel
        Queue <BinaryTree<Integer> cola = new LinkedList();
        cola.add(arbol);
        int nivelActual = 0;

        //mientras la cola no este vacía hago
        while (!cola.isEmpty()){
            int cantNodos = cola.size();
            for (int i=0; i<cantNodos;i++){ //evaluo los nodos de la cola
                BinaryTree<Integer> nodo = cola.remove(); //remuevo nodo de la cola 
                System.out.println(nodo.getData() + " "); //imprimo el dato 
                //meto los hijos del nodo en la cola (será el nivel siguiente)
                if (nodo.hasLeftChild()){
                    cola.add(nodo.getLeftChild());
                }
                if (nodo.hasRightChild()){
                    cola.add(nodo.getRightChild());
                }
            }
            nivelActual++;
        }
    }
}
