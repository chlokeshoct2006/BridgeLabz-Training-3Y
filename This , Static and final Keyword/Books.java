class Book {
    static String libraryName = "City Library";
    
    private String title;
    private String author;
    private final String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayDetails() {
        if (this instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }
}

public class Books {
    public static void main(String[] args) {
        Book.displayLibraryName();
        
        Book b1 = new Book("Java Programming", "James Gosling", "ISBN101");
        Book b2 = new Book("Python Basics", "Guido van Rossum", "ISBN102");

        b1.displayDetails();
        System.out.println();
        b2.displayDetails();
    }
}
