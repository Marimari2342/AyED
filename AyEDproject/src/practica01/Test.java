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
		
		System.out.println("Estudiantes:");
        for(int i=0; i<3;i++){
            System.out.println(estudiante[i].tusDatos());
        }
        System.out.println("Profesores:");
        for(int i=0; i<2;i++){
            System.out.println(profesor[i].tusDatos());
        }

	}

}
