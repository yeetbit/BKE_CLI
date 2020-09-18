/**
 * This Class is the "ai" Class of the tic tac toe game, it is a very basic compare & sort algorithm,
 * what finds out which move make based on the highest movescore. 
 * 
 * Following some method and dependency injection info:
 * 
 * moveMapFill():
 *  Fills move map with highest play score
 *  the index of the highest score is used to define which position to play/return.
 * 
 *  This function is momentairily very basic, moveMap[] can contain multiple highest play scores,
 *  and it picks now the first high(iHigh in moveMapSort()) Needs some improvement for a better oponent.
 *  This configuration could also be the less difficult oponent.
 * 
 * 
 * moveMapSort()
 *  The moveMapSort() method compares the highest score of all the playable rows,
 *  then a free play position of the returned row wil be selected by iterating over the rows
 *  
 *  First section sort:
 *  if iHigh(highest returned position) is less than type of row-type(movemap[index of 8]), 
 *  then iterate over index(in Playdek[3x] index of 3)
 *  and verify condition is not playing/oponent charachter(to exclude doubled playing position). 
 *  If empty playing field, use position character as move character.
 *  Momentairily this always chooses the first posibility, when there are 2 positions free.
 *  Needs some improvements.
 * 
 */

package gamelogic.player;

public class Player_ai extends Player {
    
    private char playingSymbol;
    private char oponentChar;
    //private ArrayList<Byte> moveMap = new ArrayList<Byte>();
    private byte[] moveMap = new byte[8];
    private short ascii = 254;

    public Player_ai() {
        this.playingSymbol = (char)ascii;
    }

    @Override
    public char getplayChar() {
        return playingSymbol;
    }
    
    public void setOponentChar(char oponentChar) {
        this.oponentChar = oponentChar;
    }
        
    @Override
    public void setplayChar(char symbol) {
        System.out.println("AI playing symbol is fixed, cannot convert to: "+symbol+"\nCurrent symbol: "+playingSymbol);

    }

    public char takeTurn(char[][] playDek){
        moveMapFill(playDek);        
        char move = moveMapSort(playDek);
        return move;
    }

    
    private void moveMapFill(char[][] playDek){

        // TODO: improve difficulty

        
        // play position action-score multipliers
        final byte oponentRowCharScore = 4;
        final byte playerRowCharscore = 3;
        final byte emptyRowCharscore = 2;

        // row score buffer
        byte rowScore = 0;
        boolean togglePlayerPlayed;

        // Iterate in horizontal orientation        
        if(true){
            byte i = 0;
            for (char[] row : playDek) {
                rowScore = 0;
                togglePlayerPlayed = false;
                for (char node : row) {
                    if(node!=oponentChar){rowScore += emptyRowCharscore;}
                    if(node==oponentChar){rowScore += oponentRowCharScore;}
                    if(node==playingSymbol){rowScore += playerRowCharscore;togglePlayerPlayed=true;}
                    if(node==playingSymbol&&togglePlayerPlayed){rowScore *= playerRowCharscore;}// winning move Score, if player already made a move in same row. 
                }
                //moveMap.add(i, rowScore);
                moveMap[i]=rowScore;
                i++;
            }
        // Iterate in vertical orientation
        }if(true){
            byte i=3;
            for(byte n=0; n<=2; n++){
                rowScore = 0;
                togglePlayerPlayed = false;
                for(int row=0; row<=2; row++){
                    char node = playDek[row][n];
                    if(node!=oponentChar){rowScore += emptyRowCharscore;}
                    if(node==oponentChar){rowScore += oponentRowCharScore;}
                    if(node==playingSymbol){rowScore += playerRowCharscore;togglePlayerPlayed=true;}
                    if(node==playingSymbol&&togglePlayerPlayed){rowScore *= playerRowCharscore;}// winning move Score, if player already made a move in same row. 
                }
                //moveMap.add(i, rowScore);
                moveMap[i]=rowScore;
                i++;
            }
        // Iterate in forward diagonal orientation
        }if(true){
            byte i=5, n=0, row=0;
            while(row<2){
                rowScore = 0;
                togglePlayerPlayed = false;
                char node = playDek[row][n];
                if(node!=oponentChar){rowScore += emptyRowCharscore;}
                if(node==oponentChar){rowScore += oponentRowCharScore;}
                if(node==playingSymbol){rowScore += playerRowCharscore;togglePlayerPlayed=true;}
                if(node==playingSymbol&&togglePlayerPlayed){rowScore *= playerRowCharscore;}// winning move Score, if player already made a move in same row. 
                //moveMap.add(i, rowScore);
                moveMap[i]=rowScore;
                i++;
                n++;
                row++;
            }
        // Iterate in forward diagonal orientation
        }if(true){
            // backwards diagonal
            byte i=6, n=2, row=0;
            while(row<=1){
                rowScore = 0;
                togglePlayerPlayed = false;
                char node = playDek[row][n];
                if(node!=oponentChar){rowScore += emptyRowCharscore;}
                if(node==oponentChar){rowScore += oponentRowCharScore;}
                if(node==playingSymbol){rowScore += playerRowCharscore;togglePlayerPlayed=true;}
                if(node==playingSymbol&&togglePlayerPlayed){rowScore *= playerRowCharscore;}// winning move Score, if player already made a move in same row. 
                //moveMap.add(i, rowScore);
                //System.out.println("i: "+i);
                moveMap[i]=rowScore;
                i++;
                n--;
                row++;
            }
        }   
    }

    private char moveMapSort(char[][] playDek){
    
        byte i = 0;//index
        byte iHigh = -1;
        char selection = ' ';

        //moveMap.indexOf(el);

        // simple sorting mechanism wich returns highest score index of moveMap array,
        // The highest currently  known score will be saved in iHigh. 
        for(byte score : moveMap) {
            byte counterScore = 0;
            for(byte s=i; s>=0;s--){
                counterScore = moveMap[s];
                if(score>counterScore){
                    iHigh = i;
                    //System.out.println("playingSymbol: "+playingSymbol+"i: "+i);
                }
            }   
            i++;
        }

     

        
        //TODO: Needs improvement of choice flexibility


        if(iHigh!= -1){
            if(iHigh<=2){//including index 0
                //horizontal types
                for (char c : playDek[iHigh]) {
                    char z = playDek[iHigh][c];
                    if(z!=oponentChar && z!=playingSymbol){
                        selection = z;
                        break;
                    }
                }                    
            }else if(iHigh<=5){
                //vertical types: iHigh represents the column number which will be played in
                for(int row=0; row<=2; row++){
                    byte col= iHigh;
                    col--;col--;col--;
                    System.out.println("\n iHigh:"+iHigh);
                    char z = playDek[row][col];
                    if(z!=oponentChar && z!=playingSymbol){
                        selection = z;
                        break;
                    }
                }
            }else if(iHigh==6){
                //front diagonal type
                byte e=0;
                for(int row=0; row<=2; row++){
                    char z = playDek[row][e];
                    if(z!=oponentChar && z!=playingSymbol){
                        selection = z;
                        break;
                    }
                    e++;
                }
            }else if(iHigh==7){
                //back diagonal type
                byte e=2;
                for(int row=0; row<=2; row++){
                    char z = playDek[row][e];
                    if(z!=oponentChar && z!=playingSymbol){
                        selection = z;
                        break;
                    }
                    e--;
                }
            }else{System.out.println("error@ Player_ai.moveMapSort() ,iHigh value:"+iHigh);}
        }
        return selection;
    }
}