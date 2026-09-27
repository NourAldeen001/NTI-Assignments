package services;

public class SpaService implements Service {

    @Override
    public double getCost() {
        return 100.0;
    }

    @Override
    public String getName() {
        return "Spa Service";
    }
}
