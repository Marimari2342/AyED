/*Punto 1 de la práctica1*/
public class Enteros {

    //metodo1 --> Que realice lo pedido con un for
    public static void metodo1(int num1, int num2){
        for (int i=num1;i<=num2;i++){
            System.out.println(i);
        }
    }

    //metodo2 --> Que realice lo pedido con un while
    public static void metodo2(int num1, int num2){
        int a=num1;
        while (a<=num2){
            System.out.println(a);
            a++;
        }
    }

    //metodo3 --> Que realice lo pedido sin utilizar estructuras de control iterativas
    /**
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
}

