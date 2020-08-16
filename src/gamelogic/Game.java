package gamelogic;
import java.util.Scanner;

import gui.console.Cons_GameBoard;

public class Game {

    private char [][] playDek = new char [3][3];


    // Class contstructor initializes local variables
    public Game() {
    }

    public void setDefaultPlayDek() {
        playDek = new char [3][3];
        int n = '1';

        for (char[] row : playDek) {
            for (int i = 0; i < row.length; i++) {
                row[i] = (char)n;
                n++;
            }
        }
    }

    public void gameOn(boolean p0, boolean p1){
        //Scanner scanner = new Scanner(System.in);

        updateBoard(playDek);

    }

    // instance of Cons_GameBoard Class
    private Cons_GameBoard gameBoard = new Cons_GameBoard();

    private void updateBoard(char [][] playdek){

        // method call to Console Gameboard Class instance.
        // this method only updates the playing field, 
        // and accepts only a 2D character array.
        gameBoard.updateBoard(playDek);
    }



    //test testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest
     
    





    





   

    

    
    
}