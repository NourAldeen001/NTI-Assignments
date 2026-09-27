import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("HOO", "Ahmed", 1000, 200.50);
        Book b2 = new Book("LOO", "Mohamed", 10, 100.50);
        Book b3 = new Book("SOO", "Hossam", 100, 50.50);

        System.out.println("IsLong: " + b1.isLongBook());
        b1.displayInfo();

        System.out.println("IsLong: " + b2.isLongBook());
        b1.displayInfo();

        System.out.println("IsLong: " + b3.isLongBook());
        b1.displayInfo();


        /// CAR
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "M3", 2020, 100000, "Red"));
        cars.add(new Car("BMW", "M5", 2025, 500000, "Red"));
        cars.add(new Car("Mercedes", "A", 2019, 300000, "Red"));
        cars.add(new Car("Miserti", "RT", 2023, 900000, "Red"));
        cars.add(new Car("Lomborgini", "SS", 2026, 100000000, "Red"));

        for(Car car : cars) {
            car.displayInfo();
            System.out.println("IsExpensive: " + car.isExpensive());
            System.out.println("IsNew: " + car.isNew());
        }

        /// Bank Account
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount("1222", "Nour", 1000));
        accounts.add(new BankAccount("1223", "Mustafa", 5000));
        accounts.add(new BankAccount("1224", "Omar"));

        accounts.get(0).displayInfo();
        accounts.get(1).deposit(5000);
        accounts.get(2).deposit(5000);
        System.out.println("================================================");
        accounts.get(1).displayInfo();
        accounts.get(2).displayInfo();
        System.out.println("================================================");
        accounts.get(1).withdraw(3000);
        accounts.get(2).withdraw(1000);
        System.out.println("================================================");
        accounts.get(1).displayInfo();
        accounts.get(2).displayInfo();
        System.out.println("================================================");



        double x = 10000;
        long i = x;

    }
}