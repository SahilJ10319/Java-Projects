package ca.cmpt213.tokimon;

/**
 * This Class shows off the different attributes of a Tokimon
 */
public class Tokimon {
    private String name, type;
    private double height, weight;
    int strength = 0;

    public Tokimon(String name, String type, double height, double weight) {
        this.name = name;
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.strength = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", strength=" + strength +
                '}';
    }
}







