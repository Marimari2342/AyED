package tp2.ejercicio1;

public class Transformacion {
    //variable de instancia
    private BinaryTree<Integer> arbol;
    // Constructor
    public Transformacion(BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }
    public BinaryTree<Integer> getArbol() {
        return this.arbol;
    }

    /*devuelve el árbol en el que se reemplazó el valor de cada nodo por la suma de todos
    los elementos presentes en su subárbol izquierdo y derecho. Asuma que los valores de
    los subárboles vacíos son ceros. */
    // Arbol:                      Resultado:
    //            1                       35
    //         /     \                  /    \
    //        2       3                4      26
    //         \     / \       -->      \    /  \
    //          4   5   6                0  15   0
    //             / \                     /  \
    //            7   8                   0    0

    public BinaryTree<Integer> suma(){
        if (!arbol.isEmpty()){
            // Llamamos al método recursivo para transformar el árbol
            transformar(this.arbol);
        }
        return this.arbol;
    }

    private int transformar(BinaryTree<Integer> arbol) {
        if (arbol.isLeaf()) {
            int valorHoja = arbol.getData(); // Guardamos el valor de la hoja
            arbol.setData(0); // Si es hoja, no hay subárboles --> 0
            return valorHoja; // Retornamos el valor de la hoja
        } else {
            //inicializo suma de subarboles Derecho e Izquierdo
            int suma = 0; 
            int valorActual = arbol.getData(); // Guardamos el valor actual del nodo
            if (arbol.hasLeftChild()){
                // Si tiene hijo izquierdo, transformamos el subárbol izquierdo
                suma += transformar(arbol.getLeftChild());
            }
            if (arbol.hasRightChild()){
                // Si tiene hijo derecho, transformamos el subárbol derecho
                suma += transformar(arbol.getRightChild());
            }
            arbol.setData(suma);
            return suma+valorActual;
        }
    }
}
