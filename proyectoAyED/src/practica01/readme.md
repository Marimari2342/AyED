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
public void metodo1(int num1, int num2){
    for (int i=num1;i<=num2;i++){
        System.out.println(i);
    }
}
~~~

~~~java
//metodo2 --> Que realice lo pedido con un while
public void metodo2(int num1, int num2){
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
public void metodo3(int num1, int num2){
    if (num1 > num2) {
        return;
    }
    System.out.println(num1);
    metodo3(num1+1,num2);
}
~~~

</details>