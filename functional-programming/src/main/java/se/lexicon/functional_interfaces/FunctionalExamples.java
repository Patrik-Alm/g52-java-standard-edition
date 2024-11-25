package se.lexicon.functional_interfaces;

import se.lexicon.functional_interfaces.interfaces.DoStringStuff;
import se.lexicon.functional_interfaces.interfaces.DoubleOperator;

public class FunctionalExamples {

    //Anonymous Inner class
    static DoStringStuff concatString = new DoStringStuff() {
        @Override
        public String operate(String s1, String s2) {
            return s1 + " " + s2;
        }
    };

    static DoubleOperator additionOperator = new DoubleOperator() {
        @Override
        public Double apply(Double d1, Double d2) {
            return d1 + d2;
        }
    };

    static DoubleOperator subtractionOperator = new DoubleOperator() {
        @Override
        public Double apply(Double d1, Double d2) {
            return d1 - d2;
        }
    };


    public static void main(String[] args) {

//        StringConcatenate stringConcatenate = new StringConcatenate();
//        System.out.println(stringConcatenate.operate("Simon", "Elbrink"));

        StringBiggest stringBiggest = new StringBiggest();
        System.out.println(stringBiggest.operate("Mehrdad", "Simon"));


        concatString.operate("Simon", "Elbrink");

        Double calcNumber = additionOperator.apply(300d, 500d);
        System.out.println("calcNumber = " + calcNumber);

        System.out.println(additionOperator.apply(500d, 2000d));


        calcOperator(500.3123d, 30.9234d, additionOperator);


        double calValue = calcOperator(700d, 200d, new DoubleOperator() {
            @Override
            public Double apply(Double d1, Double d2) {
                return d1 * d2;
            }
        });

        System.out.println("Multiply: " + calValue);


    }

    public static double calcOperator(Double d1, Double d2, DoubleOperator doubleOperator) {
        return doubleOperator.apply(d1, d2);
    }
}
