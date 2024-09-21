package ejercicio8;

import java.util.LinkedList;

public class DoubleEndedQueue <T> extends Queue <T>{
    /*enqueueFirst():void Permite encolar al inicio.*/
    public void enqueueFirst(T data){
        // Creo una lista auxiliar
        LinkedList<T> aux = new LinkedList<>();
        // Añade el nuevo elemento al inicio
        aux.add(data);
        // Añade todos los elementos existentes en la cola temporal
        while (!this.isEmpty()) {
            aux.add(dequeue());
        }
        // Ahora reinsertamos los elementos en la cola original
        for (T elementos : aux) {
            enqueue(elementos);
        }
    }
}
