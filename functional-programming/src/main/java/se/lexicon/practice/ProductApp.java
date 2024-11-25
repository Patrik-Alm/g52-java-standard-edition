package se.lexicon.practice;

import java.util.ArrayList;
import java.util.List;

public class ProductApp {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Iphone 6s", 100.00, 0));
        products.add(new Product("Iphone 7", 120.00, 7));
        products.add(new Product("Iphone SE", 120.00, 0));
        products.add(new Product("Iphone 8", 150.00, 5));
        products.add(new Product("Iphone 13", 5600.00, 25));
        products.add(new Product("Iphone 16", 10000.00, 25));
        products.add(new Product("Book of Apples History", 1500.00, 5));

        //What


        // 1. Print out all Products that have a stock value of 0.
        //Action
        Action printProduct = (p) -> System.out.println(p.toString());
        //Condition
        Conditional conditionalForStockZero = (p) -> p.getStock() == 0;

        process(products, conditionalForStockZero, printProduct);


        // 2. Print out the productName of all the Products that starts with B.

        process(products,
                (p) -> p.getProductName().startsWith("B"),
                (p) -> System.out.println(p.getProductName())
        );


        // TODO: 3. Print out all Products that have price above 100 AND lower than 150
        // TODO: 4. Increase the price of all Products that have a stock value of less than 10 AND above 0 by 50%

    }


    //How
    public static void process(List<Product> list, Conditional conditional, Action action) {
        for (Product product : list) {
            if (conditional.test(product)) {
                action.execute(product);
            }
        }
    }


}
