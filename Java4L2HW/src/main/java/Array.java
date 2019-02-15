public interface Array<E> {


    void add(E value);

    E get(int index);

    int getSize();

    boolean contains(E value);

    int indexOf(E value);

    boolean remove(E value);
    void remove(int index);

    boolean isAmpty();

    void sortBubble();
    void sortSelect();
    void sortInsert();
}
