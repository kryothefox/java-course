package cosas.semibasicas.models;


public class circle extends shape {
    
    private double circleRadius;
    

    public circle(String color, double circleRadius) {
        super(color, Double.MAX_VALUE);
        this.circleRadius = circleRadius;
        calcArea();
        calcPerimeter();
    }

    

    public circle() {
    }



    @Override
    public void calcArea() {
        setArea(Math.PI * (Math.pow(circleRadius,2)));
    }

    @Override
    public void calcPerimeter() {
        setPerimeter(2 * Math.PI * circleRadius);
    }



    @Override
    public String toString() {
        return "circle [circleRadius=" + circleRadius + ", getColor()=" + getColor() + ",\n getArea()=" + getArea()
                + ", getPerimeter()=" + getPerimeter() + ", getNumOfSides()=" + getNumOfSides() + ", toString()="
                + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "] \n";
    }
    
    
}
