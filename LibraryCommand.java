import java.util.Stack;

// DESIGN PATTERN 6: COMMAND
// Encapsulates checkout/return actions so they can be undone

public interface LibraryCommand {
    void execute();
    void undo();
    String getDescription();
}

class CheckoutCommand implements LibraryCommand {
    private Book book;
    private Member member;

    public CheckoutCommand(Book book, Member member) {
        this.book = book;
        this.member = member;
    }

    @Override
    public void execute() {
        book.setCheckedOut(true);
        member.addBook(book);
        System.out.println(member.getName() + " checked out: " + book.getTitle());
    }

    @Override
    public void undo() {
        book.setCheckedOut(false);
        member.removeBook(book);
        System.out.println("Undid checkout: " + book.getTitle() + " returned by " + member.getName());
    }

    @Override
    public String getDescription() {
        return "Checkout: " + book.getTitle() + " by " + member.getName();
    }
}

class ReturnCommand implements LibraryCommand {
    private Book book;
    private Member member;
    private FeeStrategy feeStrategy;
    private int daysLate;

    public ReturnCommand(Book book, Member member, FeeStrategy feeStrategy, int daysLate) {
        this.book = book;
        this.member = member;
        this.feeStrategy = feeStrategy;
        this.daysLate = daysLate;
    }

    @Override
    public void execute() {
        book.setCheckedOut(false);
        member.removeBook(book);
        double fee = feeStrategy.calculateFee(daysLate);
        System.out.println(member.getName() + " returned: " + book.getTitle());
        if (fee > 0) {
            System.out.printf("  Late fee (%s): $%.2f%n", feeStrategy.getStrategyName(), fee);
        } else {
            System.out.println("  No late fee.");
        }
        // Notify observers (other members waiting for this book)
        member.update("\"" + book.getTitle() + "\" is now available!");
    }

    @Override
    public void undo() {
        book.setCheckedOut(true);
        member.addBook(book);
        System.out.println("Undid return: " + book.getTitle() + " re-checked out to " + member.getName());
    }

    @Override
    public String getDescription() {
        return "Return: " + book.getTitle() + " by " + member.getName();
    }
}

// Command manager with undo history
class LibraryCommandManager {
    private Stack<LibraryCommand> history = new Stack<>();

    public void executeCommand(LibraryCommand command) {
        command.execute();
        history.push(command);
    }

    public void undoLast() {
        if (!history.isEmpty()) {
            LibraryCommand last = history.pop();
            System.out.println("Undoing: " + last.getDescription());
            last.undo();
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void printHistory() {
        System.out.println("\n=== Command History ===");
        if (history.isEmpty()) { System.out.println("No commands yet."); return; }
        for (LibraryCommand c : history) System.out.println("  " + c.getDescription());
    }
}
