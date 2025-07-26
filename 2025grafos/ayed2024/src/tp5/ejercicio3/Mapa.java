package tp5.ejercicio3;

import java.util.ArrayList;
import java.util.List;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;


public class Mapa {
    //variable de instacia
    private Graph<String> mapaCiudades;

    //constructor
    public Mapa(Graph <String>grafo) {
        this.mapaCiudades = grafo;
    }
    //metodos pedidos
    /*(1)Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a 
    ciudad2 en caso de que se pueda llegar, si no retorna la lista vacía. (Sin 
    tener en cuenta el combustible).*/
    //Hago un DFS para encontrar el camino
    public List<String> devolverCamino(String ciudad1, String ciudad2) {
        boolean marca[]=new boolean[mapaCiudades.getSize()]; //vector para marcar vertices visitados
        List<String>camino=new ArrayList<>(); //Lista que voy a retornar
        if (!this.mapaCiudades.isEmpty()) { //si el grafo no esta vacio 
            Vertex<String> ciudadInicio = mapaCiudades.search(ciudad1); //busco la ciudad de inicio
            Vertex<String> ciudadDestino = mapaCiudades.search(ciudad2); //busco la ciudad de destino
            if (ciudadInicio!=null && ciudadDestino!=null) { //si las ciudades existen
                boolean encontre=dfs(ciudadInicio, ciudadDestino, marca, camino); // llamo a la funcion dfs
                if (encontre){
                    return camino; //si encontre un camino, retorno la lista
                }
            }
        }
        return camino; //si no hay camino, no entra al if, retorno lista vacia
    }

    private boolean dfs (Vertex<String> cI, Vertex<String> cD, boolean []marca, List<String>camino){
        boolean encontre = false; //variable para saber si encontre el camino
        marca[cI.getPosition()] =true; //marco la ciudad de inicio como visitada
        camino.add(cI.getData()); //agrego el nombre de la ciudad a la lista camino
        //Condicion de corte
        if (cI == cD){ //si llegue a la ciudad de destino
            return true; //retorno
        }
        else{
            List<Edge<String>> adyacentes = mapaCiudades.getEdges(cI); //obtengo adyacentes de ciudad de inicio
            for (Edge<String> ady: adyacentes) { //recorro los adyacentes
                Vertex<String> ciudadAdyacente = ady.getTarget(); //obtengo la ciudad adyacente
                if (!marca[ciudadAdyacente.getPosition()]){ //si no visite la ciudad adyacente
                    encontre = dfs(ciudadAdyacente, cD, marca, camino); //llamo a la funcion recursiva
                    if (encontre) return true; // si encontré, corto
                }
            }
        }
        if(!encontre) {
            camino.remove(camino.size()-1); //Si no encontré un camino hacia el destino desde este vértice (origen), deshago la última ciudad agregada al camino.
        }
        marca[cI.getPosition()] = false; //Desmarco la ciudad de inicio antes de retornar
        return encontre;
    }

    /*(2)Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, 
    sin pasar por las ciudades que están contenidas en la lista, si no existe camino
    retorna la lista vacía. (Sin tener en cuenta el combustible). */
    //Mejor solucion --> metodo que marque a las ciudades que no quiero visitar
    //y luego llame al metodo dfs
    public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
        boolean marca[]=new boolean[mapaCiudades.getSize()]; //vector para marcar vertices visitados
        List<String>camino=new ArrayList<>(); //Lista que voy a retornar
        if (!this.mapaCiudades.isEmpty()) { //si el grafo no esta vacio 
            Vertex<String> ciudadInicio = mapaCiudades.search(ciudad1); //busco la ciudad de inicio
            Vertex<String> ciudadDestino = mapaCiudades.search(ciudad2); //busco la ciudad de destino
            if (ciudadInicio!=null && ciudadDestino!=null) { //si las ciudades existen
                marcarCiudades(ciudades, marca);//llamo metodo para marcar las ciudades de la lista a las que no quiero visitar
                boolean encontre=dfs(ciudadInicio, ciudadDestino, marca, camino); // llamo a la funcion dfs
                if (encontre){
                    return camino; //si encontre un camino, retorno la lista
                }
            }
        }
        return camino;
    }

    private void marcarCiudades(List<String>ciudades, boolean []marca){
        for (String ciudad : ciudades){ //recorro la lista de ciudades
            Vertex<String> v = this.mapaCiudades.search(ciudad); //busco la ciudad en el grafo
            if (v!=null){ //si la ciudad esta en el grafo
                marca[v.getPosition()]=true; //marco la ciudad como visitada, así no se podrá acceder a ella
            }
        }
    }

    /*(3)Retorna la lista de ciudades que forman el camino más corto para llegar de 
    ciudad1 a ciudad2, si no existe camino retorna la lista vacía. (Las rutas poseen 
    la distancia).*/
    //Usamos dfs, nos guardamos el camino minimo y vamos comparando con el camino actual
    //Si el camino actual es menor al camino minimo, lo reemplazamos
    public List<String> caminoMasCorto(String ciudad1, String ciudad2){
        boolean marca[]=new boolean[mapaCiudades.getSize()]; //vector para marcar vertices visitados
        List<String>caminoMin=new ArrayList<>(); //Lista que voy a retornar
        List<String>caminoActual=new ArrayList<>(); //Lista camino actual
        if (!this.mapaCiudades.isEmpty()) { //si el grafo no esta vacio 
            Vertex<String> ciudadInicio = mapaCiudades.search(ciudad1); //busco la ciudad de inicio
            Vertex<String> ciudadDestino = mapaCiudades.search(ciudad2); //busco la ciudad de destino
            if (ciudadInicio!=null && ciudadDestino!=null) { //si las ciudades existen
                int min = Integer.MAX_VALUE; //inicializo el minimo en el maximo valor posible
                caminoMinimo(ciudadInicio, ciudadDestino, marca, caminoMin, caminoActual, min, 0); // llamo a la funcion
            }
        }
        return caminoMin;
    }

    public int caminoMinimo(Vertex<String>cI, Vertex<String>cD, boolean [] marca, List<String>caminoMin, List<String>caminoActual, int min, int actual){
        marca[cI.getPosition()] =true; //marco la ciudad de inicio como visitada
        caminoActual.add(cI.getData()); //agrego el nombre de la ciudad a la lista camino
        //Condicion de corte
        if (cI == cD && actual < min){ //si llegue a la ciudad de destino
            min = actual; //actualizo el minimo
            caminoMin.removeAll(caminoMin); //elimino el camino minimo actual
            caminoMin.addAll(caminoActual); //nuevo camino minimo --> camino actual  
        }
        else { //si no llegue a destino, recorro los adyacentes
            List<Edge<String>> adyacentes = mapaCiudades.getEdges(cI); //obtengo adyacentes de ciudad de inicio
            for (Edge<String> ady : adyacentes) { //recorro los adyacentes
                Vertex<String> ciudadAdyacente = ady.getTarget(); //obtengo la ciudad adyacente
                if (!marca[ciudadAdyacente.getPosition()]) { //si no visite la ciudad adyacente
                    int distancia = ady.getWeight(); //obtengo la distancia de la ruta
                    caminoMinimo(ciudadAdyacente, cD, marca, caminoMin, caminoActual, min, actual + distancia); //llamo a la funcion recursiva
                }
            }
            caminoActual.remove(caminoActual.size() - 1); //elimino la ciudad actual del camino
            marca[cI.getPosition()] = false; //Desmarco la ciudad de inicio antes de retornar
        }
        return min; //retorno el minimo encontrado
    }

    /*(4)Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a 
    ciudad2. El auto no debe quedarse sin combustible y no puede cargar. Si no 
    existe camino retorna la lista vacía.*/
    //public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){}
    
    /*(5)Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a 
    ciudad2 teniendo en cuenta que el auto debe cargar la menor cantidad de veces. 
    El auto no se debe quedar sin combustible en medio de una ruta, además puede 
    completar su tanque al llegar a cualquier ciudad. Si no existe camino retorna la
    lista vacía.*/
    //public List<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){}
}
