// DESIGN PATTERN 5: DECORATOR
// Adds features to library items dynamically

public interface Displayable {
    String getDescription();
    double getCost();
}

class BasicBook implements Displayable {
    private String title;
    public BasicBook(String title) { this.title = title; }
    @Override
    public String getDescription() { return title; }
    @Override
    public double getCost() { return 0.0; }
}

// Base decorator
abstract class BookDecorator implements Displayable {
    protected Displayable book;
    public BookDecorator(Displayable book) { this.book = book; }
    @Override
    public String getDescription() { return book.getDescription(); }
    @Override
    public double getCost() { return book.getCost(); }
}

// Adds "Reserved" tag
class ReservedDecorator extends BookDecorator {
    public ReservedDecorator(Displayable book) { super(book); }
    @Override
    public String getDescription() { return book.getDescription() + " [RESERVED]"; }
    @Override
    public double getCost() { return book.getCost() + 0.50; } // reservation fee
}

// Adds "Featured" tag
class FeaturedDecorator extends BookDecorator {
    public FeaturedDecorator(Displayable book) { super(book); }
    @Override
    public String getDescription() { return "⭐ " + book.getDescription() + " ⭐"; }
    @Override
    public double getCost() { return book.getCost(); }
}

// Adds "Damaged" warning
class DamagedDecorator extends BookDecorator {
    public DamagedDecorator(Displayable book) { super(book); }
    @Override
    public String getDescription() { return book.getDescription() + " [DAMAGED - handle with care]"; }
    @Override
    public double getCost() { return book.getCost() + 1.00; } // damage surcharge
}
