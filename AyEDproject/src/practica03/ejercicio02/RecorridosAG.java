package practica03.ejercicio02;

import java.util.LinkedList;
import java.util.List;

import practica03.ejercicio01.GeneralTree;

public class RecorridosAG {
    
    //metodos auxiliares
    public static boolean esImpar (int n){
        return n % 2 == 1;
    }

    //retorna lista con elementos impares del árbol “a” mayores a "n" [PREORDEN]
    private static void numerosImparesMayoresQuePreOrden(List<Integer> l, GeneralTree<Integer> a, Integer n) {
        while (!a.isEmpty()) {
            if ((a.getData() > n) && (esImpar(a.getData()))) {
                l.add(a.getData());
            }
            for (GeneralTree<Integer> hijo : a.getChildren()) {
                numerosImparesMayoresQuePreOrden(l, hijo, n);
            }
        }
    }

    public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
        List<Integer> l = new LinkedList<Integer>();
        numerosImparesMayoresQuePreOrden(l,a,n);
        return l; 
    }

    // retorna lista con elementos impares del árbol “a” mayores a "n" [INORDEN]
    private static void numerosImparesMayoresQueInOrden(List<Integer> l, GeneralTree<Integer> a, Integer n) {
        List<GeneralTree<Integer>> hijos = a.getChildren();
        if (a.hasChildren()) {
            numerosImparesMayoresQueInOrden(l, hijos.get(0), n);
        }
        if ((esImpar(a.getData())) && (a.getData() > n)) {
            l.add(a.getData());
        }
        for (int i = 1; i < hijos.size(); i++) {
            numerosImparesMayoresQueInOrden(l, hijos.get(i), n);
        }
    }
    
    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){
        List<Integer> l = new LinkedList<Integer>();
        numerosImparesMayoresQueInOrden(l,a,n);
        return l; 
    }


    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n)


    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n)

}
