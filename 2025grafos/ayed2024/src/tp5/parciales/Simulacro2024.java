package tp5.parciales;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.Edge;

public class Simulacro2024 {
    //CIUDADES --> nodos 
    //RUTAS --> aristas que los conectan
    //creo clase Destino(ciudad y cantidad de dias de vacaciones)
    List<String> resolver(Graph<Destino> mapa, String ciudad, int cantDiasVacas){
        boolean[] marca = new boolean[mapa.getSize()];//(1)Marca
        List<String> destinos = new ArrayList<>();//(2)Lista de destinos a retornar
        List<String> destinosMax = new ArrayList<>(); //(2.1)Lista de destinos maximos
        if(!mapa.isEmpty()){ //(3)si el grafo no esta vacio --> busco la ciudad de inicio
            Vertex<Destino> inicio = buscarCiudad(ciudad, mapa);
            if(inicio!=null){ //(4)si la ciudad de inicio existe
                int cantDias = inicio.getData().getDias(); //acumulo los dias de vacaciones del destino inicial
                if (cantDias <= 15){ //si no me paso de los 15 dias
                    buscarDestinos(inicio,mapa,marca,destinos,destinosMax,cantDias);//llamada recursiva
                }
            }
        }
        return destinos;//(5)retorno la lista de destinos
    }

    private Vertex<Destino> buscarCiudad(String ciudad, Graph<Destino>mapa){
        List<Vertex<Destino>> vertices = mapa.getVertices();
        for(Vertex<Destino> v : vertices) {
            Destino destino = v.getData();
            if (destino.getCiudad().equals(ciudad)) {
                return v;
            }
        }
        return null; // Retorna null si no se encuentra la ciudad
    }

    private void buscarDestinos(Vertex<Destino>destinoActual,Graph<Destino>mapa,boolean[]marca,List<String>destinos,List<String>destinosMax, int cantDias){
        marca[destinoActual.getPosition()]=true; //(1)marco ciudad como visitada
        destinos.add(destinoActual.getData().getCiudad()); //(2)agrego la ciudad
        if(cantDias == 15){ //(3)si llevo acumulado 15 dias de vacaciones
            if(destinos.size() > destinosMax.size()){ //si la cantidad de destinos visitados es mayor a la maxima
                destinosMax.clear(); //(a)elimino los destinos anteriores
                destinosMax.addAll(destinos);//(b)agrego los destinos actuales
            }
        }
        else{
            for (Edge<Destino> ady: mapa.getEdges(destinoActual)) { //(4)recorro los destinos adyacentes
                Vertex <Destino> vecino = ady.getTarget(); //(a)obtengo destino
                int aux = vecino.getPosition(); //(b)obtengo la posicion del destino
                int cantidadDias = vecino.getData().getDias(); //(c)obtengo la cantidad de dias de vacaciones del destino
                if(!marca[aux] && (cantidadDias+cantDias<= 15)){ 
                    //si no lo visite y la cantidad de dias de vacaciones es menor o igual a 15
                    buscarDestinos(vecino,mapa,marca,destinos,destinosMax,cantDias+cantidadDias); //llamada recursiva
                }
            }
        }
        destinos.remove(destinos.size()-1); //quito el destino actual de la lista de destinos
        marca[destinoActual.getPosition()]=false; //desmarco el destino actual
    }
}
