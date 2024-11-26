package se.lexicon.util_function;

import java.util.*;
import java.util.function.Supplier;

/**
 * Supplier<T> - T get();
 * <p>
 * Example UseCase:
 * Supply Default value
 * Generate Random Value
 * Initialize value
 */
public class SupplierExamples {

    public static void main(String[] args) {

        Supplier<List<String>> init = () -> new ArrayList<>();

        List<String> list = init.get();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = Collections.emptyList();

        Supplier<String> sessionGenerator = () -> UUID.randomUUID().toString();


        System.out.println(sessionGenerator.get());

        System.out.println(takeDecimalInput.get());

    }

    public static Supplier<Double> takeDecimalInput = () ->{
        Double number;
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a Number: ");
                number = scanner.nextDouble();
                break;
            }catch (InputMismatchException e){
                System.out.println("Number is not valid!");
            }
        }

        return number;
    };




}
