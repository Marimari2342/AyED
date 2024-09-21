import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //punto01
        int a=4;
        int b=9;
        Enteros.metodo1(a, b);
        Enteros.metodo2(a, b);
        Enteros.metodo3(a, b);
        
        //punto02
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
