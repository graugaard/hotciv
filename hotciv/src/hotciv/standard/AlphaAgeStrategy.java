package hotciv.standard;

import hotciv.framework.AgeStrategy;


public class AlphaAgeStrategy implements AgeStrategy {

    public int calculateNextAge(int currentAge){

        return currentAge+100;
    }
}
