// DESIGN PATTERN 2: OBSERVER
// Notifies members when a book becomes available

public interface LibraryObserver {
    void update(String message);
}
