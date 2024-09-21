/*Punto 3 de la práctica1*/
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

    public String tusDatos() {
        return "Profesor: " + this.getNombre() + " "+ this.getApellido() + "\n     Email: "+
        		this.getEmail() + ".\n     Catedra: "+ this.getCatedra() + 
        		".\n     Facultad: "+ this.getFacultad()+".";
    }
}
