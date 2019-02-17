package queue;

import java.io.DataOutputStream;

public class MainApp {
    public static void main(String[] args) {
//        Queue<Integer> queue = new QueuePriority<Integer>(5);
//        insert(queue, 2);
//        insert(queue, 1);
//        insert(queue, 4);
//        insert(queue, 5);
//        insert(queue, 3);
//        insert(queue, 222);
//
//        System.out.println("Size: " + queue.size());
//        System.out.println("Peek: " + queue.peek());
//
//        while (!queue.isEmpty()) {
//            System.out.println(remove(queue));
//        }


        DequeImplement<Integer> dec = new DequeImplement<Integer>(5);

        insertLeft(dec,1);
        insertLeft(dec,2);
        insertLeft(dec,3);
        insertRight(dec,4);
        insertRight(dec,5);
        while (!dec.isEmpty()) {
            System.out.println(removeRight(dec));
        }

        System.out.println("");

        insertLeft(dec,1);
        insertLeft(dec,2);
        insertLeft(dec,3);
        insertRight(dec,4);
        insertRight(dec,5);
        while (!dec.isEmpty()) {
            System.out.println(removeLeft(dec));
        }
    }

    private static <E> E remove(Queue<E> queue) {
        if (!queue.isEmpty())
            return queue.remove();
        return null;
    }

    private static <E> void insert(Queue<E> queue, E value) {
        if (!queue.isFull())
            queue.insert(value);
    }

    private static <E> E removeRight(DequeImplement<E> dec) {
        if (!dec.isEmpty())
            return dec.removeRight();
        return null;
    }

    private static <E> void insertRight(DequeImplement<E> dec, E value) {
        if (!dec.isFull())
            dec.insertRight(value);
    }

    private static <E> E removeLeft(DequeImplement<E> dec) {
        if (!dec.isEmpty())
            return dec.removeLeft();
        return null;
    }

    private static <E> void insertLeft(DequeImplement<E> dec, E value) {
        if (!dec.isFull())
            dec.insertLeft(value);
    }
}
