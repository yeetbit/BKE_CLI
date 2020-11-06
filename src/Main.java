import gamelogic.*;
public class Main {

    public static void main(String[] args) {

        Game game = new Game(true,false);// for 2 players change to true true, for 1 player agaist artificial oponent change to true false.
        game.setDefaultPlayDek();
        game.startGame();       
        
        
        
    }
    
}