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

## 🟣 Examen02 [Octubre 2023]

![img_examen02](/proyectoAyED/src/recursos/examen02ABAG.png)

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

~~~java
public class ParcialArboles {

    //METODO que recibe un AB de enteros y devuelve un nuevo arbol en donde en cada nodo tengo
    //Suma--> de todos los números a lo largo del camino (desde raiz hasta nodo actual)
    //Diferencia--> nodo original - nodo padre
    public BinaryTree<SumaDif> sumaAndDif(BinaryTree<Integer>arbol){
        //Si el arbol esta vacio, devuelvo otro arbol vacio
        if(arbol.isEmpty()){
            return new BinaryTree<SumDif>();
        }
        //sino construyo un nuevo arbol
        return construir(arbol, 0,0);
    }

    //CONSTRUIR --> metodo para construir mi arbol 
    private BinaryTree<SumaDif> construir(BinaryTree<Integer>arbol, int suma, int padre){
        //PREORDEN (raiz, hI, hD)
        //Si llegamos al final (nodo vacio) retornamos null
        if (arbol.isEmpty()){
            return null;
        }
        // me guardo la suma del camino que fui recorriendo mas el valor del nodo
        int sumN=suma+arbol.getData();
        // me guardo la diferencia --> nodoactual-padre (pasado como parametro)
        int difN=arbol.getData()-padre;

        //creo una clase SumDif y luego creo un arbol que guarde este dato de tipo SumDif
        SumDif dato = new SumDif(sumN,difN);
        BinaryTree<SumDif> nodo = new BinaryTree<SumDif>(dato); 

        //continuo construyendo el arbol con los hijos
        if (arbol.hasLeftChild()){
            nodo.addLeftChild(construir(arbol.getLeftChild(),sumN, arbol.getData()));
        }
        if (arbol.hasRightChild()){
            nodo.addRightChild(construir(arbol.getRightChild(),sumN, arbol.getData()));
        }
        return nodo;
    }
}
~~~

~~~java
//CLASE AUXILIAR (el AB que devuelve el método sumAndDif() guardara datos de tipo SumaDif)
public class SumaDif{
    //variables instancia
    private int suma;
    private int dif;
   
    //constructor
    public SumaDif(int sum, int dif){
        this.suma=sum;
        this.dif=dif;
    }
}
~~~

</details>