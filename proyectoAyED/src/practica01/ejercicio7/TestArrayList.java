package ejercicio7;

import java.util.ArrayList;

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
}

