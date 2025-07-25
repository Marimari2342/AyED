package tp5.ejercicio2;

import java.util.List;
import java.util.ArrayList;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.Edge;

public class Recorridos {
    // Retorna una lista con los datos de los vértices, con el recorrido en profundidad del grafo recibido como parámetro.
    public List<T> dfs(Graph<T> grafo){

        boolean [] marca = new boolean[grafo.getSize()]; //aca anoto los vertices visitados
        List<T> listaDatos = new ArrayList<>(); //(PIDE EJERCICIO)creo la lista que voy a retornar
        for (int i=0; i<grafo.getSize(); i++){ //recorro todos los vertices del grafo
            if (!marca[i]){ //si el vertice no fue visitado
                dfs(i, grafo, marca, listaDatos); //llamo a la funcion recursiva
            }
        }
        return listaDatos; //retorno la lista 
    }

    private void dfs(int i, Graph<T> grafo, boolean[]marca, List<T>lista){
        marca[i]=true; //marco el vertice como visitado
        Vertex<T> vertice = grafo.getVertex(i); //obtengo el vertice
        lista.add(vertice.getData()); //(PIDE EJERCICIO)agrego el dato del vertice a la lista
        List <Edge<T>> adyacentes = grafo.getEdges(vertice); //obtengo la lista de adyacentes  
        for (Edge<T> ady: adyacentes) {
            int j= e.getTarget().getPosition(); //obtengo la posicion del vertice adyacente
            if (!marca[j]){ //si no visite el vertice adyacente
                dfs(j, grafo, marca, lista); //llamo a la funcion recursiva 
            }
        }
    }
    
    //bfs(Graph<T> grafo): List<T>
    // Retorna una lista con los datos de vértices, con el recorrido en amplitud del grafo recibido como parámetro.
}

