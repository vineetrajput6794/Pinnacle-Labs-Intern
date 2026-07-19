import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public int getId() {
        return id;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        isBorrowed = true;
    }

    public void returnBook() {
        isBorrowed = false;
    }

    public void displayBook() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Status: " + (isBorrowed ? "Borrowed" : "Available"));
        System.out.println("----------------------------");
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Book searchBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(int id) {
        Book book = searchBook(id);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isBorrowed()) {
            System.out.println("Book is already borrowed.");
        } else {
            book.borrowBook();
            System.out.println("Book borrowed successfully.");
        }
    }

    public void returnBook(int id) {
        Book book = searchBook(id);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (!book.isBorrowed()) {
            System.out.println("Book was not borrowed.");
        } else {
            book.returnBook();
            System.out.println("Book returned successfully.");
        }
    }

    public void displayInventory() {
        if (books.isEmpty()) {
            System.out.println("Library inventory is empty.");
            return;
        }

        System.out.println("\n===== Library Inventory =====");
        for (Book book : books) {
            book.displayBook();
        }
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book(101, "Java Programming", "James Gosling"));
        library.addBook(new Book(102, "Data Structures", "Mark Allen"));
        library.addBook(new Book(103, "Operating Systems", "Abraham Silberschatz"));
        library.addBook(new Book(104, "Database Systems", "Elmasri"));

        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. View Inventory");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Add Book");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    library.displayInventory();
                    break;

                case 2:
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowId = sc.nextInt();
                    library.borrowBook(borrowId);
                    break;

                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    library.addBook(new Book(id, title, author));
                    System.out.println("Book added successfully.");
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    int searchId = sc.nextInt();

                    Book book = library.searchBook(searchId);

                    if (book != null) {
                        book.displayBook();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using the Library Management System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}