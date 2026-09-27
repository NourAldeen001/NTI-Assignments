public class Dog extends Animal {
    // Attributes
    private String breed;

    // Constructor
    public Dog(String name, int age, double weight, boolean isHealthy, String breed) {
        super(name, age, "Dog", weight, isHealthy);
        setBreed(breed);
    }

    // Methods
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof! Woof!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " is running");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed: " + breed);
//        System.out.println("Name: " + getName() + ", Age: " + getAge() + ", Species: " + getSpecies() +
//                ", Weight: " + getWeight() + "KG, isHealthy: " + isHealthy() + ", Breed: " + breed);
    }

    public void bark() {
        System.out.println(getName() + " is barking loudly!");
    }

    public void fetch() {
        System.out.println(getName() + " is fetching the ball");
    }

    public void wagTail() {
        System.out.println(getName() + " is wagging tail happily!");
    }

    // Setters
    public void setBreed(String breed) {
        if(breed.isBlank()) {
            System.out.println("Breed must not be empty or blank, Try Again!");
            return;
        }
        this.breed = breed;
    }

    // Getters
    public String getBreed() {
        return breed;
    }
}
