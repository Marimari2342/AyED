package tp5.ejercicio2;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.Edge;

public class Recorridos {
    // Retorna una lista con los datos de los vértices, con el recorrido en profundidad del grafo recibido como parámetro.
    public List<T> dfs(Graph<T> grafo){ //--> DFS (EN PROFUNDIDAD)

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
    
    // Retorna una lista con los datos de vértices, con el recorrido en amplitud del grafo recibido como parámetro.
    public List<T> bfs(Graph<T> grafo){ //--> BFS (EN NIVELES)
        boolean [] marca = new boolean[grafo.getSize()]; //1)aca anoto los vertices visitados
        List<T> listaDatos = new ArrayList<>(); //(PIDE EJERCICIO)creo la lista que voy a retornar
        for (int i=0; i<grafo.getSize();i++){ //2)recorro todos los vertices del grafo
            if (!marca[i]){ //si el vertice no fue visitado
                bfs(i, grafo, marca, listaDatos); //3)llamo a la funcion recursiva
            }
        }
        return listaDatos; //retorno la lista
    }

    private void bfs(int i, Graph<T> grafo, boolean[]marca, List<T> listaDatos){
        
        Queue<Vertex<T>> cola = new Queue<Vertex<T>>();//1)creo la cola
        cola.enqueue(grafo.getVertex(i)); //2)agrego el vertice a la cola
        marca[i] = true; //3)marco el vertice como visitado

        while (!cola.isEmpty()) { //4)mientras la cola no este vacia
            Vertex<T> vertice = cola.dequeue(); //5)desencolo el vertice
            listaDatos.add(vertice.getData()); //(PIDE EJERCICIO)agrego el dato del vertice a la lista
            List<Edge<T>> adyacentes = grafo.getEdges(vertice); //6)obtengo la lista de adyacentes
            for (Edge<T> e : adyacentes) { //7)recorro los adyacentes
                int j = e.getTarget().getPosition(); //obtengo la posicion del vertice adyacente
                if (!marca[j]){ //si no visite el vertice adyacente
                    cola.enqueue(e.getTarget()); //8)agrego el vertice adyacente a la cola
                    marca[j] = true; //9)marco el vertice adyacente como visitado
                }
            }
        }
    }
}

