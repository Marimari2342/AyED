# AyED - Practica 1

## 🟣 Punto 1
***Escriba tres métodos de clase (static) que reciban por parámetro dos números enteros (tipo int) a y b e impriman todos los números enteros comprendidos entre a; b (inclusive), uno por cada línea en la salida estándar. Para ello, dentro de una nueva clase escriba un método por cada uno de los siguientes incisos:***

* ***Que realice lo pedido con un for.***

* ***Que realice lo pedido con un while.***

* ***Que realice lo pedido sin utilizar estructuras de control iterativas (for, while, do while).***
  
***Por último, escriba en el método de clase main el llamado a cada uno de los métodos creados, con valores de ejemplo. En su computadora, ejecute el programa y verifique que se cumple con lo pedido.***

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

~~~java
//metodo1 --> Que realice lo pedido con un for
public static void metodo1(int num1, int num2){
    for (int i=num1;i<=num2;i++){
        System.out.println(i);
    }
}
~~~

~~~java
//metodo2 --> Que realice lo pedido con un while
public static void metodo2(int num1, int num2){
    int a=num1;
    while (a<=num2){
        System.out.println(a);
        a++;
    }
}
~~~

~~~java
//metodo3 --> Que realice lo pedido sin utilizar estructuras de control iterativas/**
 * @param num1
 * @param num2
 */
public static void metodo3(int num1, int num2){
    if (num1 > num2) {
        return;
    }
    System.out.println(num1);
    metodo3(num1+1,num2);
}
~~~

~~~java
public class Main {
    public static void main(String[] args) {
        int a=4;
        int b=9;
        Enteros.metodo1(a, b);
        Enteros.metodo2(a, b);
        Enteros.metodo3(a, b);
    }
}
~~~

</details>

## 🟣 Punto 2
***Escriba un método de clase que dado un número n devuelva un nuevo arreglo de tamaño n con los n primeros múltiplos enteros de n mayores o iguales que 1.***

* ***Ejemplo: f(5) = [5; 10; 15; 20; 25]; f(k) = {n*k donde k : 1..k}***

***Agregue al programa la posibilidad de probar con distintos valores de n ingresandolos por teclado, mediante el uso de System.in. La clase Scanner permite leer de forma sencilla valores de entrada.***

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

~~~java
public class Numeros {
    public static int[] multiplos(int n){
        int[] arreglo = new int[n];
        for (int i=1;i<n;i++){
            arreglo[i-1]=n*i;
        }
        return arreglo;
    }
}
~~~

~~~java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        n = Math.abs(n); //me aseguro que sea positivo
        System.out.print("Los " + n + " primeros múltiplos de " + n + " son: ");
        for (int num : Numeros.multiplos(n)) {
            System.out.print(num + " ");
        }
        s.close();
    }
}
~~~

</details>