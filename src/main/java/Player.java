class Player {
    private int remainingGuesses;

    public Player(int maxWrongGuesses) {
        this.remainingGuesses = maxWrongGuesses;
    }

    public void decrementGuesses() {
        if (remainingGuesses > 0) remainingGuesses--;
    }

    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    public boolean isOver() {
        return remainingGuesses <= 0;
    }
}