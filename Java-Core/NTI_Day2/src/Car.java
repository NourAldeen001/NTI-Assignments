public class Car {

    String brand;
    String model;
    int year;
    double price;
    String color;

    Car() {

    }

    Car(String brand, String model, int year, double price, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
    }

    void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model +
                ", Year: " + year + ", Price:" + price + ", Color: "+ color);
    }

    boolean isExpensive() {
        return price > 50000;
    }

    boolean isNew() {
        return year >= 2020;
    }
}
