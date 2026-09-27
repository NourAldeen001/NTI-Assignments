import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Enable me to input what I want
        Scanner in = new Scanner(System.in);

        Zoo safana = new Zoo("Safana Zoo");

        safana.addAnimal(new Dog("Max", 5, 30.0, true, "Golden Retriever"));
        safana.addAnimal(new Cat("Whiskers", 3, 4.5, true, "White", true));
        safana.addAnimal(new Bird("Tweety", 2, 0.5, true, 0.3, true));


        while(true) {
            System.out.println("######################### Welcome to you in Safari Zoo #########################");
            System.out.println("""
                    ====================== Safari Zoo Management System ======================
                    1. Add Animal
                    2. Display All Animals
                    3. Search Animal By Name
                    4. Remove Animal
                    5. Feed All Animals
                    6. Make All Animals Sound
                    7. Move All Animals
                    8. Display Statistics
                    9. Search By Species
                    10. Show Healthy Animals
                    11. Animal Actions Menu
                    0. Exit
                    """);

            System.out.println("Enter Your Choice: ");
            int choice = in.nextInt();
            in.nextLine();

            switch(choice) {
                case 1:
                    createAnimal(in, safana);
                    break;
                case 2:
                    System.out.println("============ All Animals in Safari Zoo ============");
                    safana.displayAllAnimals();
                    System.out.println("===================================");
                    break;
                case 3:
                    System.out.println("Enter Animal Name Which You Want To Search on it: ");
                    String aniNameForSearch = in.nextLine();
                    safana.findAnimalByName(aniNameForSearch);
                    break;
                case 4:
                    System.out.println("Enter Animal Name Which You Want To Remove: ");
                    String aniNameForRemove = in.nextLine();
                    safana.removeAnimal(aniNameForRemove);
                    break;
                case 5:
                    System.out.println("============ Feed Time ============");
                    safana.feedAllAnimals();
                    System.out.println("===================================");
                    break;
                case 6:
                    System.out.println("============ Make Sounds ============");
                    safana.makeAllAnimalsSounds();
                    System.out.println("===================================");
                    break;
                case 7:
                    System.out.println("============ Make Animals Moving ============");
                    safana.moveAllAnimals();
                    System.out.println("===================================");
                    break;
                case 8:
                    safana.displayStatistics();
                    break;
                case 9:
                    System.out.println("Enter Animal Species Which You want to search on it: ");
                    String species = in.nextLine();
                    safana.searchBySpecies(species);
                    break;
                case 10:
                    System.out.println("============ All Healthy Animals ============");
                    List<Animal> healthyAnimals = safana.getHealthAnimals();
                    for(Animal animal : healthyAnimals) {
                        animal.displayInfo();
                    }
                    System.out.println("===================================");
                    break;
                case 11:
                    System.out.println("Enter Animal Name: ");
                    String aniName = in.nextLine();
                    Animal a = safana.findAnimalByName(aniName);
                    if(a == null) {
                        System.out.println("Cannot perform actions. Animal not found");
                        break;
                    }
                    if(a instanceof Dog) {
                        boolean back = false;
                        while(!back) {
                            System.out.println("""
                            =========== Dog Actions Menu ============
                            1. Bark
                            2. Fetch
                            3. Wag Tail
                            0. Exit
                            """);

                            System.out.println("Enter Your Choice: ");
                            int ch = in.nextInt();

                            switch(ch) {
                                case 1:
                                    ((Dog)a).bark();
                                    break;
                                case 2:
                                    ((Dog)a).fetch();
                                    break;
                                case 3:
                                    ((Dog)a).wagTail();
                                    break;
                                case 0:
                                    back = true;
                                    break;
                                default:
                                    System.out.println("Undefined Option, Try Again!");
                            }
                        }
                    }
                    else if (a instanceof Cat) {
                        boolean back = false;
                        while(!back) {
                            System.out.println("""
                            =========== Cat Actions Menu ============
                            1. Meow
                            2. Purr
                            3. Scratch
                            0. Exit
                            """);

                            System.out.println("Enter Your Choice: ");
                            int ch = in.nextInt();

                            switch(ch) {
                                case 1:
                                    ((Cat)a).meow();
                                    break;
                                case 2:
                                    ((Cat)a).purr();
                                    break;
                                case 3:
                                    ((Cat)a).scratch();
                                    break;
                                case 0:
                                    back = true;
                                    break;
                                default:
                                    System.out.println("Undefined Option, Try Again!");
                            }
                        }
                    }
                    else {
                        boolean back = false;
                        while(!back) {
                            System.out.println("""
                            =========== Bird Actions Menu ============
                            1. Chirp
                            2. Fly
                            3. Build Nest
                            0. Exit
                            """);

                            System.out.println("Enter Your Choice: ");
                            int ch = in.nextInt();

                            switch(ch) {
                                case 1:
                                    ((Bird)a).chirp();
                                    break;
                                case 2:
                                    ((Bird)a).fly();
                                    break;
                                case 3:
                                    ((Bird)a).buildNest();
                                    break;
                                case 0:
                                    back = true;
                                    break;
                                default:
                                    System.out.println("Undefined Option, Try Again!");
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Undefined choice in System, Please Try Again!");
            }
        }

    }

    public static void createAnimal(Scanner in, Zoo safana) {
        System.out.println("Dog, Cat, Or Bird ? ");
        String species = in.nextLine();

        if(species.equals("Cat")) {
            System.out.println("============ Animal Info ============");
            System.out.println("Name: ");
            String name = in.nextLine();
            System.out.println("Age: ");
            int age = in.nextInt();
            System.out.println("Weight: ");

            double weight = in.nextDouble();
            System.out.println("Healthy? (true/false)");
            boolean isHealthy = in.nextBoolean();
            in.nextLine();

            // Specific
            System.out.println("Fur Color: ");
            String furColor = in.nextLine();
            System.out.println("Indoor? (true/false)");
            boolean isIndoor = in.nextBoolean();
            System.out.println("==================================");

            Animal a = new Cat(name, age, weight, isHealthy, furColor, isIndoor);
            safana.addAnimal(a);
        }
        else if(species.equals("Dog")) {
            System.out.println("============ Animal Info ============");
            System.out.println("Name: ");
            String name = in.nextLine();
            System.out.println("Age: ");
            int age = in.nextInt();
            System.out.println("Weight: ");
            double weight = in.nextDouble();
            System.out.println("Healthy? (true/false)");
            boolean isHealthy = in.nextBoolean();
            in.nextLine();

            // Specific
            System.out.println("Breed: ");
            String breed = in.nextLine();
            System.out.println("===================================");

            Animal a = new Dog(name, age, weight, isHealthy, breed);
            safana.addAnimal(a);
        } else if(species.equals("Bird")) {
            System.out.println("============ Animal Info ============");
            System.out.println("Name: ");
            String name = in.nextLine();
            System.out.println("Age: ");
            int age = in.nextInt();
            System.out.println("Weight: ");
            double weight = in.nextDouble();
            System.out.println("Healthy? (true/false)");
            boolean isHealthy = in.nextBoolean();
            in.nextLine();


            System.out.println("Wing Span: ");
            double wingSpan = in.nextDouble();
            in.nextLine();
            System.out.println("Fly? (true/false)");
            boolean canFly = in.nextBoolean();
            System.out.println("===============================");

            Animal a = new Bird(name, age, weight, isHealthy, wingSpan, canFly);
            safana.addAnimal(a);
        }
        else {
            System.out.println("Undefined Species Types. Please, Try Again!");
        }
    }

}