package practica01.ejercicio7;

import java.util.LinkedList;    // <-- Importo java.util.LinkedList en lugar de java.util.ArrayList
import java.util.Scanner; 

public class TextLinkedList {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in) ;
	    System.out.print("Ingrese un número: ");
	    int n = s.nextInt();
        LinkedList<Integer> lista = new LinkedList<>(); // <-- Creo un arreglo LinkedList
        while (n!=0){
            lista.add(n);
            System.out.print("Ingrese otro, para cortar ingrese 0: ");
            n = s.nextInt();
        }
        System.out.println("LinkedList: " + lista);
        s.close();
    }
}
