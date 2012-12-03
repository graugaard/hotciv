package hotciv.strategy;




public class AlphaAgeStrategy implements AgeStrategy {

    public int calculateNextAge(int currentAge){

        return currentAge+100;
    }
}
