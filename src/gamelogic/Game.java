package gamelogic;
import gui.canvas;

public class Game {

    private char symbol = 'X';
    private char [][] playDek = { {symbol, symbol, symbol}, {symbol, symbol, symbol}, {symbol, symbol, symbol} };


    private void gaming(){
        int i = 0;
        for (char[] row : playDek) {
            for (char c : row) {
                if(i == 0 || i == 2 || i == 4 ){
                    System.out.println(symbol);
                }else if(i = 1 || i = 3){
                    System.out.println("|"+symbol);
                }
                i++
                
            }
            
        }

    }


   

    

    
    
}