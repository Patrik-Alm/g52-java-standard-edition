package se.lexicon;

import java.util.HashMap;

public class HashMapExample {

    public static void main(String[] args) {
        ex1();
    }


    public static void ex1(){

        HashMap<String, String> contacts = new HashMap<>();

        //add
        contacts.put("Simon", "Simon@lexicon.se");
        contacts.put("Mehrdad", "Mehrdad@lexicon.se");

        System.out.println(contacts.get("Simon"));

        System.out.println(contacts.containsKey("Mehrdad"));
        System.out.println(contacts.containsValue("Mehrdad@lexicon.se"));

    }
}
