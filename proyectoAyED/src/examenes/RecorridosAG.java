package examenes;

import java.util.List;
import java.util.Queue;

public class RecorridosAG {
    //Acá voy a agregar los recorridos en profundidad y por niveles para AG
    //ponele que quiero imprimir todos los datos del arbol
    //PREORDEN (Raiz - hijos)
    public void recorridoPreorden(GeneralTree <Integer> arbol){
        if (!arbol.isEmpty()){
            preorden(arbol);
        }
    }

    private void preorden(GeneralTree <Integer> arbol){
        //CONDICION DE CORTE
        if (arbol.isEmpty()){
            return;
        }
        //Primero la raiz
        System.out.println(arbol.getData());
        //Despues miro los hijos 
        List<GeneralTree<Integer>> children = arbol.getChildren();
        for (GeneralTree<Integer> child: children){
            preorden(child);
        }
    }

    //INORDEN (1erH - Raiz - demasH)
    public void recorridoInorden(GeneralTree <Integer> arbol){
        if (!arbol.isEmpty()){
            inorden(arbol);
        }
    }

    private void inorden(GeneralTree <Integer> arbol){
        //CONDICION DE CORTE
        if (arbol.isEmpty()){
            return;
        }
        //primero veo el primer hijo 
        List <GeneralTree<Integer>> children = arbol.getChildren();
        if (!children.isEmpty()){
            inorden(children.get(0));
        }
        //despues veo la raiz
        System.out.println(arbol.getData());
        //por ultimo el resto de los hijos
        for (int i=1; i<children.size();i++){
            inorden(children.get(i));
        }
    }

    //POSTORDEN (hijos - Raiz)
    public void recorridoPostorden(GeneralTree <Integer> arbol){
        if (!arbol.isEmpty()){
            postorden(arbol);
        }
    }

    private void postorden(GeneralTree <Integer> arbol){
        //CONDICION DE CORTE
        if (arbol.isEmpty()){
            return;
        }
        //Primero miro los hijos 
        List<GeneralTree<Integer>> children = arbol.getChildren();
        for (GeneralTree<Integer> child: children){
            postorden(child);
        }
        //despues la raiz
        System.out.println(arbol.getData());
    }

    //POR NIVELES
    public void porNiveles(GeneralTree<Integer> arbol){
        //CONDICION DE CORTE
        if (arbol.isEmpty()){
            return;
        }

        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
        
        queue.enqueue(arbol);    //encolo la raiz del arbol
        int nivelActual=0;

        //mientras la cola no este vacia
        while(!queue.isEmpty()){
            int cantNodos = queue.size();
            //Imprimir datos del nivel
            for (int i=0;i<cantNodos;i++){
                aux = queue.dequeue();   //desencolar
                System.out.print(aux.getData());
            
                //Encolar los hijos
                List <GeneralTree<Integer>> children = aux.getChildren();
                for (GeneralTree<Integer> child: children){
                    queue.enqueue(child);
                }
            }
        }
    }
}
