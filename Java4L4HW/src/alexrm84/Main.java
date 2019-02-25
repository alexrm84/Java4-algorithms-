package alexrm84;

public class Main {

    public static void main(String[] args) {
        LinkedListImplement<Integer> list = new LinkedListImplement<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.display();
        list.remove();
        list.remove(2);
        for (Integer e : list) {
            System.out.print(e+" ");
        }
    }
}
