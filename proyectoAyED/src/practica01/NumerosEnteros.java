
import java.lang.reflect.Array;

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
    

}


/****Dado un arreglo de valores tipo entero se desea calcular el valor máximo, mínimo, y promedio en un único método. Escriba tres métodos de clase, donde respectivamente:***

* ***Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return").*** */