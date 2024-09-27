package practica02.ejercicio3;
import java.util.LinkedList;
import practica02.ejercicio1y2.BinaryTree;


public class ContadorArbol {
    //variable de instancia
    private BinaryTree<Integer> arbol;

    //constructor
    public ContadorArbol(BinaryTree<Integer> unArbol) {
        arbol = unArbol;
    }

    /*Método numerosPares() que devuelve en una estructura 
    adecuada todos los elementos pares del árbol */

    // (a) InOrder (se procesa hijo izquierdo - raiz - hijo derecho)
    public LinkedList<Integer> numerosParesInOr() {
        LinkedList<Integer> lista = new LinkedList<Integer>();
        if (!arbol.isEmpty()) // Si tengo elemento en el arbol ejecuto
            this.numerosParesInOrder(arbol, lista);
        return lista;
    }

    private void numerosParesInOrder(BinaryTree<Integer> arbol, LinkedList<Integer> lista) {
        if (arbol.hasLeftChild())
            numerosParesInOrder(arbol.getLeftChild(), lista);
        if (arbol.getData() % 2 == 0)
            lista.add(arbol.getData());
        if (arbol.hasRightChild())
            numerosParesInOrder(arbol.getRightChild(), lista);
    }

    // (b) PostOrden (se procesa hijo izquierdo - hijo derecho - raiz)
    public LinkedList<Integer> numerosParesPostOr() {
        LinkedList<Integer> lista = new LinkedList<Integer>();
        if (!arbol.isEmpty()) // Si tengo elemento en el arbol ejecuto
            this.numerosParesPostOrder(arbol, lista);
        return lista;
    }

    private void numerosParesPostOrder(BinaryTree<Integer> arbol, LinkedList<Integer> lista) {
        if (arbol.hasLeftChild())
            numerosParesPostOrder(arbol.getLeftChild(), lista);
        if (arbol.hasRightChild())
            numerosParesPostOrder(arbol.getRightChild(), lista);
        if (arbol.getData() % 2 == 0)
            lista.add(arbol.getData());
    }
}
