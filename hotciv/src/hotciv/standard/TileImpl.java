package hotciv.standard;

import hotciv.framework.Position;
import hotciv.framework.Tile;

/**
 * Created with IntelliJ IDEA.
 * User: jakob
 * Date: 11/9/12
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class TileImpl implements Tile{
    private String type;

    public TileImpl(String type) {
        this.type = type;
    }
    public Position getPosition() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getTypeString() {
        return type;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
