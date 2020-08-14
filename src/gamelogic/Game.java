package gamelogic;
import gui.console.Cons_GameBoard;

public class Game {

    private char symbol;
    private char [][] playDek = new char[3][3];


    public Game(char symbol, char[][] playDek) {
        this.symbol = symbol;
        this.playDek = playDek;
    }

    // instance of Cons_GameBoard Class
    private Cons_GameBoard gameBoard = new Cons_GameBoard();

    private void updateBoard(char [][] playdek){

        // method call to Console Gameboard Class instance.
        // this method only updates the playing field, 
        // and accepts only a 2D character array.
        gameBoard.updateBoard(playDek);
    }





    





   

    

    
    
}