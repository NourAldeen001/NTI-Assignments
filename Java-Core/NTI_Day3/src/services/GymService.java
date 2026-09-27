package services;

public class GymService implements Service {
    @Override
    public double getCost() {
        return 30.0;
    }

    @Override
    public String getName() {
        return "Gym Service";
    }
}
