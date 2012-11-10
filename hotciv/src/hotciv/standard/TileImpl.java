package hotciv.standard;

import hotciv.framework.*;

/**
 * Created with IntelliJ IDEA.
 * User: jakob
 * Date: 11/9/12
 * Time: 2:04 PM.
 */
public class TileImpl implements Tile{
    private String type;

    public TileImpl(String type) {
        this.type = type;
    }
    public Position getPosition() {
        return null;
    }

    @Override
    public String getTypeString() {
        return type;
    }
}
