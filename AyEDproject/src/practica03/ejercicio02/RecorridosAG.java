package practica03.ejercicio02;

import java.util.LinkedList;
import java.util.List;

import practica03.ejercicio01.GeneralTree;

public class RecorridosAG {
    
    //metodos auxiliares
    public static boolean esImpar (int n){
        return n % 2 == 1;
    }

    private static void numerosImparesMayoresQuePreOrden (List<Integer> l,GeneralTree <Integer> a, Integer n){
        while (!a.isEmpty()) {
            if ((a.getData() > n) && (esImpar(a.getData()))) {
                l.add(a.getData());
            }
            for (GeneralTree<Integer> hijo:a.getChildren()){
                numerosImparesMayoresQuePreOrden(l, hijo, n);
            }
        }
    }

    //retorna lista con elementos impares del árbol “a” mayores a "n" [PREORDEN]
    public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
        List<Integer> l = new LinkedList<Integer>();
        numerosImparesMayoresQuePreOrden(l,a,n);
        return l; 
    }


    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n)


    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n)


    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n)

}
