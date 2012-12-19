package hotciv.view;

import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.framework.Unit;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.standard.NullTool;

public class MoveUnitTool extends NullTool {
	Game game;
	DrawingEditor editor;
	Figure figureSelected;
	int lastX;
	int lastY;
	boolean unitSelected;
	Position from;
	
	public MoveUnitTool( Game game, DrawingEditor editor) {
		this.game = game;
		this.editor = editor;
		lastX = 0;
		lastY = 0;
		unitSelected = false;
	}
	
	public void mouseDown(java.awt.event.MouseEvent e, 
			int x, int y) {
		Position p = GfxConstants.getPositionFromXY(x, y);
		if (inWorld(p)) {
		
			from = p;
			Unit u = game.getUnitAt(p);
			if (u != null) {
				figureSelected = editor.drawing().findFigure(x, y);
				lastX = x;
				lastY = y;
			}
		}
	}
	
	public void mouseDrag(java.awt.event.MouseEvent e, 
			int x, int y) {
		if (figureSelected != null) {
			figureSelected.moveBy(x-lastX, y-lastY);
			lastX = x;
			lastY = y;
		}
	}
	
	public void mouseUp(java.awt.event.MouseEvent e, 
			int x, int y) {
		if (figureSelected != null) {
			
			Position to = GfxConstants.getPositionFromXY(x, y);
			int finalX = GfxConstants.getXFromColumn(to.getColumn());
			int finalY = GfxConstants.getYFromRow(to.getRow());
			
			figureSelected.moveBy(finalX-lastX, finalY - lastY);
			if ( !inWorld(to) ) {
				int startX = GfxConstants.getXFromColumn(from.getColumn());
				int startY = GfxConstants.getYFromRow(from.getRow());
				figureSelected.moveBy(startX - finalX, startY - finalY);
			}
			else if (!game.moveUnit(from, to)) {
				int startX = GfxConstants.getXFromColumn(from.getColumn());
				int startY = GfxConstants.getYFromRow(from.getRow());
				figureSelected.moveBy(startX - finalX, startY - finalY);
			}
		}
		figureSelected = null;
	}
	
	public boolean inWorld(Position p) {
		boolean rowInWorld = (0 <= p.getRow() && 
				GameConstants.WORLDSIZE > p.getRow());
		boolean colInWorld = (0 <= p.getColumn() && 
				GameConstants.WORLDSIZE > p.getColumn());
		
		return (rowInWorld && colInWorld);
	}
}
