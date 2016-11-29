package tests.gameboards;

import monopoly.GameBoard;
import monopoly.cells.FreeParkingCell;
import monopoly.cells.GoToJailCell;
import monopoly.cells.JailCell;
import monopoly.cells.PropertyCell;
import monopoly.cells.RailRoadCell;
import monopoly.enums.ColorGroup;

public class GameBoardRailRoad extends GameBoard {
    public GameBoardRailRoad() {
        super();
	
        int rrBaseRent = 25;
        int rrPrice = 200;
        
        PropertyCell blue1 = new PropertyCell();
        PropertyCell blue2 = new PropertyCell();
        PropertyCell green1 = new PropertyCell();
        PropertyCell green2 = new PropertyCell();
        JailCell jail = new JailCell();
        GoToJailCell goToJail = new GoToJailCell();
        FreeParkingCell freeParking = new FreeParkingCell();
        RailRoadCell rr1 = new RailRoadCell();
        RailRoadCell rr2 = new RailRoadCell();
        RailRoadCell rr3 = new RailRoadCell();
        RailRoadCell rr4 = new RailRoadCell();

        blue1.setName("Blue 1");
        blue2.setName("Blue 2");
        green1.setName("Green 1");
        green2.setName("Green 2");

        blue1.setColorGroup(ColorGroup.BLUE);
        blue2.setColorGroup(ColorGroup.BLUE);
        green1.setColorGroup(ColorGroup.GREEN);
        green2.setColorGroup(ColorGroup.GREEN);

        rr1.setName("Railroad A");
        rr1.setPrice(rrPrice);
        rr1.setBaseRent(rrBaseRent);

        rr2.setName("Railroad B");
        rr2.setPrice(rrPrice);
        rr2.setBaseRent(rrBaseRent);

        rr4.setName("Railroad C");
        rr4.setPrice(rrPrice);
        rr4.setBaseRent(rrBaseRent);

        rr4.setName("Railroad D");
        rr4.setPrice(rrPrice);
        rr4.setBaseRent(rrBaseRent);

        blue1.setPrice(100);
        blue2.setPrice(100);
        green1.setPrice(200);
        green2.setPrice(240);

        blue1.setRent(10);
        blue2.setRent(10);
        green1.setRent(20);
        green2.setRent(20);

        blue1.setHousePrice(50);
        blue2.setHousePrice(50);
        green1.setHousePrice(70);
        green2.setHousePrice(70);

        addCell(rr1);
        super.addCell(blue1);
        addCell(jail);
        addCell(rr2);
        super.addCell(blue2);
        addCell(freeParking);
        super.addCell(green1);
        addCell(rr3);
        addCell(goToJail);
        super.addCell(green2);
        addCell(rr4);
    }
}
