import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelManagementSystem {
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addRoom() {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        System.out.print("Enter room type: ");
        String type = scanner.next();
        rooms.add(new Room(roomNumber, type));
        System.out.println("Room added.");
    }

    public void bookRoom() {
        System.out.print("Enter customer name: ");
        String name = scanner.next();
        System.out.print("Enter customer contact: ");
        String contact = scanner.next();

        System.out.println("Available rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }

        System.out.print("Enter room number to book: ");
        int roomNumber = scanner.nextInt();

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                Customer customer = new Customer(name, contact);
                bookings.add(new Booking(room, customer));
                room.setAvailable(false);
                System.out.println("Room booked successfully.");
                return;
            }
        }
        System.out.println("Room not available.");
    }

    public void viewBookings() {
        System.out.println("Current bookings:");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public static void main(String[] args) {
        HotelManagementSystem hms = new HotelManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Room");
            System.out.println("2. Book Room");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hms.addRoom();
                    break;
                case 2:
                    hms.bookRoom();
                    break;
                case 3:
                    hms.viewBookings();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}