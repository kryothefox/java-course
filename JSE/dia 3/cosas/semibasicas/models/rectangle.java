package cosas.semibasicas.models;

public class rectangle extends shape{
    
    private double length, height;
    public static int NUM_SIDES = 4;

    public rectangle(String color, double length, double height) {
        super(color, NUM_SIDES);
        this.length = length;
        this.height = height;     
        calcArea();
        calcPerimeter();   
    }

    public rectangle(){

    }

    @Override
    public void calcArea() {
       setArea(height*length);
    }

    @Override
    public void calcPerimeter() {
        setPerimeter(height*2 + length*2);
    }

    @Override
    public String toString() {
        return "rectangle [length=" + length + ", height=" + height + ", getColor()=" + getColor() + ", getArea()="
                + getArea() + ", getPerimeter()=" + getPerimeter() + ", getNumOfSides()=" + getNumOfSides()
                + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + "] \n";
    }

    
}
