package practica02.ejercicio9;

import practica02.ejercicio1y2.BinaryTree;

public class ParcialArboles {

    public BinaryTree<SumaDiferencia> sumAndDif(BinaryTree<Integer> arbol) {
        BinaryTree<SumaDiferencia> arbolN = new BinaryTree<SumaDiferencia>();
        if (!arbol.isEmpty())
            evaluar(arbol, arbolN, 0, 0);
        return arbolN;
    }

    private void evaluar(BinaryTree<Integer> a, BinaryTree<SumaDiferencia> aN, int sum,
            int padre) {
        int actual = a.getData();
        SumaDiferencia aux = new SumaDiferencia(sum + a.getData(), a.getData() - padre);
        aN.setData(aux);
        if (a.hasLeftChild()) {
            aN.addLeftChild(new BinaryTree<SumaDiferencia>());
            evaluar(a.getLeftChild(), aN.getLeftChild(), sum + actual, actual);
        }
        if (a.hasRightChild()) {
            aN.addRightChild(new BinaryTree<SumaDiferencia>());
            evaluar(a.getRightChild(), aN.getRightChild(), sum + actual, actual);
        }
    }
}
