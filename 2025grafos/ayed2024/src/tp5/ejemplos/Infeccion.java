/*EJEMPLO DE PARCIAL --> Tiempo de infección de una red
Un poderoso e inteligente virus de computadora infecta cualquier computadora en 1 
minuto, logrando infectar toda la red de una empresa con cientos de computadoras.
Dado un grafo que representa las conexiones entre las computadoras de la empresa, 
y una computadora ya infectada, escriba un programa en Java que permita determinar
el tiempo que demora el virus en infectar el resto de las computadoras Asuma que 
todas las computadoras pueden ser infectadas, no todas las computadoras tienen 
conexión directa entre sí, y un mismo virus puede infectar un grupo de computadoras
al mismo tiempo sin importar la cantidad.*/
// BFS (AMPLITUD)--> puede infectar un grupo de computadoras al mismo tiempo (ADYACENTES)
package tp5.ejemplos;

import java.util.Queue;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.Edge;

public class Infeccion {
    public static int tiempoInfeccion(Graph<String>grafo, Vertex<String>inicial){
        int tiempo = 0;//inicializo el tiempo de infección
        boolean [] marca = new boolean[grafo.getSize()]; //marco los vertices visitados
        Queue<Vertex<String>> cola = new Queue<Vertex<String>>(); //creo la cola
        cola.enqueue(inicial); //agrego el vertice inicial a la cola
        cola.enqueue(null); //agrego un null para marcar el final de un nivel
        marca[inicial.getPosition()] = true; //marco el vertice inicial como visitado
        while (!cola.isEmpty()){ //mientras la cola no este vacia --> encolo
            Vertex<String> vertice = cola.dequeue(); //desencolo el vertice
            if (vertice != null){ //si el vertice no es null --> todavia tengo adyacentes que se pueden contagiar en el mismo minuto
                List <Edge<String>> adyacentes = grafo.getEdges(vertice); //obtengo la lista de adyacentes
                for (Edge<String> ady: adyacentes){ //recorro los adyacentes
                    Vertex<String> destino = ady.getTarget(); //obtengo el vertice adyacente
                    if (!marca[destino.getPosition()]){ //si no visite el vertice adyacente
                        marca[destino.getPosition()] = true; //marco el vertice adyacente como visitado
                        cola.enqueue(destino); //agrego el vertice adyacente a la cola
                    }
                }
            }
            else if (!cola.isEmpty()){ //cuando se me acabaron los adyacentes de un nivel sumo un minuto de tiempo
                tiempo++;
                cola.enqueue(null); //agrego un null para marcar el final de un nivel
            }
        }
        return tiempo; //retorno el tiempo de infección
    }


    
}
