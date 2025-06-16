package com.core;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class init {
    public static void main(String[] args) {

        // **** ITERABLES AND COLLECTIONS ****

        List<Integer> intList = Arrays.asList(new Integer[] { 4, 2, 1, 5, 2 });

        Iterator<Integer> iter = intList.iterator();

        /*
         * while (iter.hasNext()) {
         * Integer value = iter.next();
         * System.out.println(value);
         * }
         */

        // **** EXCEPTIONS AND CATCHING

        try {

            Scanner sc = new Scanner(System.in);
            System.out.println("input 2 numbers");

            double val = sc.nextDouble();
            double val2 = sc.nextDouble();
            sc.close(); // Java GC, I SUMMON YOU!!!

            if (val2 == 0.0) {
                throw new ArithmeticException("diving by 0 you dingus");
            }
            ;

            System.out.println(val / val2);

        } catch (InputMismatchException | IllegalStateException ex) {

            System.out.println("bad input provided!\n" + ex);
            ex.printStackTrace();

        } catch (ArithmeticException ex) {

            System.out.println("bad calculation!\n" + ex);
            ex.printStackTrace();

        } finally {

            System.out.println("prg finished"); // executes no matter what, unless unhandled exception

        }

        Scanner sc = new Scanner(System.in);
        subtract(sc);

    }

    public static void subtract(Scanner scanner) {

        try {
            System.out.println("Input 2 numbers");
            Double val1 = scanner.nextDouble();
            Double val2 = scanner.nextDouble();
            scanner.close();
            System.out.println(val1 - val2);

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }

}