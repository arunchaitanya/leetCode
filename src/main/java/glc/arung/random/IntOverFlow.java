package glc.arung.random;

public class IntOverFlow{

    public static void main(String[] args){
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int max_1 = max*max;
        int temp = Integer.parseInt("3247483647");
        System.out.println("max overflow is " + temp);
        System.out.println("max is "+ max_1 + " min is "+ min);
    }

}