package alexrm84.twoside;

import alexrm84.LinkedList;

public interface TwoSideLinkedList<E> extends LinkedList<E> {

    void insertLeft(E value);
    void insertRight(E value);
    E removeLeft();
}
