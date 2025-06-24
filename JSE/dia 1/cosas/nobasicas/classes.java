package cosas.nobasicas;

import cosas.nobasicas.models.Planets;

public class classes {

// SIMULATION OF OOP WITH PLANETS AND FUNCTIONS INSIDE CLASSES

    public static void main(String[] args) {
        Planets planet1 = new Planets("Earth","Solar System","Milky Way",1,6371*1000,9.81,true);
        Planets exampleplanet = new Planets();

        final double EARTH_MASS = planet1.calculatePlanetMass(); 
        final double EARTH_VOLUME = planet1.calculateVolume();    
        printPlanetProperties(planet1);

        new classes().thing(5);
    }

    public static void printPlanetProperties(Planets planet){
        System.err.println(planet.getName());
        System.err.println(planet.getSystem());
        System.err.println(planet.getGalaxy());
        System.err.println(planet.getPlanetRadius());
        System.err.println(planet);
    }

    public void thing(int n){
        System.out.println("normal" + n);
    }

    public void thing(Integer n){
        System.out.println(n);
    }

}
