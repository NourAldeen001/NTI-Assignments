public class Cat extends Animal {
    // Attributes
    private String furColor;
    private boolean isIndoor;

    // Constructor
    public Cat(String name, int age, double weight, boolean isHealthy, String furColor, boolean isIndoor) {
        super(name, age, "Cat", weight, isHealthy);
        setFurColor(furColor);
        setIndoor(isIndoor);
    }

    // Methods
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " is sneaking quietly");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("FurColor: " + furColor + ", isIndoor: " + isIndoor);
//        System.out.println("Name: " + getName() + ", Age: " + getAge() + ", Species: "+ getSpecies() +
//                ", Weight: " + getWeight() + "KG, isHealthy: " + isHealthy() +
//                ", FurColor: " + furColor + ", isIndoor: " + isIndoor);
    }

    public void meow() {
        System.out.println(getName() + " is meowing softly");
    }

    public void purr() {
        System.out.println(getName() + " is purring contentedly");
    }

    public void scratch() {
        System.out.println(getName() + " is scratching the post");
    }

    // Setters
    public void setFurColor(String furColor) {
        if(furColor.isBlank()) {
            System.out.println("FurColor must not be empty or blank, Try Again!");
            return;
        }
        this.furColor = furColor;
    }

    public void setIndoor(boolean isIndoor) {
        this.isIndoor = isIndoor;
    }

    // Getters
    public String getFurColor() {
        return furColor;
    }

    public boolean isIndoor() {
        return isIndoor;
    }

}
