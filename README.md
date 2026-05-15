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
The final demo will show a full checkout/return flow using all 6 patterns working together — a member checks out a book (Command + Singleton), gets a late fee on return (Strategy), sees book status decorated (Decorator), receives a notification (Observer), and items are created via factory (Factory).

### Sprint 3 Problems
No blocking issues. All 6 patterns are implemented and integrated in Main.java.
