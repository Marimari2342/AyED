package practica01.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class EjercicioSucesion {

    public EjercicioSucesion(){

    }

    public List<Integer> calcularSucesion(int n) {
        List<Integer> lista = new ArrayList<Integer>();
        if (n==1){
            lista.add(n);
            return lista;
        }
        else{
            if(n%2==0){
                lista.add(n);
                n=n/2;
                lista.addAll(calcularSucesion(n));
                return lista;
            }
            else {
                lista.add(n);
                n=3*n+1;
                lista.addAll(calcularSucesion(n));
                return lista;
            }
        }
    }
}
