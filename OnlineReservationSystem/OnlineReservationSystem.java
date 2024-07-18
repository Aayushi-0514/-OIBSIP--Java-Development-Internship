import java.util.Date;
import java.util.Scanner;

public class OnlineReservationSystem {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------");
        System.out.println(" -----------| WELCOME TO ONLINE-RESERVATION SYSTEM |-----------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("|\t\t\t\tPRESS BUTTON\t\t\t|");
        System.out.println("------------------------------------------------------------------");
        System.out.println("\t\t1. SIGN UP \t\t\t 2. LOGIN");
        System.out.println("------------------------------------------------------------------");
        System.out.print("\t\t\t\t");
        int BUTTON = sc.nextInt();
        System.out.println("------------------------------------------------------------------");

        switch (BUTTON) {
            case 1 -> signIn();
            case 2 -> {
                System.out.println("First Create Your Account!");
                System.out.println("------------------------------------------------------------------");
                signIn();
            }
            default -> {
                System.out.println(" ----------- |\t\t\tINCORRECT INPUT\t\t\t\t| ----------- ");
                System.out.println("------------------------------------------------------------------");
            }
        }
    }

    public static void signIn() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String id;
        String pw;

        System.out.print("Enter User ID: ");
        try {
            id = sc.next();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        System.out.print("Enter password: ");
        try {
            pw = sc.next();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        System.out.println(" ----------- | SIGN IN SUCCESSFULLY | -----------");
        System.out.println("------------------------------------------------------------------");
        logIn(id, pw);
    }

    public static void logIn(String id, String pw) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter User LOGIN_ID: ");
        String L_id = sc.next();
        System.out.print("Enter LOGIN_Password: ");
        String L_pw = sc.next();

        if (id.equals(L_id) && pw.equals(L_pw)) {
            System.out.println(" ----------- | LOGIN IN SUCCESSFULLY | -----------");
            System.out.println("------------------------------------------------------------------");
            System.out.println(" ----------- | PRESS BUTTON | ----------- ");
            System.out.println("1. Reservation System");
            int BUTTON1 = sc.nextInt();
            if (BUTTON1 == 1) {
                reservationSystem();
            } else {
                System.out.println(" ----------- |\t\t\tINCORRECT INPUT\t\t\t\t| ----------- ");
                System.out.println("------------------------------------------------------------------");
            }
        } else {
            System.out.println("------------------------------------------------------------------");
            System.out.println("\t\t\t\t\t\t| 404 |\t\t\t");
            System.out.println("\t\t\t\tINCORRECT ID & PASSWORD\t\t\t");
            System.out.println("------------------------------------------------------------------");
        }
    }

    public static void cancellationSystem(String name, int age, String start, String end, int PNR, int classType,
    String date, String trainName, int trainNumber) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter PNR: ");
        int PNR_No = sc.nextInt();
        if (PNR == PNR_No) {
            printTicket(name, age, start, end, PNR, classType, date, trainName, trainNumber);
            System.out.println("-----------| CANCELLATION SUCCESSFULLY |----------- ");
            System.out.println("------------------------------------------------------------------");
        } else {
            System.out.println("-----------| PNR NOT FOUND!! |-----------");
            cancellationSystem(name, age, start, end, PNR, classType, date, trainName, trainNumber);
            System.out.println("------------------------------------------------------------------");
        }
    }

    public static void reservationSystem() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------");

        System.out.print("Enter Name of Passenger: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        sc.nextLine(); // consume newline

        System.out.print("Enter Train Name: ");
        String trainName = sc.nextLine();

        System.out.print("Enter Destination Date: ");
        String date = sc.next();

        System.out.print("Enter Class Type: ");
        int classType = sc.nextInt();

        sc.nextLine(); // consume newline

        System.out.print("Enter Starting Point: ");
        String start = sc.next();

        System.out.print("Enter Destination Point: ");
        String end = sc.next();

        System.out.println("------------------------------------------------------------------");

        int trainNumber = (int) (Math.random() * 1000000);
        int PNR = (int) (Math.random() * 10000);

        System.out.print("Press 1 To Generate Ticket: ");
        int button3 = sc.nextInt();

        switch (button3) {
            case 1 -> {
                printTicket(name, age, start, end, PNR, classType, date, trainName, trainNumber);
                System.out.println("-----------| YOUR TICKET IS CONFIRMED SUCCESSFULLY |-----------");
                System.out.println("------------------------------------------------------------------");
            }
            case 2 -> {
                cancellationSystem(name, age, start, end, PNR, classType, date, trainName, trainNumber);
            }
            default -> {
                System.out.println(" ----------- |\t\t\tINCORRECT INPUT\t\t\t\t| ----------- ");
                System.out.println("------------------------------------------------------------------");
            }
        }
    }

    public static void printTicket(String name, int age, String start, String end, int PNR, int classType,
    String date, String trainName, int trainNumber) {
        System.out.println("------------------------------------------------------------------");
        System.out.println(" ----------- |\t\t\t\tTICKET\t\t\t\t| ----------- ");
        System.out.println("------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t" + new Date());
        System.out.println("\t\t\t\t\t\t\t-----------------------------------");
        System.out.println("|Train Name|\t\t\t|Train Number|\t\t\t|PNR|\t\t\t|Class_Type|");
        System.out.println(trainName + "\t\t\t\t\t" + trainNumber + "\t\t\t\t" + PNR + "\t\t\t\t" + classType);
        System.out.println("\nDestination - " + start + "\t\tTo\t\t" + end);
        System.out.println("\n|Passenger Name|\t\t\t|Age|\t\t\t|Date|");
        System.out.println(name + "\t\t\t\t\t" + age + "\t\t\t\t" + date);
        System.out.println("------------------------------------------------------------------");
    }
}
