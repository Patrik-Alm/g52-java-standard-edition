package se.lexicon;

import se.lexicon.model.Person;

import java.util.*;

public class ArrayListExamples {

    public static void main(String[] args) {
        ex7();
    }

    public static void ex0() {

        char[] letters = {'J', 'A', 'V', 'A'};

        System.out.println(Arrays.toString(letters));

        letters = addChar('!', letters);

        System.out.println(Arrays.toString(letters));
    }

    private static char[] addChar(char letter, char[] array) {
        int newLength = array.length;
        var newArray = Arrays.copyOf(array, array.length + 1);
        newArray[newLength] = letter;
        return newArray;
    }

    public static void ex1() {
        //Wrapper class = Integer
        //primitive type = int

        // <> = Generics, Generalizes what type of element.


        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(100); // [100]
        numbers.add(100); // [100, 100]
        numbers.add(400); // [100, 100, 400]
        numbers.add(300); // [100, 100, 400, 300]
        numbers.add(200); // [100, 100, 400, 300, 200]

        System.out.println(numbers);
        System.out.println("numbers.size() = " + numbers.size());

        //number[0]
        System.out.println("Access element with index 0 " + numbers.get(0));
        System.out.println("Access element with index 3 " + numbers.get(3));
//        System.out.println("Access element with index 5 " + numbers.get(5)); // Throws IndexOutOfBoundsException: Index 5 out of bounds for length 5


        Iterator<Integer> iterator = numbers.iterator();

        System.out.println("-----------Okay to modify or delete ----------");
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number.equals(400)) {
                iterator.remove();
            } else {
                System.out.println(number);
            }
        }


        System.out.println("---------For Print out - Not Modify------------");
        for (Integer number : numbers) {
            if (number == 400) {
                //Delete
//                numbers.remove(number); // throws exception: java.util.ConcurrentModificationException
            }

            System.out.println(number);
        }
    }

    public static void ex2() {

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(100);
        numbers.add(400);
        numbers.add(300);
        numbers.add(200);


//        boolean isRemoved = numbers.remove(new Integer(400)); // Deprecated
        boolean isRemoved = numbers.remove(Integer.valueOf(400)); // ✅

        System.out.println("-----Print with enhanced for-loop-------");
        for (Integer number : numbers) {
            System.out.println(number);
        }

        System.out.println("-----Print with index based for-loop-------");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(1));
        }

    }

    public static void ex3() {

        List<String> cars = new ArrayList<>();
        cars.add("Volvo");
        cars.add("VW");
        cars.add("Volvo");


        List<String> moreCars = new ArrayList<>();
        cars.add("Tesla M3");
        cars.add("Ford");

        cars.addAll(moreCars);

        for (String car : cars) {
            System.out.println(car);
        }


        System.out.println("cars.indexOf(\"Volvo\") = " + cars.indexOf("Volvo"));
        System.out.println("cars.lastIndexOf(\"Volvo\") = " + cars.lastIndexOf("Volvo"));
        System.out.println("cars.indexOf(\"Test\") = " + cars.indexOf("Test")); //-1


    }

    //?
    public static void ex4() {

        List<String> originalList = new ArrayList<>();
        originalList.add("D");
        originalList.add("C");
        originalList.add("A");
        originalList.add("B");
        originalList.add("a");

        List<String> referenceList = originalList;

        System.out.println("originalList = " + originalList.size());
        System.out.println("referenceList = " + referenceList.size());

//        ArrayList<String> copyListCast = originalList.clone();
    }

    public static void ex5() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(3);

//        numbers.sort(null);
        numbers.sort(Collections.reverseOrder());

        System.out.println(numbers);


        List<String> letters = new ArrayList<>();
        letters.add("D");
        letters.add("C");
        letters.add("A");
        letters.add("B");
        letters.add("a");

//        Collections.sort(letters);
        Collections.sort(letters, String.CASE_INSENSITIVE_ORDER);

        System.out.println(letters);
    }

    public static void ex6() {

        String test1 = "TEST";
        String test2 = "TEST";

        boolean isCompareToStrings = test1.equals(test2);

        System.out.println("isCompareToStrings = " + isCompareToStrings); // True

        System.out.println(test1.hashCode()); // Identical to test2
        System.out.println(test2.hashCode()); // Identical to test1
        System.out.println("test".hashCode()); // Different


        Person person1 = new Person(1, "Simon", "Elbrink", "simon@lexicon.se");
        Person person2 = new Person(1, "Simon", "Elbrink", "simon@lexicon.se");

        boolean isEqualPersons = person1.equals(person2);
        System.out.println("isEqualPersons = " + isEqualPersons);

        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
    }


    public static void ex7() {

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(3, "Bob", "Johanson", "bob@test.se"));
        people.add(new Person(1, "John", "Doe", "jon@test.se"));
        people.add(new Person(2, "Alice", "Smith", "alice@test.se"));


        System.out.println(people.size());

        // Using Natural Ordering implemented inside Person Class
        Collections.sort(people);

        System.out.println("\n------ Horizontal Print out------ ");
        for (Person person : people) { // Prints on Separate lines
            System.out.println(person);
        }

        System.out.println("\n------ Custom Sort------ ");

        // Anonymous inner class
//        Collections.sort(people, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getLastname().compareTo(o2.getLastname());
//            }
//        });

        //Same as above  - Lambda
//        Collections.sort(people, (Person o1, Person o2) -> o1.getLastname().compareTo(o2.getLastname()));

        // Method Reference
        Collections.sort(people, Comparator.comparing(Person::getLastname));


        for (Person person : people) {
            System.out.println(person);
        }

    }
}
