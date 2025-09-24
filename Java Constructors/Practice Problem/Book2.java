public class Book2 {
    String title;
    String author;
    double price;
    boolean available;

    public Book2(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }


    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("You have borrowed: " + title);
        } else {
            System.out.println("Sorry, " + title + " is not available.");
        }
    }


    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Available: " + (available ? "Yes" : "No"));
    }
}

class Main {
    public static void main(String[] args) {
        Book2 b1 = new Book2("1984", "George Orwell", 12.99, true);
        b1.display();

        System.out.println();
        b1.borrowBook(); 
        b1.borrowBook();

        System.out.println();
        b1.display(); 
    }
}
