package hotciv.standard;
import hotciv.framework.*;

/**
 * Implementation of unit interface for alphaciv
 */
public class UnitImpl implements Unit{
    Player owner;
    String type;
    public  UnitImpl(String type, Player owner){
        this.type = type;
        this.owner = owner;
    }
    public String getTypeString() {
        return type;
    }

    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public int getMoveCount() {
        return 0;
    }

    @Override
    public int getDefensiveStrength() {
        return 0;
    }

    @Override
    public int getAttackingStrength() {
        return 0;
    }
}
