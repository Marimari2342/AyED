
/*Punto 5 de la práctica1*/
public class NumerosEnteros {
    
    public static double[] metodo1(int[] arreglo){
        double[] aux = new double[3];
        aux[0] = -100000; //maximo
        aux[1] = 100000; //minimo
        aux[2] = 0; //promedio
        for (int i=0;i<arreglo.length;i++){
            if (arreglo[i]>aux[0]){     //valor maximo
                aux[0]=arreglo[i];
            }
            if (arreglo[i]<aux[1]){     //valor minimo
                aux[1]=arreglo[i];
            }
            aux[2]+=arreglo[i];         //valor promedio
        }
        aux[2]=aux[2]/arreglo.length;
        return aux;
    }
    
    public static void metodo2(int[] arreglo, Resultados resultados){
        resultados.setMax(arreglo[0]);
        resultados.setMin(arreglo[0]);
        resultados.setProm(0);
        int aux=0;
        for (int i=0;i<arreglo.length;i++){
            if(arreglo[i]>resultados.getMax()){     //maximo
                resultados.setMax(arreglo[i]);
            }
            if(arreglo[i]<resultados.getMin()){     //minimo
                resultados.setMin(arreglo[i]);
            }
            aux+=arreglo[i];                        //promedio
        }
        resultados.setProm(aux/arreglo.length);
    }
}


/****Dado un arreglo de valores tipo entero se desea calcular el valor máximo, mínimo, y promedio en un único método. Escriba tres métodos de clase, donde respectivamente:***

* ***Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return").*** */