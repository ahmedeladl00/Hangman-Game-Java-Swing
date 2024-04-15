public class Game {
    private final char [] word;
    private final char [] guessed;

    public Game (char[] word){
        this.word = new char[word.length];
        this.guessed = new char[word.length];
        for (int i = 0; i < word.length; i++){
            this.word[i] = word[i];
            this.guessed[i] = '_';
        }
    }

    public void printGuessed (){
        for (char c : guessed){
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public boolean checkChar(char c){
        boolean flag = false;
        for (int i = 0; i < this.word.length; i++){
            if (this.word[i] == c){
                this.word[i] = 0;
                this.guessed[i] = c;
                flag = true;
            }
        }
        return flag;
    }

    public boolean win(){
        for (char c: word) {
            if (c != 0){
                return false;
            }
        }
        return true;
    }
}
