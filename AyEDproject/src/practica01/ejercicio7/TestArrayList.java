package practica01.ejercicio7;

import java.util.ArrayList;
import java.util.Scanner;

public class TestArrayList {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in) ;
	    System.out.print("Ingrese un número: ");
	    int n = s.nextInt();
        ArrayList<Integer> lista = new ArrayList<>();
        while (n!=0){
            lista.add(n);
            System.out.print("Ingrese otro, para cortar ingrese 0: ");
            n = s.nextInt();
        }
        System.out.println("ArrayList: " + lista);

        //punto c)
        for(int i=0;i<lista.size();i++){
            System.out.print(lista.get(i)+" ");
        }
        s.close();
    }
}
