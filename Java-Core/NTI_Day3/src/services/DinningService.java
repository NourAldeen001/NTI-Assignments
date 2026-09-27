package services;

public class DinningService implements Service {

    @Override
    public double getCost() {
        return 50.0;
    }

    @Override
    public String getName() {
        return "Dinning Service";
    }
}
