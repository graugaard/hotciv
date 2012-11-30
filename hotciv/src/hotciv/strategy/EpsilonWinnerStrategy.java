package hotciv.strategy;

import java.util.*;
import hotciv.common.GameImpl;
import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.Battle;

public class EpsilonWinnerStrategy implements WinnerStrategy {
    int round = 0;

    public EpsilonWinnerStrategy(int round){
        this.round = round;
    }
    public EpsilonWinnerStrategy(){

    }


    public Player getWinner(Game currentGame) {
        GameImpl g = (GameImpl) currentGame;
        List<Battle> battles = g.getBattleHistory();
        int redWins = 0;
        int blueWins = 0;

        for ( Battle battle: battles){

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
