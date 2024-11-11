package se.lexicon;

import se.lexicon.model.Person;

import java.util.HashSet;
import java.util.TreeSet;

public class HashSetExamples {

    public static void main(String[] args) {

        ex2();
    }

    public static void ex1() {

        TreeSet<String> countries = new TreeSet<>(); // No duplicates & Sorted
//        HashSet<String> countries = new HashSet<>(); // No Duplicates
        countries.add("Sweden");
        countries.add("Iran");
        countries.add("India");
        countries.add("USA");
        countries.add("Sweden"); // No Duplicates allowed.

        System.out.println(countries);
    }

    public static void ex2() {

        HashSet<Person> people = new HashSet<>();
        people.add(new Person(3, "John", "Doe", "jon@test.se"));
        people.add(new Person(1, "Alice", "Smith", "alice@test.se"));
        people.add(new Person(2, "Bob", "Johanson", "bob@test.se"));
        people.add(new Person(2, "Bob", "Johanson", "bob@test.se"));

        System.out.println(people.size());
    }
}
