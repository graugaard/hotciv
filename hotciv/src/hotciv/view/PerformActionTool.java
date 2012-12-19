package hotciv.view;

import hotciv.framework.Game;
import hotciv.framework.Position;
import minidraw.framework.DrawingEditor;
import minidraw.standard.NullTool;

public class PerformActionTool extends NullTool {
	
	Game game;
	DrawingEditor editor;
	Position selectedPosition;
	public PerformActionTool(Game game, DrawingEditor editor) {
		this.game = game;
		this.editor = editor;
	}
	
	public void mouseDown(java.awt.event.MouseEvent e, int x, int y) {
		selectedPosition = GfxConstants.getPositionFromXY(x, y);
	}
	
	public void mouseUp(java.awt.event.MouseEvent e, int x, int y) {
		if (e.isShiftDown()) {
			if (game.getUnitAt(selectedPosition) != null) {
				game.performUnitActionAt( selectedPosition );
			}
		}
		selectedPosition = null;
	}
}
