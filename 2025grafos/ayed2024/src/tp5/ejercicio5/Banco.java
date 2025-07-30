package tp5.ejercicio5;
/*El Banco Itaú se suma a las campañas "QUEDATE EN CASA" lanzando un programa para 
acercar el sueldo a los jubilados hasta sus domicilios. Para ello el banco cuenta 
con información que permite definir un grafo de personas donde la persona puede ser 
un jubilado o un empleado del banco que llevará el dinero. Se necesita armar la 
cartera de jubilados para cada empleado repartidor del banco, incluyendo en cada 
lista, los jubilados que vivan un radio cercano a su casa y no hayan percibido la 
jubilación del mes. Para ello, implemente un algoritmo que dado un Grafo<Persona> 
retorne una lista de jubilados que se encuentren a una distancia menor a un valor 
dado del empleado Itaú (grado de separación del empleado Itaú). El método recibirá 
un Grafo<Persona>, un empleado y un grado de separación/distancia y debe retornar 
una lista de hasta 40 jubilados que no hayan percibido la jubilación del mes y se 
encuentren a una distancia menor a la recibida como parámetro. */
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Banco {
    
    public List<Persona> jubiladosCercanos(Graph<Persona>personas, Persona empleado, int distancia){
        //(1)MARCA
        boolean[]marca=new boolean[personas.getSize()];
        //(2)LISTA RETORNO
        List<Persona> jubiladosCercanos=new ArrayList<>();
        //(3)VERIFICO SI EL GRAFO NO ESTA VACIO
        if(!personas.isEmpty()){
            //(4)busco el empleado en el grafo
            Vertex<Persona> empleadoV = buscarEmpleado(empleado.getNombre(), personas);
            if(empleadoV!=null){ //si encontre al empleado
                //creo la cola para BFS
                Queue<Vertex<Persona>> cola = new Queue<>();
                marca[empleadoV.getPosition()]=true; //marco el empleado como visitado
                cola.enqueue(empleadoV); //agrego el empleado a la cola
                cola.enqueue(null); //agrego un null para marcar el final de un nivel
                //ahora busco (bfs) los jubilados que 
                //1. percibieron la jubilacion
                //2. estan a una distancia menor a la recibida como parametro
                while (!cola.isEmpty() && distancia>0 &&jubiladosCercanos.size() < 40) { //mientras la cola no este vacia, no me halla salido del nivel de amplitud pedido y no llegue a 40 jubilados
                    Vertex <Persona> p = cola.dequeue(); //desencolo el vertice
                    if (p!=null){ //si el vertice no es null
                        List<Edge<Persona>> adys = personas.getEdges(v);
                        Iterator <Edge<Persona>> it = adys.iterator();
                        while(it.hasNext() && jubiladosCercanos.size() < 40) { //recorro los adyacentes
                            Vertex<Persona> aux = it.next().getTarget(); //obtengo el vertice destino
                            int posDestino = aux.getPosition(); //obtengo la posicion del vertice destino
                            if(!marca[posDestino]) {
                                marca[posDestino] = true;
                                cola.enqueue(aux);
                                if(aux.getData().cumple()) {
                                    jubiladosCercanos.add(new Persona(aux.getData().getNombre(), aux.getData().getDomicilio(), aux.getData().getTipo()));
                                }
                            }
                        }
                    } 
                    else if (!cola.isEmpty()) {
                        distancia--;
                        cola.enqueue(null);
                    }
                }
            }
        }
        return jubiladosCercanos; //retorno la lista de jubilados cercanos
    }
    
    private Vertex<Persona> buscarEmpleado(String empleado, Graph<Persona>personas){
        List<Vertex<Persona>> vertices = personas.getVertices();
        for(Vertex<Persona> v : vertices) {
            Persona persona = v.getData();
            if (persona.getNombre().equals(empleado)) {
                return v;
            }
        }
        return null; // Retorna null si no se encuentra el empleado
    }

}