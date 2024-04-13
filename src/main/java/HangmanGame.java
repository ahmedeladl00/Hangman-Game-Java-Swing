import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * =====================================================================
 * Write your implementation for the assignment at the "TODO" sections.
 * For more details, refer to README.md.
 * =====================================================================
 */

public class HangmanGame {
    public static void main(String[] args) {

        // Scanner to read the input
        Scanner scanner = new Scanner(System.in);

        // Read the secret word and turn it into an array of characters
        System.out.println("Enter the secret word:");
        char[] word = scanner.nextLine().toCharArray();
        
        Game game = new Game(word);

        Player p = new Player();

        while (true){
            System.out.println("Current progress:");
            game.printGuessed();
            System.out.println("You have " + p.getCounter() + " wrong guesses left.");
            if (!p.isOver()){
                p.setC(scanner.next().charAt(0));
                if (!game.checkChar(p.getC())){
                    p.decrement();
                }
                if(game.win()){
                    String str = Stream.of(word)
                            .map(String::new)
                            .collect(Collectors.joining());
                    System.out.println("Congratulations! You've guessed the word: " + str);
                    break;
                }
            } else {
                System.out.println("Game Over!");
                break;
            }
        }

        scanner.close();
    }
}
