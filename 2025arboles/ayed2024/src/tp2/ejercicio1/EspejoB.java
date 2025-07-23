package tp2.ejercicio1;

public class EspejoB {
    public BinaryTree<Integer> espejo(BinaryTree <Integer> arbol){
        BinaryTree <Integer> arbolEspejo = new BinaryTree<>();
        if (arbol != null && !arbol.isEmpty()) {
            crearEspejo(arbol, arbolEspejo);
        }
        return arbolEspejo;
    }

    private void crearEspejo(BinaryTree<Integer> arbol, BinaryTree<Integer> arbolEspejo) {
        arbolEspejo.setData(arbol.getData());
        if (arbol.hasLeftChild()){
            arbolEspejo.addRightChild(new BinaryTree<Integer>());
            crearEspejo(arbol.getLeftChild(), arbolEspejo.getRightChild());
        }
        if (arbol.hasRightChild()){
            arbolEspejo.addLeftChild(new BinaryTree<Integer>());
            crearEspejo(arbol.getRightChild(), arbolEspejo.getLeftChild());
        }
    }
}
