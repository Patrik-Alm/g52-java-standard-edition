package se.lexicon.util_function;


import se.lexicon.functional_interfaces.practice.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer<T> - void accept(T t);
 * <p>
 * Example Use Case:
 * Print element of a collection
 * Modify element in a collection
 * Perform an action on the element while iterating
 */
public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<String> msg = (message) -> System.out.println(message);

        msg.accept("Hello Group 52");

        List<Product> products = new ArrayList<>();
        products.add(new Product("Iphone 6s", 100.00, 0));
        products.add(new Product("Iphone 7", 120.00, 7));
        products.add(new Product("Iphone SE", 120.00, 0));
        products.add(new Product("Iphone 8", 150.00, 5));
        products.add(new Product("Iphone 13", 5600.00, 25));
        products.add(new Product("Iphone 16", 10000.00, 25));
        products.add(new Product("Book of Apples History", 1500.00, 5));

        Consumer<Product> printProductName = (p) -> System.out.println(p.getProductName().toUpperCase());

//        for (Product product: products){
//            printProductName.accept(product);
//        }

        products.forEach(printProductName);

        products.forEach(
                (product)-> System.out.println(product.getPrice())
        );






    }

}
