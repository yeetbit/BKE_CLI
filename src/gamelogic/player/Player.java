package gamelogic.player;

public class Player {

    private boolean turn;
    private char playingSymbol;



    public Player(){
        this.turn = false;
        this.playingSymbol = ' ';
    }

    public char getplayChar() {
        return playingSymbol;
    }

    public void setplayChar(char playingSymbol) {
        this.playingSymbol = playingSymbol;
    }

    public boolean getTurn(){
        return this.turn;
    }

    public void isTurn(){
        this.turn = true;
    }

    public void noTurn(){
        this.turn = false;
    }

  
  
    
}