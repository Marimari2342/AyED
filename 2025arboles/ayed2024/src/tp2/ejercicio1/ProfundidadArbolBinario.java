/*variable de instancia un árbol binario de números enteros y un método de instancia
sumaElementosProfundidad (int p):int el cuál devuelve la suma de todos los nodos del 
árbol que se encuentren a la profundidad pasada como argumento. */

package tp2.ejercicio1;

import java.util.LinkedList;
import java.util.Queue;

public class ProfundidadArbolBinario {
    
    //variable de instancia
    private BinaryTree<Integer> arbol;
    // Constructor
    public ProfundidadArbolBinario(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    //Metodo de instancia que devuelve la suma de todos los nodos del arbol que se
    //encuentran a la profundidad pasada como argumento. 
    public int sumaElementosProfundidad (int p){
        if (arbol.isEmpty() || p < 0){
			System.out.println("Árbol vacío o profundidad inválida.");
			return 0;
		}
	
		Queue<BinaryTree<Integer>> cola = new LinkedList<>();
		cola.add(arbol);
		int nivel = 0;
        int suma = 0;
	
		while (!cola.isEmpty()) {
			int aux = cola.size();
	

            
			for (int i = 0; i < aux; i++) {
				BinaryTree<Integer> nodo = cola.remove();
	
				// ✅ Agregamos los hijos siempre, no importa si imprimimos o no
				if (nodo.hasLeftChild()) {
					cola.add(nodo.getLeftChild());
				}
				if (nodo.hasRightChild()) {
					cola.add(nodo.getRightChild());
				}
	
				// ✅ Solo imprimimos si el nivel está entre n y m
				if (nivel == p) {
					suma+= nodo.getData();
				}
			}
	
			if (nivel == p) {
				System.out.print("Suma en profundidad nivel " + p +": "+ suma + "\n");
			}
	
			nivel++;
		}
        return suma;
    }
}
