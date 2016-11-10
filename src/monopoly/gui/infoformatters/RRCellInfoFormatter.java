package monopoly.gui.infoformatters;

import monopoly.Cell;
import monopoly.Player;
import monopoly.cells.RailRoadCell;
import monopoly.gui.CellInfoFormatter;

public class RRCellInfoFormatter implements CellInfoFormatter {
    @Override
    public String format(Cell cell) {
        StringBuilder buf = new StringBuilder();
        buf.append("<html><b><font color='lime'>")
                .append(cell.getName())
                .append("</font>")
                .append("</html>");
        return buf.toString();
    }
    
    @Override
    public String formatToolTip(Cell cell) {
        RailRoadCell c = (RailRoadCell)cell;
        StringBuilder buf = new StringBuilder();
        Player owner = cell.getPlayer();
        String ownerName = "";
        if(owner != null) {
            ownerName = owner.getName();
        }
        buf.append("<html><b><font color='lime'>")
                .append(cell.getName())
                .append("</font></b><br>")
                .append("$")
                .append(c.getPrice())
                .append("<br>Owner: ")
                .append(ownerName)
                .append("</html>");
        return buf.toString();    
    }
}
