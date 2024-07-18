import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        boolean play = true;
        try (Scanner sc = new Scanner(System.in)) {
            while (play) {
                int answer = (int) (Math.random() * 100) + 1;
                int k = 5;
                boolean correct = false;
                int trials=1;
                System.out.println("A number is choosen between 1 to 100. \nGuess the number within 5 trials.");
                while (k > 0) {
                    System.out.print("Trial "+trials+" : Guess the number: ");
                    int guess = sc.nextInt();
                    if (guess == answer) {
                        System.out.println("Congratulations!! You have guessed correctly.");
                        correct = true;
                        break;
                    } else if (guess > answer) {
                        System.out.println("The number is less than " + guess + ". you have " + (k - 1) + " chances left.");
                        k--;
                    } else if (guess < answer) {
                        System.out.println("The number is greater than " + guess + ". you have " + (k - 1) + " chances left.");
                        k--;
                    }
                    trials++;
                }
                if (correct == false) {
                    System.out.println("The number was " + answer);
                    System.out.println("Play again ...");
                }
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = sc.next();
                if (!playAgain.equalsIgnoreCase("yes")) {
                    play = false;
                    System.out.println("Thanks for playing!");
                }
            }
        }
    }
}
