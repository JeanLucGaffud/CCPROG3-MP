//Hotel Reservation System Class or HRS 
import java.util.*;
import MP3.Guest


import static java.lang.System.in;

public class HRS {
    ArrayList<Hotel> hotels;

    public HRS() {
        this.hotels = new ArrayList<Hotel>();
    }
    
    public void promptHotelSystem()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the Hotel Reservation System!");
        System.out.println("\n Main Menu");
        System.out.println("1. Create Hotel");
        System.out.println("2. View Hotel");
        System.out.println("3. Manage Hotel");
        System.out.println("4. Simulate Booking");
        System.out.println("5. Exit");
        int choice = in.nextInt();
    }
    public void promptCreateHotel(){
        System.out.println("Enter hotel name: ");
        String hotelName = in.next();
        Hotel newHotel = new Hotel(hotelName);
        hotels.add(newHotel);
    }

    public void promptViewHotel(){
        System.out.println("1. High level information");
        System.out.println("Enter hotel name: ");
        String hotelName = in.next();
        if(hotels.indexOf(hotelName) == -1)
        {
            System.out.println("Hotel not found");
            break;
        }
        System.out.println("\nHotel Name: " +hotels.get(hotels.indexOf(hotelName)).getHotelName());
        System.out.println("Total number of booked room: " +hotels.get(hotels.indexOf(hotelName)).getNReservation());
        System.out.println("Total number of rooms: " +hotels.get(hotels.indexOf(hotelName)).getTotalRooms());
        System.out.println("Estimate earnings: " +hotels.get(hotels.indexOf(hotelName)).getEstimateEarnings());
    }

    public void promptManageHotel(){
        System.out.println("1. Change hotel name");
        System.out.println("2. Add room");
        System.out.println("3. Remove room");
        System.out.println("4. Update base price");
        System.out.println("Enter hotel name: ");
        ;
        String hotelName = in.next();
        if(hotels.indexOf(hotelName) == -1)
        {
            System.out.println("Hotel not found");
            break;
        }
        int choice1 = in.nextInt();
        switch(choice1)
        {
            case 1:
                System.out.println("Enter new hotel name: ");
                String newName = in.next();
                hotels.get(hotels.indexOf(hotelName)).changeName(newName);
                break;
            case 2:
                System.out.println("Enter room name: ");
                String roomName = in.next();
                Room newRoom = new Room(roomName);
                hotels.get(hotels.indexOf(hotelName)).addRoom(newRoom);
                break;
            case 3:
                System.out.println("Enter room name: ");
                String roomName = in.next();
                Room room = new Room(roomName);
                hotels.get(hotels.indexOf(hotelName)).removeRoom(room);
                break;
            case 4:
                System.out.println("Enter new base price: ");
                double newBasePrice = in.nextDouble();
                hotels.get(hotels.indexOf(hotelName)).updateBasePrice(newBasePrice);
                break;
        }
    }

}
