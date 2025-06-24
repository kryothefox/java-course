package cosas.semibasicas.models;

abstract public class shape{
    
    private String color;
    private double area, perimeter;
    private double numOfSides;
    
    public shape(String color, double numOfSides) {
        super();
        this.color = color;
        this.numOfSides = numOfSides;
        }

    

    public shape() {
    }



    public String getColor() {
        return color;
    }

    

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }



    public double getNumOfSides() {
        return numOfSides;
    }
    
    
    
    
    public void setArea(double area) {
        this.area = area;
    }
    
    
    
    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    } 
    
    
    public abstract void calcArea(); 
    public abstract void calcPerimeter();
    
    @Override
    public String toString() {
        return "shape [color=" + color + ", area=" + area + ", perimeter=" + perimeter + ", numOfSides=" + numOfSides
                + ", getColor()=" + getColor() + ", getArea()=" + getArea() + ", getPerimeter()=" + getPerimeter()
                + ", getNumOfSides()=" + getNumOfSides() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }


    }
