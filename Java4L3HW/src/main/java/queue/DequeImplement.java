package queue;

public class DequeImplement<E extends Object > extends QueueImplement<E> {

    public static final int DEFAULT_REAR = -1;
    public static final int DEFAULT_FRONT = 0;

    private int rear;
    private int front;

    protected int size;
    protected E[] data;

    public DequeImplement(int maxSize) {
        super(maxSize);
        this.size=0;
        this.data=(E[]) new Object[maxSize];
        this.front = DEFAULT_FRONT;
        this.rear = DEFAULT_REAR;
    }

    public void insertLeft(E value) {
        if (front==0)
            front=data.length;
        data[--front]=value;
        size++;
    }

    public void insertRight(E value) {
        if (rear==data.length-1)
            rear=DEFAULT_REAR;
        data[++rear]=value;
        size++;
    }

    public E removeLeft() {
        E value = data[front++];
        if (front==data.length)
            front=DEFAULT_FRONT;
        size--;
        return value;
    }

    public E removeRight() {
        E value = data[rear--];
        if (rear==DEFAULT_REAR)
            rear=data.length-1;
        size--;
        return value;
    }

    public E peekLeft() {
        return data[front];
    }

    public E peekRight() {
        return data[rear];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==data.length;
    }

    public int size() {
        return size;
    }
}
