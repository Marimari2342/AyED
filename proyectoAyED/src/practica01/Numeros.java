/*Punto 2 de la práctica1*/
/*Escriba un método de clase que dado un número n devuelva un nuevo arreglo de 
tamaño n con los n primeros múltiplos enteros de n mayores o iguales que 1 */

public class Numeros {
    public static int[] multiplos(int n){
        int[] arreglo = new int[n];
        for (int i=1;i<n;i++){
            arreglo[i-1]=n*i;
        }
        return arreglo;
    }
}