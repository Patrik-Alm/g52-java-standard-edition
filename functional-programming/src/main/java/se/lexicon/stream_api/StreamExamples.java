package se.lexicon.stream_api;

import se.lexicon.stream_api.model.Gender;
import se.lexicon.stream_api.model.Person;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {
    public static void main(String[] args) {

        ex10();
    }

    // Terminal Operation: Count
    public static void ex1() {
        Stream<String> skills = Stream.of("Java", "C#", "Python", "C++");

        long count = skills.count();
        System.out.println(count); //4

    }

    // Terminal Operation: forEach
    public static void ex2() {
        Stream<Integer> iterate = Stream.iterate(0, integer -> integer + 1);
        iterate.forEach(integer -> System.out.println(integer));
    }

    // Terminal Operation: count
    public static void ex3() {
        Person person1 = new Person(1, "Tobias", "Engberg", LocalDate.parse("1999-02-02"), Gender.MALE);
        Person person2 = new Person(2, "Marcus", "Gudmundsen", LocalDate.parse("1998-03-02"), Gender.MALE);
        Person person3 = new Person(3, "Simon", "Elbrink", LocalDate.parse("1997-01-02"), Gender.MALE);

        Stream<Person> personStream = Stream.of(person1, person2, person3);

        long count = personStream.count();

    }

    // Terminal Operation: Min / Max
    public static void ex4() {
        List<Integer> numbers = Arrays.asList(2, 100, 1, 12, 100000, 20000);

        Comparator<Integer> compareWithLambda = (n1, n2) -> n1.compareTo(n2);

        Optional<Integer> optionalOfMinValue = numbers.stream().min(compareWithLambda);

        if (optionalOfMinValue.isPresent()) {
            System.out.println("Min value is: " + optionalOfMinValue.get());
        } else {
            System.out.println(" No min number found");
        }
    }


    // Terminal Operation: findFirst() / FindAny
    public static void ex5() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Bob", "David", "Eve");

        String foundName = names.stream().findFirst().orElseThrow(() -> new IllegalArgumentException("Element Not found"));

        System.out.println("foundName = " + foundName);

    }

    public static void ex6() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 12, 13);

        Predicate<Integer> isEven = integer -> integer % 2 == 0;

        boolean isAllMatch = numbers.stream().allMatch(isEven);
        System.out.println("isAllMatch = " + isAllMatch); // False

        boolean isAnyMatch = numbers.stream().anyMatch(isEven);
        System.out.println("isAnyMatch = " + isAnyMatch); // True

        boolean isNoneMatch = numbers.stream().noneMatch(isEven);
        System.out.println("isNoneMatch = " + isNoneMatch); // False

    }

    // Terminal Operation: Collect
    public static void ex7() {
        List<String> names = Arrays.asList("Niclas", "Erik", "Ulf", "Kent", "Fredrik", "Fredrik");

        long count = names.stream().distinct().count();
        System.out.println("count = " + count);

        Set<String> string = names.stream().collect(Collectors.toSet());
        System.out.println("string = " + string);

    }

    // Intermediate Operation: filter()
    public static void ex8() {
        List<Integer> numbers = Arrays.asList(1, -7, 10, 26, -123, 32, 11, 7, 19);

        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n % 2 != 0) // Intermediate Operation
                .filter(n -> n > 0) // Intermediate Operation
                .collect(Collectors.toList()); // Terminal Operation

        System.out.println(oddNumbers);
    }

    // Intermediate Operation: skip() & limit()
    public static void ex9() {
        Stream<Integer> iterate =
                Stream.iterate(0, integer -> integer + 1)
                        .skip(15)
                        .limit(120);
        iterate.forEach(integer -> System.out.println(integer));

        List<String> names = Arrays.asList("Erik", "Ulf", "Niclas", "Fredrik", "Marcus", "Kent");

        names.stream()
                .skip(3)
                .limit(2)
                .forEach(s -> System.out.println(s)); //Fredrik, Marcus
    }

    // Intermediate Operation: map() & sorted()
    public static void ex10() {

        List<Person> people = Arrays.asList(
                new Person(1, "Alice", "Johnson", LocalDate.parse("1990-05-15"), Gender.FEMALE),
                new Person(2, "Bob", "Smith", LocalDate.parse("1985-08-20"), Gender.MALE),
                new Person(3, "Emily", "Davis", LocalDate.parse("1993-02-10"), Gender.FEMALE),
                new Person(4, "John", "Doe", LocalDate.parse("1988-11-30"), Gender.MALE),
                new Person(5, "Olivia", "Brown", LocalDate.parse("1987-04-25"), Gender.FEMALE),
                new Person(6, "Michael", "Williams", LocalDate.parse("1991-09-05"), Gender.MALE),
                new Person(7, "Sophia", "Martinez", LocalDate.parse("1989-07-12"), Gender.FEMALE),
                new Person(8, "Daniel", "Johnson", LocalDate.parse("1995-03-18"), Gender.MALE),
                new Person(9, "Ella", "Taylor", LocalDate.parse("1992-06-28"), Gender.FEMALE),
                new Person(10, "William", "Anderson", LocalDate.parse("1986-12-03"), Gender.MALE),
                new Person(11, "Ava", "Garcia", LocalDate.parse("1994-01-08"), Gender.FEMALE),
                new Person(12, "Alexander", "Brown", LocalDate.parse("1984-10-17"), Gender.MALE),
                new Person(13, "Charlotte", "Miller", LocalDate.parse("1990-08-22"), Gender.FEMALE),
                new Person(14, "James", "Wilson", LocalDate.parse("1983-06-14"), Gender.MALE),
                new Person(15, "Isabella", "Moore", LocalDate.parse("1988-04-07"), Gender.FEMALE)
        );

        Function<Person, String> extractPersonName = p -> p.getFirstName() + " " + p.getLastName();

        people.stream()
                .map(extractPersonName)
                .sorted()
                .forEach(name -> System.out.println(name));

        people.stream()
                .sorted((p1, p2) -> p1.getDateOfBirth().compareTo(p2.getDateOfBirth()))
                .forEach(person -> System.out.println(person));


    }


}
