package queue;

public class QueueImplement<E> implements Queue<E> {

    public static final int DEFAULT_REAR = -1;
    public static final int DEFAULT_FRONT = 0;

    private int rear;
    private int front;

    protected int size;
    protected E[] data;

    public QueueImplement(int maxSize) {
        this.size=0;
        this.data=(E[]) new Object[maxSize];
        this.front = DEFAULT_FRONT;
        this.rear = DEFAULT_REAR;
    }

    @Override
    public void insert(E value) {
        if (rear==data.length-1)
            rear=DEFAULT_REAR;
        size++;
        data[++rear]=value;
    }

    @Override
    public E remove() {
        E value = data[front++];
        if (front==data.length)
            front=DEFAULT_FRONT;
        size--;
        return value;
    }

    @Override
    public E peek() {
        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==data.length;
    }

    @Override
    public int size() {
        return size;
    }
}
