import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DigitalLibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        System.out.println("-------------------------------------------------------------");
        System.out.println("------------- WELCOME TO THE DIGITAL LIBRARY ----------------");
        System.out.println("-------------------------------------------------------------");

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Register User");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1 -> library.addBook(sc);
                case 2 -> library.viewBooks();
                case 3 -> library.registerUser(sc);
                case 4 -> library.borrowBook(sc);
                case 5 -> library.returnBook(sc);
                case 6 -> {
                    System.out.println("Thank you for using the Digital Library Management System!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

class Library {
    private final ArrayList<Book> books;
    private final HashMap<String, User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new HashMap<>();
    }

    public void addBook(Scanner sc) {
        System.out.print("Enter Book ID: ");
        String bookId = sc.nextLine();
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Book Author: ");
        String author = sc.nextLine();

        Book book = new Book(bookId, title, author);
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Books available in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void registerUser(Scanner sc) {
        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();
        System.out.print("Enter User Name: ");
        String userName = sc.nextLine();

        User user = new User(userId, userName);
        users.put(userId, user);
        System.out.println("User registered successfully!");
    }

    public void borrowBook(Scanner sc) {
        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();
        if (!users.containsKey(userId)) {
            System.out.println("User not found! Please register first.");
            return;
        }

        System.out.print("Enter Book ID to borrow: ");
        String bookId = sc.nextLine();
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("Book not found!");
        } else if (book.isBorrowed()) {
            System.out.println("Book is already borrowed!");
        } else {
            book.setBorrowed(true);
            System.out.println("Book borrowed successfully!");
        }
    }

    public void returnBook(Scanner sc) {
        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();
        if (!users.containsKey(userId)) {
            System.out.println("User not found!");
            return;
        }

        System.out.print("Enter Book ID to return: ");
        String bookId = sc.nextLine();
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("Book not found!");
        } else if (!book.isBorrowed()) {
            System.out.println("Book was not borrowed!");
        } else {
            book.setBorrowed(false);
            System.out.println("Book returned successfully!");
        }
    }

    private Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }
}

class Book {
    private final String id;
    private final String title;
    private final String author;
    private boolean borrowed;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }

    public String getId() {
        return id;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID='" + id + '\'' +
                ", Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Borrowed=" + borrowed +
                '}';
    }
}

class User {
    private final String id;
    private final String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID='" + id + '\'' +
                ", Name='" + name + '\'' +
                '}';
    }
}

