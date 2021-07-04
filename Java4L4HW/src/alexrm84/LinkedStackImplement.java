package alexrm84;

public class LinkedStackImplement<E> implements Stack<E> {

    private LinkedList<E> data;

    public LinkedStackImplement() {
        this.data = new LinkedListImplement<>();
    }

    @Override
    public void push(E value) {
        data.insert(value);
    }

    @Override
    public E pop() {
        return data.remove();
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
    public boolean isFool() {
        return false;
    }

    @Override
    public int size() {
        return data.getSize();
    }
}
