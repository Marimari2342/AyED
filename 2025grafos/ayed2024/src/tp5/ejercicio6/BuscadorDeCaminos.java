package tp5.ejercicio6;
/*Un día, Caperucita Roja decide ir desde su casa hasta la de su abuelita, 
recolectando frutos del bosque del camino y tratando de hacer el paseo de la 
manera más segura posible. La casa de Caperucita está en un claro del extremo 
oeste del bosque, la casa de su abuelita en un claro del extremo este, y dentro 
del bosque entre ambas hay algunos otros claros.
El bosque está representado por un grafo, donde los vértices representan los claros 
(identificados por un String) y las aristas los senderos que los unen. Cada arista
informa la cantidad de árboles frutales que hay en elsendero. Caperucita sabe que
el lobo es muy goloso y le gustan mucho las frutas, entonces para no ser capturada 
por el lobo, desea encontrar todos los caminos que no pasen por los senderos con 
cantidad de frutales >= 5 y lleguen a la casa de la abuelita.
Su tarea es definir una clase llamada BuscadorDeCaminos, con una variable de
instancia llamada "bosque" de tipo Graph, que representa el bosque descrito e 
implementar un método que devuelva un listado con TODOS los caminos que cumplen 
con las condiciones mencionadas anteriormente. 
Nota: La casa de Caperucita debe ser buscada antes de comenzar a buscar el camino.*/
// Recorrido DFS
// variable de instancia bosque de tipo Graph<String>
// Grafos con aristas con peso --> tengo que tomar caminos con peso < 5
// TODOS LOS CAMINOS --> Retorno una lista de listas de String, cada lista es un camino
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.Edge;
import java.util.ArrayList;
import java.util.List;

public class BuscadorDeCaminos {
    //variable de instancia
    private Graph<String> bosque;

    public List <List<String>> recorridosMasSeguro(){
        boolean [] marca = new boolean[bosque.getSize()]; //para marcar los claros visitados
        List<List<String>> caminosSeguros = new ArrayList<>();
        // Lógica para encontrar todos los caminos seguros
        if (!bosque.isEmpty()) {
            Vertex<String> casaCaperucita = bosque.search("Casa Caperucita"); //busco la casa de Caperucita
            Vertex<String> casaAbuelita = bosque.search("Casa Abuelita"); //busco la casa de la abuelita
            if (casaCaperucita!=null && casaAbuelita!=null){
                buscarCaminosSeguros(casaCaperucita, casaAbuelita, marca, new ArrayList<>(), caminosSeguros);
            }
        }
        return caminosSeguros;
    }

    private void buscarCaminosSeguros(Vertex<String> actual, Vertex<String> casaAbuelita, boolean[] marca, List<String> caminoActual, List<List<String>> caminosSeguros) {
        marca[actual.getPosition()] = true; //marco el claro actual como visitado
        caminoActual.add(actual.getData()); //agrego el claro actual al camino
        //condicion de parada: si llego a la casa de la abuelita
        if (actual.getData().equals(casaAbuelita.getData())) {
            caminosSeguros.add(new ArrayList<>(caminoActual)); //agrego el camino actual a la lista de caminos seguros
            //tambien puedo hacer if (actual == casaAbuelita) pero es mejor usar equals
        } else {
            //recorro los adyacentes del claro actual
            List <Edge<String>> adyacentes = this.bosque.getEdges(actual);
            for (Edge<String> ady : adyacentes) {
                Vertex<String> vecino = ady.getTarget(); //obtengo el claro vecino
                if (!marca[vecino.getPosition()] && ady.getWeight() < 5) { //si no lo visite y el peso de la arista es menor a 5
                    buscarCaminosSeguros(vecino, casaAbuelita, marca, caminoActual, caminosSeguros); //llamada recursiva
                }
            }
        }
        //desmarco el claro actual y lo quito del camino actual para retroceder
        marca[actual.getPosition()] = false; //desmarco el claro actual
        caminoActual.remove(caminoActual.size() - 1); //quito el claro actual del camino
    }
}
