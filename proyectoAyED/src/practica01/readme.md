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

## 🟣 Punto 3

***Creación de instancias mediante el uso del operador new.***

***Cree una clase llamada Estudiante con los atributos especificados abajo y sus correspondientes métodos getters y setters (haga uso de las facilidades que brinda eclipse)***

* nombre

* apellido

* comision

* email

* direccion

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
public class Estudiante {
    
    //Atributos
	private String nombre;
	private String apellido;
	private String comision;
	private String email;
	private String direccion;
	
	//Constructores
	public Estudiante() {	
	}
		
	public Estudiante(String unNombre,String unApe,String unaCom,String unMail,String unaDir) {
		this.nombre=unNombre;
		this.apellido=unApe;
		this.comision=unaCom;
		this.email=unMail;
		this.direccion=unaDir;
	}
	
	//Getters y Setters
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getComision() {
		return this.comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return this.direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
~~~

</details>

***Cree una clase llamada Profesor con los atributos especificados abajo y sus correspondientes métodos getters y setters (haga uso de las facilidades que brinda eclipse)***

* nombre

* apellido

* email

* catedra

* facultad

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
public class Profesor {
    //Atributos
	private String nombre;
	private String apellido;
	private String email;
	private String catedra;
	private String facultad;
	
	//Constructor
	public Profesor() {
	}
	
	public Profesor(String unNombre,String unApe,String unMail,String unaCat,String unaFacu) {
		this.nombre=unNombre;
		this.apellido=unApe;
		this.email=unMail;
		this.catedra=unaCat;
		this.facultad=unaFacu;
	}
	
	//Getters y Setters
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCatedra() {
		return this.catedra;
	}
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	public String getFacultad() {
		return this.facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
}
~~~

</details>

***Agregue un método de instancia llamado tusDatos() en la clase Estudiante y en la clase Profesor, que retorne un String con los datos de los atributos de las mismas. Para acceder a los valores de los atributos utilice los getters previamente definidos.***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

metodo tusDatos() en Profesor
~~~java
public String tusDatos() {
        return "Profesor: " + this.getNombre() + " "+ this.getApellido() + "\n     Email: "+
        		this.getEmail() + ".\n     Catedra: "+ this.getCatedra() + 
        		".\n     Facultad: "+ this.getFacultad()+".";
    }
~~~

metodo tusDatos() en Estudiante

~~~java
public String tusDatos() {
    return "Estudiante: " + this.getNombre() + " "+ this.getApellido() + 
        	".\n     Comision: "+ this.getComision() +"\n     Email: "+
        	this.getEmail() + ".\n     Direccion: "+ this.getDireccion()+".";
}
~~~

</details>

***Escriba una clase llamada Test con el método main, el cual cree un arreglo con 2 objetos Estudiante, otro arreglo con 3 objetos Profesor, y luego recorra ambos arreglos imprimiendo los valores obtenidos mediante el método tusDatos(). Recuerde asignar los valores de los atributos de los objetos Estudiante y Profesor invocando los respectivos métodos setters.***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
public class Test {

    public static void main(String[] args) {
        // Crear arreglo de Estudiantes
        Estudiante[] estudiantes = new Estudiante[2];
        
        // Asignar los valores a los objetos Estudiante utilizando setters
        estudiantes[0] = new Estudiante();
        estudiantes[0].setNombre("Juan");
        estudiantes[0].setApellido("Pérez");
        estudiantes[0].setComision("101");
        estudiantes[0].setEmail("juan.perez@mail.com");
        estudiantes[0].setDireccion("Calle Falsa 123");

        estudiantes[1] = new Estudiante();
        estudiantes[1].setNombre("María");
        estudiantes[1].setApellido("González");
        estudiantes[1].setComision("102");
        estudiantes[1].setEmail("maria.gonzalez@mail.com");
        estudiantes[1].setDireccion("Avenida Siempreviva 742");

        // Crear arreglo de Profesores
        Profesor[] profesores = new Profesor[3];
        
        // Asignar los valores a los objetos Profesor utilizando setters
        profesores[0] = new Profesor();
        profesores[0].setNombre("Carlos");
        profesores[0].setApellido("Gutiérrez");
        profesores[0].setEmail("carlos.gutierrez@mail.com");
        profesores[0].setCatedra("Matemáticas");
        profesores[0].setFacultad("Ingeniería");

        profesores[1] = new Profesor();
        profesores[1].setNombre("Ana");
        profesores[1].setApellido("Martínez");
        profesores[1].setEmail("ana.martinez@mail.com");
        profesores[1].setCatedra("Física");
        profesores[1].setFacultad("Ciencias Exactas");

        profesores[2] = new Profesor();
        profesores[2].setNombre("Luis");
        profesores[2].setApellido("Fernández");
        profesores[2].setEmail("luis.fernandez@mail.com");
        profesores[2].setCatedra("Química");
        profesores[2].setFacultad("Ciencias Naturales");

        // Recorrer el arreglo de Estudiantes e imprimir los datos
        System.out.println("Estudiantes:");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.tusDatos());
        }

        // Recorrer el arreglo de Profesores e imprimir los datos
        System.out.println("\nProfesores:");
        for (Profesor profesor : profesores) {
            System.out.println(profesor.tusDatos());
        }
    }
}
~~~

</details>

***Agregue dos breakpoints, uno en la línea donde itera sobre los estudiantes y otro en la línea donde itera sobre los profesores Ejecute la clase Test en modo debug y avance paso a paso visualizando si el estudiante o el profesor recuperado es lo esperado.***

 ## 🟣 Punto 4 

***Pasaje de parámetros en Java: sin ejecutar el programa en su computadora, sólo analizándolo, indique qué imprime el siguiente código. Luego, ejecute el ejercicio en su computadora, y compare su resultado con lo esperado en el inciso anterior.***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
package practica01;

public class SwapValores {
    public static void swap1 (int x, int y) { //x=1,y=2
        if (x < y) {        //1<2
            int tmp = x ;   //tmp=1
            x = y ;         //x=2
            y = tmp;        //y=1
        }
    }

    public static void swap2 (Integer x, Integer y) {   //x=3,y=4
        if (x < y) {        //3<4
            int tmp = x ;   //tmp=3
            x = y ;         //x=4
            y = tmp;        //y=3
        }
    }

    public static void main(String[] args) {
        int a = 1, b = 2;
        Integer c = 3, d = 4;
        swap1(a, b);        //paso parámetros --> solo se puede por valor
        swap2(c, d);
        System.out.println("a=" + a + " b=" + b);   //a=1 b=2
        System.out.println("c=" + c + " d=" + d);   //c=3 d=4 
    }
}
~~~

Analizando por caso:

* **Método swap1(int x, int y):**

Este método toma dos enteros primitivos (int) como parámetros. Sin embargo, en Java, los parámetros se pasan por valor, lo que significa que cualquier cambio en los valores dentro del método no afectará a las variables originales. Dentro de <code>swap1</code>, si x < y, los valores se intercambian, pero solo los valores locales en el contexto del método, no las variables originales fuera de este. En el método <code>main</code>, los valores a = 1 y b = 2 son pasados a <code>swap1</code>. Como 1 < 2, dentro del método los valores de x y y se intercambian, pero eso no afecta a las variables en el main.

* **Método swap2(Integer x, Integer y):**

Este método toma dos objetos Integer (clase envolvente de int). Aunque Java pasa objetos por referencia, en este caso también se comporta como si se pasaran por valor debido a la **inmutabilidad** de los objetos Integer. Es decir, las referencias originales no cambian fuera del método. En el <code>main</code>, los valores c = 3 y d = 4 son pasados a <code>swap2</code>. Como 3 < 4, dentro del método los valores de x y y se intercambian, pero no afecta a c y d en el <code>main</code>.

-----------------------------------

En conclusión, en Java no existe el paso por referencia. El paso por valor es obligatorio.Lo que se almacena en una variable no primitiva no es el objeto en sí sino una dirección o identificador del objeto en el espacio dinámico de memoria. Cuando pasas por parámetros la variable, estás pasando una copia de dicha dirección.

La clase Integer (y también el resto de los wrappers de los tipos primitivos) no permiten que se pueda cambiar el valor que contienen. Por esta característica son clases inmutables.

</details>

***Inserte un breakpoint en las líneas donde se indica: <code>y = tmp</code> y ejecute en modo debug ¿los valores que adoptan las variables x, y coinciden con los valores impresos por consola?***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

Al insertar un breakpoint en la linea <code>y = tmp</code> y ejecutar en modo debug notamos que los valores que adoptan las variables x, y no coinciden con los valores impresos por consola, esto es porque la clase Integer es inmutable (no permite que se pueda cambiar el valor que contiene).

![ImagenDebug](/proyectoAyED/src/recursos/imagen01.png)

</details>

## 🟣 Punto 5

***Dado un arreglo de valores tipo entero se desea calcular el valor máximo, mínimo, y promedio en un único método. Escriba tres métodos de clase, donde respectivamente:***

* ***Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return").***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

En este caso retorno un arreglo de double con los valores pedidos.

* metodo1( )

~~~java
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
~~~

</details>

* ***Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede ser de tipo arreglo).***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

En este caso, no puedo usar un arreglo como parámetro, pero puedo utilizar un objeto de una clase auxiliar que voy a llamar Resultados para almacenar los valores de máximo, mínimo y promedio.

Resultados.java

~~~java
public class Resultados {
    private int maximo;
    private int minimo;
    private double promedio;

    //getters
    public int getMax(){
        return this.maximo;
    }

    public int getMin(){
        return this.minimo;
    }

    public double getProm(){
        return this.promedio;
    }
    
    //setters
    public void setMax(int num){
        this.maximo=num;
    }

    public void setMin(int num){
        this.minimo=num;
    }

    public void setProm(double num){
        this.promedio=num;
    }
}
~~~

* metodo2( )

~~~java
public static void metodo2(int[] arreglo, Resultados resultados){
    resultados.setMax(arreglo[0]);
    resultados.setMin(arreglo[0]);
    resultados.setProm(0);
    int aux=0;
    for (int i=0;i<arreglo.length;i++){
        if(arreglo[i]>resultados.getMax()){     //maximo
            resultados.setMax(arreglo[i]);
        }
        if(arreglo[i]<resultados.getMin()){     //minimo
            resultados.setMin(arreglo[i]);
        }
        aux+=arreglo[i];                        //promedio
    }
    resultados.setProm(aux/arreglo.length);
}
~~~

</details>

* ***Devuelva lo pedido sin usar parámetros ni la sentencia "return".***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

En este caso mi metodo (que no será estático) va a guardar lo pedido en variables dentro de la clase, mediante getters y setters. Luego, si quiero acceder a los resultados, lo haré mediante los getters.

* metodo3( )

~~~java

public class NumerosEnteros {
    
    /*Usamos atributos, getters y setters para el metodo3*/
    private int maximo;
    private int minimo;
    private double promedio;

    //getters
    public int getMax(){
        return this.maximo;
    }

    public int getMin(){
        return this.minimo;
    }

    public double getProm(){
        return this.promedio;
    }
    
    //setters
    public void setMax(int num){
        this.maximo=num;
    }

    public void setMin(int num){
        this.minimo=num;
    }

    public void setProm(double num){
        this.promedio=num;
    }

    public void metodo3(int[] arreglo){
        this.setMax(arreglo[0]);
        this.setMin(arreglo[0]);
        this.setProm(0);
        int aux=0;
        for (int i=0;i<arreglo.length;i++){
            if(arreglo[i]>this.getMax()){        //maximo
                this.setMax(arreglo[i]);
            }
            if(arreglo[i]<this.getMin()){        //minimo
                this.setMin(arreglo[i]);
            }
            aux+=arreglo[i];                     //promedio
        }
        this.setProm(aux/arreglo.length);
    }
}
~~~

</details>

## 🟣 Punto 6

***Análisis de las estructuras de listas provistas por la API de Java.***

* ***1. ¿En qué casos ArrayList ofrece un mejor rendimiento que LinkedList?***

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

ArrayList ofrece un mejor rendimiento en los siguientes casos:

* Acceso aleatorio: La principal ventaja de ArrayList es que permite el acceso a los elementos en tiempo constante cuando se accede a un elemento por su índice. Esto se debe a que internamente es un arreglo dinámico, y accede a un índice de manera directa.

* Iteración: Al ser un arreglo continuo en memoria, iterar sobre un ArrayList es generalmente más rápido que sobre un LinkedList, ya que los datos están almacenados de manera contigua, aprovechando mejor la caché del procesador.

* Adiciones al final de la lista: Si el ArrayList tiene suficiente capacidad (si no es necesario redimensionar el arreglo interno), la operación de agregar un elemento al final es muy rápida.

</details>

* ***2. ¿Cuándo LinkedList puede ser más eficiente que ArrayList?***

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

LinkedList puede ser más eficiente en los siguientes casos:

* Inserciones y eliminaciones en posiciones intermedias: Las operaciones de inserción y eliminación en el medio o al inicio de la lista son más eficientes en un LinkedList. En cambio, en un ArrayList, insertar o eliminar un elemento en posiciones intermedias implica desplazar todos los elementos posteriores.

* Frecuentes adiciones y eliminaciones al principio de la lista: Para una LinkedList, agregar o eliminar elementos al principio de la lista es una operación mucho más rápida, mientras que en un ArrayList implica mover todos los elementos.

</details>

* ***3. ¿Qué diferencia encuentra en el uso de la memoria en ArrayList y LinkedList?***

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

La diferencia principal en el uso de la memoria entre ArrayList y LinkedList se debe a sus estructuras internas:

* ArrayList: Utiliza un arreglo contiguo para almacenar sus elementos. Su consumo de memoria es más eficiente porque solo almacena los datos. Sin embargo, cuando el arreglo se queda sin espacio, debe crearse un nuevo arreglo de mayor capacidad y copiar todos los elementos, lo que implica cierta sobrecarga temporal en memoria.

* LinkedList: Utiliza nodos enlazados. Cada nodo almacena tanto el dato como referencias (punteros) al nodo anterior y al nodo siguiente (en una lista doblemente enlazada). Esto significa que por cada elemento se consume memoria adicional para almacenar estas referencias. Además, la memoria no está contiguamente asignada, lo que puede ser menos eficiente para la caché de CPU.

</details>

* ***4. ¿En qué casos sería preferible usar un ArrayList o un LinkedList?***

<details><summary> <code> click para ver resolución 🖱 </code></summary><br>

Usar ArrayList:

* Cuando necesitas acceso rápido por índice (lecturas frecuentes).

* Si tu aplicación realiza muchas iteraciones sobre la lista.

* Cuando las operaciones de inserción y eliminación son principalmente al final de la lista.

* Si el tamaño de la lista es relativamente estable y no se anticipan muchas inserciones/eliminaciones en el medio.

Usar LinkedList:

* Cuando la aplicación requiere inserciones o eliminaciones frecuentes en el medio o al principio de la lista.

* Si el tamaño de la lista cambia constantemente y hay muchas operaciones de inserción y eliminación.

* Cuando no necesitas acceder frecuentemente a los elementos por índice, ya que acceder a un elemento específico en un LinkedList es costoso.

</details>

## 🟣 Punto 7

***Uso de las estructuras de listas provistas por la API de Java. Para resolver este punto cree el paquete tp1.ejercicio7.***

* ***Escriba una clase llamada TestArrayList cuyo método main recibe una secuencia de números, los agrega a una lista de tipo ArrayList, y luego de haber agregado todos los números a la lista, imprime el contenido de la misma iterando sobre cada elemento.***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java

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
~~~

</details>

* ***Si en lugar de usar un ArrayList en el inciso anterior hubiera usado un LinkedList ¿Qué diferencia encuentra respecto de la implementación? Justifique***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

Si se usa una <code>LinkedList</code> en lugar de un <code>ArrayList</code>, hay algunas diferencias en cuanto a la implementación y comportamiento de ambas clases, pero el código para iterar elementos es prácticamente el mismo. 

Hay diferencias en la declaración de la lista, puesto que en lugar de declarar un <code>ArrayList</code>, declararía una <code>LinkedList</code>. La estructura del código sería la misma, solo cambia el tipo de la lista:

~~~java
ArrayList<Integer> numeros = new ArrayList<>(); //con ArrayList
~~~

~~~java
LinkedList<Integer> numeros = new LinkedList<>(); //con LinkedList
~~~

En cuanto a la iteracion, en ambos casos es muy similar, ya que tanto ArrayList como LinkedList implementan la interfaz List. Por lo tanto, los métodos de iteración se comportan de manera similar. El código de iteración para LinkedList sigue siendo idéntico:

~~~java
for (int i = 0; i < numeros.size(); i++) {
    System.out.println(numeros.get(i));
}
~~~

</details>

* ***¿Existen otras alternativas para recorrer los elementos de la lista del punto 7a?***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

Si, puedo por ejemplo usar un while, que recorra toda la lista (usando una variable auxiliar) desde 0 hasta su ultimo elemento (consigo la dimensión del ArrayList con **lista.size()**) e imprima cada elemento de la misma.

~~~java
int i = 0;
while (i < numeros.size()) {
    System.out.println(numeros.get(i));
    i++;
}
~~~

</details>

* ***Escriba un método que realice las siguientes acciones:***

***a) Cree una lista que contenga 3 estudiantes.***

***b) Genere una nueva lista que sea una copia de la lista del inciso i.***

***c) Imprima el contenido de la lista original y el contenido de la nueva lista.***

***d) Modifique algún dato de los estudiantes.***

***e) Vuelva a imprimir el contenido de la lista original y el contenido de la nueva lista.***

***¿Qué conclusiones obtiene a partir de lo realizado? ¿Cuántas formas de copiar una lista existen? ¿Qué diferencias existen entre ellas?***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
public void metodoQueHace(){
    /*Cree una lista que contenga 3 estudiantes.*/
    ArrayList<Estudiante> listaEstudiante = new ArrayList<Estudiante>();
    listaEstudiante.add("Juan","Perez","A","juan@gmail.com","Calle 5 N 123");
    listaEstudiante.add("Maria","Gomez","B","maria@gmail.com","Calle 8 N 987");
    listaEstudiante.add("Camila","Flores","A","camila@gmail.com","Calle 15 N 165");
        
    /*Genere una nueva lista que sea una copia de la lista del inciso anterior*/
    ArrayList<Estudiante> listaCopia = new ArrayList<Estudiante>(listaEstudiante);

    /*Imprima el contenido de la lista original y el contenido de la nueva lista*/
    System.out.print("Lista Original");
    for (Estudiante estudiante : listaEstudiante){ //uso un for each más rapido
        System.out.print(estudiante);
    }

    System.out.print("Lista Copia");
    for (Estudiante estudiante : listaCopia){ //uso un for each más rapido
        System.out.print(estudiante);
    }

    /*Modifique algún dato de los estudiantes.*/
    listaEstudiante.get(0).setNombre("Martin");
    listaCopia.get(1).setDireccion("Avenida 76 N 4569");

    /*Vuelva a imprimir el contenido de la lista original y el contenido de la 
    nueva lista.*/
    System.out.print("Lista Original");
    for (Estudiante estudiante : listaEstudiante){ //uso un for each más rapido
        System.out.print(estudiante);
    }

    System.out.print("Lista Copia");
    for (Estudiante estudiante : listaCopia){ //uso un for each más rapido
        System.out.print(estudiante);
    }
}
~~~

* Conclusiones

Referencias compartidas: Al usar el constructor ArrayList, se crea una nueva lista que contiene referencias a los mismos objetos. Por lo tanto, si se modifican los objetos en la lista original, también se reflejarán en la copia.

Inmutabilidad de la copia: Para crear una copia "independiente", donde los cambios en la lista original no afecten a la copia, se necesitaría realizar una copia profunda (deep copy), lo cual implica crear nuevos objetos en lugar de copiar solo las referencias.

----------------------------------

</details>

* ***A la lista del punto 7d, agregue un nuevo estudiante. Antes de agregar, verifique que el estudiante no estaba incluido en la lista.***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
Estudiante estudianteNuevo = new Estudiante("Luana","Roig","B"," "," ");
    if (!listaEstudiante.contains(estudianteNuevo)){
        listaEstudiante.add(estudianteNuevo);
    }
~~~

</details>

* ***Escriba un método que devuelva verdadero o falso si la secuencia almacenada en la lista es o no capicúa:***

~~~java
public boolean esCapicua(ArrayList<Integer> lista)
~~~

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
public boolean esCapicua(ArrayList<Integer> lista){
    for (int i = 0; i < lista.size() / 2; i++) { //voy desde 0 hasta la mitad
        if (!lista.get(i).equals(lista.get(lista.size() -1 -i))) { //si son distintos
            return false; // No es capicúa
        }
    }
    return true; // Es capicúa
}
~~~

</details>

* ***Considere que se aplica la siguiente función de forma recursiva. A partir de un número n positivo se obtiene una sucesión que termina en 1:***

![ImagenEjemplo](/proyectoAyED/src/recursos/imagen02.png)

***Para cualquier n con el que se arranque siempre se llegará al 1. Escriba un programa recursivo que, a partir de un número n, devuelva una lista con cada miembro de la sucesión.***

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
package ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class EjercicioSucesion {
    
    public static void main(String[] args) {
        int n = 6;
        EjercicioSucesion sucesion = new EjercicioSucesion();
        List<Integer> resultado = sucesion.calcularSucesion(n); //llamo al metodo

        // Imprimo el resultado
        System.out.println("Sucesión para n = " + n + ": " + resultado);
    }

    public List<Integer> calcularSucesion(int n) {
        List<Integer> lista = new ArrayList<>();
        generarSucesion(n, lista);
        return lista;
    }

    private void generarSucesion(int n, List<Integer> lista) {
        // Agregar el número actual a la lista
        lista.add(n);
        // Condición de fin
        if (n == 1) {
            return;
        }
        // Llamada recursiva según el valor de n
        if (n % 2 == 0) {                       //si n es par
            generarSucesion(n / 2, lista);
        } else {
            generarSucesion(3 * n + 1, lista);  // n es impar
        }
    }
}
~~~

</details>

* ***Implemente un método recursivo que invierta el orden de los elementos en un ArrayList.***

~~~java
public void invertirArrayList(ArrayList<Integer> lista)
~~~

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
public void invertirArrayList(ArrayList<Integer> lista){
    // Llamada recursiva para invertir la lista
    invertirRecursivo(lista, 0);
}

private static void invertirRecursivo(ArrayList<Integer> lista, int aux) {
    // Condición de terminación: si hemos llegado al medio de la lista
    if (aux >= lista.size() / 2) {
        return;
    }
    // Intercambiar elementos
    int elem = lista.get(aux); //me guardo el elem en pos=aux
    lista.set(aux, lista.get(lista.size() -1 -aux)); //reescribo en pos=aux 
    lista.set(lista.size() - 1 - aux, elem); //rescribo en pos contraria a aux
    // Llamada recursiva con el siguiente índice
    invertirRecursivo(lista, aux + 1);
}
~~~

</details>

* ***Implemente un método recursivo que calcule la suma de los elementos en un LinkedList.***

~~~java
public int sumarLinkedList(LinkedList<Integer> lista)
~~~

<details><summary> <code> Respuesta 🖱 </code></summary><br>

Este método me modifica la lista, así que si no quiero que eso pase tendría que crear una copia antes y trabajar sobre ella.

~~~java
public int sumarLinkedList(LinkedList<Integer> lista){
    // Llamada recursiva para calcular la suma        
    return sumarRecursivo(lista);
}

private static int sumarRecursivo(LinkedList<Integer> lista){
    //condicion de corte
    if(lista.isEmpty()){
        return 0;
    }
    //suma recursiva
    int suma=lista.get(0);
    lista.remove(0);
    return suma + sumarRecursivo(lista);
}
~~~

</details>

* ***Implemente el método “combinarOrdenado” que reciba 2 listas de números ordenados y devuelva una nueva lista también ordenada conteniendo los elementos de las 2 listas.***

~~~java
public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> l1, ArrayList<Integer> l2);
~~~

<details><summary> <code> Respuesta 🖱 </code></summary><br>

~~~java
public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> l1, ArrayList<Integer> l2){
    // Lista para almacenar el resultado
    ArrayList<Integer> listaCombinada = new ArrayList<>(); 
    int i = 0, j = 0;
    // Recorrer ambas listas hasta que una se quede sin elementos
    while (i < l1.size() && j < l2.size()) { //mientras no llego al final de alguna lista
        if (l1.get(i) <= l2.get(j)) { 
            listaCombinada.add(l1.get(i)); // Agregar el menor de los dos
            i++; // Avanzar el puntero de la primera lista
        } else {
            listaCombinada.add(l2.get(j)); // Agregar el menor de los dos
            j++; // Avanzar el puntero de la segunda lista
        }
    }
    /*Acá sali del while, eso significa que al menos una de las dos listas
     * la recorri completa. Por lo tanto, agrego los elementos restantes de
     * la lista que aun tenga elementos (si es que tiene). A lo sumo entra a
     * UNO de los bucles while de abajo.
    */
    // Agregar los elementos restantes de l1 (si los hay)
    while (i < l1.size()) {
        listaCombinada.add(l1.get(i));
        i++;
    }
    // Agregar los elementos restantes de l2 (si los hay)
    while (j < l2.size()) {
        listaCombinada.add(l2.get(j));
        j++;
    }
    //retorno la lista combinada
    return listaCombinada;
}
~~~

</details>

## 🟣 Punto 8

***El objetivo de este punto es ejercitar el uso de la API de listas de Java y aplicar conceptos de la programación orientada a objetos. Sean las siguientes especificaciones de cola, cola circular y cola con 2 extremos disponibles, vistas en la explicación teórica:***

* Implemente en JAVA la clase Queue de acuerdo con la especificación dada en el diagrama de clases. Defina esta clase dentro del paquete tp1.ejercicio8.

1. Queue() Constructor de la clase.

2. enqueue(dato: T): Inserta el elemento al final de la cola.

3. dequeue():T Elimina el elemento del frente de la cola y lo retorna. Si la cola está vacía se produce un error.

4. head(): T Retorna el elemento del frente de la cola. Si la cola está vacía se
produce un error.

5.isEmpty(): boolean Retorna verdadero si la cola no tiene elementos y falso en
caso contrario.

6. size():int Retorna la cantidad de elementos de la cola.

7. toString(): String Retorna los elementos de la cola en un String.

* Implemente en JAVA las clase CircularQueue de acuerdo con la especificación dada en el diagrama de clases. Defina esta clase dentro del paquete tp1.ejercicio8.

1 shift(): T Permite rotar los elementos, haciéndolo circular. Retorna el elemento
encolado.

* Implemente en JAVA la clase DoubleEndedQueue de acuerdo con la especificación
dada en el diagrama de clases. Defina esta clase dentro del paquete tp1.ejercicio8.

1. enqueueFirst():void Permite encolar al inicio.

<details><summary> <code> Respuesta 🖱 </code></summary><br>

La resolución de los ejercicios esta en la carpeta **ejercicio8**

* <code>[Sequence.java](/proyectoAyED/src/practica01/ejercicio8/Sequence.java)</code>

* <code>[Queue.java](/proyectoAyED/src/practica01/ejercicio8/Queue.java)</code>

* <code>[CircularQueue.java](/proyectoAyED/src/practica01/ejercicio8/CircularQueue.java)</code>

* <code>[DoubleEndedQueue.java](/proyectoAyED/src/practica01/ejercicio8/DoubleEndedQueue.java)</code>

</details>

