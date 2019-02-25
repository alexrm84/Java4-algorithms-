package alexrm84.twoside;

public class LinkedQueueImplement<E> implements Queue<E> {

    TwoSideLinkedList<E> data;

    public LinkedQueueImplement() {
        this.data = new TwoSideLinkedListImplement<>();
    }

    @Override
    public void insert(E value) {
        data.insertRight(value);
    }

    @Override
    public E remove() {
        return data.removeLeft();
    }

    @Override
    public E peek() {
        return data.getFirstElement();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return data.getSize();
    }
}
