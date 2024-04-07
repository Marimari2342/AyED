package practica01.ejercicio7;

import java.util.ArrayList;
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
        System.out.print("Lista: "+lista);
        s.close();
    }
}
