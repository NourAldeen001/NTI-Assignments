import java.util.ArrayList;
import java.util.List;

public class Zoo {
    // Attributes
    private List<Animal> animals;
    private String zooName;

    // Constructor
    public Zoo(String zooName) {
        animals = new ArrayList<>();
        setZooName(zooName);
    }

    // Methods
    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getName() + " has been added to " + zooName);
    }

    public void displayAllAnimals() {
        if(animals.isEmpty()) {
            System.out.println(zooName + " is empty");
        }
        else {
            for(Animal animal : animals) {
                System.out.println("=============== Animal Info ===============");
                animal.displayInfo();
                System.out.println("===========================================");
            }
        }
    }

    public void removeAnimal(String name) {
        if(!name.isBlank()) {
            Animal a = findAnimalByName(name);
            if(a != null) {
                animals.remove(a);
                System.out.println(a.getName() + " removed successfully");
            }
            else {
                System.out.println("Animal not found!");
            }
        }
        else {
            System.out.println(name + " is empty or blank, Try Again!");
        }
    }

    public Animal findAnimalByName(String name) {
        for(Animal animal : animals) {
            if(animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        System.out.println("Animal not found!");
        return null;
    }

    public void feedAllAnimals() {
        for(Animal animal : animals) {
            animal.eat();
        }
    }

    public void makeAllAnimalsSounds() {
        for(Animal animal : animals) {
            animal.makeSound();
        }
    }

    public void moveAllAnimals() {
        for(Animal animal : animals) {
            animal.move();
        }
    }

    public int getTotalAnimal() {
        return animals.size();
    }

    public double getAverageAge() {
        if(animals.isEmpty()) {
            return 0;
        }
        else {
            double sum =  0;
            for(Animal animal : animals) {
                sum += animal.getAge();
            }
            return (sum / animals.size());
        }
    }

    public void displayStatistics() {
        System.out.println("==================== " + zooName + " Statistics ====================");
        System.out.println("Total Animals: " + getTotalAnimal());
        System.out.println("Average Age: " + getAverageAge());
        System.out.println("Total Dogs: " + countAnimalsBySpecies("Dog"));
        System.out.println("Total Cats: " + countAnimalsBySpecies("Cat"));
        System.out.println("Total Birds: " + countAnimalsBySpecies("Bird"));
        System.out.println("Total Healthy Animals: " + getHealthAnimals().size());
        System.out.println("=======================================================================");
    }


    public int countAnimalsBySpecies(String species) {
        List<Animal> animalsWithSpecies = new ArrayList<>();
        if(!species.isBlank()) {
            for(Animal animal : animals) {
                if(species.equals(animal.getSpecies())) {
                    animalsWithSpecies.add(animal);
                }
            }
            if(animalsWithSpecies.isEmpty()) System.out.println(species + " is not found between animals");
            return animalsWithSpecies.size();
        }
        else {
            System.out.println(species + " is empty or blank, Try Again!");
            return -1;
        }
    }

    public void searchBySpecies(String species) {
        List<Animal> animalsWithSpecies = new ArrayList<>();
        if(!species.isBlank()) {
            for(Animal animal : animals) {
                if(species.equals(animal.getSpecies())) {
                    System.out.println(animal.getName() + " is a " + animal.getSpecies());
                    animalsWithSpecies.add(animal);
                }
            }
            if(animalsWithSpecies.isEmpty()) System.out.println(species + " is not found between animals");
        }
        else {
            System.out.println(species + " is empty or blank, Try Again!");
        }
    }

    public List<Animal> getHealthAnimals() {
        List<Animal> healthyOnes = new ArrayList<>();
        for(Animal animal : animals) {
            if(animal.isHealthy()) {
                healthyOnes.add(animal);
            }
        }
        return healthyOnes;
    }

    public List<Animal> getAnimalsByAgeRange(int minAge, int maxAge) {
        List<Animal> animalsWithinRange = new ArrayList<>();
        for(Animal animal : animals) {
            if(animal.getAge() >= minAge && animal.getAge() <= maxAge) {
                animalsWithinRange.add(animal);
            }
        }
        return animalsWithinRange;
    }

    // Setters
    public void setZooName(String zooName) {
        if(zooName.isBlank()) {
            System.out.println("ZooName must not be empty or blank, Try Again");
            return;
        }
        this.zooName = zooName;
    }

    // Getters
    public String getZooName() {
        return zooName;
    }
}
