package gamelogic.player;

public class Player_ai extends Player {
    
    char oponentChar;
    char[][] moveMap = new char[3][3];

    public Player_ai() {

    }


    public char takeTurn(char[][] playDek){
        char move = ' ';
        
         // if horizontals 3 same chars in a row win game & end game
         if(!state){
            for (char[] row : playDek) {
                int w=0;
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
            int w=0;
            for(int n=0; n<=2; n++){
                for(int row=0; row<=2; row++){
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
            int w=0, n=0, row=0;
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
            int w=0;
            for(int p=0; p<=2; p++){
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

      
        

            //TODO AI algorithm here

        return move;
    }

    public setOponentChar(char oponentChar){
        this.oponentChar = oponentChar;

    }




}