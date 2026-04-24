import java.util.ArrayList;
import java.util.List;

// DESIGN PATTERN 2: OBSERVER (concrete observer)
public class Member implements LibraryObserver {
    private String name;
    private String memberId;
    private List<Book> checkedOutBooks;
    private List<String> notifications;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.checkedOutBooks = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    @Override
    public void update(String message) {
        notifications.add(message);
        System.out.println("Notification for " + name + ": " + message);
    }

    public void addBook(Book book) { checkedOutBooks.add(book); }
    public void removeBook(Book book) { checkedOutBooks.remove(book); }
    public List<Book> getCheckedOutBooks() { return checkedOutBooks; }
    public String getName() { return name; }
    public String getMemberId() { return memberId; }

    public void printNotifications() {
        System.out.println("\nNotifications for " + name + ":");
        if (notifications.isEmpty()) System.out.println("  No notifications.");
        for (String n : notifications) System.out.println("  - " + n);
    }

    @Override
    public String toString() {
        return String.format("Member[%s]: %s (%d books checked out)",
            memberId, name, checkedOutBooks.size());
    }
}
