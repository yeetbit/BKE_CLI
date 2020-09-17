package gamelogic;

import gamelogic.player.*;
import gui.console.Cons_GameBoard;

public class Game {

    private char [][] playDek = new char [3][3];
    private char move;
    private Player_0 player_0;
    private Player_1 player_1;
    private Player_ai player_ai;
    private Cons_GameBoard terminalGame;
    private boolean versusAI;    

    public Game(boolean p01, boolean p02) {
        setDefaultPlayDek();
        Cons_GameBoard terminalGame = new Cons_GameBoard();
        if(p01&&p02){
            versusAI = false;
            player_0.setplayChar(terminalGame.askPlayerSymbol("player 1"));
            player_1.setplayChar(terminalGame.askPlayerSymbol("player 2"));
        }else if(p01&&!p02){ // Player vs AI oponent mode
            versusAI = true;
            player_0.setplayChar(terminalGame.askPlayerSymbol("player 1"));
            player_ai.setOponentChar(player_0.getplayChar());
        }
    }

    public void startGame(){
        gameSwitch();
    }

    private void gameSwitch(){//fixed for 2 or ai play
        boolean p0 = player_0.getTurn(); 
        boolean p1_get_Turn;

        if(versusAI){p1_get_Turn = player_ai.getTurn();
        }else{p1_get_Turn = player_1.getTurn();}

        if(p0&&!p1_get_Turn){
            player_0.noTurn();
            if(versusAI){player_ai.isTurn();}else{player_1.isTurn();}
            updateBoard(playDek);
            gameState();       
        }else if(!p0&&p1_get_Turn){
            player_0.isTurn();
            if(versusAI){player_ai.noTurn();}else{player_1.noTurn();}
            updateBoard(playDek);
            gameState();
        }else{
            //TODO: random first turn generator.
            player_0.noTurn();
            if(versusAI){player_ai.isTurn();}else{player_1.isTurn();}
            updateBoard(playDek);
            gameState();        
        }
    }

    private void gameState(){//fixed for 2 or ai play   
        boolean p1_get_Turn;

        if(versusAI){p1_get_Turn = player_ai.getTurn();
        }else{p1_get_Turn = player_1.getTurn();} 
             
        if(player_0.getTurn()&&!p1_get_Turn){      
            move = terminalGame.askPlayerToPlay(player_0.getplayChar(), "Player 1");
        }else if(!versusAI&&!player_0.getTurn()&&p1_get_Turn){
            move = terminalGame.askPlayerToPlay(player_1.getplayChar(), "Player 2");
        }else if(versusAI&&!player_0.getTurn()&&p1_get_Turn){
            move = player_ai.takeTurn(playDek);
        }else{terminalGame.errorMessage("in gamestate() player select");}

        for (char[] row : playDek) {
            for (byte i=0;i<row.length; i++) {
                if(row[i]==move){
                    row[i] = whichPlayerReturn();
                }  
            }
        }
        if(!gameWin()){
            gameSwitch();
        }else if(gameWin()){
            updateBoard(playDek);
            terminalGame.playerWins(whichPlayerReturn());

        }else{terminalGame.errorMessage("in gamestate() winning game select.");}
    }
    
    private boolean gameWin(){//no fix needed only dependencies
        boolean state = false;
        char turnChar = whichPlayerReturn();
        // if horizontals 3 same chars in a row win game & end game
        if(!state){
            for (char[] row : playDek) {
                byte w=0;
                for (char node : row) {
                    if(node==turnChar){
                        w++;
                    }
                }
                if(w==3){
                    state = true;
                    break;
                }
            }
        // if verticals 3 same chars in a row win game & end game
        }if(!state){
            byte w=0;
            for(byte n=0; n<=2; n++){
                for(byte row=0; row<=2; row++){
                    if(playDek[row][n]==turnChar){
                        w++;                        
                    }
                    if(row==2&&w==3){
                        state = true;
                        break;
                    }
                }
                if(w!=3){
                    w = 0;
                }
            }
        // if Diagonals 3 same chars in a row win game & end game
        }if(!state){
            byte w=0, n=0, row=0;
            // forwards diagonal
            if(playDek[0][0]==turnChar){
                while(row<=2){
                    if(playDek[row][n]==turnChar){
                        w++;
                        if(w==3){
                            state = true;
                        }
                    }
                    n++;
                    row++;
                }
            // backwards diagonal
            }else if(playDek[0][2]==turnChar){
                w = 0;
                n = 2;
                row = 0;
                while(row<=2){
                    if(playDek[row][n]==turnChar){
                        w++;
                        if(w==3){
                            state = true;
                        }
                    }
                    n--;
                    row++;
                }
            
            }
        // if playDek is full, end game
        }else if(!state){
            byte w=0;
            for(byte p=0; p<=1; p++){ //TODO: needs fixing
                // overloaded method, which returns
                turnChar = whichPlayerReturn(p); 
                for(char[] row : playDek) {
                    for(char node : row) {
                        if(node==turnChar){
                            w++;
                        }
                    }
                   
                }
                if(w==9){
                    gameFullDeck();
                    break;
                }
            }
        }
        return state;
    }

    private void gameFullDeck(){//no fix needed only dependencies
        terminalGame.playerDraw();
    }

    // Returns The current playing character
    private char whichPlayerReturn(){//fixed for 2 or ai play
        char playerChar = ' ';
        char p1_get_char;
        boolean p1_get_Turn;

        if(versusAI){p1_get_Turn = player_ai.getTurn();}else{p1_get_Turn = player_1.getTurn();}
        if(versusAI){p1_get_char = player_ai.getplayChar();}else{p1_get_char = player_1.getplayChar();} 

        if(player_0.getTurn()&&!p1_get_Turn){  
            playerChar = player_0.getplayChar();
        }else if(!player_0.getTurn()&&p1_get_Turn){
            playerChar = p1_get_char;
        }
        return playerChar;
    }

    // Returns all playing character
    private char whichPlayerReturn(int player){//fixed for 2 or ai play
        char playerChar = ' ';
        if(player==0){  
            playerChar = player_0.getplayChar();
        }else if(player==1){
            if(versusAI){
                playerChar = player_ai.getplayChar();
            }else{
                playerChar = player_1.getplayChar();
            }
        }
        return playerChar;
    }

    public void setDefaultPlayDek() {
        byte n = '1';

        for (char[] row : playDek) {
            for (byte i = 0; i < row.length; i++) {
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