package se.lexicon.model;

public class Fruit extends Product {

    private final String color;

    public Fruit(int id, String fruitType, String color, double price) {
        super(id, price, fruitType);
        this.color = color;
    }

    @Override
    public String examine() {
        return "{ id: " + getId() + ", fruit: " + color + " " + getProductName() + " }";
    }

    @Override
    public String use() {
        return getProductName() + " taste delicious!";
    }


}
