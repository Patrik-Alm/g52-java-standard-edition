package se.lexicon.functional_interfaces.practice;

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


        System.out.println("----------------- Exercise 1 -----------------");
        // 1. Print out all Products that have a stock value of 0.
        //Action
        Action printProduct = (p) -> System.out.println(p.toString());
        //Condition
        Conditional conditionalForStockZero = (p) -> p.getStock() == 0;

        process(products, conditionalForStockZero, printProduct);


        System.out.println("----------------- Exercise 2 -----------------");
        // 2. Print out the productName of all the Products that starts with B.

        process(products,
                (p) -> p.getProductName().startsWith("B"),
                (p) -> System.out.println(p.getProductName())
        );


        System.out.println("----------------- Exercise 3 -----------------");
        // 3. Print out all Products that have price above 100 AND lower than 150

        process(products, p -> p.getPrice() >= 100 && p.getPrice() <= 150, printProduct  );


        System.out.println("----------------- Exercise 4 -----------------");
        // 4. Increase the price of all Products that have a stock value of less than 10 AND above 0 by 50%
        process(products,
                p ->  p.getStock() < 10 && p.getStock() > 0,    //Check conditional
                p -> p.setPrice(p.getPrice() * 1.5 )            //Increase the price by 50%
                );

        products.forEach(
                product -> System.out.println(product.toString())
        );

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
