// DESIGN PATTERN 4: FACTORY
// Creates different types of library items

public abstract class LibraryItem {
    protected String title;
    protected String creator;
    protected String id;

    public LibraryItem(String title, String creator, String id) {
        this.title = title;
        this.creator = creator;
        this.id = id;
    }

    public abstract String getType();
    public String getTitle() { return title; }
    public String getId() { return id; }

    @Override
    public String toString() {
        return String.format("%s: \"%s\" by %s [ID: %s]", getType(), title, creator, id);
    }
}

class PhysicalBook extends LibraryItem {
    public PhysicalBook(String title, String author, String isbn) {
        super(title, author, isbn);
    }
    @Override
    public String getType() { return "Physical Book"; }
}

class Ebook extends LibraryItem {
    public Ebook(String title, String author, String id) {
        super(title, author, id);
    }
    @Override
    public String getType() { return "E-Book"; }
}

class AudioBook extends LibraryItem {
    public AudioBook(String title, String narrator, String id) {
        super(title, narrator, id);
    }
    @Override
    public String getType() { return "Audiobook"; }
}

// The Factory
class LibraryItemFactory {
    public static LibraryItem createItem(String type, String title, String creator, String id) {
        switch (type.toLowerCase()) {
            case "physical": return new PhysicalBook(title, creator, id);
            case "ebook":    return new Ebook(title, creator, id);
            case "audio":    return new AudioBook(title, creator, id);
            default: throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }
}
