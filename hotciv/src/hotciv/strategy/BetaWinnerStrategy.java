package hotciv.strategy;

import hotciv.common.GameImpl;
import hotciv.framework.*;

import java.util.List;


public class BetaWinnerStrategy implements WinnerStrategy{

    public Player getWinner(Game currentGame, int round){
        Player winner = null;
        GameImpl g = (GameImpl) currentGame;
        List<City> cities = g.getCities();

        for ( int i = 0; i < cities.size(); i++){
            if (cities.get(i) != null) {
                if (winner == null){
                    winner = cities.get(i).getOwner();
                }
                else if (winner != cities.get(i).getOwner()){
                    return null;
                }
            }
        }
        return winner;
    }

}
