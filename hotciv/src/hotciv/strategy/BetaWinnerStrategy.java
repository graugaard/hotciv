package hotciv.strategy;

import hotciv.common.GameImpl;
import hotciv.framework.*;

import java.util.List;


public class BetaWinnerStrategy implements WinnerStrategy{

    public Player getWinner(Game currentGame){
        Player winner = null;
        GameImpl g = (GameImpl) currentGame;
        List<City> cities = g.getCities();

        for ( City city: cities){
            if (city != null) {
                if (winner == null){
                    winner = city.getOwner();
                }
                else if (winner != city.getOwner()){
                    return null;
                }
            }
        }
        return winner;
    }

}
