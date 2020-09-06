package gamelogic.player;

import java.util.ArrayList;
import java.util.Collection;

public class Player_ai extends Player {
    
    char playingSymbol;
    char oponentChar;
    char[][] moveMap = new char[3][3];
    short ascii = 254;

    public Player_ai() {
        this.playingSymbol = (char)ascii;
    }
    
    @Override
    public char getplayChar() {
        return playingSymbol;
    }
    
    @Override
    public void setplayChar(char symbol) {
        System.out.println("AI playing symbol is fixed, cannot convert to: "+ symbol);
    }

    public char takeTurn(char[][] playDek){
        char move = ' ';
        int opCharScore = 3;
        int 


        int moveChance = 0; // how many positions are free
        int moveHorizontal;
        int H = 3;
        int M = 3;
        int L = 3;
        int[] moveZone = {H,M,L};   // how many zones
        int moveType = 0;
        
        if(move==' '){
            
            for (char[] row : playDek) {
                for (char node : row) {
                    if(node!=oponentChar){
                        

                    }
                }
            }
        // if verticals 3 same chars in a row win game & end game
        }if(move==' '){
            int w=0;
            for(int n=0; n<=2; n++){
                for(int row=0; row<=2; row++){
                    if(playDek[row][n]==oponentChar){
                        w++;                        
                    }
                    if(row==2&&w==3){
                    move = true;
                        break;
                    }
                }
                if(w!=3){
                    w = 0;
                }
            }
        // if Diagonals 3 same chars in a row win game & end game
        }if(move==' '){
            int w=0, n=0, row=0;
            // forwards diagonal
            if(playDek[0][0]==oponentChar){
                while(row<=2){
                    if(playDek[row][n]==oponentChar){
                        w++;
                        if(w==3){
                        move = true;
                        }
                    }
                    n++;
                    row++;
                }
            // backwards diagonal
            }else if(playDek[0][2]==oponentChar){
                w = 0;
                n = 2;
                row = 0;
                while(row<=2){
                    if(playDek[row][n]==oponentChar){
                        w++;
                        if(w==3){
                        move = true;
                        }
                    }
                    n--;
                    row++;
                }
            
            }
        // if playDek is full, end game
        }   
        return move;
    }

    private char moveCalculator(int row, int node){
        
        return move;

    }
    
}