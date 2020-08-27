package gui.console;
import java.util.Scanner;

public class Cons_GameBoard {
    
    //
    // the Cons_GameBoard class updates the changed playing field
    // and sends messages to the users
    // in a console/CLI style interface.
    //

    public Cons_GameBoard(){
    }

    //instantiate Scanner class object
    Scanner scanner = new Scanner(System.in);

    public void updateBoard(char[][] playDek){
        int i=0;
        nLine();
        System.out.println("Choose position, and enter corresponding number:");
        nLine();
        for (char[] row : playDek) {

            System.out.println("                 "+" "+row[0]+" | "+row[1]+" | "+row[2]);
            if(i!=2){
                System.out.println("                 "+"-----------");
            }
            i++;
        }
        i=0;
        nLine();

    }
   
    //Asks player to pick a playing symbol
    public char askPlayerSymbol(String p){
        skipLine();
        System.out.println(p+" choose your favorite character: ");
        char symbol = scanInput();
        skipLine();
        return symbol;
    }

    //Asks player to play a position on the playing dek
    public char askPlayerToPlay(char currentSymbol, String p){
        nLine();
        //TODO needs also a faulty or double input check, and message the player to try again.
        System.out.println(p+" is on turn.");
        char move = scanInput();
        skipLine();
        return move;

    }

    public void playerWins(char player){
        
        System.out.println("Congratulations "+player+" wins!");
        nLine();
    }

    //scan's and fetches an only char, 1st element input   
    public char scanInput(){
        char input = scanner.next().charAt(0);
        return input;

    }

    public void errorMessage(String word){
        skipLine();
        System.out.println("Error while "+word);
    }

    private void skipLine(){
        for(int i = 0; i < 15; i++){nLine();}
    }

    private void nLine(){
        System.out.println("\n");
    }
    
}