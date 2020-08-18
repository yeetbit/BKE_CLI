package gamelogic;

import gamelogic.player.*;
import gui.console.Cons_GameBoard;

public class Game {

    private char [][] playDek = new char [3][3];

    // Class constructor initializes without accessible variables
    public Game() {
    }
    
    // instance of Cons_GameBoard Class
    Cons_GameBoard terminalGame = new Cons_GameBoard();

    //TODO reconsider pre-initialized instances    
    Player_0 player0 = new Player_0();
    Player_1 player1 = new Player_1();

    





    public void setGame(boolean p0, boolean p1){
        if(p0&&p1){
            player0.setplayChar(terminalGame.askPlayerSymbol("player 1"));      //TODO get rid of hardbaked 
            player1.setplayChar(terminalGame.askPlayerSymbol("player 2"));

            gameSwitch(player0.getTurn(), player1.getTurn());
        }else if(p0&&!p1){
            //players[0] = terminalGame.askPlayerSymbol("player 1");
            //Player_0 player0 = new Player_0(players[0]);
            //TODO create fixed symbol for CPU
        }
    }

    private void gameState(){
        if(player0.getTurn()&&!player1.getTurn()){      //TODO get rid of hardbaked
            terminalGame.askPlayerToPlay(player0.getplayChar(), "Player 1");
        }else if(!player0.getTurn()&&player1.getTurn()){
            terminalGame.askPlayerToPlay(player1.getplayChar(), "Player 2");
        }
    }

    private void gameSwitch(boolean p0, boolean p1){
        if(p0&&!p1){
            player0.noTurn();       //TODO get rid of hardbaked
            player1.isTurn();
            gameState();       
        }else if(!p0&&p1){
            player0.isTurn();       //TODO get rid of hardbaked
            player1.noTurn();
            gameState();
        }else{
            //TODO random first turn generator.
            player0.noTurn();       //TODO get rid of hardbaked
            player1.isTurn();
            gameState();        
        }
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