package cosas.nobasicas;

public class addresses {
    public static void main(String[] args) {
        
        Character randomChar = 'H';
        System.out.println(randomChar.hashCode()); //72
        randomChar++;
        System.out.println(randomChar.hashCode()); //73
        randomChar--;
        System.out.println(randomChar.hashCode()); //72
      
    }
}
