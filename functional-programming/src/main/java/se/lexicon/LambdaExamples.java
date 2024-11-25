package se.lexicon;

import se.lexicon.interfaces.*;

import java.util.Random;
import java.util.regex.Pattern;

public class LambdaExamples {


    //Lambda Expressions as fields
    static DoStringStuff concatString = (String s1, String s2) -> { return s1 + " " + s2;};

    static DoStringStuff getBiggest = (String s1, String s2) -> {

            if (s1.length() >= s2.length()){
                return s1;
            }else {
                return s2;
            }

        };

    static DoubleOperator addOperator = (d1, d2) -> d1 + d2;

    static StringValidator notNullValidator = (String input) -> input != null;

    static StringValidator mobileValidator = (String mobileNumber) -> mobileNumber != null && Pattern.compile("^\\d{10}$").matcher(mobileNumber).matches();

    static Printer printMessage = (String message) -> System.out.println(message);


    public static void main(String[] args) {

        System.out.println(concatString.operate("Simon", "Elbrink"));

        System.out.println(addOperator.apply(4003.50,1230.23));

        System.out.println(calOperator(
                400.23,34234.65,
                (number1,number2) -> number1 * number2));


        System.out.println(notNullValidator.validate("Simon"));


        System.out.println(mobileValidator.validate("123456894856")); // False
        System.out.println(mobileValidator.validate("0731234556")); // True


        printMessage.print("Hello World");

        calOperator(400000.23,34234.65,
                (n1,n2) -> n1 / n2,
                printMessage
                );


        IntRandom generateRandomInt = () -> new Random().nextInt();

        int randomIntHere = generateRandomInt.generate();

        System.out.println(randomIntHere);


    }


    public static double calOperator (double n1, double n2, DoubleOperator doubleOperator){
        return doubleOperator.apply(n1,n2);
    }

    public static void calOperator (double n1, double n2, DoubleOperator doubleOperator, Printer printer){
        printer.print(String.valueOf(doubleOperator.apply(n1,n2)));
    }





}
