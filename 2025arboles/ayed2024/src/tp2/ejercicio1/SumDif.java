package tp2.ejercicio1;

public class SumDif {
    //variables de instancia
    private int suma;
    private int diferencia;
    //constructor
    public SumDif(int suma, int diferencia) {
        this.suma = suma;
        this.diferencia = diferencia;
    }
    //getters
    public int getSuma() {
        return suma;
    }   
    public int getDiferencia() {
        return diferencia;
    }
    //setters
    public void setSuma(int suma) {
        this.suma = suma;
    }
    public void setDiferencia(int diferencia) {
        this.diferencia = diferencia;
    }

    @Override
    public String toString() {
        return "Suma: " + suma + ", Diferencia: " + diferencia;
    }
}
