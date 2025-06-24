package cosas.basicas;

public class hellofriend {

     //global vars 
    static byte RANDOMBYTE;

    public static void main(String[] args) { // MAIN

        var var = "var";
        System.out.println("\"Hello friend.\"");

        System.out.println(RANDOMBYTE);
        RANDOMBYTE = 10;
        // local var
        what();    
    }
    
    static void what(){
        System.out.println(RANDOMBYTE);
    }


}