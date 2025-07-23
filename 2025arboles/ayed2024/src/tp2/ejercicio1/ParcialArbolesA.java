/*Escribir en una clase ParcialArboles que contenga UNA ÚNICA variable de instancia de tipo
BinaryTree de valores enteros NO repetidos y el método público con la siguiente firma:
public boolean isLeftTree (int num)
El método devuelve true si el subárbol cuya raíz es “num”, tiene en su subárbol izquierdo una
cantidad mayor estricta de árboles con un único hijo que en su subárbol derecho. Y false en caso
contrario. Consideraciones:
● Si “num” no se encuentra en el árbol, devuelve false.
● Si el árbol con raíz “num” no cuenta con una de sus ramas, considere que en esa rama hay
-1 árboles con único hijo. */
package tp2.ejercicio1;

public class ParcialArbolesA {
    //variable de instancia
    private BinaryTree<Integer> arbol; //guarda valores enteros no repetidos
    //constructor
    public ParcialArbolesA(BinaryTree<Integer> arbol){
        this.arbol=arbol;
    }
    //metodo que devuelve true si el subárbol cuya raíz es “num”, tiene en su subárbol 
    //izquierdo una cantidad mayor estricta de árboles con un único hijo que en su 
    //subárbol derecho. Y false en caso contrario.
    public boolean isLeftTree(int num){
        //busco el nodo con el valor num
        BinaryTree <Integer> nodoNum = buscar(this.arbol, num);
        //si no existe "num" devuelvo false
        if (nodoNum == null || nodoNum.isEmpty()) {
            return false;
        }
        //por ultimo evaluo si el subarbol izquierdo tiene mas nodos con un unico hijo
        //que el subarbol derecho
        return evaluar(nodoNum);
    }

    private BinaryTree <Integer> buscar (BinaryTree<Integer>nodo, int num){
        //primero busco el num (vamos a hacer un recorrido preorden)
        if (nodo == null) {
            return null; //si el nodo es nulo, me vuelvo
        }
        if (nodo.getData() == num) {
            return nodo; //si el nodo es el buscado, lo devuelvo
        }
        BinaryTree<Integer> aux = null; //inicializo aux como nulo
        //si no es el nodo buscado, sigo buscando en los hijos
        if (nodo.hasLeftChild()){
            aux = buscar(nodo.getLeftChild(), num);
            if (aux != null) {
                return aux; //si encontré el nodo en el hijo izquierdo, lo devuelvo
            }
        }
        if (nodo.hasRightChild()){
            aux = buscar(nodo.getRightChild(), num);
            if (aux != null) {
                return aux; //si encontré el nodo en el hijo derecho, lo devuelvo
            }
        }
        return aux; //devuelvo el nodo encontrado o null si no se encuentra
    }   

    //evaluo si el subA izquierdo tiene mas nodos con un unico hijo que el subA derecho
    private boolean evaluar(BinaryTree <Integer> nodo){
        int izquierdo = 0;
        int derecho = 0;
        if (nodo.hasLeftChild()) {
            izquierdo = contar(nodo.getLeftChild());
        }
        else {
            izquierdo = -1;
        }
        if (nodo.hasRightChild()) {
            derecho = contar(nodo.getRightChild());
        }
        else {
            derecho = -1;
        }
        return izquierdo > derecho;
    }

    //cuenta la cantidad de nodos con un unico hijo en el subarbol
    public int contar(BinaryTree<Integer> nodo) {
        //si es hoja, no tiene hijos
        if (nodo.isLeaf()) {
            return 0; //no cuenta como árbol con un único hijo
        }
        int contador = 0;
        //si tiene hijo izquierdo y derecho, no cuenta como árbol con un único hijo
        if (nodo.hasLeftChild() && nodo.hasRightChild()) {
            contador += contar(nodo.getLeftChild());
            contador += contar(nodo.getRightChild());
            return contador; //sigo contando en los subárboles izquierdo y derecho
        }
        //si tiene solo hijo izquierdo, cuenta como árbol con un único hijo
        if (nodo.hasLeftChild() && !nodo.hasRightChild()) {
            contador++;
            contador += contar(nodo.getLeftChild()); //sigo contando en el subárbol izquierdo
        }
        //si tiene solo hijo derecho, cuenta como árbol con un único hijo
        if (!nodo.hasLeftChild() && nodo.hasRightChild()) {
            contador++;
            contador += contar(nodo.getRightChild()); //sigo contando en el subárbol derecho
        }
        return contador;
    }
    
}
