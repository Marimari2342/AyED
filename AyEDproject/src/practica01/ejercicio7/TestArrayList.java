package practica01.ejercicio7;

import java.util.ArrayList;
import java.util.Scanner;

public class TestArrayList {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int n = s.nextInt();
        ArrayList<Integer> lista = new ArrayList<>();
        while (n != 0) {
            lista.add(n);
            System.out.print("Ingrese otro, para cortar ingrese 0: ");
            n = s.nextInt();
        }
        System.out.println("ArrayList: " + lista);

        // punto c)
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i) + " ");
        }
        s.close();

        // punto d)
        ArrayList<String> listaE = crearLista();
        ArrayList<String> listaEb = new ArrayList<>(listaE);
        System.out.println("Lista1: " + listaE);
        System.out.println("Lista2: " + listaEb);
        listaE.set(1, "Sofia Martins");
        listaEb.set(0, "Marina Jensen");
        System.out.println("Lista1: " + listaE);
        System.out.println("Lista2: " + listaEb);
        // punto e)
        String aux = "Florencia Moreno";
        if (!listaE.contains(aux)) {
            listaE.add(aux);
        }
        System.out.println("Lista1: " + listaE);
        // punto f)
        System.out.println("Es capicua: " + esCapicua(lista));
    }

    // Crear un ArrayList de 3 estudiantes
    public static ArrayList<String> crearLista() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Juan Perez");
        lista.add("Maria Rodriguez");
        lista.add("Sebastian Paez");
        return lista;
    }

    // Metodo Capicúa
    public static boolean esCapicua(ArrayList<Integer> l) {
        boolean aux = true;
        int n = 0;
        while (n < l.size() - n - 1 && aux) {
            if (l.get(n) == l.get(l.size() - n - 1)) {
                n++;
            } else {
                aux = false;
            }
        }
        return aux;
    }

}
