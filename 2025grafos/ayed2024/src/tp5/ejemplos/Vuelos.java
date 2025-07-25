package tp5.ejemplos;

import tp5.ejercicio1.Graph;
import java.util.LinkedList;
import java.util.List;
/*Dado un Grafo orientado y valorado positivamente, implemente un método que 
retorne una lista con todos los caminos cuyo costo total sea igual a 10 Se 
considera costo total del camino a la suma de los costos de las aristas que forman
parte del camino, desde un vértice origen a un vértice destino Se recomienda 
implementar un método público que invoque a un método recursivo privado */
public class Vuelos {
    public LinkedList<LinkedList<String>> dfsConCosto(Graph<T> grafo){
        //1) anoto los vertices visitados
        boolean[] marca = new boolean[grafo.getSize()]; 
        //2) (PIDE EL EJERCICIO) creo la lista que voy a retornar)
        LinkedList<LinkedList<String>> recorridos = new LinkedList<>();
        LinkedList<String> camino = null;
        //3) (PIDE EL EJERCICIO)inicializo el costo en 0.
        int costo=0;
        //4) recorro todos los vertices del grafo 
        for (int i=0; i<grafo.getSize(); i++){
            camino = new LinkedList<>(); //5) creo un nuevo camino
            camino.add(grafo.getVertex(i).getData().toString()); //6) agrego el dato del vertice al camino
            marca[i] = true; //7) marco el vertice como visitado
            dfsConCosto(i, grafo, marca, costo, camino, recorridos); //llamo a la funcion recursiva
            marca[i] = false; //8) desmarco el vertice para que pueda ser visitado en otro camino
        } 
        return recorridos; //9) retorno la lista de recorridos
    }

    private void dfsConCosto(int i, Graph<T> grafo, boolean[]marca, int costo, LinkedList<String> camino, LinkedList<LinkedList<String>>recorridos){
        Vertex<T> verticeDestino = null; //vertice destino
        Vertex<T> vertice = grafo.getVertex(i); //obtengo el vertice origen
        int peso =0; //inicializo el peso
        int j=0; //posicion del vertice adyacente
        List<Edge<T>> adyacentes = grafo.getEdges(vertice); //obtengo la lista de adyacentes
        for (Edge<T> ady: adyacentes) { //recorro lista de adyacentes
            j=ady.getTarget().getPosition(); //obtengo la posicion del vertice adyacente
            if(!marca[j]){ //si no visite el vertice  
                peso=ady.getWeight(); //obtengo el peso de la arista
                if ((costo+peso)<=10){ //si el costo total no supera 10
                    verticeDestino = ady.getTarget(); //obtengo el vertice destino
                    camino.add(verticeDestino.getData().toString()); //agrego el vertice destino al camino
                    marca[j]=true; //marco el vertice adyacente como visitado
                    if((costo+peso)==10){
                        recorridos.add(new LinkedList<>(camino)); //si el costo es 10, agrego el camino a la lista de recorridos
                    }
                    else {
                        dfsConCosto(j, grafo, marca, costo+peso, camino, recorridos); //si no, llamo a la funcion recursiva
                    }
                    camino.remove(verticeDestino.getData().toString()); //elimino el vertice del camino
                    marca[j] = false; //desmarco el vertice adyacente
                }
            }
        }
    }
}
