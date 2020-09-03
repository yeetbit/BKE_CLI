package gamelogic.player;

import java.util.ArrayList;

public class Player_ai extends Player {
    
    char oponentChar;
    char[][] moveMap = new char[3][3];

    public Player_ai() {

    }
    
    public void setOponentChar(char oponentChar){
        this.oponentChar = oponentChar;
    }


    public char takeTurn(char[][] playDek){
        char move = ' ';
        
         // if horizontals 3 same chars in a row win game & end game
         if(move==' '){
            for (char[] row : playDek) {
                for (char node : row) {
                    if(node==oponentChar){
                        moveCalculator(row, node)

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