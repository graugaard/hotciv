package hotciv.view;

import java.awt.Rectangle;

import hotciv.framework.Game;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.standard.NullTool;

public class EndOfTurnTool extends NullTool {
	
	Game game;
	DrawingEditor editor;
	Figure selectedFigure;
	
	public EndOfTurnTool( Game game, DrawingEditor editor ) {
		this.game = game;
		this.editor = editor;
	}
	
	public void mouseDown(java.awt.event.MouseEvent e,
			int x, int y) {
		selectedFigure = editor.drawing().findFigure(x, y);
	}
	
	public void mouseUp(java.awt.event.MouseEvent e,
			int x, int y){
		if (selectedFigure == null) {
			return;
		}
		Rectangle box = selectedFigure.displayBox();
		/* check to see if
		 * figure covers end of turn button
		 */
		boolean xInRange = GfxConstants.TURN_SHIELD_X >= box.x 
				&& GfxConstants.TURN_SHIELD_X <= box.x + box.width;
		boolean yInRange = GfxConstants.TURN_SHIELD_Y >= box.y
				&& GfxConstants.TURN_SHIELD_Y <= box.y + box.height;
		
		boolean turnShieldCovered = (xInRange && yInRange);
		
		if (turnShieldCovered) {
			System.out.println("I am ending this turn");
			game.endOfTurn();
		}
	}
}
