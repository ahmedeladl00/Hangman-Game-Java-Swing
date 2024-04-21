class Game {
    private final String secretWord;
    private final boolean[] guessed;

    public Game(String secretWord) {
        this.secretWord = secretWord;
        this.guessed = new boolean[secretWord.length()];
    }

    public String getSecretWord() {
        return secretWord;
    }

    public String displayProgress() {
        StringBuilder display = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            if (guessed[i]) {
                display.append(secretWord.charAt(i));
            } else {
                display.append('_');
            }
            display.append(' ');
        }
        return display.toString();
    }

    public boolean checkGuess(char guess) {
        boolean isCorrect = false;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guess && !guessed[i]) {
                guessed[i] = true;
                isCorrect = true;
            }
        }
        return isCorrect;
    }

    public boolean isWin() {
        for (boolean g : guessed) {
            if (!g) return false;
        }
        return true;
    }
}