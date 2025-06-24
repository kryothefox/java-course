package cosas.semibasicas;

import cosas.semibasicas.models.circle;
import cosas.semibasicas.models.rectangle;
import cosas.semibasicas.models.triangle;

public class heritance {


    public static void main(String[] args) {
        
        
        rectangle newRect = new rectangle("blue", 5, 20);
        //System.out.println(newRect.getArea());

        circle newCircle = new circle("red", 5);
        //System.out.println(newCircle.getArea());
        Double[] sides = new Double[]{5.4,2.2,1.1};
        triangle newTri = new triangle("name",sides);

        System.out.println(newRect.toString() + newCircle.toString() + newTri.toString());

    }
}
