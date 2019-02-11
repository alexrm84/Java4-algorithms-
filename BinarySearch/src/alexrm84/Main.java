package alexrm84;

public class Main {

    public static void main(String[] args) {
        int massSize=10000;
        int[] mass = new int[massSize];
        for (int i = 0; i < massSize; i++) {
            mass[i]=i+5;
        }
        System.out.println("Индекс искомова числа= "+findNumber(mass,0,massSize-1,11,1));
    }

    public static int findNumber(int[] mass, int min, int max, int needN, int count){
        if (mass[(min+max)/2]==needN) {
            System.out.println("Количество проверок= "+count);
            return (min+max)/2;
        }
        if (min>max) return -1;
        if (mass[(min+max)/2]<needN) {
            return findNumber(mass,(min+max)/2+1,max,needN,count+1);
        } else {
            return findNumber(mass, min, (min+max)/2-1,needN,count+1);
        }
    }
}
