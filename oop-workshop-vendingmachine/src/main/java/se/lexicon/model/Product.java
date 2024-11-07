package se.lexicon.model;

public abstract class Product {

    private final int id;
    private double price;
    private String productName;

    public Product(int id, double price, String productName) {
        this.id = id;
        this.price = price;
        this.productName = productName;
    }

    /**
     * Abstract method to examine the product.
     *
     * @return A description of the product examination.
     */
    public abstract String examine();

    /**
     * Abstract method to use the product.
     *
     * @return A description of using the product.
     */
    public abstract String use();


    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

}
