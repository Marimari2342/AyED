package examenes;

public class ParcialArboles2 {
    //Arbol General de enteros --> POSTORDEN que retorne el elemento mayor. (hI, hD, raiz)

    //Quiero retornar el mayor elemento del arbol.
    public int mayorNum(GeneralTree <Integer> arbol){
        if (arbol.isEmpty()){
            return 0; //No me lo dice pero vamos a suponer que si el arbol estaba vacío retorno 0
        }
        int max=0;
        //POSTORDEN --> primero bajo hasta el hijo izquierdo
        for (GeneralTree<Integer> hijo : arbol.getChildren()){
            int maxHijo = mayorNum(hijo);
            Math.max(max, maxHijo);
            /*if (maxHijo>max){
                max=maxHijo;
            }*/
        }
        return max;
    }
}
