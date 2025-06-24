package cosas.semibasicas;

import java.util.Arrays;

public class StringVsStringBuffer {
    public static void main(String[] args) {
        // **** STRING MANIPULATION ****

        String exampleString = "Hello World!     ";

        System.out.println(exampleString.substring(0,5)); // Hello

        System.out.println(exampleString.indexOf("World")); // 6 

        System.out.println(exampleString.trim()); // Hello World! (no whitespaces)

        System.out.println(exampleString.isBlank()); // false

        System.out.println(exampleString.startsWith("Hello")); // true




        // **** STRING BUILDER ****

        StringBuilder sb = new StringBuilder("Hello Friend!");
        System.out.println(sb.hashCode());
        
        sb.append(" How are you?"); // Hello Friend! How are you?
        System.out.println(sb.hashCode());
        System.out.println(sb);
        
        sb.insert(5, '!'); // Hello! Friend! How are you?
        System.out.println(sb.hashCode()); // more memory optimization
        
    
        System.out.println(sb);

        String exampleString2 = "Hello World";
        StringBuilder sb2 = new StringBuilder("Hello World");

        //System.out.println(exampleString.equals(sb2)); // false!

        System.out.println(Arrays.toString(exampleString2.split(" ")));
        System.out.println(Arrays.toString( String.valueOf(sb2).split(" ")) ); // have to convert to String first


    }
}
