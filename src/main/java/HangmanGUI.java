import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HangmanGUI extends JFrame {
    private final Game game;
    private final Player player;
    private JLabel wordLabel;
    private JLabel messageLabel;

    public HangmanGUI(String secretWord) {
        this.game = new Game(secretWord);
        this.player = new Player(6);

        createUI();
        setupKeyListener();
    }

    private void createUI() {
        setTitle("Hangman Game");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        wordLabel = new JLabel(game.displayProgress(), SwingConstants.CENTER);
        wordLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(wordLabel, BorderLayout.CENTER);

        messageLabel = new JLabel("Guess a letter!", SwingConstants.CENTER);
        add(messageLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void setupKeyListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (Character.isLetter(e.getKeyChar())) {
                    handleGuess(e.getKeyChar());
                }
            }
        });
        setFocusable(true);
        requestFocusInWindow();
    }

    private void handleGuess(char guess) {
        if (game.checkGuess(guess)) {
            wordLabel.setText(game.displayProgress());
            if (game.isWin()) {
                messageLabel.setText("Congratulations! You've guessed the word!");
            }
        } else {
            player.decrementGuesses();
            messageLabel.setText("Wrong guess! " + player.getRemainingGuesses() + " guesses left.");
            if (player.isOver()) {
                messageLabel.setText("Game Over! The correct word was: " + game.getSecretWord());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String secretWord = JOptionPane.showInputDialog("Enter the secret word:");
            if (secretWord != null) {
                new HangmanGUI(secretWord);
            }
        });
    }
}