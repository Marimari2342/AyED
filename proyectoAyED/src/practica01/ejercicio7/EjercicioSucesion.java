package ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class EjercicioSucesion {
    
    public static void main(String[] args) {
        int n = 6;
        EjercicioSucesion sucesion = new EjercicioSucesion();
        List<Integer> resultado = sucesion.calcularSucesion(n); //llamo al metodo

        // Imprimo el resultado
        System.out.println("Sucesión para n = " + n + ": " + resultado);
    }

    public List<Integer> calcularSucesion(int n) {
        List<Integer> lista = new ArrayList<>();
        generarSucesion(n, lista);
        return lista;
    }

    private void generarSucesion(int n, List<Integer> lista) {
        // Agregar el número actual a la lista
        lista.add(n);
        // Condición de fin
        if (n == 1) {
            return;
        }
        // Llamada recursiva según el valor de n
        if (n % 2 == 0) {                       //si n es par
            generarSucesion(n / 2, lista);
        } else {
            generarSucesion(3 * n + 1, lista);  // n es impar
        }
    }
}
