package alexrm84.twoside;

public interface Queue<E> {

    void insert(E value);
    E remove();
    E peek();

    boolean isEmpty();
    boolean isFull();
    int size();
}
