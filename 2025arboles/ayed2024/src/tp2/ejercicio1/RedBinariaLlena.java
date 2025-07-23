/*Una red binaria es una red que posee una topología de árbol binario lleno. Los nodos 
que conforman una red binaria llena tiene la particularidad de que todos ellos conocen
cuál es su retardo de reenvío. El retardo de reenvío se define como el período comprendido
entre que un nodo recibe un mensaje y lo reenvía a sus dos hijos.
Su tarea es calcular el mayor retardo posible, en el camino que realiza un mensaje desde 
la raíz hasta llegar a las hojas en una red binaria llena. En el ejemplo, debería 
retornar 10+3+9+12=34 (Si hay más de un máximo retorne el último valor hallado).
Nota: asuma que cada nodo tiene el dato de retardo de reenvío expresado en cantidad de
segundos.
a) Indique qué estrategia (recorrido en profundidad o por niveles) utilizará para resolver el
problema.

ESTRATEGIA: Utilizare un recorrido en profundidad (inOrden) para calcular el retardo de reenvío
de cada nodo, ya que necesito sumar los valores de los nodos desde la raíz hasta las hojas.

b) Cree una clase Java llamada RedBinariaLlena donde implementará lo solicitado en el
método retardoReenvio():int
*/
package tp2.ejercicio1;

public class RedBinariaLlena {

    // variable de instancia
    private BinaryTree<Integer> red;

    // Constructor
    public RedBinariaLlena(BinaryTree<Integer> red) {
        this.red = red;
    }

    /* Método que calcula el mayor retardo de reenvío en la red binaria llena */
    public int retardoReenvio() {
        return calcularRetardo(this.red, 0);
    }

    private int calcularRetardo(BinaryTree<Integer> nodo, int retardoActual) {
        if (nodo == null) return 0;

        int retardo = retardoActual + nodo.getData();

        // Si es hoja, devolvemos su retardo total
        if (nodo.isLeaf()) {
            return retardo;
        }

        // Si no es hoja, buscamos el máximo entre los hijos
        int maxIzq = nodo.hasLeftChild() ? calcularRetardo(nodo.getLeftChild(), retardo) : 0;
        int maxDer = nodo.hasRightChild() ? calcularRetardo(nodo.getRightChild(), retardo) : 0;

        return Math.max(maxIzq, maxDer);
    }
}
