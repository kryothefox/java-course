package com.core;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;




import com.core.Calculator.inconvenientCalculator;
import com.core.Errors.zeroOnSecondValue;
import com.core.UsersPackage.User;

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

        /*
         * inconvenientCalculator calculator = new inconvenientCalculator();
         * System.out.println(calculator.subtract(250, 0.1));
         * System.out.println(calculator.add(250, 0.1));
         */

        // **** WORKING WITH AUTOCLOSABLE ****

        /*
         * Test test = new Test();
         * try (test){
         * throw new Exception();
         * } catch (Exception e) {
         * System.out.println("this prints last");
         * 
         * }
         */

        // **** SERIALIZABLE OBJECTS ****

        User newUser = new User("meow", "balls");

        // WRITE OBJECT OUT TO A SERIALIZABLE OBJ FILE
        try (FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir") + "/dia 5/com/core/User.ser")) {
            
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            
            objOut.writeObject(newUser);
            
            objOut.close();
            fileOut.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("obj info saved");
        
        
        // INPUT OBJECT
        try (FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir") + "/dia 5/com/core/User.ser")){

            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            Object theObject = objIn.readObject();

            System.out.println(theObject.toString());

        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }


        String dir = "temperatures.txt";

        try {
            FileReader fr = new FileReader(dir);
            BufferedReader br = new BufferedReader(fr);
            br.close();
            // add the reading instructions.
        
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static class Test implements AutoCloseable {

        @Override
        public void close() throws Exception {
            System.out.println("meow");
        }

    }

}
