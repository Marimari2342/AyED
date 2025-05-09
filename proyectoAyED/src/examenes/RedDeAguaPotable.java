package examenes;

//RED DE AGUA POTABLE --> ARBOL GENERAL
//El caudal se divide en partes iguales con cada bifurcación
public class RedDeAguaPotable {
    //variable de instancia 
    private GeneralTree<Integer>red;

    //constructor
    public RedDeAguaPotable(GenerateTree<Integer> red){
        this.red=red;
    }

    //METODO que calcula el caudal
    public double minimoCaudal(double caudal){
        if (red == null || red.isEmpty()){
            return 0;
        }
        return minimo(red,caudal);
    }

    //metodo recursivo 
    private double minimo(GeneralTree<Integer> nodo, double caudal){
        //si es una hoja retorno el caudal
        if (nodo.isLeaf()){
            return caudal;
        }
        
        double min=100000; //sino inicializo en un numero alto la variable "min"
        List<GeneralTree<Integer>> hijos = nodo.getChildren(); //guardo en lista a los hijos
        int cantHijos = hijos.size(); //me guardo la cantidad de hijos

        for (GeneralTree<Integer> hijo : hijos){
            double minSub = minimo(hijo, caudal/cantHijos);
            Math.min(min,minSub);
        }
        /*for (int i=0;i<hijos.size();i++){
         * double minSub = minimo(hijo.get(i),caudal/cantHijos);
         * if (minSub<min){
         *  min=minSub;
         * }
        } */
    }
}
