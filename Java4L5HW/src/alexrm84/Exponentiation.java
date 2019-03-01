package alexrm84;

public class Exponentiation {

    public static void main(String[] args) {
        System.out.println(getResult(5,3));
        System.out.println(getResult(5,0));
        System.out.println(getResult(5,-3));
    }

    public static double getResult(int number,int degree){
        if (degree==0){
            return 1;
        }
        if (degree<0){
            return 1/getResult(number,Math.abs(degree));
        }
        return number*getResult(number,degree-1);
    }
}
