package alexrm84;

public interface Tree<E extends Comparable<? super E>> {

    enum TraversMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    void add(E value);

    boolean remove(E value);

    boolean find(E value);

    void display();

    boolean isEmpty();

    void travers(TraversMode traversMode);
}
