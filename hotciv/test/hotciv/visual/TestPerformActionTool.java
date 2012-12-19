package hotciv.visual;

import hotciv.framework.Game;
import hotciv.stub.StubGame2;
import hotciv.view.PerformActionTool;
import minidraw.framework.DrawingEditor;
import minidraw.standard.MiniDrawApplication;

public class TestPerformActionTool {
	public static void main(String[] args) {
		Game game = new StubGame2();
		DrawingEditor editor = 
			      new MiniDrawApplication( "Click anywhere to see Drawing updates",  
			                               new HotCivFactory4(game) );
		editor.open();
		editor.setTool(new PerformActionTool( game, editor ));
		editor.showStatus("Click on a unit to perfom action except red settler");
	}
}
