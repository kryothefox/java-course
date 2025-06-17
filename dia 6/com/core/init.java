package com.core;

import com.core.interfaces.cat;
import com.core.interfaces.feline;

public class init {
    
    // **** FUNCTIONAL INTERFACES ****
    
    public static void main(String[] args) {
        
        cat newCat = new cat();
        System.out.println(newCat.meow(4));

        meowTest(
            (int count) -> "mrrrp\n".repeat(count), 6);
        
    }

    static void meowTest(feline aFeline, int count){
        System.out.println(aFeline.meow(count));
    }
    

}
