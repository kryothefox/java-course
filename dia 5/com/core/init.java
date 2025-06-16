package com.core;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.core.Errors.zeroOnSecondValue;

@SuppressWarnings("unused")
public class init {
    public static void main(String[] args) {

        // **** ITERABLES AND COLLECTIONS ****

        /*
         * List<Integer> intList = Arrays.asList(new Integer[] { 4, 2, 1, 5, 2 });
         * 
         * Iterator<Integer> iter = intList.iterator();
         * 
         * 
         * while (iter.hasNext()) {
         * Integer value = iter.next();
         * System.out.println(value);
         * }
         */

        // **** EXCEPTIONS AND CATCHING

        /*
         * try {
         * 
         * Scanner sc = new Scanner(System.in);
         * System.out.println("input 2 numbers");
         * 
         * double val = sc.nextDouble();
         * double val2 = sc.nextDouble();
         * sc.close(); // Java GC, I SUMMON YOU!!!
         * 
         * if (val2 == 0.0) {
         * throw new ArithmeticException("diving by 0 you dingus");
         * }
         * ;
         * 
         * System.out.println(val / val2);
         * 
         * } catch (InputMismatchException | IllegalStateException ex) {
         * 
         * System.out.println("bad input provided!\n" + ex);
         * ex.printStackTrace();
         * System.exit(1);
         * 
         * } catch (ArithmeticException ex) {
         * 
         * System.out.println("bad calculation!\n" + ex);
         * ex.printStackTrace();
         * 
         * } finally {
         * 
         * System.out.println("prg finished"); // executes no matter what, unless
         * unhandled exception
         * 
         * }
         */

        
        Calculator meow = new Calculator();
        System.out.println(meow.subtract(250,0));

    }

    public static class Calculator {
        public double subtract(double a, double b)
                throws ArithmeticException,
                NumberFormatException,
                NullPointerException,
                NoSuchElementException,
                zeroOnSecondValue {

            System.out.println("Input 2 numbers");
            if(b == 0.0){throw new zeroOnSecondValue();};
            return (a - b);

        }
        
    }

}
