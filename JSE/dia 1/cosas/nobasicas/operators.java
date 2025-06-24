package cosas.nobasicas;

import java.util.Scanner;

public class operators {
    public static void main(String[] args) {
        // **** ASSIGNATION OPERATOR ****

        String name = "John";
        int age = 20; // Assign with =

        // **** ARITHMETIC OPERATORS ****

        int newAge = age + 20; // Addition

        int takeAway = newAge - 10; // Subtraction

        double relativeAge = takeAway * 20; // Multiplication

        float divisionTwo = (float) relativeAge / 5; // Division

        // **** LOGICAL OPERATORS ****

        boolean meaningOfLife = 0 == Double.POSITIVE_INFINITY;
        boolean doesHeKnow = name != "john";

        // IF ELSE CONDITIONS

        if (age % 2 == 0) {
            System.out.println("the age is even");
        } else {
            System.out.println("the age is odd");
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("input a number:");
        int n = scanner.nextInt();
        // System.out.println(scanner.hashCode());
        scanner.close();

        if (n == 2) {
            System.out.println("yes");
        } else if (n == 2) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }

        // **** TERINARY OPERATOR ****

        Scanner sc = new Scanner(System.in);
        int promptInt = sc.nextInt();
        boolean isEven = (promptInt % 2 == 0) ? true : false;
        sc.close();
        System.out.println(isEven);

        // **** INCREMENTAL STUFF
        int a = 5;
        int b = ++a + ++a;
        // 5+1 + 6+1s
        /*
         * First b is declared but on initialization, a is incremented first (6) and
         * incrememnted one more time upon addition so 6+7.
         * 
         * AT THIS POINT a = 7 and b = 13!
         */

        int c = ++b - a;
        /*
         * b is incrememnted to 14 then subtracted by the current value of a, 7
         */

        System.out.println(c);

    }
}
