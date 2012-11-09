package hotciv.standard;

import hotciv.framework.*;

/** Skeleton implementation of HotCiv.
 
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Computer Science Department
     Aarhus University
   
   This source code is provided WITHOUT ANY WARRANTY either 
   expressed or implied. You may study, use, modify, and 
   distribute it for non-commercial purposes. For any 
   commercial use, see http://www.baerbak.com/
*/

public class GameImpl implements Game {
  public Tile getTileAt( Position p ) {
      //TODO: fake it code
      return new Tile() {

          @Override
          public Position getPosition() {
              return null;  //To change body of implemented methods use File | Settings | File Templates.
          }

          @Override
          public String getTypeString() {
              return "ocean";  //To change body of implemented methods use File | Settings | File Templates.
          }
      };
  }
  public Unit getUnitAt( Position p ) { return null; }
  public City getCityAt( Position p ) {
      if(p.getColumn()==1 && p.getRow() == 1)
          return new CityImpl(Player.RED);
      if(p.getColumn() == 1 && p.getRow() == 4)
          return new CityImpl(Player.BLUE);
      else return null;
  }
  public Player getPlayerInTurn() { return null; }
  public Player getWinner() { return null; }
  public int getAge() { return 0; }
  public boolean moveUnit( Position from, Position to ) {
    return false;
  }
  public void endOfTurn() {}
  public void changeWorkForceFocusInCityAt( Position p, String balance ) {}
  public void changeProductionInCityAt( Position p, String unitType ) {}
  public void performUnitActionAt( Position p ) {}
}
