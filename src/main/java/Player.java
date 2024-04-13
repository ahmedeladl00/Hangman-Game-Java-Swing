public class Player {
    private int counter;
    private char c;

    public Player(){
        this.counter = 6;
    }

    public boolean isOver(){
        return counter <= 0;
    }

    public int getCounter() {
        return counter;
    }

    public void decrement(){
        this.counter--;
    }

    public void setC(char c){
        this.c = c;
    }

    public char getC() {
        return c;
    }
}
