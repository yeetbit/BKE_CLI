package gamelogic;
import java.util.Scanner;

import gui.console.Cons_GameBoard;

public class Game {

    private char symbol;
    private char [][] playDek = new char [3][3];


    // Class contstructor initializes local variables
    public Game() {
        symbol = 'H';
    }

    public void setPlayDek() {
        playDek = new char [][] {{symbol, symbol, symbol},{symbol, symbol, symbol},{symbol, symbol, symbol}};
        
    }

    // instance of Cons_GameBoard Class
    private Cons_GameBoard gameBoard = new Cons_GameBoard();

    private void updateBoard(char [][] playdek){

        // method call to Console Gameboard Class instance.
        // this method only updates the playing field, 
        // and accepts only a 2D character array.
        gameBoard.updateBoard(playDek);
    }

    public void gameOn(boolean p0, boolean p1){
        //Scanner scanner = new Scanner(System.in);

        updateBoard(playDek);



    }





    





   

    

    
    
}