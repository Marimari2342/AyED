package ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class Queue <T> extends Sequence{
    /*Atributos*/
    private List<T> data;
    /*Queue() Constructor de la clase.*/
    public Queue(){
        this.data = new ArrayList<>();
    } 
    /*enqueue(dato: T): Inserta el elemento al final de la cola.*/
    public void enqueue(T dato){
        this.data.add(dato);
    }
    /* dequeue():T Elimina el elemento del frente de la cola y lo retorna. Si la 
    cola está vacía se produce un error.*/
    public T dequeue(){
        if (this.data.isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        return this.data.remove(0);
    }
    /*head(): T Retorna el elemento del frente de la cola. Si la cola está vacía se
    produce un error.*/
    public T head(){
        if (this.data.isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        return this.data.get(0);
    }
    /*isEmpty(): boolean Retorna verdadero si la cola no tiene elementos y falso en
    caso contrario.*/
    @Override
    public Boolean isEmpty(){
        return this.data.isEmpty();
    }
    /*size():int Retorna la cantidad de elementos de la cola.*/
    @Override
    public int size(){
        return this.data.size();
    }
    /*toString(): String Retorna los elementos de la cola en un String.*/
    @Override
    public String toString(){
        if (isEmpty()) {
            return "Cola vacía.";
        }
        String s = "Elementos de la cola: ";
        for (T elemento : data) {
            s+=elemento+" ";
        }
        return s;
    }
}

/*NOTA: El @Override en Java es una anotación que se utiliza para indicar que un
método está sobrescribiendo un método de su clase padre (superclase o interfaz)*/
