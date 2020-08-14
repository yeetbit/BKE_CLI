package gui.console;

public class Cons_GameBoard {
    
    // updates the changed playing field

    public void updateBoard(char[][] playDek){
        int i = 0;
        for (char[] row : playDek) {
            for (char node : row) {
                if(i == 0 || i == 2 || i == 4 ){
                    System.out.println(node);
                }else if(i == 1 || i == 3){
                    System.out.println("|"+node);
                }
                i++;
                
            }
            
        }

    }
    
}