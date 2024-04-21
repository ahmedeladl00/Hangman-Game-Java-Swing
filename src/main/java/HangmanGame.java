import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the secret word:");
            String secretWord = scanner.nextLine();

            Game game = new Game(secretWord);
            Player player = new Player(6); // Setting max wrong guesses as 6

            while (!player.isOver() && !game.isWin()) {
                System.out.println("Current progress: " + game.displayProgress());
                System.out.println("You have " + player.getRemainingGuesses() + " wrong guesses left.");

                System.out.println("Enter your guess:");
                char guess = scanner.next().charAt(0);

                if (!game.checkGuess(guess)) {
                    player.decrementGuesses();
                }
            }

            if (game.isWin()) {
                System.out.println("Congratulations! You've guessed the word: " + secretWord);
            } else {
                System.out.println("Game Over! The correct word was: " + secretWord);
            }
        }
    }
}