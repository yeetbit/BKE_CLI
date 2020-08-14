package gui.console;

public class Cons_GameBoard {

    private char symbol;
    private char [][] playDek = new char[3][3];


    public Cons_GameBoard(char symbol, char[][] playDek) {
        this.symbol = symbol;
        this.playDek = playDek;
    }

    public void updateBoard(){
        int i = 0;
        for (char[] row : playDek) {
            for (char c : row) {
                if(i == 0 || i == 2 || i == 4 ){
                    System.out.println(c);
                }else if(i == 1 || i == 3){
                    System.out.println("|"+symbol);
                }
                i++;
                
            }
            
        }

    }
    
}