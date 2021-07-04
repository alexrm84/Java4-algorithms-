package alexrm84.twoside;

import alexrm84.Entry;
import alexrm84.LinkedListImplement;

public class TwoSideLinkedListImplement<E> extends LinkedListImplement<E> implements TwoSideLinkedList<E> {

    private Entry<E> lastElement;

    @Override
    public void insertLeft(E value) {
        super.insert(value);
        if (getSize() == 1){
            lastElement = (Entry<E>) getFirstElement();
        }
    }

    @Override
    public void insertRight(E value) {
        Entry<E> newElement = new Entry<>(value);
        if (isEmpty()){
            setFirst(newElement);
        }else {
            lastElement.setNext(newElement);
        }
        lastElement=newElement;
        setSize(getSize()+1);

    }

    @Override
    public E removeLeft() {
        E removedElement = super.remove();
        if (isEmpty()){
            lastElement=null;
        }
        return removedElement;
    }

    public boolean remove(E value) {
        Entry<E> current = (Entry<E>) getFirstElement();
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
        if (current==(Entry<E>)getFirstElement()){
            setFirst(((Entry<E>)getFirstElement()).getNext());
        }else if (current == lastElement){
            lastElement = previous;
            previous.setNext(null);
        }else{
            previous.setNext(current.getNext());
        }
        setSize(getSize()-1);
        return true;
    }
}
