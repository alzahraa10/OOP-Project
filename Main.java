// Library Checkout System - Main Demo
// Demonstrates 8 Design Patterns:
//   1. Singleton   - LibraryCatalog
//   2. Observer    - Member notifications
//   3. Strategy    - Fee calculation
//   4. Factory     - LibraryItem creation
//   5. Decorator   - Book display features
//   6. Command     - Checkout/return with undo
//   7. Builder     - MemberBuilder
//   8. Iterator    - CatalogIterator

public class Main {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   LIBRARY CHECKOUT SYSTEM DEMO");
        System.out.println("========================================\n");

        // -------------------------
        // PATTERN 1: SINGLETON
        // -------------------------
        System.out.println("--- Pattern 1: Singleton (LibraryCatalog) ---");
        LibraryCatalog catalog = LibraryCatalog.getInstance();
        LibraryCatalog catalog2 = LibraryCatalog.getInstance();
        System.out.println("Same instance? " + (catalog == catalog2)); // true
        catalog.printCatalog();

        // -------------------------
        // PATTERN 2: OBSERVER
        // -------------------------
        System.out.println("\n--- Pattern 2: Observer (Member Notifications) ---");
        Member alice = new Member("Alice", "M001");
        Member bob = new Member("Bob", "M002");
        Member student = new Member("Charlie", "M003");
        System.out.println("Members created: " + alice + ", " + bob + ", " + student);

        // -------------------------
        // PATTERN 3: STRATEGY
        // -------------------------
        System.out.println("\n--- Pattern 3: Strategy (Fee Calculation) ---");
        FeeStrategy standardFee = new StandardFeeStrategy();
        FeeStrategy premiumFee = new PremiumFeeStrategy();
        FeeStrategy studentFee = new StudentFeeStrategy();

        int daysLate = 5;
        System.out.printf("Standard fee for %d days late: $%.2f%n", daysLate, standardFee.calculateFee(daysLate));
        System.out.printf("Premium fee for %d days late:  $%.2f%n", daysLate, premiumFee.calculateFee(daysLate));
        System.out.printf("Student fee for %d days late:  $%.2f%n", daysLate, studentFee.calculateFee(daysLate));

        // -------------------------
        // PATTERN 4: FACTORY
        // -------------------------
        System.out.println("\n--- Pattern 4: Factory (LibraryItem Creation) ---");
        LibraryItem physicalBook = LibraryItemFactory.createItem("physical", "Clean Code", "Robert Martin", "ISBN-001");
        LibraryItem ebook        = LibraryItemFactory.createItem("ebook",    "Design Patterns", "Gang of Four", "EB-002");
        LibraryItem audiobook    = LibraryItemFactory.createItem("audio",    "Atomic Habits", "James Clear", "AU-003");
        System.out.println(physicalBook);
        System.out.println(ebook);
        System.out.println(audiobook);

        // -------------------------
        // PATTERN 5: DECORATOR
        // -------------------------
        System.out.println("\n--- Pattern 5: Decorator (Book Display) ---");
        Displayable book = new BasicBook("The Great Gatsby");
        System.out.println("Basic:     " + book.getDescription() + " | Cost: $" + book.getCost());

        book = new FeaturedDecorator(book);
        System.out.println("Featured:  " + book.getDescription() + " | Cost: $" + book.getCost());

        book = new ReservedDecorator(book);
        System.out.println("Reserved:  " + book.getDescription() + " | Cost: $" + book.getCost());

        book = new DamagedDecorator(book);
        System.out.println("Damaged:   " + book.getDescription() + " | Cost: $" + book.getCost());

        // -------------------------
        // PATTERN 6: COMMAND
        // -------------------------
        System.out.println("\n--- Pattern 6: Command (Checkout/Return with Undo) ---");
        LibraryCommandManager manager = new LibraryCommandManager();
        Book gatsby = catalog.findByIsbn("978-0743273565");
        Book orwell = catalog.findByIsbn("978-0451524935");

        // Checkout books
        manager.executeCommand(new CheckoutCommand(gatsby, alice));
        manager.executeCommand(new CheckoutCommand(orwell, bob));

        // Return with late fees
        manager.executeCommand(new ReturnCommand(gatsby, alice, standardFee, 3));
        manager.executeCommand(new ReturnCommand(orwell, bob, studentFee, 2));

        // Undo last action
        System.out.println("\nUndoing last command...");
        manager.undoLast();

        // Print history
        manager.printHistory();

        // Print final catalog
        catalog.printCatalog();

        // -------------------------
        // PATTERN 7: BUILDER
        // -------------------------
        System.out.println("\n--- Pattern 7: Builder (MemberBuilder) ---");

        Member premiumMember = new MemberBuilder()
            .setName("Diana")
            .setMemberId("M004")
            .setMembershipType("PREMIUM")
            .build();

        Member studentMember = new MemberBuilder()
            .setName("Evan")
            .setMemberId("M005")
            .setMembershipType("STUDENT")
            .build();

        Member customMember = new MemberBuilder()
            .setName("Fiona")
            .setMemberId("M006")
            .setMembershipType("STANDARD")
            .setFeeStrategy(new PremiumFeeStrategy()) // custom override
            .build();

        System.out.println("Built: " + premiumMember);
        System.out.println("Built: " + studentMember);
        System.out.println("Built (custom fee): " + customMember);

        // -------------------------
        // PATTERN 8: ITERATOR
        // -------------------------
        System.out.println("\n--- Pattern 8: Iterator (CatalogIterator) ---");

        System.out.println("All books in catalog:");
        LibraryIterator allBooks = catalog.getAllBooksIterator();
        while (allBooks.hasNext()) {
            Book b = allBooks.next();
            System.out.println("  " + b.getTitle() + " | Checked out: " + b.isCheckedOut());
        }

        System.out.println("\nAvailable books only:");
        LibraryIterator availableBooks = catalog.getAvailableBooksIterator();
        while (availableBooks.hasNext()) {
            Book b = availableBooks.next();
            System.out.println("  " + b.getTitle());
        }

        System.out.println("\n========================================");
        System.out.println("   DEMO COMPLETE");
        System.out.println("========================================");
    }
}
