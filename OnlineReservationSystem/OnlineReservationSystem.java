import java.util.ArrayList;
import java.util.Scanner;

public class OnlineReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        System.out.println("-------------------------------------------------------------");
        System.out.println("--------- WELCOME TO THE ONLINE RESERVATION SYSTEM ----------");
        System.out.println("-------------------------------------------------------------");

        while (true) {
            System.out.println("1. SIGN UP");
            System.out.println("2. LOGIN");
            System.out.println("3. EXIT");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> signUp(users, sc);
                case 2 -> login(users, sc);
                case 3 -> {
                    System.out.println("Thank you for using the Online Reservation System!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void signUp(ArrayList<User> users, Scanner sc) {
        sc.nextLine(); // consume newline
        System.out.print("Enter User ID: ");
        String id = sc.nextLine();
        System.out.print("Enter password: ");
        String pw = sc.nextLine();
        users.add(new User(id, pw));
        System.out.println("SIGN UP SUCCESSFULLY!");
    }

    private static void login(ArrayList<User> users, Scanner sc) {
        sc.nextLine(); // consume newline
        System.out.print("Enter User ID: ");
        String id = sc.nextLine();
        System.out.print("Enter password: ");
        String pw = sc.nextLine();

        for (User user : users) {
            if (user.getId().equals(id) && user.getPassword().equals(pw)) {
                System.out.println("LOGIN SUCCESSFULLY!");
                reservationMenu(sc);
                return;
            }
        }
        System.out.println("INCORRECT ID & PASSWORD!");
    }

    private static void reservationMenu(Scanner sc) {
        while (true) {
            System.out.println("1. Make a Reservation");
            System.out.println("2. Cancel a Reservation");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> makeReservation(sc);
                case 2 -> cancelReservation(sc);
                case 3 -> {
                    System.out.println("Logged out successfully.");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void makeReservation(Scanner sc) {
        sc.nextLine(); // consume newline
        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Start Location: ");
        String start = sc.nextLine();
        System.out.print("Enter End Location: ");
        String end = sc.nextLine();
        System.out.print("Enter Class Type (1- First Class, 2- Second Class): ");
        int classType = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Travel Date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        int pnr = (int) (Math.random() * 10000);

        System.out.println("Reservation made successfully with PNR: " + pnr);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("From: " + start + " To: " + end);
        System.out.println("Class: " + (classType == 1 ? "First Class" : "Second Class"));
        System.out.println("Date: " + date);
    }

    private static void cancelReservation(Scanner sc) {
        System.out.print("Enter PNR to cancel: ");
        int pnr = sc.nextInt();
        System.out.println("Reservation with PNR " + pnr + " cancelled successfully.");
    }
}

class User {
    private String id;
    private final String password;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public User(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}

