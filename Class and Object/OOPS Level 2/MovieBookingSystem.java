class MovieTicket {
    String movieName;
    int seatNumber;
    double price;
    boolean isBooked;

  
    MovieTicket(String movieName, double price) {
        this.movieName = movieName;
        this.price = price;
        this.isBooked = false;
    }

    
    void bookTicket(int seatNumber) {
        if (!isBooked) {
            this.seatNumber = seatNumber;
            this.isBooked = true;
            System.out.println("Ticket booked successfully for " + movieName + " (Seat: " + seatNumber + ")");
        } else {
            System.out.println("Sorry, this ticket is already booked!");
        }
    }

    
    void displayTicket() {
        if (isBooked) {
            System.out.println(" Ticket Details ");
            System.out.println("Movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: " + price);
           
        } else {
            System.out.println("No ticket booked yet for " + movieName);
        }
    }
}

public class MovieBookingSystem {
    public static void main(String[] args) {
        
        MovieTicket t1 = new MovieTicket("Avengers: Endgame", 300);
        MovieTicket t2 = new MovieTicket("Inception", 250);

       
        t1.bookTicket(12);
        t1.displayTicket();

        t2.displayTicket(); 
        t2.bookTicket(5);
        t2.displayTicket();

        
        t1.bookTicket(20);
    }
}

