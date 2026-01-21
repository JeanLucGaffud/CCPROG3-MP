import java.util.*;
import java.time.LocalDateTime;

public class Reservation {
    private String guestName;
    private Room room;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private double totalBookingPrice;
    private String status;

    public Reservation(Guest guest, LocalDateTime checkInDate, LocalDateTime checkOutDate) {
        this.guestName = guestName;
        this.rooms = rooms;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalBookingPrice = calculateTotalPrice(pricePerNight, checkInDate, checkOutDate);
    }
    public void reservationStatus(ArrayList<Room> rooms) {
        if(checkInDate.compareTo(checkOutDate) < 0) {}
        // Validate check-in and check-out dates
        if (isValidDate(checkInDate) || isValidDate(checkOutDate)) {
            System.out.println("Invalid date format. Please enter dates in the format YYYY-MM-DD.");
            return;
        }

        // Convert dates to integers for comparison
        int checkInDay = Integer.parseInt(checkInDate.split("-")[2]);
        int checkOutDay = Integer.parseInt(checkOutDate.split("-")[2]);

        // Check if check-out is on the 1st or check-in is on the 31st
        if (checkOutDay == 1 || checkInDay == 31) {
            System.out.println("Reservations cannot be made when check-out is on the 1st or check-in is on the 31st.");
            return;
        }

        // Ensure reservation falls within the same month
        else if (!isSameMonth(checkInDate, checkOutDate)) {
            System.out.println("Reservations must fall within the same month.");
            return;
        }

        // Ensure check-out date is greater than check-in date
        else if (checkOutDate.compareTo(checkInDate) <= 0) {
            System.out.println("Check-out date must be greater than check-in date.");
            return;
        }
    }
    public boolean isSameMonth(String date1, String date2) {
        return date1.substring(0, 7).equals(date2.substring(0, 7));
    }
    public boolean isValidDate(String date) {
        String[] parts = date.split("-");
        if (parts.length != 3) {
            return true;
        }
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        return year < 1000 || year > 9999 || month < 1 || month > 12 || day < 1 || day > 31;
    }
    public int calculateNumberOfNights(String checkInDate, String checkOutDate) {
        // Assuming date format is YYYY-MM-DD
        // Example: "2024-06-15"
        String[] checkInParts = checkInDate.split("-");
        String[] checkOutParts = checkOutDate.split("-");

        int checkInYear = Integer.parseInt(checkInParts[0]);
        int checkInMonth = Integer.parseInt(checkInParts[1]);
        int checkInDay = Integer.parseInt(checkInParts[2]);

        int checkOutYear = Integer.parseInt(checkOutParts[0]);
        int checkOutMonth = Integer.parseInt(checkOutParts[1]);
        int checkOutDay = Integer.parseInt(checkOutParts[2]);

        // Assuming all months have 31 days
        // Simplified calculation
        return ((checkOutYear - checkInYear) * 12 + (checkOutMonth - checkInMonth)) * 31 + (checkOutDay - checkInDay);
    }
    public double calculateTotalPrice(double basePricePerNight, String checkInDate, String checkOutDate) {
        // Simple calculation: number of nights * base price per night
        int numberOfNights = calculateNumberOfNights(checkInDate, checkOutDate);
        return numberOfNights * basePricePerNight;
    }
    public void makeReservation(ArrayList<Hotel> hotels) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        String checkInDate = scanner.nextLine();
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        String checkOutDate = scanner.nextLine();

        Scanner scanner1 = new Scanner(System.in);
        String sIndex = scanner1.toString();
        int index = hotels.indexOf(sIndex);

        // Display available rooms
        System.out.println("\nAvailable Rooms:");
        int i = 1;
        for (Room room : hotels.get(1).getRooms())
        {
            for(int j = 0; j < rooms.size(); j++)
            {
                System.out.println(i++ + ". " + rooms.get(j).getName() + " - $" + rooms.get(j).getBasePrice() + " per night");
            }

        }

        System.out.print("Enter room number to reserve: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Validate room number
        if (roomNumber < 1 || roomNumber > hotels.get(1).getRooms().size()) {
            System.out.println("Invalid room number. Please try again.");
            return;
        }

        // Get selected room
        Room selectedRoom = hotels.get(index).getRooms().get(roomNumber - 1);

        // Calculate total price based on number of nights
        double totalPrice = calculateTotalPrice(selectedRoom.getBasePrice(), checkInDate, checkOutDate);

        // Create reservation
        Reservation reservation = new Reservation(guestName, checkInDate, checkOutDate, selectedRoom, totalPrice);
        hotels.get(index).addReservation(reservation);

        System.out.println("Reservation made successfully!");
    }
}
