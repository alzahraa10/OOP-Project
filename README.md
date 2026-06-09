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

## Sprint 3

### Design Patterns Implemented

1. **Singleton** — `LibraryCatalog.java`: Only one catalog instance exists, accessed via `LibraryCatalog.getInstance()`.
2. **Observer** — `LibraryObserver.java` + `Member.java`: Members get notified when a book becomes available.
3. **Strategy** — `FeeStrategy.java`: Swappable late-fee strategies (Standard, Premium, Student) based on member type.
4. **Factory** — `LibraryItemFactory.java`: Creates PhysicalBook, Ebook, or AudioBook without exposing the constructor.
5. **Decorator** — `BookDecorator.java`: Wraps books dynamically with Reserved, Featured, or Damaged tags and fees.
6. **Command** — `LibraryCommand.java`: Checkout and return actions are encapsulated with undo support via a history stack.

### UML Diagram
See `UML_Diagram.png` in the root of this repository.

### Final Submission Goals
The final demo will show a full checkout/return flow using all 8 patterns working together.

### Sprint 3 Problems
No blocking issues. All patterns are implemented and integrated in Main.java.

---

## Sprint 4

### Design Patterns Added

7. **Builder** — `MemberBuilder.java`: Builds Member objects step by step using a fluent interface. Automatically assigns the correct default fee strategy based on membership type.
8. **Iterator** — `CatalogIterator.java`: Two custom iterators — AllBooksIterator and AvailableBooksIterator — walk through the catalog without exposing the internal list.

### UML Diagram
See `UML_Diagram-2.png` in the root of this repository.

### Sprint 4 Problems
No blocking issues. Builder and Iterator integrate cleanly with existing code.

---

## Sprint 5

### Design Patterns Status
All 8 design patterns fully implemented and integrated:

1. Singleton — LibraryCatalog
2. Observer — LibraryObserver / Member
3. Strategy — FeeStrategy (Standard, Premium, Student)
4. Factory — LibraryItemFactory
5. Decorator — BookDecorator (Reserved, Featured, Damaged)
6. Command — LibraryCommand + LibraryCommandManager
7. Builder — MemberBuilder
8. Iterator — CatalogIterator (AllBooks, AvailableBooks)

### UML Diagram
See `UML_Diagram-2.png` in the root of this repository.

### Final Submission Goals
The final demo will show a full library session: members built with Builder, catalog browsed with Iterator, books checked out and returned using Command (with undo), fees calculated via Strategy, items created via Factory, display enhanced with Decorator, notifications sent through Observer, all sharing one catalog via Singleton.

### Sprint 5 Problems
No issues. All 8 patterns are complete and working together in Main.java.

---

## Final Submission

### Bugs / Known Issues
- No major bugs. All 8 patterns compile and run correctly together.
- The project runs as a console demo via Main.java showing all patterns in sequence.
- No GUI implemented; the focus was on demonstrating design patterns through a working library checkout flow.

### Notes
- Entry point: `Main.java`
- UML diagram: `UML_Diagram-2.png`
- All 8 design patterns exceed the requirement of 6 for a solo project.
