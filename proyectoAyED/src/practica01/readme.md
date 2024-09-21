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