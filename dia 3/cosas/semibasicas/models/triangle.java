package cosas.semibasicas.models;

import java.util.Arrays;

public class triangle extends shape {

    final int NUM_SIDES = 3;
    private Double[] sides = new Double[2];

    

    public triangle(String color, Double[] numOfSides) {
        super(color, 3);
        this.sides = numOfSides;
        calcArea();
        calcPerimeter();
    }

    

    public triangle() {
    }



    @Override
    public void calcArea() {

    }
    @Override
    public void calcPerimeter() {
        double s = getPerimeter()/2;
        double result = Math.sqrt(s * (s-sides[0])*(s-sides[1])*(s-sides[2]));
        setArea(result);
    }



    @Override
    public String toString() {
        return "triangle [NUM_SIDES=" + NUM_SIDES + ", sides=" + Arrays.toString(sides) + ", getColor()=" + getColor()
                + ", getArea()=" + getArea() + ", getPerimeter()=" + getPerimeter() + ", getNumOfSides()="
                + getNumOfSides() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
                + hashCode() + "]\n";
    }



}
