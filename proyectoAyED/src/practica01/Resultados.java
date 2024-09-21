/*Punto 5 de la práctica1 (clase auxiliar para el punto B)*/
public class Resultados {
    private int maximo;
    private int minimo;
    private double promedio;

    //getters
    public int getMax(){
        return this.maximo;
    }

    public int getMin(){
        return this.minimo;
    }

    public double getProm(){
        return this.promedio;
    }
    
    //setters
    public void setMax(int num){
        this.maximo=num;
    }

    public void setMin(int num){
        this.minimo=num;
    }

    public void setProm(double num){
        this.promedio=num;
    }
}
