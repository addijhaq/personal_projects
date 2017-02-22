import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



    }


    public List<String> fizzBuzzList(Integer[] integerArray) {
        //   * Given an array of Integers, return a List that contains the same Integers
        //	 * (as Strings). Except any multiple of 3 should be replaced by the String
        //	 * "Fizz", any multiple of 5 should be replaced by the String "Buzz", and
        //   * any multiple of both 3 and 5 should be replaced by the String "FizzBuzz"

        //   * fizzBuzzList( {1, 2, 3} ) -> [1, 2, "Fizz"] fizzBuzzList( {4, 5, 6} ) ->
        //	 * [4, "Buzz", 6] fizzBuzzList( {7, 8, 9, 10, 11, 12, 13, 14, 15} ) -> [7,
        //	 * 8, "Fizz", "Buzz", 11, "Fizz", 13, 14, "FizzBuzz"]
        //
        List<String> stringList = new ArrayList<String>(integerArray.length);
        for (Integer number : integerArray) {
            if (number % 3 == 0 && number % 5 == 0) {
                stringList.add("FizzBuzz");
            } else if (number % 3 == 0) {
                stringList.add("Fizz");
            } else if (number % 5 == 0) {
                stringList.add("Buzz");
            } else {
                stringList.add(number.toString());
            }

        }
        return stringList;
    }




    public void DecimalToBinary(){

        /*
        Write a command line program which accepts a series of decimal integer values as command line arguments,
        and displays each decimal value as itself and its binary equivalent

        $ DecimalToBinary 460 8218 1 31313 987654321
        460 in binary is 111001100
        8218 in binary is 10000000011010
        1 in binary is 1
        31313 in binary is 111101001010001
        987654321 in binary is 111010110111100110100010110001
        */
        Scanner numCapture = new Scanner(System.in);

        System.out.println("Please enter number to convert to binary.");
        String stringNum = numCapture.nextLine();
        int startingNumber = Integer.parseInt(stringNum);
        int modNum = startingNumber;
        String savedBinary = "";


        for(
                int i = 0;
                startingNumber >0;i++)

        {
            modNum = startingNumber % 2;
            startingNumber = startingNumber / 2;
            if (modNum == 0) {
                savedBinary += "0";
            }
            if (modNum == 1) {
                savedBinary += "1";
            }
        }

        savedBinary =new

                StringBuilder(savedBinary).

                reverse().

                toString();
        System.out.println("Your Binary Number is "+savedBinary +".");
    }

    public void Fibonacci() {
    /*
    The Fibonacci numbers are the integers in the following sequence:
            0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
    By definition, the first two numbers in the Fibonacci sequence are 0 and 1, and each subsequent number is the sum of the previous two.

    Write a command line program which displays a Fibonacci sequence to the console. The program accepts an integer value as a command line
    argument which specifies when to terminate the Fibonacci sequence, and quit the program.

    $ java Fibonacci 25
            0, 1, 1, 2, 3, 5, 8, 13, 21
    */

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a number >>");
        String fibString = scan.nextLine();
        int fibNumber = Integer.parseInt(fibString);
        System.out.println("the fibonnacci number selected is " + fibNumber);

        int a = 1;
        int b = 0;

        for (int i = 0; b < fibNumber; i++) {
            System.out.print(b + ", ");
            b = a + b;
            a = Math.abs(b - a);
        }
    }


    public String factorize(Integer n) {
        List<Integer> primeList = new ArrayList<Integer>();

        while (n > 1) {

            if (n % 2 == 0) {
                n = n / 2;
                primeList.add(2);
            } else if (n % 3 == 0) {
                n = n / 3;
                primeList.add(3);
            } else if (n % 5 == 0) {
                n = n / 5;
                primeList.add(5);
            } else if (n % 7 == 0) {
                n = n / 7;
                primeList.add(7);
            } else if (n % 11 == 0) {
                n = n / 11;
                primeList.add(11);
            } else if (n == 1) {
                break;
            } else {
                primeList.add(n);
                break;
            }


        }

        return primeList.toString();
    }

}
