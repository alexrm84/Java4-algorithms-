package stack;

public class StackImplement<E> implements Stack<E> {
    private E[] data;
    private int size;

    public StackImplement(int maxSize) {
        this.size=0;
        this.data = (E[]) new Object[maxSize];
    }

    @Override
    public void push(E value) {
        data[size++]=value;
    }

    @Override
    public E pop() {
        return data[--size];
    }

    @Override
    public E peek() {
        return data[size-1];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFool() {
        return size==data.length;
    }

    @Override
    public int size() {
        return size;
    }
}
