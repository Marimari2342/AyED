import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        // Creo una lista de tipo ArrayList para almacenar los números
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agrego los numeros al array
        numeros.add(4);
        numeros.add(15);
        numeros.add(54);
        numeros.add(2);

        // Imprimir el contenido de la lista iterando sobre cada elemento
        System.out.println("Contenido de la lista:");
        for (int i=0;i<numeros.size();i++){
            System.out.println(numeros.get(i));
        }
    }
}

