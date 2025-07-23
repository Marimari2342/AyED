/*Defina una clase Java denominada ContadorArbol cuya función principal es proveer métodos de
validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un
BinaryTree<Integer>. Implemente en dicha clase un método denominado numerosPares() que
devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del
árbol (divisibles por 2). */
package tp2.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class ContadorArbol {
    
    //variable de instancia
    private BinaryTree<Integer> arbol;

    // Constructor
    public ContadorArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }   

    /*a) Implemente el método realizando un recorrido InOrden. */
    public List<Integer> numerosParesInOrden() {
        List<Integer> pares = new ArrayList<>();
        inOrden(this.arbol, pares);
        return pares;
    }
    
    private void inOrden(BinaryTree<Integer> nodo, List<Integer> pares) {
        // InOrden: hI, raiz, hD
        if (nodo != null){
            //Primero HIJO IZQUIERDO
            if (nodo.hasLeftChild()){
                inOrden(nodo.getLeftChild(), pares);
            }
            //Luego RAIZ
            if (nodo.getData() % 2 == 0){ //veo que sea par
                pares.add(nodo.getData());
            }
            //Ultimo HIJO DERECHO
            if (nodo.hasRightChild()){
                inOrden(nodo.getRightChild(), pares);
            }
        }
    }

    /*b) Implemente el método realizando un recorrido PostOrden. */
    public List<Integer> numerosParesPostOrden() {
        List<Integer> pares = new ArrayList<>();
        postOrden(this.arbol, pares);
        return pares;
    }
    
    private void postOrden(BinaryTree<Integer> nodo, List<Integer> pares) {
        // InOrden: hI, hD, raiz
        if (nodo != null){
            //Primero HIJO IZQUIERDO
            if (nodo.hasLeftChild()){
                postOrden(nodo.getLeftChild(), pares);
            }
            //Luego HIJO DERECHO
            if (nodo.hasRightChild()){
                postOrden(nodo.getRightChild(), pares);
            }
            //Ultima la RAIZ
            if (nodo.getData() % 2 == 0){ //veo que sea par
                pares.add(nodo.getData());
            }
        }
    }
}
