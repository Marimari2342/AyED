package practica01;

public class SwapValores {
    public static void swap1 (int x, int y) { //x=1,y=2
        if (x < y) {        //1<2
            int tmp = x ;   //tmp=1
            x = y ;         //x=2
            y = tmp;        //y=1
        }
    }

    public static void swap2 (Integer x, Integer y) {   //x=3,y=4
        if (x < y) {        //3<4
            int tmp = x ;   //tmp=3
            x = y ;         //x=4
            y = tmp;        //y=3
        }
    }

    public static void main(String[] args) {
        int a = 1, b = 2;
        Integer c = 3, d = 4;
        swap1(a, b);        //paso parámetros --> solo se puede por valor
        swap2(c, d);
        System.out.println("a=" + a + " b=" + b);   //a=1 b=2
        System.out.println("c=" + c + " d=" + d);   //c=3 d=4 
    }
}
