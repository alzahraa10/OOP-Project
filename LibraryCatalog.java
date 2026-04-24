import java.util.ArrayList; // Singleton Pattern - only one catalog instance
import java.util.List;

// DESIGN PATTERN 1: SINGLETON
// Ensures only one instance of the library catalog exists
public class LibraryCatalog {
    private static LibraryCatalog instance;
    private List<Book> books;

    private LibraryCatalog() {
        books = new ArrayList<>();
        // Add some starter books
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "978-0061935466"));
        books.add(new Book("1984", "George Orwell", "978-0451524935"));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "978-0141439518"));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "978-0547928227"));
    }

    public static LibraryCatalog getInstance() {
        if (instance == null) {
            instance = new LibraryCatalog();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added to catalog: " + book.getTitle());
    }

    public Book findByIsbn(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) return b;
        }
        return null;
    }

    public List<Book> getAllBooks() { return books; }

    public void printCatalog() {
        System.out.println("\n=== Library Catalog ===");
        for (Book b : books) System.out.println(b);
    }
}
