package hotciv.strategy;

import java.util.*;
import hotciv.common.GameImpl;
import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.Battle;

public class EpsilonWinnerStrategy implements WinnerStrategy {

    public Player getWinner(Game currentGame, int round) {
        GameImpl g = (GameImpl) currentGame;
        List<Battle> b = g.getBattleHistory();
        int redWins = 0;
        int blueWins = 0;

        for ( int i = 0; i < b.size(); i++){
            Battle battle = b.get(i);
            if (battle.round() > round){
                if (battle.successfull()) {
                    if(battle.getAttacker().equals(Player.RED)) {
                        redWins++;
                    }
                    else if(battle.getAttacker().equals(Player.BLUE)){
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
        }
        return null;
    }
}
