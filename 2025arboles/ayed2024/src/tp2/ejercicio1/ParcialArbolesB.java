package tp2.ejercicio1;

public class ParcialArbolesB {

    //variables de instancia
    private BinaryTree<Integer> arbol1;
    //constructor
    public ParcialArbolesB(BinaryTree<Integer> arbol1) {
        this.arbol1 = arbol1;
    }

    //metodo pedido
    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        // es prefijo si arbol1 coincide con la parte inicial de arbol2
        // si ambos arboles estan vacios son prefijos
        if (arbol1.isEmpty() && arbol2.isEmpty()) {
            return true;
        }
        // si uno de los dos arboles esta vacio y el otro no, no son prefijos
        if (arbol1.isEmpty() || arbol2.isEmpty()) {
            return false;
        }
        // llamo al metodo recursivo para comparar los nodos
        return compararNodos(arbol1, arbol2);
    }   

    private boolean compararNodos(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        // comparo los datos de los nodos
        if (arbol1.getData().equals(arbol2.getData())){
            //miro los hijos
            if (arbol1.hasLeftChild()){     //HIJO IZQUIERDO
                if (!arbol2.hasLeftChild()) {
                    return false; // si arbol1 tiene hijo izquierdo y arbol2 no, no son prefijos
                }
                else {
                    return compararNodos(arbol1.getLeftChild(), arbol2.getLeftChild());
                }
            }
            if (arbol1.hasRightChild()){    //HIJO DERECHO
                if (!arbol2.hasRightChild()) {
                    return false; // si arbol1 tiene hijo derecho y arbol2 no, no son prefijos
                }
                else {
                    return compararNodos(arbol1.getRightChild(), arbol2.getRightChild());
                }
            }
            return true; // si ambos nodos tienen los mismos datos y no tienen hijos, son prefijos
        } 
        else {
            return false; // si los datos no coinciden, no son prefijos
        }
    }
}
