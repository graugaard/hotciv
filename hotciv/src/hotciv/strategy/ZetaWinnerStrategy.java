package hotciv.strategy;

import hotciv.common.GameImpl;
import hotciv.framework.Game;
import hotciv.framework.Player;


public class ZetaWinnerStrategy implements WinnerStrategy {

    private WinnerStrategy before20RoundsStrategy, after20RoundsStrategy, currentStrategy;

    public ZetaWinnerStrategy (WinnerStrategy before20RoundsStrategy, WinnerStrategy after20RoundsStrategy){
        this.before20RoundsStrategy = before20RoundsStrategy;
        this.after20RoundsStrategy = after20RoundsStrategy;
        this.currentStrategy = null;
    }

    @Override
    public Player getWinner(Game currentGame, int round) {
        GameImpl g = (GameImpl) currentGame;
        int currentRound = g.getCurrentRound();
        if (currentRound > 20) {
            currentStrategy = after20RoundsStrategy;
        }
        else {
            currentStrategy = before20RoundsStrategy;
        }

        return currentStrategy.getWinner(currentGame, 20);

    }


}
