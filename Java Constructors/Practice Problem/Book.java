public class Book {
    String title;
    String author;
    double price;

    public Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    public Book(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
    }

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
}

class Main {
    public static void main(String[] args) {
        Book b1 = new Book();
        b1.display();

        System.out.println();

        Book b2 = new Book("1984", "George Orwell", 15.99);
        b2.display();
    }
}
