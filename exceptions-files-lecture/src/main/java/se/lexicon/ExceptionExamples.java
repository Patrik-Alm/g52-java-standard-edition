package se.lexicon;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.function.Supplier;

public class ExceptionExamples {
    public static void main(String[] args) {

        // Unchecked (Runtime) Exception
//        int[] number = {1,2,3,4,5};
//        System.out.println(number[10]);


        // Checked (Compile Time) Exception
//        Path filePath = Paths.get("folder/TestHere.txt");
//        BufferedReader reader = Files.newBufferedReader(filePath);


        LocalDate localDate = takeDateInput.get();

    }

    //RunTime Exception
    //Potential problems:
    // Bigger, Lower, Letter, null(Empty)
    public static void takeScoreInput(){
        while (true){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter a score between 1-100: ");

            try{
                int score = Integer.parseInt(scanner.nextLine());

                if (score <= 0){
                    System.out.println("Try Again - Score should not be zero or negative");
                } else if(score >= 101){
                    System.out.println("Try Again - Score should be maximum 100");
                }

                System.out.println("Entered Score: " + score);

            }catch(NumberFormatException e){
                System.out.println("Try Again - Invalid Input");
//                e.printStackTrace();
            }
        }
    }

    public static void takeDateInput(){
        Scanner scanner = new Scanner(System.in);
        while(true){

            System.out.println("Enter your birthDate (YYYY-MM-DD): ");

            try{
            String input = scanner.nextLine();
            LocalDate date = LocalDate.parse(input);
            System.out.println(date);

            }catch (DateTimeParseException ex){
                System.out.println("Invalid date format. Please enter date in yyyy-mm-dd format. " + ex.getMessage());
//                ex.printStackTrace();

            }
        }
    }


    public static Supplier<LocalDate> takeDateInput =() -> {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = null;

        while(true){
            System.out.println("Enter your birthDate (YYYY-MM-DD): ");
            try{
                String input = scanner.nextLine();
                date = LocalDate.parse(input);
                break;
            }catch (DateTimeParseException ex){
                System.out.println("Invalid date format. Please enter date in yyyy-mm-dd format. " + ex.getMessage());
//                ex.printStackTrace();
            }
        }
        return date;
    };


}
