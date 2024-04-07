package practica01.ejercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EjercicioSucesion {

    // Constructor
    public EjercicioSucesion() {

    }

    public List<Integer> calcularSucesion(int n) {
        List<Integer> lista = new ArrayList<Integer>();
        if (n == 1) {
            lista.add(n);
            return lista;
        } else {
            if (n % 2 == 0) {
                lista.add(n);
                n = n / 2;
                lista.addAll(calcularSucesion(n));
                return lista;
            } else {
                lista.add(n);
                n = 3 * n + 1;
                lista.addAll(calcularSucesion(n));
                return lista;
            }
        }
    }

    public int sumarLinkedList(LinkedList<Integer> lista) {
        int num = 0;
        if (lista.size() == 0) {
            return num;
        } else {
            num = lista.get(lista.size() - 1);
            lista.remove(lista.size() - 1);
            num += sumarLinkedList(lista);
            return num;
        }
    }
}
