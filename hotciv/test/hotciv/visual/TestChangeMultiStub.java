package hotciv.visual;

import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.view.GfxConstants;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.standard.NullTool;

import java.awt.*;
import java.awt.event.MouseEvent;


public class TestChangeMultiStub extends NullTool {
    public TestChangeMultiStub(Game game, DrawingEditor editor){
        this.game = game;
        this.editor = editor;
    }
    Game game;
    DrawingEditor editor;
    City city;
    Position cityPosition;
    Figure selectedFigure;



    public void mouseDown(MouseEvent e, int x, int y){

        selectedFigure = editor.drawing().findFigure(x, y);
        Position p = GfxConstants.getPositionFromXY(x, y);
        game.setTileFocus(p);
        if(game.getCityAt(p) != null){
            city = game.getCityAt(p);
            cityPosition = p;
        }
    }
    public void mouseUp(MouseEvent e, int x, int y){
        if (game.getPlayerInTurn() == city.getOwner()){

            if (selectedFigure == null){
                return;
            }
            Rectangle box = selectedFigure.displayBox();

            boolean xInRangeProduction = GfxConstants.CITY_PRODUCTION_X >= box.x
                    && GfxConstants.CITY_PRODUCTION_X <= box.x + box.width;
            boolean yInRangeProduction = GfxConstants.CITY_PRODUCTION_Y >= box.y
                    && GfxConstants.CITY_PRODUCTION_Y <= box.y + box.height;

            boolean cityProductionCovered = (xInRangeProduction && yInRangeProduction);
            if(cityProductionCovered){
                if(city.getProduction().equals( GameConstants.ARCHER)) {
                    game.changeProductionInCityAt(cityPosition, GameConstants.LEGION);
                }
                else if(city.getProduction().equals( GameConstants.LEGION)){
                    game.changeProductionInCityAt(cityPosition, GameConstants.SETTLER);
                }
                else {
                    game.changeProductionInCityAt(cityPosition, GameConstants.ARCHER);
                }
            }
            boolean xInRangeWorkForce = GfxConstants.WORKFORCEFOCUS_X >= box.x
                    && GfxConstants.WORKFORCEFOCUS_X <= box.x + box.width;
            boolean yInRangeWorkForce = GfxConstants.WORKFORCEFOCUS_Y >= box.y
                    && GfxConstants.WORKFORCEFOCUS_Y <= box.y + box.height;

            boolean cityWorkForceCovered = (xInRangeWorkForce && yInRangeWorkForce);

            if(cityWorkForceCovered){
                if(city.getWorkforceFocus().equals(GameConstants.foodFocus)){
                    game.changeWorkForceFocusInCityAt(cityPosition, GameConstants.productionFocus);
                }
                else {
                    game.changeWorkForceFocusInCityAt(cityPosition, GameConstants.foodFocus);
                }


            }
            Position po = GfxConstants.getPositionFromXY(x, y);
            game.notifyWorldChangeAt(po);


        }

    }

}
