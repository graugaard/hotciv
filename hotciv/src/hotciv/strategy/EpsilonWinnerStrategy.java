package hotciv.strategy;

import java.util.*;
import hotciv.common.GameImpl;
import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.Battle;

public class EpsilonWinnerStrategy implements WinnerStrategy {

    public Player getWinner(Game currentGame) {
        GameImpl g = (GameImpl) currentGame;
        List<Battle> b = g.getBattleHistory();
        int redWins = 0;
        int blueWins = 0;

        for ( int i = 0; i < b.size(); i++){
            if (b.get(i).successfull()) {
                if(b.get(i).getAttacker().equals(Player.RED)) {
                    redWins++;
                }
                else if(b.get(i).getAttacker().equals(Player.BLUE)){
                    blueWins++;
                }
            }
            if (redWins >= 3){
                return Player.RED;
            }
            else if (blueWins >= 3){
                return Player.BLUE;
            }
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
