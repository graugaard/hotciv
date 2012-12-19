package hotciv.view;


import hotciv.framework.Game;
import hotciv.framework.Position;

import minidraw.standard.NullTool;


import java.awt.event.*;


public class FocusOnTileTool extends NullTool {
    private Game game;





    public FocusOnTileTool(Game game){
        this.game = game;



    }
    public void mouseDown(MouseEvent e, int x, int y) {
        Position p = GfxConstants.getPositionFromXY(x, y);
        game.setTileFocus(p);
    }


}
