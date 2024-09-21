package practica01;
/*Punto 3 de la práctica1*/
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

    public String tusDatos() {
        return "Estudiante: " + this.getNombre() + " "+ this.getApellido() + 
        		".\n     Comision: "+ this.getComision() +"\n     Email: "+
        		this.getEmail() + ".\n     Direccion: "+ this.getDireccion()+".";
    }
}
