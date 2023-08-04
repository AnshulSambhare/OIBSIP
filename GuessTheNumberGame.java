import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumberGame {

    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int totalRounds = 3;
        int score = 0;

        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number Game!");

        for (int round = 1; round <= totalRounds; round++) {
            JOptionPane.showMessageDialog(null, "Round " + round + "! You have " + maxAttempts + " attempts.");

            int targetNumber = generateRandomNumber(minRange, maxRange);
            int attempts = 0;

            while (attempts < maxAttempts) {
                int guess = getUserGuess(minRange, maxRange);
                attempts++;

                if (guess == targetNumber) {
                    int roundScore = calculateScore(maxAttempts, attempts);
                    score += roundScore;
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in "
                            + attempts + " attempts. You scored " + roundScore + " points in this round.");
                    break;
                } else if (guess < targetNumber) {
                    JOptionPane.showMessageDialog(null, "Your guess is too low.");
                } else {
                    JOptionPane.showMessageDialog(null, "Your guess is too high.");
                }
            }

            if (attempts == maxAttempts) {
                JOptionPane.showMessageDialog(null, "Oops! You ran out of attempts. The correct number was: " + targetNumber);
            }
        }

        JOptionPane.showMessageDialog(null, "Game over! Your final score: " + score);
    }

    private static int generateRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    private static int getUserGuess(int min, int max) {
        String input = JOptionPane.showInputDialog("Guess the number between " + min + " and " + max + ":");
        int guess = Integer.parseInt(input);
        while (guess < min || guess > max) {
            input = JOptionPane.showInputDialog("Invalid guess! Please enter a number between " + min + " and " + max + ":");
            guess = Integer.parseInt(input);
        }
        return guess;
    }

    private static int calculateScore(int maxAttempts, int attempts) {
         
        int maxScore = 100; // Maximum score for a round
        int deductionPerAttempt = maxScore / maxAttempts;
        return maxScore - (deductionPerAttempt * (attempts - 1));
    }
}
