public class Guest {
    private String name;
    private String email;

    public Guest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Guest promptGuestInfo() {
        System.out.println("Enter your name: ");
        String name = in.next();
        System.out.println("Enter your email: ");
        String email = in.next();
        Guest guest = new Guest(name, email);
        return guest;
    }
}
