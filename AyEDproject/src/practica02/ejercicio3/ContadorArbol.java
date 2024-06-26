package practica02.ejercicio3;
import java.util.LinkedList;
import practica02.ejercicio1y2.BinaryTree;

public class ContadorArbol {

    private BinaryTree<Integer> arbol;

    public ContadorArbol(BinaryTree<Integer> unArbol) {
        arbol = unArbol;
    }

    // InOrder (se procesa hijo izquierdo - raiz - hijo derecho)
    public LinkedList<Integer> NumerosParesInOr() {
        LinkedList<Integer> lista = new LinkedList<Integer>();
        if (!arbol.isEmpty()) // Si tengo elemento en el arbol ejecuto
            this.NumerosParesInOrder(arbol, lista);
        return lista;
    }

    private void NumerosParesInOrder(BinaryTree<Integer> arbol, LinkedList<Integer> lista) {
        if (arbol.hasLeftChild())
            NumerosParesInOrder(arbol.getLeftChild(), lista);
        if (arbol.getData() % 2 == 0)
            lista.add(arbol.getData());
        if (arbol.hasRightChild())
            NumerosParesInOrder(arbol.getRightChild(), lista);
    }

    // PostOrden (se procesa hijo izquierdo - hijo derecho - raiz)
    public LinkedList<Integer> NumerosParesPostOr() {
        LinkedList<Integer> lista = new LinkedList<Integer>();
        if (!arbol.isEmpty()) // Si tengo elemento en el arbol ejecuto
            this.NumerosParesPostOrder(arbol, lista);
        return lista;
    }

    private void NumerosParesPostOrder(BinaryTree<Integer> arbol, LinkedList<Integer> lista) {
        if (arbol.hasLeftChild())
            NumerosParesInOrder(arbol.getLeftChild(), lista);
        if (arbol.hasRightChild())
            NumerosParesInOrder(arbol.getRightChild(), lista);
        if (arbol.getData() % 2 == 0)
            lista.add(arbol.getData());
    }
}
