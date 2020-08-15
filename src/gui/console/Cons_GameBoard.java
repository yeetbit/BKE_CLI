package gui.console;

public class Cons_GameBoard {
    
    // updates the changed playing field

    public void updateBoard(char[][] playDek){
        int i = 0;
        for (char[] row : playDek) {
            for (char node : row) {
                if(i!=2){
                    System.out.println(node+"|");
                }else{
                    System.out.println(node);
                }
                i++;
                
            }
            
        }

    }
    
}