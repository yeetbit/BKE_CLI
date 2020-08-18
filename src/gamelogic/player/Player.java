package gamelogic.player;

public class Player {

    private boolean turn;
    private char playingSymbol;

    public Player(char playingSymbol) {
        this.playingSymbol = playingSymbol;
    }

    public void isTurn(){
        this.turn = true;
    }

    public void noTurn(){
        this.turn = false;
    }

  
    
}