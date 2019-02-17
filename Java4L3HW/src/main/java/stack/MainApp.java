package stack;

public class MainApp {

    public static void main(String[] args) {

        String str = "public static void main(String[] args)";
        Shifter shifter = new Shifter();
        System.out.println(str);
        System.out.println(shifter.shift(str));
    }
}
