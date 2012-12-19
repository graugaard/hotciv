package hotciv.visual;

import hotciv.common.GameImpl;
import hotciv.factories.AlphaFactory;
import hotciv.framework.Game;
import hotciv.standard.AlphaWorldGeneration;
import minidraw.framework.DrawingEditor;
import minidraw.standard.MiniDrawApplication;


public class TestMulti {
    public static void main(String[] args){
        Game game = new GameImpl(new AlphaFactory(), new AlphaWorldGeneration());
        DrawingEditor editor = new MiniDrawApplication("", new HotCivFactory4(game));
        editor.open();
        editor.setTool(new TestChangeMultiStub(game, editor));
    }

}
