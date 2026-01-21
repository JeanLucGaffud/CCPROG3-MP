import java.util.ArrayList;

public class Hotel {
    private String hotelName;
    private int nReservation;
    private ArrayList<Room> rooms;
    private int totalRooms;
    private double estimateEarnings;

    public Hotel(String hotelName) {
        this.hotelName = hotelName;
        this.nReservation = 0;
    }
    public void changeName(String newName) {
        hotelName = newName;
    }
    public String getHotelName() {
        return hotelName;
    }
    public int getNReservation() {
        return nReservation;
    }
    public void setNReservation(int nReservation) {
        this.nReservation = nReservation;
    }
    public ArrayList<Room> getRooms() {
        return rooms;
    }
    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
    public int getTotalRooms() {
        return totalRooms;
    }
    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }
    public double getEstimateEarnings() {
        return estimateEarnings;
    }
    public void setEstimateEarnings(double estimateEarnings) {
        this.estimateEarnings = rooms.getFirst().getBasePrice() * nReservation;
    }
    public void addRoom(Room newRoom) {
        rooms.add(newRoom);
    }
    public void removeRoom(Room room) {
        rooms.remove(room);
    }
    public void updateBasePrice(double newBasePrice) {
        for (Room room : rooms) {
            if (room.getBasePrice() != newBasePrice) {
                room.setBasePrice(newBasePrice);
            }
        }
    }
    public void addReservation(Reservation newReservation) {
        this.reservations.add(newReservation);
    }
    public void removeReservation(Reservation newReservation) {
        this.reservations.remove(newReservation);
    }

    public boolean promptReserve() {
        
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
