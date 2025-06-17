package com.core.interfaces;


@FunctionalInterface
public interface feline {

    public String meow(int count);

    default void pluh(){
        System.err.println("PLUH");
    }


}