package alexrm84;

import java.util.LinkedList;

public class ChainsHashTableImplement implements HashTable {

    public static final Integer INVALID_COST = null;

    private class Entry{
        private Item key;
        private int value;

        public Entry(Item key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private LinkedList<Entry>[] data;
    private int size;
    private int maxSize;

    public ChainsHashTableImplement(int maxSize) {
        this.data = new LinkedList[maxSize];
        this.maxSize = maxSize;
    }

    private int hashFunc(int key){
        return key % data.length;
    }

    @Override
    public boolean put(Item item, Integer cost) {
        int index = hashFunc(item.hashCode());
        if (data[index]==null){
            data[index] = new LinkedList<>();
        }
        boolean check = true;
        for (Entry entry:data[index]) {
            if (entry.key.equals(item)){
                entry.value=cost;
                check=false;
            }
        }
        if (check){
            data[index].add(new Entry(item,cost));
            size++;
        }
        return true;
    }

    @Override
    public Integer get(Item item) {
        int index = hashFunc(item.hashCode());
        for (Entry entry:data[index]) {
            if (entry.key.equals(item)){
                return entry.value;
            }
        }
        return INVALID_COST;
    }

    @Override
    public boolean remove(Item item) {
        int index = hashFunc(item.hashCode());
        for (Entry entry:data[index]) {
            if (entry.key.equals(item)){
                data[index].remove(entry);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void display() {
        System.out.println("------------------------------");
        for (int i = 0; i < data.length; i++) {
            if (data[i]!=null){
                for (Entry entry:data[i]) {
                    System.out.println(String.format("%d = [%s]",i,entry));
                }
            }
        }
        System.out.println("------------------------------");
    }
}
