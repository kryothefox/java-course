package cosas.nobasicas.models;

public class Planets {
    
    
    private String name,system,galaxy;
    private int numberOfMoons;
    private double planetRadius;
    private double gravitationalAcceleration;
    protected boolean habitable;
    public final static double GRAVIATIONAL_CONSTANT = 6.67408E-11;

    public Planets(){
        this("example","examplesystem","randomting",20,12412,2104,false);
    }
    
    
    public Planets(String planetName, String planetSystem, String planetGalaxy, int moons, double radius, double gravaccel, boolean  habitable){
        this.name = planetName;
        this.system = planetSystem;
        this.galaxy = planetGalaxy;
        this.numberOfMoons = moons;
        this.planetRadius = radius;
        this.gravitationalAcceleration = gravaccel;
        this.habitable = habitable;
    }
    
    public double calculateVolume(){
        return (4.0/3) * (Math.PI * Math.pow(planetRadius, 3));
    }

    public double calculatePlanetMass(){
        return (gravitationalAcceleration * Math.pow(planetRadius,2))/GRAVIATIONAL_CONSTANT;
    }

    // GETTERS AND SETTERS (access modifiers)


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(String galaxy) {
        this.galaxy = galaxy;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    public void setNumberOfMoons(int numberOfMoons) {
        this.numberOfMoons = numberOfMoons;
    }

    public double getPlanetRadius() {
        return planetRadius;
    }

    public void setPlanetRadius(double planetRadius) {
        this.planetRadius = planetRadius;
    }

    public double getGravitationalAcceleration() {
        return gravitationalAcceleration;
    }

    public void setGravitationalAcceleration(double gravitationalAcceleration) {
        this.gravitationalAcceleration = gravitationalAcceleration;
    }

    public boolean isHabitable() {
        return habitable;
    }

    public void setHabitable(boolean habitable) {
        this.habitable = habitable;
    }

    public static double getGraviationalConstant() {
        return GRAVIATIONAL_CONSTANT;
    }


    @Override
    public String toString() {
        return "Planets [name=" + name + ", system=" + system + ", galaxy=" + galaxy + ", numberOfMoons="
                + numberOfMoons + ", planetRadius=" + planetRadius + ", gravitationalAcceleration="
                + gravitationalAcceleration + ", habitable=" + habitable + ", hashCode()=" + hashCode() + "]";
    }
    
    
    
}
