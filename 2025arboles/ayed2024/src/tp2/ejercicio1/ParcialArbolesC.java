package tp2.ejercicio1;

public class ParcialArbolesC {
    //variables de instancia
    private BinaryTree<Integer> arbol;

    //constructor
    public ParcialArbolesC(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    //metodo pedido
    public BinaryTree<SumDif> sumAndDif(BinaryTree<Integer> arbol) {
        // creo el nuevo arbol
        BinaryTree<SumDif> nuevoArbol = new BinaryTree<>();
        // llamo al metodo recursivo para transformar el arbol
        if (!arbol.isEmpty()) {
            transformar(arbol, nuevoArbol, 0, 0);
        }
        return nuevoArbol;
    }

    private void transformar(BinaryTree<Integer>arbol, BinaryTree<SumDif>arbolNuevo, int suma, int padre) {
        //me guardo el valor del nodo actual
        int nodoActual = arbol.getData();
        //creo una clase SumDif
        SumDif sumDif = new SumDif(suma+nodoActual, nodoActual-padre);
        //agrego el nodo (de tipo SumDif) al nuevo arbol
        arbolNuevo.setData(sumDif);
        //evaluo hijos
        if (arbol.hasLeftChild()) {
            arbolNuevo.addLeftChild(new BinaryTree<SumDif>());
            transformar (arbol.getLeftChild(), arbolNuevo.getLeftChild(), suma + nodoActual, nodoActual);
        }
        if (arbol.hasRightChild()) {
            arbolNuevo.addRightChild(new BinaryTree<SumDif>()); 
            transformar(arbol.getRightChild(), arbolNuevo.getRightChild(), suma + nodoActual, nodoActual);
        }
    }

    //tostring
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Elementos del árbol transformado:\n");
    
        BinaryTree<SumDif> arbolTransformado = sumAndDif(arbol);
        recorrerPreorden(arbolTransformado, sb, 1);
    
        return sb.toString();
    }

    private void recorrerPreorden(BinaryTree<SumDif> nodo, StringBuilder sb, int contador) {
        if (nodo == null || nodo.isEmpty()) {
            return;
        }

        sb.append("Nodo").append(contador).append(": ")
        .append(nodo.getData().toString()).append("\n");

        int siguiente = contador + 1;

        if (nodo.hasLeftChild()) {
            recorrerPreorden(nodo.getLeftChild(), sb, siguiente);
            siguiente++;
        }
        if (nodo.hasRightChild()) {
            recorrerPreorden(nodo.getRightChild(), sb, siguiente);
        }
    }
}
