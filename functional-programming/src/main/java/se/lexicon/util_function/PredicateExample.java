package se.lexicon.util_function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate<T> - boolean test(T t);
 * <p>
 * Example UseCase:
 * Filtering in a Collection
 * Select element from a Stream
 * Writing more concise and expressive code when dealing with condition(if statements)
 */
public class PredicateExample {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = -10; i <=30; i++ ){
            numbers.add(i);
        }

        System.out.println(numbers);

        Predicate<Integer> isPositive = (number) -> number > 0;
        Predicate<Integer> isEven = number -> number % 2 == 0;
//        Predicate<Integer> isOdd = number -> number % 2 != 0;


        System.out.println(filterNumbers(numbers, isPositive));
        System.out.println(filterNumbers(numbers, isPositive.and(isEven)));
        System.out.println(filterNumbers(numbers, isEven.negate()));



    }

    public static List<Integer> filterNumbers(List<Integer> numbers, Predicate<Integer> predicate){
        List<Integer> filteredNumbers = new ArrayList<>();

        for (Integer number: numbers){
            if (predicate.test(number)){
                filteredNumbers.add(number);
            }
        }
        return filteredNumbers;
    }

}
