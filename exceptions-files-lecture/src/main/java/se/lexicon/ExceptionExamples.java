package se.lexicon;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ExceptionExamples {

    // NOT ALLOWED TO HAVE THROWS ON MAIN() METHOD!
    public static void main(String[] args) {

        // Unchecked (Runtime) Exception
//        int[] number = {1,2,3,4,5};
//        System.out.println(number[10]);


        // Checked (Compile Time) Exception
//        Path filePath = Paths.get("folder/TestHere.txt");
//        BufferedReader reader = Files.newBufferedReader(filePath);


//        LocalDate localDate = takeDateInput.get();


//        copyImage();
//        writeTextToFile();
//        writeTextToFileResource();
        readPeopleFromJSON();
    }

    //RunTime Exception
    //Potential problems:
    // Bigger, Lower, Letter, null(Empty)
    public static void takeScoreInput() {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter a score between 1-100: ");

            try {
                int score = Integer.parseInt(scanner.nextLine());

                if (score <= 0) {
                    System.out.println("Try Again - Score should not be zero or negative");
                } else if (score >= 101) {
                    System.out.println("Try Again - Score should be maximum 100");
                }

                System.out.println("Entered Score: " + score);

            } catch (NumberFormatException e) {
                System.out.println("Try Again - Invalid Input");
//                e.printStackTrace();
            }
        }
    }

    public static void takeDateInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Enter your birthDate (YYYY-MM-DD): ");

            try {
                String input = scanner.nextLine();
                LocalDate date = LocalDate.parse(input);
                System.out.println(date);

            } catch (DateTimeParseException ex) {
                System.out.println("Invalid date format. Please enter date in yyyy-mm-dd format. " + ex.getMessage());
//                ex.printStackTrace();

            }
        }
    }


    public static Supplier<LocalDate> takeDateInput = () -> {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = null;

        while (true) {
            System.out.println("Enter your birthDate (YYYY-MM-DD): ");
            try {
                String input = scanner.nextLine();
                date = LocalDate.parse(input);
                break;
            } catch (DateTimeParseException ex) {
                System.out.println("Invalid date format. Please enter date in yyyy-mm-dd format. " + ex.getMessage());
//                ex.printStackTrace();
            }
        }
        return date;
    };


    //   NIO (Non-Blocking style, reactive. - Not Covered much here.)

    //Checked (Compile Time) Exception
    //Files I/O, NIO
    public static void readTextFromFile() {
        //java.io
        //java.nio

//        Path filePath = Paths.get("C:\\Users\\lexicon-simon\\lexicon-course-code\\Java Group 52\\g52-java-standard-edition\\exceptions-files-lecture\\folder\\lastnames.txt");
        Path filePath = Paths.get("exceptions-files-lecture/folder/lastnames.txt");

        try {
            BufferedReader reader = Files.newBufferedReader(filePath);

//        List<String> lastnames = reader.lines()
//                                        .toList();
//        lastnames.forEach(System.out::println);

            Stream<String> lines = Files.lines(filePath);
            lines.forEach(System.out::println);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //Copy an Image to another folder using NIO
    public static void copyImage() {
        Path sourceFile = Paths.get("exceptions-files-lecture/source/Grogu.png");
        Path destinationPath = Paths.get("exceptions-files-lecture/destination");

        try {
            Files.createDirectory(destinationPath);
            Files.copy(sourceFile, destinationPath.resolve(sourceFile.getFileName())
                    ,StandardCopyOption.REPLACE_EXISTING
                    ,StandardCopyOption.COPY_ATTRIBUTES
            );

            //Specific Exception -> General Exception
        } catch (NoSuchFileException ex) {
            System.out.println("File Path does not exist: " + ex);
        } catch (FileAlreadyExistsException ex) {
            System.out.println("File Already Exists: " + ex);
        } catch (IOException ex) {
            System.out.println("IO Exception: " + ex);
        }
    }


    //Throw an exception with "throw" keyword
    public static void divide() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number 1: ");
        int number1 = scanner.nextInt();
        System.out.println("Enter number 2: ");
        int number2 = scanner.nextInt();

        if (number2 == 0) {
            throw new ArithmeticException("Number 2 should not be Zero.");
        }

        int result = number1 / number2;

        System.out.println("result = " + result);
    }

    //Throw our own Exception
    // and Throws Keyword
    //Mathematical it's okay, it's not okay in our bank transaction.(Business Logic)
    public static void withdrawal() throws InsufficientFundsException {

        double balance = 100;
        double amount = 150;
        System.out.println("Operation - Withdraw");
        System.out.println("Current balance: " + balance);
        System.out.println("Withdraw Amount: " + amount);

        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount, "Balance is Insufficient...");
        }

        balance = balance - amount;

        System.out.println("Current balance is: " + balance);
    }

    // throw: is used to throw an exception or exceptional event(propagate the exception to a higher-lever).
    // throws: is used to indicate that a method might throw one or more exceptions -- What about checked vs unchecked


    public static void writeTextToFile(){

        Path relativePath = Paths.get("exceptions-files-lecture/folder/TextHere.txt");

        BufferedWriter bufferedWriter = null;
        try{
             bufferedWriter = Files.newBufferedWriter(relativePath);
            bufferedWriter.write("Hello Group 52");
            bufferedWriter.newLine();

        }catch (IOException ex){
            System.out.println("An I/O Exception occurred: " + ex.getMessage());
        }finally { //Always running last
            System.out.println("Finally Block Executed");
            if (bufferedWriter != null){
                try{
                    bufferedWriter.close();
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }

    }

    public static void writeTextToFileResource(){
        Path relativePath = Paths.get("exceptions-files-lecture/folder/TextHere.txt");

        // Try with Resource - AutoCloses resources, if they implement AutoClosable Interface
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(relativePath
                ,StandardOpenOption.CREATE
                ,StandardOpenOption.APPEND)
        ){

            bufferedWriter.write("In the middle of difficulty lies opportunity. – Albert Einstein");
            bufferedWriter.newLine();
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }finally {
            // Will always run last
            //Clean up station
            System.out.println("Finally Block executed");
        }

    }
    //JSON File (READ / WRITE JSON file using Jackson)
    public static void savePeopleAsJSON(){

        List<Person> people = new ArrayList<>();

        people.add(new Person("Alice",30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charles", 35));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("exceptions-files-lecture/folder/people.json");


        try {
            objectMapper.writeValue(file,people);
            System.out.println("People data saved to File.");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void readPeopleFromJSON(){

        File file = new File("exceptions-files-lecture/folder/people.json");
        ObjectMapper objectMapper = new ObjectMapper();
        List<Person> people = null;

        try {
           people = objectMapper.readValue(file, new TypeReference<List<Person>>(){});

            System.out.println("People Data read from JSON file");

            people.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }






}