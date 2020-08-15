package gui.console;

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
    
}