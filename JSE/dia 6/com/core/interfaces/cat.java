package com.core.interfaces;

public class cat implements feline<String,Integer> {

    @Override
    public String meow(String x, Integer t) {
        return "meow".repeat(t);
    }




    
}
