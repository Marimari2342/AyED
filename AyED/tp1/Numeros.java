package tp1;
import java.util.Scanner;

public class Numeros {
	
		public static void main(String[] args) {
			//Punto1
			ImprimirF(5, 9);
			ImprimirW(5, -9);
			Imprimir(10, 2);
			
			//Punto2
			Scanner s = new Scanner(System.in) ;
	        System.out.print("Ingrese un número: ");
	        int n = s.nextInt();
			int [] arr = Multiplos(n);
			System.out.print("Arreglo: ");
			for (int i=0;i<n;i++)
				System.out.print(arr[i]+" ");

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
	
	public static int [] Multiplos(int n) {
		int[] arr = new int[n];
		for (int i=1;i<=n;i++)
			arr[i-1]=n*i;
		return arr;
	}
}
