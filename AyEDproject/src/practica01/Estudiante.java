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
	
	public String tusDatos() {
        return "Estudiante: " + this.getNombre() + " "+ this.getApellido() + 
        		".\n     Comision: "+ this.getComision() +"\n     Email: "+
        		this.getEmail() + ".\n     Direccion: "+ this.getDireccion()+".";
    }
	
}
