package tp5.ejercicio5;

public class Persona {
    //variable de instancia
    private String nombre;
    private String domicilio;
    private String tipo; //tipo de persona (Jubilado, Empleado, etc.)
    private boolean percibioCobro;

    //Constructor
    public Persona(String nombre, String domicilio, String tipo) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.tipo = tipo;
        this.percibioCobro = false; //por defecto, no ha percibido cobro
    }
    //Getters
    public String getNombre() {
        return nombre;
    }   
    public String getDomicilio() {
        return domicilio;
    }
    public String getTipo() {
        return tipo;
    }
    public void setCobro(boolean cobro) {
        this.percibioCobro = cobro;
    }
    public boolean cumple() {
        return this.tipo.equals("Jubilado") && !this.percibioCobro;
    }

}
