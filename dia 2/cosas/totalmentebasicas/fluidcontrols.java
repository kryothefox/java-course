package cosas.totalmentebasicas;


import java.util.Scanner;

public class fluidcontrols {
    public static void main(String[] args) {
       
       
        // **** ITERATION BLOCKS ****


        /*
            while (condition){
                instructions;
            }
        
        */ 

        //int randomInt1 = 10;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("input a random num:");
        int randomInt1 = sc.nextInt();
        sc.close();

        while (randomInt1 > 0) {
            System.out.println(randomInt1);
            randomInt1 = randomInt1 - 1;
        }
       





        /*
        do {
            instructions;
        } while (condition);
        */
        
        
        
        int x = 40;
        do {
            System.out.println(x);
            x--;
        } while (x >= 0);
        
       






        /*
        
        for (int i = 0; range; i++) {
            instructions;    
        } 
        
        */

        // **** INFINITE FOR LOOP ****
        
        int a = 0;
        for(;;){
            if (a > 100) {
                break;
            }
            System.out.println(a);
            a++;
        } 
       
        





        // **** FOR LOOP THROUGH ARRAY ****

        
        int[] randomNumbers = {1,2,5021,5,12,561616};

        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.println(randomNumbers[i]);
        }
       






        // **** RECURSIVE FOR LOOP THROUGH ARRAY ****

        
        int[] intArr = {1,2,3,4,5,6,7,8,9,0};
        for (int element : intArr) {
            System.out.println(element);
        }
       






        //String[] stringArr = new String[]{"john","jane","doe"};
        
        String[] stringArr = {"john","j.", "doe"};
        String fullName = "";
        for (String element : stringArr) {
            fullName = fullName.concat(element+" "); 
        }
        System.out.println(fullName);
       
        



        // **** SWITCH STATEMENT ****
        
        String DayOfTheWeek = "Monday";
        switch (DayOfTheWeek) {
            case "Monday":
                System.out.println("Pasta");
                break;
            case "Tuesday":
                System.out.println("Paella");
                break;
            case "Wednesday":
                System.out.println("Tortilla");
                break;
            /*
             * 
             * rest of the days
             * 
            */
            default:
                break; //this executes in case none of the cases match
        }


        




    }
}
