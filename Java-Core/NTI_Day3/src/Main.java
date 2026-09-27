import management.Hotel;
import models.*;
import services.DinningService;
import services.GymService;
import services.Service;
import services.SpaService;

public class Main {
    public static void main(String[] args) {

        // Hotel
        Hotel grandHotel = getHotel();

        // Customers
        Customer customer1 = new Customer("John Smith", "john-smith@gmail.com", "01756348597");
        Customer customer2 = new Customer("Jane Doe", "jane-doe@gmail.com", "01467985243");
        Customer customer3 = new Customer("Bob Wilson", "bob-wilson@gmail.com", "01423759642");

        System.out.println("=====================================================================================");

        // Display All Rooms In Hotel
        grandHotel.displayAllRooms();

        System.out.println("=====================================================================================");

        // Services
        Service spaService = new SpaService();
        Service dinningService = new DinningService();
        Service gymService = new GymService();

        // Display Available Rooms
        grandHotel.displayAvailableRooms();

        System.out.println("=====================================================================================");


        // Booking In Hotel
        grandHotel.bookRoom("101", customer1, spaService);
        System.out.println("=====================================================================================");
        grandHotel.bookRoom("102", customer2, dinningService, gymService);
        System.out.println("=====================================================================================");
        grandHotel.bookRoom("103", customer3, spaService, dinningService, gymService);
        System.out.println("=====================================================================================");

        // Display Available Rooms
        grandHotel.displayAvailableRooms();

        System.out.println("=====================================================================================");

        // Booking Details
        grandHotel.displayBookingDetails("101");
        grandHotel.displayBookingDetails("102");
        grandHotel.displayBookingDetails("103");
        grandHotel.displayBookingDetails("104");

    }

    private static Hotel getHotel() {
        Hotel grandHotel = new Hotel("Grand Plaza Hotel");

        // Rooms
        Room standardRoom = new StandardRoom("101", 200.00);
        Room deluxeRoom = new DeluxeRoom("102", 300.00);
        Room suiteRoom = new SuiteRoom("103", 500.00);
        Room standardRoom2 = new StandardRoom("104", 200.00);

        // Adding Rooms in hotel
        grandHotel.addRoom(standardRoom);
        grandHotel.addRoom(deluxeRoom);
        grandHotel.addRoom(suiteRoom);
        grandHotel.addRoom(standardRoom2);
        return grandHotel;
    }
}