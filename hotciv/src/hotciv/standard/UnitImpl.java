package hotciv.standard;
import hotciv.framework.*;

/**
 * Implementation of unit interface for alphaciv
 */
public class UnitImpl implements Unit {
    private Player owner;
    private String type;
    private int movecount = 1;
    boolean fortified = false;

    public  UnitImpl(String type, Player owner) {
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
        if(fortified){
            return 0;
        }
        else return movecount;
    }

    @Override
    public int getDefensiveStrength() {
        int res;
        if (type.equals(GameConstants.ARCHER)) {
            res = 3;
        }
        if (type.equals(GameConstants.LEGION)) {
            res = 2;
        }
        // we are certain we now have a settler
        else {
            res = 3;
        }
        if (fortified) {
            return res*2;
        }
        return res;
    }

    @Override
    public int getAttackingStrength() {
        return 0;
    }

    public void setFortify() {
        if (fortified){
            fortified = false;
        }
        else {
            fortified = true;
            setMoveCount(0);
        }
    }

    /**
     * precondition: getMoveCount>= amount >= 0
     * @param amount is the new movecount,
     */
    public void setMoveCount(int amount) {
        movecount = amount;
    }
}
