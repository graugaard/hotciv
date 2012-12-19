package hotciv.visual;

import minidraw.framework.*;
import minidraw.standard.*;

import java.awt.*;

import hotciv.framework.*;
import hotciv.stub.StubGame2;
import hotciv.view.MoveUnitTool;

public class TestMoveUnitTool {
	public static void main(String[] args) {
		Game game = new StubGame2();
		DrawingEditor editor = 
			      new MiniDrawApplication( "Click anywhere to see Drawing updates",  
			                               new HotCivFactory4(game) );
		editor.open();
		editor.setTool(new MoveUnitTool( game, editor ));
		editor.showStatus("Click on a unit to move it");
	}
}
