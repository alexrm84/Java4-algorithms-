import java.util.Arrays;

public class ArrayImplement<E extends Object & Comparable<? super E>> implements Array<E> {

    protected  static final int INVALID_INDEX = -1;
    private static final int DEFAULT_CAPACITY = 16;

    protected int size;
    protected E[] data;

    public ArrayImplement(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayImplement(int initialSize){
        this.data = (E[]) new Object[initialSize];
    }


    @Override
    public void add(E value) {
        checkSize();
        data[size++]=value;
    }

    protected void checkSize(){
        if (size==data.length)
            data = Arrays.copyOf(data,data.length*2);
    }

    @Override
    public E get(int index) {
        return data[index];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1 ? true : false;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value))
                return i;
        }
        return -1;
    }

    @Override
    public boolean remove(E value) {
        return removeByIndex(indexOf(value));
    }

    @Override
    public void remove(int index) {
        if (!removeByIndex(index))
            throw new ArrayIndexOutOfBoundsException(index);
    }

    private boolean removeByIndex(int index){
        if (index==INVALID_INDEX || index<0 || index>=size){
            return false;
        }

        for (int i = index; i < size-1; i++) {
            data[i]=data[i+1];
        }
        data[size-1]=null;
        size--;
        return true;
    }

    @Override
    public boolean isAmpty() {
        return size==0;
    }

    @Override
    public void sortBubble() {
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size-1; j++) {
                if (data[j].compareTo(data[j+1])>0)
                    change(j,j+1);
            }
        }
    }

    @Override
    public void sortSelect() {
        for (int i = 0; i < size-1; i++) {
            int min=i;
            for (int j = i+1; j < size; j++) {
                if (data[j].compareTo(data[min])<0)
                    min=j;
            }
            change(min,i);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i <size ; i++) {
            E temp = data[i];
            int j=i;
            while (j>0 && data[j-1].compareTo(temp)>=0){
                data[j]=data[j-1];
                j--;
            }
            data[j]=temp;
        }
    }

    void change(int index1,int index2){
        E temp=data[index1];
        data[index1]=data[index2];
        data[index2]=temp;
    }
}
