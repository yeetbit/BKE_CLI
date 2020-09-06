package gamelogic.player;

import java.util.ArrayList;
import java.util.Collection;

public class Player_ai extends Player {
    
    private char playingSymbol;
    private char oponentChar;
    private ArrayList<Byte> moveMap = new ArrayList<Byte>();
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
        fillMoveMap(playDek);        
        char move = moveSort();
        return move;
    }

    private void fillMoveMap(char[][] playDek){
        
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
                moveMap.add(i, rowScore);
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
                moveMap.add(i, rowScore);
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
                moveMap.add(i, rowScore);
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
                moveMap.add(i, rowScore);
                i++;
                n--;
                row++;
            }
        }   
    }

    private char moveSort(){

        moveMap.indexOf(o);
        

        
        return char poopy = '2';

    }
    
}