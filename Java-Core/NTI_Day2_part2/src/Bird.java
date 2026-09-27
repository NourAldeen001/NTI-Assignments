public class Bird extends Animal {
    // Attributes
    private double wingSpan;
    private boolean canFly;

    // Constructor
    public Bird(String name, int age, double weight, boolean isHealthy, double wingSpan, boolean canFly) {
        super(name, age, "Bird", weight, isHealthy);
        setWingSpan(wingSpan);
        setCanFly(canFly);
    }

    // Methods
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Tweet! Tweet!");
    }

    @Override
    public void move() {
        if(canFly) {
            System.out.println(getName() + " is flying");
        }
        else {
            System.out.println(getName() + " is hopping");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("WingSpan: " + wingSpan + ", CanFly: " + canFly);
//        System.out.println("Name: " + getName() + ", Age: " + getAge() + ", Species: "+ getSpecies() +
//                ", Weight: " + getWeight() + "KG, isHealthy: " + isHealthy() +
//                ", WingSpan: " + wingSpan + ", CanFly: " + canFly);
    }

    public void chirp() {
        System.out.println(getName() + " is chirping melodiously");
    }

    public void fly() {
        if(canFly) {
            System.out.println(getName() + " is soaring in the sky");
        }
        else {
            System.out.println(getName() + " cannot fly");
        }
    }

    public void buildNest() {
        System.out.println(getName() + " is building a nest");
    }

    // Setters
    public void setWingSpan(double wingSpan) {
        if(wingSpan < 0) {
            System.out.println("wingSpan must be positive");
            return;
        }
        this.wingSpan = wingSpan;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    // Getters
    public double getWingSpan() {
        return wingSpan;
    }

    public boolean isCanFly() {
        return canFly;
    }
}
