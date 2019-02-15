public class SortedArray<E extends Object & Comparable<? super E>> extends ArrayImplement<E> {

    @Override
    public void add(E value) {
        checkSize();
        int index;
        for (index = 0; index < size; index++) {
            if (data[index].compareTo(value)>0)
                break;
        }
        for (int i = size; i > index; i--) {
            data[i]=data[i-1];
        }
        data[index]=value;
        size++;
    }

    @Override
    public int indexOf(E value) {
        int min=0;
        int max=size-1;
        while (min<=max){
            int mid=(min+max)/2;
            if (data[mid].equals(value))
                return mid;
            if (data[mid].compareTo(value)>0)
                max=mid-1;
            else
                min=mid+1;
        }
        return INVALID_INDEX;
    }

    public int indexOfRec(E value, int min, int max){
        int mid=(min+max)/2;
        if (data[mid].equals(value))
            return mid;
        if (min>max) return INVALID_INDEX;
        if (data[mid].compareTo(value)>0) {
            return indexOfRec(value,min,mid-1);
        } else {
            return indexOfRec(value, mid+1, max);
        }

    }
}
