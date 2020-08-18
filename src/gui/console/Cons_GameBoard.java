package gui.console;
import java.util.Scanner;

public class Cons_GameBoard {
    
    // updates the changed playing field

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
        return symbol;
    }



    //Asks player to play a position on the playing dek
    public char askPlayerToPlay(char currentSymbol, String p){
        nLine();
        //TODO needs also a faulty or double input check, and message the player to try again.
        System.out.println(p+" is on turn.");
        char input = scanInput();
        skipLine();
        return input;

    }

    //scan's and fetches an only char, 1 element input
    public char scanInput(){
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);
        scanner.close();
        return input;

    }

    private void skipLine(){
        for(int i = 0; i < 15; i++){nLine();}
    }

    private void nLine(){
        System.out.println("\n");
    }
    
}