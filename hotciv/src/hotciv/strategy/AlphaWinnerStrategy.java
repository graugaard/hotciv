package hotciv.strategy;

import hotciv.framework.*;


public class AlphaWinnerStrategy implements WinnerStrategy {
    public Player getWinner(Game currentGame){
        if(currentGame.getAge() == -3000) return Player.RED;
        else return null;
    }
}
