package gamelogic.player;

import java.util.ArrayList;
import java.util.Collection;

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
        System.out.println("AI playing symbol is fixed, cannot convert to: "+ symbol);
    }

    public char takeTurn(char[][] playDek){
        moveMapFill(playDek);        
        char move = moveMapSort(playDek);
        return move;
    }

    private void moveMapFill(char[][] playDek){
        
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
            byte i=6, n=0, row=0;
            while(row<=2){
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
            byte i=7, n=2, row=0;
            while(row<=2){
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
                n--;
                row++;
            }
        }   
    }

    private char moveMapSort(char[][] playDek){
        byte i = 0;//index
        byte iHigh = -1;
        char selection;

        //moveMap.indexOf(o);

        // simple sorting mechanism wich returns highest score of array
        for(byte score : moveMap) {
            for(byte s=i; s>=0;s--){
                if(moveMap[i]>moveMap[s]){
                    iHigh = i;
                }
            }   
            i++;
        }

        if(iHigh!= -1){
            if(iHigh<3){
                //horizontal
                for (char c : playDek[iHigh]) {
                    char z = playDek[iHigh][c];
                    if(z!=oponentChar && z!=playingSymbol){
                        selection = z;
                        break;
                    }
                }                    
            }else if(iHigh<5){
                //vertical
                for(int row=0; row<=2; row++){
                    char z = playDek[iHigh][row];
                    if(z!=oponentChar && z!=playingSymbol){
                        selection = z;
                        break;
                    }
                }
    
            }else if(iHigh<6){

            }else if(iHigh<7){

            }else{System.out.println("error@ Player_ai.moveMapSort() ,iHigh value:"+iHigh);

            }

        }



        

        
        return char poopy = '2';

    }
    
}