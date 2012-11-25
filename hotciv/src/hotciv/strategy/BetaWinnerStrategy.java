package hotciv.strategy;

import hotciv.framework.*;


public class BetaWinnerStrategy implements WinnerStrategy{
    public Player getWinner(Game currentGame){
        Player p1 = currentGame.getCityAt(new Position(1, 1)).getOwner();
        Player p2 = currentGame.getCityAt(new Position(4, 1)).getOwner();
        if (p1 == p2) {
            return p1;
        }
        else return null;
    }

}
