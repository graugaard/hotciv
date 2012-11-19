package hotciv.standard;

import hotciv.framework.AgeStrategy;


public class BetaAgeStrategy implements AgeStrategy {
    public int calculateNextAge(int currentAge) {
        if (currentAge < -100) return currentAge+100;
        else if (currentAge == -100) return -1;
        else if (currentAge == -1) return 1;
        else if (currentAge == 1) return 50;
        else if (currentAge < 1750) return currentAge+50;
        else if (currentAge < 1900) return currentAge+25;
        else if (currentAge < 1970) return currentAge+5;
        else return currentAge+1;
    }
}
