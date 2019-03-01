package alexrm84;

public class Item {
    private int price;
    private int weight;
    private String name;

    public Item(String name, int price, int weight) {
        this.price = price;
        this.weight = weight;
        this.name=name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
