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
	
	public String tusDatos() {
        return "Profesor: " + this.getNombre() + " "+ this.getApellido() + "\n     Email: "+
        		this.getEmail() + ".\n     Catedra: "+ this.getCatedra() + 
        		".\n     Facultad: "+ this.getFacultad()+".";
    }
	

}
