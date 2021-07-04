package alexrm84;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListImplement<E> implements LinkedList<E>, Iterable<E> {

    private Entry<E> firstElement;
    private int size;

    public Iterator<E> iterator(){
        return new LinkedListImplementIterator();
    }

    private class LinkedListImplementIterator implements Iterator<E>{

        Entry<E> current;

        public LinkedListImplementIterator() {
            this.current = LinkedListImplement.this.getFirst();
        }

        @Override
        public E next() {
            if (!this.hasNext()){
                throw new NoSuchElementException();
            }
            E value = current.getValue();
            current=current.getNext();
            return value;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }
    }

    @Override
    public void insert(E value) {
        Entry<E> newElement = new Entry<>(value);
        newElement.setNext(firstElement);
        firstElement = newElement;
        size++;
    }

    @Override
    public E remove() {
        if (isEmpty()){
            return null;
        }
        E temp = firstElement.getValue();
        firstElement = firstElement.getNext();
        size--;
        return temp;
    }

    @Override
    public boolean remove(E value) {
        Entry<E> current = firstElement;
        Entry<E> previous = null;
        while (current != null){
            if (current.getValue().equals(value)){
                break;
            }
            previous = current;
            current = current.getNext();
        }
        if (current==null){
            return false;
        }
        if (current==firstElement){
            firstElement = firstElement.getNext();
        }else{
            previous.setNext(current.getNext());
        }
        size--;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int value) {
        this.size = value;
    }

    @Override
    public boolean find(E value) {
        Entry<E> current = firstElement;
        while (current != null){
            if (current.getValue().equals(value)){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public void display() {
        System.out.println("display " + this.getClass().getSimpleName());
        Entry<E> current = firstElement;
        while (current != null){
            System.out.print(current.getValue()+" ");
            current = current.getNext();
        }
        System.out.println();
    }

    @Override
    public E getFirstElement() {
        return firstElement.getValue();
    }

    @Override
    public Entry<E> getFirst() {
        return firstElement;
    }

    @Override
    public void setFirst(Entry<E> value) {
        firstElement=value;
    }
}
