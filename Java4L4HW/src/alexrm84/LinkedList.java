package alexrm84;

public interface LinkedList<E> {

    void insert(E value);
    E remove();
    boolean remove(E value);

    boolean isEmpty();
    int getSize();
    void setSize(int value);

    boolean find(E value);

    void display();

    E getFirstElement();

    Entry<E> getFirst();
    void  setFirst(Entry<E> value);
}
