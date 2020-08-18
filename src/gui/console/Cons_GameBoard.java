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

    private void nLine(){
        System.out.println("\n");
    }

    public char [] askPlayerSymbol(boolean p0, boolean p1){
        // TODO: ask player(s) for playing character


    }

    public char scanInput(){
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);
        scanner.close();
        return input;

    }

    public char playerPlay(char currentSymbol, char currentPlayer){
        nLine();
        System.out.println("Player "+ currentPlayer);
        char input = scanInput();
        return input;

    }
    
}