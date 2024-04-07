package practica01.ejercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese un numero entero: ");
        int n = s.nextInt();
        List<Integer> lista = new ArrayList<Integer>();
        EjercicioSucesion e = new EjercicioSucesion();
        lista = e.calcularSucesion(n);
        System.out.print("Lista: " + lista + "\n");

        // Punto h)
        ArrayList<Integer> lInv = new ArrayList<Integer>();
        ListaEnteros l = new ListaEnteros(5);
        System.out.print("Lista Original: " + l.MostrarLista() + "\n");
        l.invertirArrayList(lInv);
        s.close();

        // Punto i)
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            ll.add(i + 1);
        }
        System.out.println("Lista punto i): " + ll);
        System.out.print("Suma: " + e.sumarLinkedList(ll));
    }
}
