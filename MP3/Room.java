
import java.util.*;
import java.time.LocalDateTime;

public class Room {
    private String name;
    private double basePrice;
    private String status;
    private ArrayList<Reservation> reservations;

    public Room(String name) {
        this.reservations = new ArrayList<>();
        this.name = name;
        this.basePrice = 1299.0;
    }
    public String getName()
    {
        return this.name;
    }
    public double getBasePrice()
    {
        return this.basePrice;
    }
    public String getStatus()
    {
        return this.status;
    }
    public void setBasePrice(double basePrice)
    {
        this.basePrice = basePrice;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    //Adjust for localdatetime class
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

    public LocalDateTime toDate(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        int hour = Integer.parseInt(parts[3]);
        int minute = Integer.parseInt(parts[4]);
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public boolean promptReserveRoom(){
        Guest guest;
        String sDate;
        LocalDateTime checkInDate;
        LocalDateTime checkOutDate;
        Scanner scanner = new Scanner(System.in);
        
        guest = promptGuestInfo();

        System.out.print("Enter check-in date (YYYY-MM-DD-HH-MM): ");
        sDate = scanner.nextLine();

        if (isValidDate(sDate)) {
            System.out.println("Invalid date format. Please try again.");
            return false;
        }
        
        checkInDate = toDate(sDate);
      
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        sDate = scanner.nextLine();

        if (isValidDate(sDate)) {
            System.out.println("Invalid date format. Please try again.");
            return;
        }

        checkOutDate = toDate(sDate);

        reservations.add(new Reservation(guest, checkInDate, checkOutDate));
        return true;
    }
    
   
}
