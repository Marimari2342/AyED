# AyED - Practica 1


## 🟣 Punto 1
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



## 🟣 Punto 2
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
			s.close();

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


## 🟣 Punto 3

***Creación de instancias mediante el uso del operador new.***

***Cree una clase llamada Estudiante con los atributos especificados abajo y sus correspondientes métodos getters y setters (haga uso de las facilidades que brinda eclipse)***
* nombre
* apellido
* comision
* email
* direccion

<details><summary> <code> Respuesta 🖱 </code></summary>

~~~java
package practica01;

public class Estudiante {

	//Atributos
	private String Nombre;
	private String Apellido;
	private String Comision;
	private String Email;
	private String Direccion;
	
	//Constructor
	public Estudiante() {
			
	}
		
	public Estudiante(String unNombre,String unApe,String unaCom,String unMail,String unaDir) {
		this.Nombre=unNombre;
		this.Apellido=unApe;
		this.Comision=unaCom;
		this.Email=unMail;
		this.Direccion=unaDir;
	}
	
	//Getters y Setters
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getComision() {
		return Comision;
	}
	public void setComision(String comision) {
		Comision = comision;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
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

<details><summary> <code> Respuesta 🖱 </code></summary>

~~~java
package practica01;

public class Profesor {
	
	//Atributos
	private String Nombre;
	private String Apellido;
	private String Email;
	private String Catedra;
	private String Facultad;
	
	//Constructor
	public Profesor() {
		
	}
	
	public Profesor(String unNombre,String unApe,String unMail,String unaCat,String unaFacu) {
		this.Nombre=unNombre;
		this.Apellido=unApe;
		this.Email=unMail;
		this.Catedra=unaCat;
		this.Facultad=unaFacu;
	}
	
	//Getters y Setters
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCatedra() {
		return Catedra;
	}
	public void setCatedra(String catedra) {
		Catedra = catedra;
	}
	public String getFacultad() {
		return Facultad;
	}
	public void setFacultad(String facultad) {
		Facultad = facultad;
	}
}
~~~

</details>

***Agregue un método de instancia llamado tusDatos() en la clase Estudiante y en la clase Profesor, que retorne un String con los datos de los atributos de las mismas. Para acceder a los valores de los atributos utilice los getters previamente definidos.***

<details><summary> <code> Respuesta 🖱 </code></summary>

~~~java
//Clase Estudiante
public String tusDatos() {
        return "Estudiante: " + this.getNombre() + " "+ this.getApellido() + 
        		".\n     Comision: "+ this.getComision() +"\n     Email: "+
        		this.getEmail() + ".\n     Direccion: "+ this.getDireccion()+".";
    }

//Clase Profesor
public String tusDatos() {
        return "Profesor: " + this.getNombre() + " "+ this.getApellido() + "\n     Email: "+
        		this.getEmail() + ".\n     Catedra: "+ this.getCatedra() + 
        		".\n     Facultad: "+ this.getFacultad()+".";
    }
~~~

</details>

***Escriba una clase llamada Test con el método main, el cual cree un arreglo con 2 objetos Estudiante, otro arreglo con 3 objetos Profesor, y luego recorra ambos arreglos imprimiendo los valores obtenidos mediante el método tusDatos(). Recuerde asignar los valores de los atributos de los objetos Estudiante y Profesor invocando los respectivos métodos setters.***

<details><summary> <code> Respuesta 🖱 </code></summary>

~~~java
package practica01;

public class Test {

	public static void main(String[] args) {
		
		Profesor [] profesor = new Profesor[2];
		Estudiante [] estudiante = new Estudiante[3];
		
		estudiante[0] = new Estudiante("","","","","");
		estudiante[1] = new Estudiante("","","","","");
		estudiante[2] = new Estudiante("","","","","");
		
		estudiante[0].setApellido("Paez");
		estudiante[0].setNombre("David");
		estudiante[0].setComision("1A");
		estudiante[0].setEmail("david@alumno.com");
		estudiante[0].setDireccion("calle 5");
		
		estudiante[1].setApellido("Godoy");
		estudiante[1].setNombre("Bianka");
		estudiante[1].setComision("1B");
		estudiante[1].setEmail("bianka@alumno.com");
		estudiante[1].setDireccion("calle 8 y 20");
		
		estudiante[2].setApellido("Bento");
		estudiante[2].setNombre("Manuel");
		estudiante[2].setComision("1A");
		estudiante[2].setEmail("manuel@alumno.com");
		estudiante[2].setDireccion("calle 3");
		
		//profesor[0] = new Profesor("","","","","");
		//profesor[1] = new Profesor("","","","","");
		
		profesor[0].setApellido("Perez");
		profesor[0].setNombre("Juan");
		profesor[0].setEmail("perez@facultad.com");
		profesor[0].setCatedra("AyED");
		profesor[0].setFacultad("Informatica");
		
		profesor[1].setApellido("Gomez");
		profesor[1].setNombre("Maria");
		profesor[1].setEmail("gomez@facultad.com");
		profesor[1].setCatedra("AyED");
		profesor[1].setFacultad("Informatica");
		
        for(int i=0; i<3;i++){
            System.out.println(estudiante[i].tusDatos());
        }

        for(int i=0; i<2;i++){
            System.out.println(profesor[i].tusDatos());
        }
	}
}
~~~

</details>

***Agregue dos breakpoints, uno en la línea donde itera sobre los estudiantes y otro en la línea donde itera sobre los profesores Ejecute la clase Test en modo debug y avance paso a paso visualizando si el estudiante o el profesor recuperado es lo esperado.***

<details><summary> <code> Respuesta 🖱 </code></summary>
Al ingresar datos con los métodos setters hay un problema, pues cada uno de los valores de los atributos son null, para eso necesito antes utilizar un constructor ingresando datos desde ahí.
</details>

 ## 🟣 Punto 4 

***Pasaje de parámetros en Java: sin ejecutar el programa en su computadora, sólo analizándolo, indique qué imprime el siguiente código. Luego, ejecute el ejercicio en su computadora, y compare su resultado con lo esperado en el inciso anterior.***

<details><summary> <code> Respuesta 🖱 </code></summary>

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

En Java no existe el paso por referencia. El paso por valor es obligatorio.Lo que se almacena en una variable no primitiva no es el objeto en sí sino una dirección o identificador del objeto en el espacio dinámico de memoria. Cuando pasas por parámetros la variable, estás pasando una copia de dicha dirección.

La clase Integer (y también el resto de los wrappers de los tipos primitivos) no permiten que se pueda cambiar el valor que contienen. Por esta característica son clases inmutables.

</details>

***Inserte un breakpoint en las líneas donde se indica: <code>y = tmp</code> y ejecute en modo debug ¿los valores que adoptan las variables x, y coinciden con los valores impresos por consola?***

<details><summary> <code> Respuesta 🖱 </code></summary>

Al insertar un breakpoint en la linea <code>y = tmp</code> y ejecutar en modo debug notamos que los valores que adoptan las variables x, y no coinciden con los valores impresos por consola, esto es porque la clase Integer es inmutable (no permite que se pueda cambiar el valor que contiene).

![ImagenDebug](/AyEDproject/src/recursos/imagen01.png)

</details>


## 🟣 Punto 5

***Dado un arreglo de valores tipo entero se desea calcular el valor máximo, mínimo, y promedio en un único método. Escriba tres métodos de clase, donde respectivamente:***

* ***Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return").***

<details><summary> <code> Respuesta 🖱 </code></summary>

Lo que hago es un método que retorne un arreglo de double con el maximo, el minimo y el promedio. Otra forma podría ser también retornar un String, pero si necesito usar los datos para algo estos estarían dentro del String, entonces no está tan buena esa idea.

El punto **a)** se encuentra en el archivo [Enteros.java](/AyEDproject/src/practica01/Enteros.java).

~~~java
public static double[] Metodo1(int[] arreglo) {
    double[] aux = new double[3];
    aux[0] = -10000; // maximo
    aux[1] = 10000; // minimo
    aux[2] = 0; // prom
    for (int i = 0; i < arreglo.length; i++) {
        if (arreglo[i] > aux[0]) {
            aux[0] = arreglo[i];
        }
        if (arreglo[i] < aux[1]) {
            aux[1] = arreglo[i];
        }
        aux[2] += arreglo[i];
    }
    aux[2] = aux[2] / arreglo.length;
    return aux;
}
~~~

</details>

* ***Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede ser de
tipo arreglo).***

<details><summary> <code> Respuesta 🖱 </code></summary>

Usamos como parámetro un objeto con tres variables de instacia: max, min y prom.

El punto **b)** se encuentra en el archivo [Enteros.java](/AyEDproject/src/practica01/Enteros.java) y [ObjB.java](/AyEDproject/src/practica01/ObjB.java).

~~~java
public static void Metodo2(ObjB ob, int []arreglo){
    ob.setMax(-1);
    ob.setMin(9999);
    ob.setProm(0);

    for (int i = 0; i < arreglo.length; i++) {
        if (arreglo[i] > ob.getMax()) {
            ob.setMax(arreglo[i]);
        }
        if (arreglo[i] < ob.getMin()) {
            ob.setMin(arreglo[i]);
        }
        ob.setProm(ob.getProm() + arreglo[i]);
    }
    ob.setProm(ob.getProm() / arreglo.length);
}
~~~

</details>

* ***Devuelva lo pedido sin usar parámetros ni la sentencia "return".***

<details><summary> <code> Respuesta 🖱 </code></summary>

</details>

## 🟣 Punto 6

***Análisis de las estructuras de listas provistas por la API de Java.¿En qué casos ArrayList ofrece un mejor rendimiento que LinkedList? ¿Cuándo LinkedList puede ser más eficiente que ArrayList? ¿Qué diferencia encuentra en el uso de la memoria en ArrayList y LinkedList? ¿En qué casos sería preferible usar un ArrayList o un LinkedList?***

<details><summary> <code> click para ver resolución 🖱 </code></summary>

Internamente, ArrayList se implementa como una matriz ordinaria. Es por eso que insertar un elemento en medio requiere generar un espacio en el arreglo y luego colocar el nuevo elemento en la ranura libre. Obtener y configurar elementos (get, set) es rápido , ya que estas operaciones simplemente abordan el elemento de matriz relevante.

LinkedList tiene una estructura interna diferente. Se implementa como una lista con elementos interconectados: un conjunto de elementos distintos, cada uno de los cuales almacena referencias a los elementos siguientes y anteriores en la lista. Para insertar un elemento en el medio de dicha lista, solo necesita cambiar las referencias de sus futuros vecinos. Sin embargo, para obtener un elemento debe pasar por todos los anteriores. En otras palabras, las operaciones de obtención y configuración serán lentas.

Si hay que insertar (o eliminar) elementos con frecuencia en medio de la colección, es mejor usar LinkedList. En todos los demás casos, ArrayList funciona mejor.

</details>

## 🟣 Punto 7

***Uso de las estructuras de listas provistas por la API de Java. Para resolver este punto cree el paquete tp1.ejercicio7.***

* ***Escriba una clase llamada TestArrayList cuyo método main recibe una secuencia de números, los agrega a una lista de tipo ArrayList, y luego de haber agregado todos los números a la lista, imprime el contenido de la misma iterando sobre cada elemento.***

<details><summary> <code> Respuesta 🖱 </code></summary>

~~~java
package practica01.ejercicio7;

import java.util.ArrayList;
import java.util.Scanner;

public class TestArrayList {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in) ;
	    System.out.print("Ingrese un número: ");
	    int n = s.nextInt();
        ArrayList<Integer> lista = new ArrayList<>();
        while (n!=0){
            lista.add(n);
            System.out.print("Ingrese otro, para cortar ingrese 0: ");
            n = s.nextInt();
        }
        System.out.println("ArrayList: " + lista);
		s.close();
    }
}
~~~

</details>

* ***Si en lugar de usar un ArrayList en el inciso anterior hubiera usado un LinkedList ¿Qué diferencia encuentra respecto de la implementación? Justifique***

<details><summary> <code> Respuesta 🖱 </code></summary>

No hay mucha diferencia respecto a la implementación, sólo que debo importar **java.util.LinkedList** puesto que trabajo con un LinkedList, y además creo una LinkedList en lugar de una ArrayList. El resto es igual.

~~~java
package practica01.ejercicio7;

import java.util.LinkedList;    // <-- Importo java.util.LinkedList en lugar de java.util.ArrayList
import java.util.Scanner; 

public class TextLinkedList {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in) ;
	    System.out.print("Ingrese un número: ");
	    int n = s.nextInt();
        LinkedList<Integer> lista = new LinkedList<>(); // <-- Creo un arreglo LinkedList
        while (n!=0){
            lista.add(n);
            System.out.print("Ingrese otro, para cortar ingrese 0: ");
            n = s.nextInt();
        }
        System.out.println("LinkedList: " + lista);
        s.close();
    }
}
~~~

</details>
