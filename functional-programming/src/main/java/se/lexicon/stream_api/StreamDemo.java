package se.lexicon.stream_api;

import se.lexicon.stream_api.model.Gender;
import se.lexicon.stream_api.model.Person;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamDemo {

    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
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

        //Imperative Style - How

        System.out.println("---------- Print Born on Leap Year ----------");
        for (Person person: personList){
            if (person.getDateOfBirth().isLeapYear()){
                System.out.println(person);
            }
        }

        System.out.println("---------- Print Female ----------");
        for (Person person : personList){
            if (person.getGender() == Gender.FEMALE){
                System.out.println(person);
            }
        }

        //-----------


        Predicate<Person> isLeapYear = person -> person.getDateOfBirth().isLeapYear();
        Predicate<Person> isFemale = person -> person.getGender() == Gender.FEMALE;
        Consumer<Person> printPerson = person -> System.out.println(person);


        process(personList, isLeapYear, printPerson);

        process(personList,isFemale,
                person -> System.out.println(person.getFirstName())
        );





        //Declarative Style - What
        personList.stream()
                .filter(isLeapYear)
                .filter(isFemale)
                .forEach(printPerson);


    }

    //Generics is used here
    public  static <T> void process (List<T> list, Predicate<T> predicate, Consumer<T> consumer){
        for (T t : list){
            if (predicate.test(t)){
                consumer.accept(t);
            }
        }
    }


}
