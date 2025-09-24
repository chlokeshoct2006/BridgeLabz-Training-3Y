public class HotelBooking {
    String guestName;
    String roomType;
    int nights;


    public HotelBooking() {
        this("Unknown", "Standard", 1); // Calls parameterized constructor
    }

    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public HotelBooking(HotelBooking hb) {
        this.guestName = hb.guestName;
        this.roomType = hb.roomType;
        this.nights = hb.nights;
    }

    void display() {
        System.out.println("Guest: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }
}

class Main {
    public static void main(String[] args) {
        HotelBooking b1 = new HotelBooking(); 
        b1.display();

        System.out.println();

        HotelBooking b2 = new HotelBooking("John Doe", "Deluxe", 3); // Parameterized
        b2.display();

        System.out.println();

        HotelBooking b3 = new HotelBooking(b2);
        b3.display();
    }
}
