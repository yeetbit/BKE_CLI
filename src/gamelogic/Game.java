package gamelogic;

import gamelogic.player.*;
import gui.console.Cons_GameBoard;

public class Game {

    private char [][] playDek = new char [3][3];
    private char move;

    // Class constructor initializes without accessible variables
    public Game() {
    }
    
    // instance of Cons_GameBoard Class
    Cons_GameBoard terminalGame = new Cons_GameBoard();

    //TODO reconsider pre-initialized instances    
    Player_0 player0 = new Player_0();
    Player_1 player1 = new Player_1();
    Player_ai PlayerAI = new Player_ai();



    public void setGame(boolean p0, boolean p1){
        if(p0&&p1){
            player0.setplayChar(terminalGame.askPlayerSymbol("player 1"));      //TODO get rid of hardbaked 
            player1.setplayChar(terminalGame.askPlayerSymbol("player 2"));

            gameSwitch();
        }else if(p0&&!p1){
            //players[0] = terminalGame.askPlayerSymbol("player 1");
            //Player_0 player0 = new Player_0(players[0]);
            //TODO create fixed symbol for CPU
        }
    }

    private void gameSwitch(){
        //TODO whole method needs whichPlayerReturn() method overloading
        boolean p0 = player0.getTurn(); 
        boolean p1 = player1.getTurn();
        if(p0&&!p1){
            player0.noTurn();       //TODO get rid of hardbaked
            player1.isTurn();
            updateBoard(playDek);
            gameState();       
        }else if(!p0&&p1){
            player0.isTurn();       //TODO get rid of hardbaked
            player1.noTurn();
            updateBoard(playDek);
            gameState();
        }else{
            //TODO random first turn generator.
            player0.noTurn();       //TODO get rid of hardbaked
            player1.isTurn();
            updateBoard(playDek);
            gameState();        
        }
    }

    private void gameState() {         
        if(player0.getTurn()&&!player1.getTurn()){      //TODO get rid of hardbaked
            move = terminalGame.askPlayerToPlay(player0.getplayChar(), "Player 1");

        }else if(!player0.getTurn()&&player1.getTurn()){
            move = terminalGame.askPlayerToPlay(player1.getplayChar(), "Player 2");
        }

        for (char[] row : playDek) {
            for (int i=0;i<row.length; i++) {
                if(row[i]==move){
                    row[i] = whichPlayerReturn();
                }  
            }
        }
        if(!gameWin()){
            gameSwitch();

        }else if(gameWin()){

        }
    }

    private boolean gameWin(){
        boolean state = false;

        // Checks Rows for 3 times true
        if(!state){
            char turnChar = whichPlayerReturn();
            
            for (char[] row : playDek) {
                int i=1;
                for (char node : row) {
                    if(node==turnChar){
                        i++;
                    }
                }
                if(i==3){
                    state = true;
                }
            }
        // checks Columns for 3 times true
        }else if(!state){
            state = true;
        // checks Diagonals for 3 times true
        }else if(!state){
            state = true;
        }
        return state;  
    }

    private boolean rowCheck(){
        
        
        return

    }
    private boolean colCheck(){

    }
    private boolean diagCheck(){

    }

    //controlled by playerselect, injects parameters of players
    public void playerObjectInjection(){
        // TODO create logic

    }

    // Returns The current playing character
    private char whichPlayerReturn(){
        char playerChar = ' ';
        if(player0.getTurn()&&!player1.getTurn()){  
            playerChar = player0.getplayChar();
        }else if(!player0.getTurn()&&player1.getTurn()){
            playerChar = player1.getplayChar();
        }
        return playerChar;
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

    public void updateBoard(char [][] playDek){
        // method call to Console Gameboard Class instance.
        // this method only updates the playing field, 
        // and accepts only a 2D character array, the array contains the 9 playable positions of the playingBoard.
        terminalGame.updateBoard(playDek);

    }     






   

    

    
    
}