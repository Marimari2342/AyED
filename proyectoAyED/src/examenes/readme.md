# EXAMENES - Algoritmos y Estructuras de Datos

**Resolución de exámenes de AyED de otros años (ejercicios de código de AB y AG).**

## 🟣 Examen01 [Mayo 2023 - Tema2]

![img_examen01](/proyectoAyED/src/recursos/examen01ABAG.png)

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

~~~java
public class ParcialArboles {
    //unica variable de instancia de tipo BinaryTree
    private BinaryTree <Integer> arbol;

    //constructor
    public ParcialArboles(BinaryTree<Integer> a){
        this.arbol=a;
    }
    /*metodo publico --> devuelve TRUE si el subarbol con raiz "num" tiene igual
    cantidad de arboles con dos hijos en el subArbol izquierdo y el subArbol derecho*/
    public Boolean isTwoTree(int num){
        //ME POSICIONO --> metodo para buscar el nodo que tenga guardado "num" y lo retorne
        BinaryTree<Integer> aux = buscar(this.arbol, num);

        //si no se encontró "num"
        if (aux.isEmpty()){
            return false;
        }

        //CUENTO --> metodo para contar nodos que cumplan con lo pedido, en cada subarbol
        int izq = -1;
        int der = -1;
        if (aux.hasLeftChild())
            izq = contar(aux.getLeftChild());
        if (aux.hasRightChild())
            izq = contar(aux.getRightChild());

        return izq == der;
    }

    //metodo para buscar el nodo que tenga guardado "num" y lo retorne
    private BinaryTree<Integer> buscar(BinaryTree<Integer> a, int num){
        //recorrido PREORDEN
        //condicion de corte --> encontré el num o llegue al final del arbol 
        if (a.getData()==num||a.isEmpty()){
            return a;
        }
        //reviso hijos
        if (a.hasLeftChild()){
            buscar(a.getLeftChild(), num);
        }
        if (a.hasRightChild()){
            buscar(a.getRightChild(), num);
        }
    }

    //metodo para contar nodos que cumplan con lo pedido, en cada subarbol
    private int contar(BinaryTree<Integer> a ){
        int aux=0;
        if(!a.isEmpty()){ //condicion de corte, llegué a una hoja entonces ya no reviso
            if (a.hasLeftChild() && a.hasRightChild()){
                aux++;
            }
            aux+=contar(a.getLeftChild())+contar(a.getRightChild());
        }
        return aux;
    }

}
~~~

</details>