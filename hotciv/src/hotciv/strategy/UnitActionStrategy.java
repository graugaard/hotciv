package hotciv.strategy;


import hotciv.framework.*;



public interface UnitActionStrategy {
    public boolean returnAction(Position p, ExtendedGame thisGame);
}
