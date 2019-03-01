package alexrm84;

import java.util.HashSet;

public class Backpack {

    private final int MAX_WEIGHT=20;
    private int maxPrice=0;

    private HashSet<Item> items =new HashSet<>();
    private HashSet<Item> resultItems = new HashSet<>();


    public static void main(String[] args) {
        Backpack backpack =new Backpack();
        backpack.start();
        backpack.display();
    }

    public void start(){
        items.add(new Item("Ручка", 5, 1));
        items.add(new Item("Карандаш", 4, 1));
        items.add(new Item("Учебник", 20, 10));
        items.add(new Item("Тетрадь", 10, 5));
        items.add(new Item("Обед", 15, 15));
        selectionOfItemsSimple(items);
    }

    private int getCurrentWeight(HashSet<Item> newItems){
        int temp=0;
        for (Item item:newItems) {
            temp+=item.getWeight();
        }
        return temp;
    }

    private int getCurrentPrice(HashSet<Item> newItems){
        int temp=0;
        for (Item item:newItems) {
            temp+=item.getPrice();
        }
        return temp;
    }

    public void selectionOfItemsSimple(HashSet<Item> newItems){
        if (newItems.size()==0){
            return;
        }
        if (getCurrentWeight(newItems)<=MAX_WEIGHT){
            int check=getCurrentPrice(newItems);
            if (check>=maxPrice){
                maxPrice=check;
                resultItems=newItems;
            }
        }
        for (Item item:newItems) {
            HashSet<Item> newSet =new HashSet<>(newItems);
            newSet.remove(item);
            selectionOfItemsSimple(newSet);
        }
    }

    private void display(){
        System.out.println("Оптимальный состав предметов дающий "+maxPrice+" состоит из:");
        for (Item item:resultItems) {
            System.out.print(item.getName()+" ");
        }
    }
}
