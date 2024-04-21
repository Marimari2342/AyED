package practica02.ejercicio5;

import practica02.ejercicio1y2.BinaryTree;

public class ProfundidadDeArbolBinario {

    private BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> unArbol) {
        arbol = unArbol;
    }

    public int sumaElementosProfundidad(int prof) {
        if (!arbol.isEmpty())
            return sumarElementos(arbol, prof, 0);
        else
            return 0;
    }

    private int sumarElementos(BinaryTree<Integer> arbol, int prof, int nivel) {
        if (prof == nivel)
            return arbol.getData();
        else {
            int suma = 0;
            if (arbol.hasLeftChild())
                suma += sumarElementos(arbol.getLeftChild(), prof, nivel + 1);
            if (arbol.hasRightChild())
                suma += sumarElementos(arbol.getRightChild(), prof, nivel + 1);
            return suma + arbol.getData();
        }
    }
}
