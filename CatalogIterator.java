// DESIGN PATTERN 8: ITERATOR
// Provides a way to walk through the catalog without exposing its internal list.

import java.util.List;
import java.util.NoSuchElementException;

// Iterator interface
interface LibraryIterator {
    boolean hasNext();
    Book next();
}

// Concrete iterator — iterates over all books
class AllBooksIterator implements LibraryIterator {
    private List<Book> books;
    private int index = 0;

    public AllBooksIterator(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return index < books.size();
    }

    @Override
    public Book next() {
        if (!hasNext()) throw new NoSuchElementException("No more books.");
        return books.get(index++);
    }
}

// Concrete iterator — iterates only over available (not checked out) books
class AvailableBooksIterator implements LibraryIterator {
    private List<Book> books;
    private int index = 0;
    private Book nextBook = null;

    public AvailableBooksIterator(List<Book> books) {
        this.books = books;
        advance();
    }

    private void advance() {
        nextBook = null;
        while (index < books.size()) {
            Book b = books.get(index++);
            if (!b.isCheckedOut()) {
                nextBook = b;
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return nextBook != null;
    }

    @Override
    public Book next() {
        if (!hasNext()) throw new NoSuchElementException("No more available books.");
        Book result = nextBook;
        advance();
        return result;
    }
}
