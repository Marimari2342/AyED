package examenes;

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

/* CLASE AUXILIAR (el AB que devuelve el método sumAndDif() guardara datos de tipo SumaDif)
 * public class SumaDif{
 *  //variables instancia
 *  private int suma;
 *  private int dif;
 * 
 *  //constructor
 *  public SumaDif(int sum, int dif){
 *      this.suma=sum;
 *      this.dif=dif;
 *  }
 * }
 */
