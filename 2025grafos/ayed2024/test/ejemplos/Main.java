package tp5.ejemplos;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.Edge;
import java.util.LinkedList;
import java.util.List;
import tp5.ejemplos.Vuelos;
import tp5.ejercicio1.adjList.AdjListGraph;;

public class Main {

    public static void main(String[] args) {
        Graph<String> ciudades = new AdjListGraph<>();
        Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
        Vertex<String> v2 = ciudades.createVertex("Santiago");
        Vertex<String> v3 = ciudades.createVertex("Asunción");
        Vertex<String> v4 = ciudades.createVertex("Caracas");
        Vertex<String> v5 = ciudades.createVertex("Madrid");
        ciudades.connect(v1, v2, 3);
        ciudades.connect(v1, v3, 6);
        ciudades.connect(v2, v4, 4);
        Vuelos vuelos = new Vuelos();
        LinkedList<LinkedList<String>> lista = vuelos.dfsConCosto(ciudades);
        for (LinkedList<String> e : lista) {
            System.out.println(e);
        }
    }
}
