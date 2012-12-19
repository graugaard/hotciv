package hotciv.standard;
import java.awt.event.MouseEvent;

import minidraw.framework.*;
import minidraw.standard.*;
import hotciv.common.*;
import hotciv.factories.*;
import hotciv.framework.*;
import hotciv.standard.*;


public class HotcivMain {

	public static void main(String[] args) {
		Game game = new GameImpl( new AlphaFactory(), new AlphaWorldGeneration() );
		DrawingEditor editor = 
				new MiniDrawApplication ( "Hotciv, semi civ",
						new HotCivGUIFactory( game ) );
		editor.open();
		editor.setTool( new UpdateTool( editor, game ) );
		editor.showStatus( "Hotciv stuff" );
	}
}

class UpdateTool extends NullTool {
	  private Game game;
	  private DrawingEditor editor;
	  public UpdateTool(DrawingEditor editor, Game game) {
	    this.editor = editor;
	    this.game = game;
	  }
	  private int count = 0;
	  public void mouseDown(MouseEvent e, int x, int y) {
	    switch(count) {
	    case 0: {
	      editor.showStatus( "State change: Moving archer to (1,1)" );
	      game.moveUnit( new Position(2,0), new Position(1,1) );

	      break;
	    }
	    case 4: {
	      editor.showStatus( "State change: Moving archer to (2,2)" );
	      game.moveUnit( new Position(1,1), new Position(2,1) );
	      break;
	    }
	    case 1: {
	      editor.showStatus( "State change: End of Turn (over to blue)" );
	      game.endOfTurn();
	      break;
	    }
	    case 2: {
	    	game.moveUnit( new Position(3,2), new Position(4,3) );
	      editor.showStatus( "State change: Blue legion red settler" );
	      break;
	    }
	    case 3: {
	    	editor.showStatus( "State change: Turn ends (over to red)" );
	    	game.endOfTurn();
	    	break;
	    }
	    default: {
	    	game.endOfTurn();
	      editor.showStatus("No more changes in my list...");
	    }
	    }
	    count ++;
	  }
	}