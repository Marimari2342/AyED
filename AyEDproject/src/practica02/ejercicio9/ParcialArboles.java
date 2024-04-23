package practica02.ejercicio9;

import practica02.ejercicio1y2.BinaryTree;

public class ParcialArboles {

    public BinaryTree<SumaDiferencia> sumAndDif(BinaryTree<Integer> arbol) {
        BinaryTree<SumaDiferencia> arbolN = new BinaryTree<SumaDiferencia>();
        evaluar(arbol, arbolN);
        return arbolN;
    }

    private BinaryTree<SumaDiferencia> evaluar(BinaryTree<Integer> a, BinaryTree<SumaDiferencia> aN) {

        return aN;
    }
}
