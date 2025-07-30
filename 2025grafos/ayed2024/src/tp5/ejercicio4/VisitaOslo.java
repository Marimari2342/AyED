package tp5.ejercicio4;

/*Se quiere realizar un paseo en bicicleta por lugares emblemáticos de Oslo. Para 
esto se cuenta con un grafo de bicisendas. Partiendo desde el “Ayuntamiento” hasta 
un lugar destino en menos de X minutos, sin pasar por un conjunto de lugares que 
están restringidos.*/
//Recibo un grafo de lugares, un destino, un tiempo maximo y una lista de lugares restringidos.
//Parto del Ayuntamiento
import java.util.List;
import java.util.ArrayList;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.Edge;

public class VisitaOslo {
    public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
        boolean [] marca = new boolean[lugares.getSize()]; //Para marcar lugares visitados/restringidos
        //De no existir camino posible, se debe retornar una lista vacía.
        List<String> recorrido = new ArrayList<>(); //Lista con el recorrido a retornar
        if (!lugares.isEmpty()){
            //El “Ayuntamiento” debe ser buscado antes de comenzar el recorrido para encontrar un camino.
            Vertex<String> partidaV = lugares.search("Ayuntamiento");
            Vertex<String> destinoV = lugares.search(destino);
            if (partidaV!=null && destinoV!=null){
                marcarSitios(lugares, marca, lugaresRestringidos);
                recorridoBici(partidaV, destinoV, lugares, marca, recorrido, maxTiempo);
            }
        }
        return recorrido;
    }

    private void marcarSitios(Graph<String> lugares, boolean[] marca, List<String> restringidos){
        for (String lugar : restringidos){ //recorro la lista de lugares restringidos
            Vertex<String> v = this.lugares.search(lugar); //busco el lugar en el grafo
            if (v!=null){ //si el lugar esta en el grafo
                marca[v.getPosition()]=true; //marco el lugar como visitado, así no se podrá acceder a el
            }
        }
    }

    private boolean recorridoBici(Vertex<String> partida, Vertex<String> destino, Graph<String> lugares, boolean[] marca, List<String> recorrido, int tiempoRestante) {
        //Debe retornar el primer camino que encuentre que cumple las restricciones.
        boolean caminoEncontrado=false;
        marca[partida.getPosition()]=true; //Marcar el lugar de partida como visitado
        recorrido.add(partida.getData()); //Agregar el lugar de partida al recorrido
        //condicion de corte
        if(partida == destino){
            caminoEncontrado=true;
        }
        else{
            List <Edge<String>> adyacentes = lugares.getEdges(partida); //Obtener los adyacentes al lugar de partida
            for (Edge<String> ady : adyacentes){
                Vertex<String> v = ady.getTarget(); //Obtener el vértice destino de la arista
                int tiempo = ady.getWeight(); //Obtener el peso de la arista --> TIEMPO EN BICI
                if (!marca[v.getPosition()] && tiempo <= tiempoRestante){ //Si no está visitado y el peso es menor o igual al tiempo restante
                    caminoEncontrado=recorridoBici(v, destino, lugares, marca, recorrido, tiempoRestante - tiempo); //Llamada recursiva
                }
            }
        }
        if (!caminoEncontrado) { //Si no se encontró un camino
            recorrido.remove(recorrido.size() - 1); //Remover el último lugar del recorrido
        }
        marca[partida.getPosition()]=false; //Desmarcar el lugar de partida para futuras iteraciones
        return caminoEncontrado; //Retornar si se encontró un camino
    }
}
