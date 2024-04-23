package practica02.ejercicio9;

public class SumaDiferencia {

    private int suma;
    private int dif;

    public SumaDiferencia(int s, int d) {
        suma = s;
        dif = d;
    }

    public int getSuma() {
        return suma;
    }

    public int getDif() {
        return dif;
    }

    public void setSuma(int s) {
        this.suma = s;
    }

    public void setDif(int d) {
        this.dif = d;
    }

    public String toString() {
        return "Suma: " + suma + " Diferencia: " + dif;
    }

}
