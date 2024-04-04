package practica01;


public class Enteros {

    public static void main(String[]args){

        int [] arreglo = {3,6,1,7,2,9,4,3};
        double [] datos;
        datos = Metodo1(arreglo);
        System.out.print("Punto A - Maximo, minimo y promedio: ");
        for (int i=0;i<datos.length;i++){
            System.out.print(datos[i]+", ");
        }

        ObjB ob =new ObjB();
        Metodo2(ob, arreglo);
        System.out.print("\n"+ob.toString());
    }

    public static double[] Metodo1(int[] arreglo) {
        double[] aux = new double[3];
        aux[0] = -10000; // maximo
        aux[1] = 10000; // minimo
        aux[2] = 0; // prom
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] > aux[0]) {
                aux[0] = arreglo[i];
            }
            if (arreglo[i] < aux[1]) {
                aux[1] = arreglo[i];
            }
            aux[2] += arreglo[i];
        }
        aux[2] = aux[2] / arreglo.length;
        return aux;
    }

    public static void Metodo2(ObjB ob, int []arreglo){
        ob.setMax(-1);
        ob.setMin(9999);
        ob.setProm(0);

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] > ob.getMax()) {
                ob.setMax(arreglo[i]);
            }
            if (arreglo[i] < ob.getMin()) {
                ob.setMin(arreglo[i]);
            }
            ob.setProm(ob.getProm() + arreglo[i]);
        }
        ob.setProm(ob.getProm() / arreglo.length);
    }
}
