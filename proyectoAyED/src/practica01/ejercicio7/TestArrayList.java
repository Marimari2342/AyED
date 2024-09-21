package ejercicio7;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestArrayList {
    public static void main(String[] args) {
        // Creo una lista de tipo ArrayList para almacenar los números
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agrego los numeros al array
        numeros.add(4);
        numeros.add(15);
        numeros.add(54);
        numeros.add(2);

        // Imprimir el contenido de la lista iterando sobre cada elemento
        System.out.println("Contenido de la lista:");
        for (int i=0;i<numeros.size();i++){
            System.out.println(numeros.get(i));
        }
    }

    public void metodoQueHace(){
        /*Cree una lista que contenga 3 estudiantes.*/
        ArrayList<Estudiante> listaEstudiante = new ArrayList<Estudiante>();
        listaEstudiante.add("Juan","Perez","A","juan@gmail.com","Calle 5 N 123");
        listaEstudiante.add("Maria","Gomez","B","maria@gmail.com","Calle 8 N 987");
        listaEstudiante.add("Camila","Flores","A","camila@gmail.com","Calle 15 N 165");
        
        /*Genere una nueva lista que sea una copia de la lista del inciso anterior*/
        ArrayList<Estudiante> listaCopia = new ArrayList<Estudiante>(listaEstudiante);

        /*Imprima el contenido de la lista original y el contenido de la nueva lista.*/
        System.out.print("Lista Original");
        for (Estudiante estudiante : listaEstudiante){ //uso un for each más rapido
            System.out.print(estudiante);
        }

        System.out.print("Lista Copia");
        for (Estudiante estudiante : listaCopia){ //uso un for each más rapido
            System.out.print(estudiante);
        }

        /*Modifique algún dato de los estudiantes.*/
        listaEstudiante.get(0).setNombre("Martin");
        listaCopia.get(1).setDireccion("Avenida 76 N 4569");

        /*Vuelva a imprimir el contenido de la lista original y el contenido de la 
        nueva lista.*/
        System.out.print("Lista Original");
        for (Estudiante estudiante : listaEstudiante){ //uso un for each más rapido
            System.out.print(estudiante);
        }

        System.out.print("Lista Copia");
        for (Estudiante estudiante : listaCopia){ //uso un for each más rapido
            System.out.print(estudiante);
        }

        /*Punto (e) --> Agregue un nuevo estudiante. Antes de agregar, verifique
        que el estudiante no estaba incluido en la lista*/
        Estudiante estudianteNuevo = new Estudiante("Luana","Roig","B"," "," ");
        if (!listaEstudiante.contains(estudianteNuevo)){
            listaEstudiante.add(estudianteNuevo);
        }
    }

    public boolean esCapicua(ArrayList<Integer> lista){
        for (int i = 0; i < lista.size() / 2; i++) { //voy desde 0 hasta la mitad
            if (!lista.get(i).equals(lista.get(lista.size() - 1 - i))) { //si no son iguales
                return false; // No es capicúa
            }
        }
        return true; // Es capicúa
    }

    /*(h) Implemente un método recursivo que invierta el orden de los elementos en 
    un ArrayList.*/
    public void invertirArrayList(ArrayList<Integer> lista){
        // Llamada recursiva para invertir la lista
        invertirRecursivo(lista, 0);
    }

    private static void invertirRecursivo(ArrayList<Integer> lista, int aux) {
        // Condición de terminación: si hemos llegado al medio de la lista
        if (aux >= lista.size() / 2) {
            return;
        }
        // Intercambiar elementos
        int elem = lista.get(aux); //me guardo el elem en pos=aux
        lista.set(aux, lista.get(lista.size() -1 -aux)); //reescribo en pos=aux 
        lista.set(lista.size() - 1 - aux, elem); //rescribo en pos contraria a aux
        // Llamada recursiva con el siguiente índice
        invertirRecursivo(lista, aux + 1);
    }

    /*(i)Implemente un método recursivo que calcule la suma de los elementos en 
    un LinkedList. */
    public int sumarLinkedList(LinkedList<Integer> lista){
        // Llamada recursiva para calcular la suma        
        return sumarRecursivo(lista);
    }

    private static int sumarRecursivo(LinkedList<Integer> lista){
        //condicion de corte
        if(lista.isEmpty()){
            return 0;
        }
        //suma recursiva
        int suma=lista.get(0);
        lista.remove(0);
        return suma + sumarRecursivo(lista);
    }

    /*(j) Implemente el método “combinarOrdenado” que reciba 2 listas de números 
    ordenados y devuelva una nueva lista también ordenada conteniendo los elementos 
    de las 2 listas.*/
    public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> l1, ArrayList<Integer> l2){
        // Lista para almacenar el resultado
        ArrayList<Integer> listaCombinada = new ArrayList<>(); 
        int i = 0, j = 0;
        // Recorrer ambas listas hasta que una se quede sin elementos
        while (i < l1.size() && j < l2.size()) { //mientras no llego al final de alguna lista
            if (l1.get(i) <= l2.get(j)) { 
                listaCombinada.add(l1.get(i)); // Agregar el menor de los dos
                i++; // Avanzar el puntero de la primera lista
            } else {
                listaCombinada.add(l2.get(j)); // Agregar el menor de los dos
                j++; // Avanzar el puntero de la segunda lista
            }
        }
        /*Acá sali del while, eso significa que al menos una de las dos listas
         * la recorri completa. Por lo tanto, agrego los elementos restantes de
         * la lista que aun tenga elementos (si es que tiene). A lo sumo entra a
         * UNO de los bucles while de abajo.
        */
        // Agregar los elementos restantes de l1 (si los hay)
        while (i < l1.size()) {
            listaCombinada.add(l1.get(i));
            i++;
        }
        // Agregar los elementos restantes de l2 (si los hay)
        while (j < l2.size()) {
            listaCombinada.add(l2.get(j));
            j++;
        }
        //retorno la lista combinada
        return listaCombinada;
    }
}

