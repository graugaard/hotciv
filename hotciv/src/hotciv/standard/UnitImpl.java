package hotciv.standard;
import hotciv.framework.*;

/**
 * Implementation of unit interface for alphaciv
 */
public class UnitImpl implements Unit{
    private Player owner;
    private String type;
    private int movecount = 1;

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
        return movecount;
    }

    @Override
    public int getDefensiveStrength() {
        return 0;
    }

    @Override
    public int getAttackingStrength() {
        return 0;
    }

    /**
     * precondition: getMoveCount>= amount >= 0
     * @param amount is the new movecount,
     */
    public void setMoveCount(int amount) {
        movecount = amount;
    }
}
