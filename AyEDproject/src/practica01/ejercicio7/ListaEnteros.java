package practica01.ejercicio7;

import java.io.Console;
import java.util.ArrayList;

public class ListaEnteros {

    private ArrayList<Integer> l;
    private int tam;

    // Constructor
    public ListaEnteros(int n) {
        l = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            l.add(i + 1);
        }
        tam = n;
    }

    public String MostrarLista() {
        return this.l.toString();
    }

    public void invertirArrayList(ArrayList<Integer> lista) {
        if (tam == 0) {
            System.out.println("Lista invertida:" + lista);
            tam = l.size();
        } else {
            lista.add(this.l.get(tam - 1));
            tam--;
            this.invertirArrayList(lista);
        }
    }

}
