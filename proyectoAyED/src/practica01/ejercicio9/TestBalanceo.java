package ejercicio9;

import java.util.Stack;

/*determinar si un String dado está balanceado. El String a verificar es un
parámetro de entrada (no es un dato predefinido)*/
public class TestBalanceo {
    

    /*metodo*/
    public Boolean estaBalanceado(String s){
        /*Inicialización: Creo una pila vacía para almacenar los caracteres de 
        apertura que se encuentren en el string.*/
        Stack<Character> pila = new Stack<>();

        /*Recorrido del String: Itera a través de cada carácter del string*/
        for (char aux : s.toCharArray()){
            if(aux=='('||aux=='['||aux=='{'){ //si es un carácter de apertura 
                pila.push(aux); //lo agrego a la pila
            }
            if(aux==')'||aux==']'||aux=='}'){ //si es un caracter de cierre
                if (pila.isEmpty()){
                    return false; //el string no está balanceado
                } 
            } else if (!verifico(aux,pila.pop())){
                return false; //Los caracteres de apertura y cierre no corresponden
            }
        }
        return pila.isEmpty();
    }

    /*Verifico si el carácter de cierre corresponde al carácter de apertura*/
    private Boolean verifico(char inicio, char fin){
        return ((inicio=='{' && fin=='}')||
                (inicio=='(' && fin==')')||
                (inicio=='[' && fin==']'));
    }
}
