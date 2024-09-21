package ejercicio8;

public class CircularQueue <T> extends Queue <T>{
    /*shift(): T Permite rotar los elementos, haciéndolo circular. Retorna el 
    elemento encolado.*/
    public T shift(){
        if (this.isEmpty()) { //por las dudas de que la cola este vacia
            throw new IllegalStateException("La cola está vacía.");
        }
        // Extraemos el elemento en el frente de la cola
        T elemento = this.dequeue();
        // Encolamos de nuevo el elemento al final para hacer la rotación
        this.enqueue(elemento);
        // Retornamos el elemento que se ha rotado
        return elemento;
    }
}
