package hotciv.visual;

import minidraw.framework.DrawingEditor;
import minidraw.standard.MiniDrawApplication;
import hotciv.common.GameImpl;
import hotciv.factories.*;
import hotciv.framework.Game;
import hotciv.standard.DeltaWorldGeneration;
import hotciv.view.MultiTool;

public class TestMultiTool {
	public static void main(String[] args) {
		Game game = new GameImpl(new AlphaFactory(), new DeltaWorldGeneration());
		DrawingEditor editor = new MiniDrawApplication("Play a game",
				new HotCivGUIFactory(game));
		editor.open();
		editor.setTool(new MultiTool(game, editor));
		editor.showStatus("Would you like to play a game");
	}
}
