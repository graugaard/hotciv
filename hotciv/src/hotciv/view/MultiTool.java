package hotciv.view;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Tool;
import minidraw.standard.NullTool;
/**
 * Combine a lot of tools for GUI use
 * @author jakob
 *
 */
public class MultiTool implements Tool {
	private MoveUnitTool moveUnitTool;
	private PerformActionTool performActionTool;
	private EndOfTurnTool endOfTurnTool;
	private CityTool changeTool;
	
	public MultiTool( Game game, DrawingEditor editor ) {
	
		moveUnitTool = new MoveUnitTool(game, editor);
		performActionTool = new PerformActionTool(game, editor);
		endOfTurnTool = new EndOfTurnTool(game, editor);
		changeTool = new CityTool( game, editor );
	}
	
	public void mouseDown(java.awt.event.MouseEvent e, int x, int y) {
		moveUnitTool.mouseDown(e, x, y);
		//performActionTool.mouseDown(e, x, y);
		endOfTurnTool.mouseDown(e, x, y);
		//changeTool.mouseDown(e, x, y);
	}
	
	public void mouseDrag(java.awt.event.MouseEvent e, int x, int y) {
		moveUnitTool.mouseDrag(e, x, y);
		//performActionTool.mouseDrag(e, x, y);
		endOfTurnTool.mouseDrag(e, x, y);
		//changeTool.mouseDrag(e, x, y);
	}
	
	public void mouseUp(java.awt.event.MouseEvent e, int x, int y) {
		moveUnitTool.mouseUp(e, x, y);
		//performActionTool.mouseUp(e, x, y);
		endOfTurnTool.mouseUp(e, x, y);
		//changeTool.mouseUp(e, x, y);
	}
	
	@Override
	public void keyDown(KeyEvent arg0, int arg1) {
		//performActionTool.keyDown(arg0, arg1);
		moveUnitTool.keyDown(arg0, arg1);
		endOfTurnTool.keyDown(arg0, arg1);
		//changeTool.keyDown(arg0, arg1);
	}

	@Override
	public void mouseMove(MouseEvent arg0, int arg1, int arg2) {
		//performActionTool.mouseMove(arg0, arg1, arg2);
		moveUnitTool.mouseMove(arg0, arg1, arg2);
		endOfTurnTool.mouseMove(arg0, arg1, arg2);
		//changeTool.mouseMove(arg0, arg1, arg2);
	}
}
