public class Animal {

    // Attributes
    private String name;
    private int age;
    private String species;
    private double weight; // In KG
    private boolean isHealthy;

    // Constructor
    public Animal(String name, int age, String species, double weight, boolean isHealthy) {
        setName(name);
        setAge(age);
        setSpecies(species);
        setWeight(weight);
        setHealthy(isHealthy);
    }

    // Methods
    public void eat() {
        System.out.println(name + " is eating");
    }

    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    public void makeSound() {
        System.out.println(name + " makes a sound");
    }

    public void move() {
        System.out.println(name + " is moving");
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Species: " + species +
                ", Weight: " + weight + "KG, isHealthy: " + isHealthy);
    }

    // Setters
    public void setName(String name) {
        if(name.isBlank()) {
            System.out.println("Name must not be empty or blank, Try again!");
            return;
        }
        this.name = name;
    }

    public void setAge(int age) {
        if(age > 0 && age < 50) {
            this.age = age;
            return;
        }
        System.out.println("Age must greater than 0 and less than 50, Try Again!");
    }

    public void setSpecies(String species) {
        if(species.isBlank()) {
            System.out.println("Species must not be empty or blank, Try again!");
            return;
        }
        this.species = species;
    }

    public void setWeight(double weight) {
        if(weight < 0) {
            System.out.println("Weight must be positive value");
            return;
        }
        this.weight = weight;
    }

    public void setHealthy(boolean isHealthy) {
        this.isHealthy = isHealthy;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isHealthy() {
        return isHealthy;
    }
}
