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

