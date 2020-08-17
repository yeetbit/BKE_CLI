package gamelogic;
import java.util.Scanner;
import gui.console.Cons_GameBoard;

public class Game {

    private char [][] playDek = new char [3][3];
    private char [] players = new char [2];


    // Class constructor initializes without accessible variables
    public Game() {
    }
    
    
    // instance of Cons_GameBoard Class
    Cons_GameBoard terminalGame = new Cons_GameBoard();
    


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


    public void setGame(boolean p0, boolean p1){
        if(p0&&p1){
            players = setPlayer(p0, p1);
            gameSwitch(players);



        }else if(p0&&!p1){
            players = setPlayer(p0, p1);


        }
    }

    private void gameSwitch(char playerSymbol[]){
       
        char input = terminalGame.askPlayerPlay(currentPlayer);



    }





    

    public void updateBoard(char [][] playdek){
        // method call to Console Gameboard Class instance.
        // this method only updates the playing field, 
        // and accepts only a 2D character array, the array contains the 9 playable positions of the playingBoard.
        terminalGame.updateBoard(playDek);

    }     

    private char setPlayer(boolean p0, boolean p1){
        if(p0&&p1){

            // Two player mode initialized, choice of playing character returned
            char [] playSymbol = new char [2];
            return playSymbol = terminalGame.askPlayerSymbol(p0, p1);

            
        }else if(p0&&!p1){
            // TODO: initialize single player mode.
           
        }


    }





   

    

    
    
}