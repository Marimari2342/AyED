package tp5.parciales;

public class Destino {
    //variables de instancia
    private String ciudad;
    private int dias;
    //constructor
    public Destino(String ciudad, int dias) {
        this.ciudad = ciudad;
        this.dias = dias;
    }
    //getters
    public String getCiudad() {
        return ciudad;
    }
    public int getDias() {
        return dias;
    }
    
}
