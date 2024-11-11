package se.lexicon;

import se.lexicon.model.Person;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {
        ex1();
    }


    public static void ex1() {

        HashMap<String, String> contacts = new HashMap<>();

        //add
        contacts.put("Simon", "Simon@lexicon.se");
        contacts.put("Mehrdad", "Mehrdad@lexicon.se");

        System.out.println(contacts.get("Simon"));

        System.out.println(contacts.containsKey("Mehrdad"));
        System.out.println(contacts.containsValue("Mehrdad@lexicon.se"));


        // After Lecture

        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        HashMap<String, Person> people = new HashMap<>();
        Person person1 = new Person(3, "John", "Doe", "jon@test.se");
        Person person2 = new Person(1, "Alice", "Smith", "alice@test.se");
        Person person3 = new Person(2, "Bob", "Johanson", "bob@test.se");

        people.put(person1.getEmail(), person1);
        people.put(person2.getEmail(), person2);
        people.put(person3.getEmail(), person3);

        System.out.println(people.get("bob@test.se"));

    }
}
