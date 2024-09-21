
/*Punto 5 de la práctica1*/
public class NumerosEnteros {
    
    /*Usamos atributos, getters y setters para el metodo3*/
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

    //PUNTO (a)
    public static double[] metodo1(int[] arreglo){
        double[] aux = new double[3];
        aux[0] = -100000; //maximo
        aux[1] = 100000; //minimo
        aux[2] = 0; //promedio
        for (int i=0;i<arreglo.length;i++){
            if (arreglo[i]>aux[0]){     //valor maximo
                aux[0]=arreglo[i];
            }
            if (arreglo[i]<aux[1]){     //valor minimo
                aux[1]=arreglo[i];
            }
            aux[2]+=arreglo[i];         //valor promedio
        }
        aux[2]=aux[2]/arreglo.length;
        return aux;
    }
    
    //PUNTO (b)
    public static void metodo2(int[] arreglo, Resultados resultados){
        resultados.setMax(arreglo[0]);
        resultados.setMin(arreglo[0]);
        resultados.setProm(0);
        int aux=0;
        for (int i=0;i<arreglo.length;i++){
            if(arreglo[i]>resultados.getMax()){     //maximo
                resultados.setMax(arreglo[i]);
            }
            if(arreglo[i]<resultados.getMin()){     //minimo
                resultados.setMin(arreglo[i]);
            }
            aux+=arreglo[i];                        //promedio
        }
        resultados.setProm(aux/arreglo.length);
    }

    //PUNTO (c)
    public void metodo3(int[] arreglo){
        this.setMax(arreglo[0]);
        this.setMin(arreglo[0]);
        this.setProm(0);
        int aux=0;
        for (int i=0;i<arreglo.length;i++){
            if(arreglo[i]>this.getMax()){        //maximo
                this.setMax(arreglo[i]);
            }
            if(arreglo[i]<this.getMin()){        //minimo
                this.setMin(arreglo[i]);
            }
            aux+=arreglo[i];                    //promedio
        }
        this.setProm(aux/arreglo.length);
    }
}

