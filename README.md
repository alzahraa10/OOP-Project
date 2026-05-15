# OOP-Project
# Sprint 1 Checklist

- Are you in a Group?
No

- If so, who else is in your group?
N/A

- What programming language are you selecting? Which version?
Java (version 25)

- Do you have your GitHub account set up?
Yes

- Do you have a public repository for your Project?
Yes

- What is the link to your GitHub repository?
(https://github.com/alzahraa10/OOP-Project)

- If you are in a group, does everyone have access?
N/A

- Do you have a “Hello World” program that compiles and runs?
Yes

- Where is the entry point to your project?
src/Main.java


# Sprint 3

## Design Patterns Implemented

All 6 design patterns have been implemented and are actively used in the project:

1. **Singleton** — `LibraryCatalog.java`: Ensures only one instance of the catalog exists across the entire application. Accessed via `LibraryCatalog.getInstance()`.

2. **Observer** — `LibraryObserver.java` + `Member.java`: Members implement `LibraryObserver` and receive notifications (e.g. when a returned book becomes available).

3. **Strategy** — `FeeStrategy.java`: Interchangeable late-fee calculation strategies (`StandardFeeStrategy`, `PremiumFeeStrategy`, `StudentFeeStrategy`) are swapped in at runtime based on member type.

4. **Factory** — `LibraryItemFactory.java`: A static factory creates `PhysicalBook`, `Ebook`, or `AudioBook` instances without the caller needing to know the concrete class.

5. **Decorator** — `BookDecorator.java`: Dynamically wraps a `Displayable` book with additional behaviors — `ReservedDecorator` (+$0.50 fee), `FeaturedDecorator` (star prefix), `DamagedDecorator` (+$1.00 surcharge) — without modifying the base class.

6. **Command** — `LibraryCommand.java`: Encapsulates checkout and return actions as command objects with `execute()` and `undo()` support. `LibraryCommandManager` maintains a history stack.

## UML Diagram

See `UML_Diagram.png` in the root of this repository.

## Final Submission Goals

For the final submission, the Library Checkout System will demonstrate:

- A fully working checkout and return flow using the Command pattern (with undo support)
- Member registration and notification when a book they are waiting on becomes available (Observer)
- Support for multiple library item types: physical books, e-books, and audiobooks (Factory)
- Dynamic late-fee calculation based on member tier — standard, premium, or student (Strategy)
- Book display with stacked decorators showing reservation status, featured status, and damage surcharges (Decorator)
- A single shared catalog instance across the entire application (Singleton)

The program will run from `Main.java` and demonstrate all 6 patterns working together in a realistic library scenario.

## Sprint 3 Problems / Notes

No major blocking issues encountered. All 6 patterns were implemented and integrated successfully. The `ReturnCommand` ties together the Strategy pattern (fee calculation) and the Observer pattern (notifying members on return) in a single command, which demonstrates the patterns working together rather than in isolation.

One area to improve in future sprints: the Observer pattern currently only notifies the returning member rather than a separate waiting-list. Future work could add a proper subject/subscriber list to `LibraryCatalog` so multiple members waiting on a book all get notified on return.
