# AyED - Practica 1


## Punto 1
***Escriba tres métodos de clase (static) que reciban por parámetro dos números enteros (tipo int) a y b e impriman todos los números enteros comprendidos entre a; b (inclusive), uno por cada línea en la salida estándar. Para ello, dentro de una nueva clase escriba un método por cada uno de los siguientes incisos:***

* ***Que realice lo pedido con un for.***
* ***Que realice lo pedido con un while.***
* ***Que realice lo pedido sin utilizar estructuras de control iterativas (for, while, do while).***
  
***Por último, escriba en el método de clase main el llamado a cada uno de los métodos creados, con valores de ejemplo. En su computadora, ejecute el programa y verifique que se cumple con lo pedido.***

<details><summary> <code> click para ver resolución 🖱 </code></summary>



~~~java
package tp1;

public class Numeros {
	
		public static void main(String[] args) {
			//Punto1
			ImprimirF(5, 9);
			ImprimirW(5, -9);
			Imprimir(10, 2);

		}
	
	//Imprimir con for
	public static void ImprimirF(int a,int b)
	{
		if (a > b) {
			int aux = a;
			a = b;
			b = aux;
		}
		for (int i=a;i<=b;i++)
			System.out.print(i+ " | ");
		System.out.print("\n");
	}
	
	//Imprimir con While
	public static void ImprimirW(int a,int b)
	{
		if (a > b) {
			int aux = a;
			a = b;
			b = aux;
		}
		while (a!=b+1) {
			System.out.print(a+ " | ");
			a++;
		}
		System.out.print("\n");
	}
	
	public static void Imprimir(int a, int b)
	{
		if (a > b) {
			int aux = a;
			a = b;
			b = aux;
		}
		if(a<b)
		{
			System.out.print(a+ " | ");
			a++;
			Imprimir(a,b);
		}
		else if(a==b) {
			System.out.print(a+ " | ");
			System.out.print("\n");
		}
	}
}

~~~
</details>



## Punto 2
***Escriba un método de clase que dado un número n devuelva un nuevo arreglo de tamaño n con los n primeros múltiplos enteros de n mayores o iguales que 1.***

* ***Ejemplo: f(5) = [5; 10; 15; 20; 25]; f(k) = {n*k donde k : 1..k}***

***Agregue al programa la posibilidad de probar con distintos valores de n ingresandolos por teclado, mediante el uso de System.in. La clase Scanner permite leer de forma sencilla valores de entrada.***

<details><summary> <code> click para ver resolución 🖱 </code></summary>

~~~java
package tp1;
import java.util.Scanner;

public class Numeros {
	
		public static void main(String[] args) {
		
			//Punto2
			Scanner s = new Scanner(System.in) ;
	        	System.out.print("Ingrese un número: ");
	        	int n = s.nextInt();
			int [] arr = Multiplos(n);
			System.out.print("Arreglo: ");
			for (int i=0;i<n;i++)
				System.out.print(arr[i]+" ");

		}
	
	public static int [] Multiplos(int n) {
		int[] arr = new int[n];
		for (int i=1;i<=n;i++)
			arr[i-1]=n*i;
		return arr;
	}
}

~~~

</details>
