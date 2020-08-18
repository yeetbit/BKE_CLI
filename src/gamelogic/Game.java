package gamelogic;

import gamelogic.player.Player;
import gamelogic.player.Player_0;
import gui.console.Cons_GameBoard;

public class Game {

    private char [][] playDek = new char [3][3];
    private char [] players = new char [2];
    private int currentPlayer;


    // Class constructor initializes without accessible variables
    public Game() {
    }
    
    // instance of Cons_GameBoard Class
    Cons_GameBoard terminalGame = new Cons_GameBoard();
    





    public void setGame(boolean p0, boolean p1){
        if(p0&&p1){
            players[0] = terminalGame.askPlayerSymbol("player 1");
            Player_0 player0 = new Player_0(players[0]);
            players[1] = terminalGame.askPlayerSymbol("player 2");
            Player_1 player1 = new Player_1(players[1]);

            gameSwitch();
        }else if(p0&&!p1){
            players = setPlayer(p0, p1);
        }
    }

    private void gameSwitch(){
       
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

    public void updateBoard(char [][] playdek){
        // method call to Console Gameboard Class instance.
        // this method only updates the playing field, 
        // and accepts only a 2D character array, the array contains the 9 playable positions of the playingBoard.
        terminalGame.updateBoard(playDek);

    }     






   

    

    
    
}