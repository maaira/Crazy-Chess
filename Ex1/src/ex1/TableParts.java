package ex1;
/**
 *
 * @author Maira
 */
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/*
--------------------------------------- SPECIFIED / DIRECTED PART OF THE TRAY ------------------------------
*/

public class TableParts extends Rectangle{
    private Piece piece;
    private final int width = 50;
    private final int height = 50;
    private final int location[]= new int[2]; 
    
    public Piece getPiece() {
        return piece;
    }
    
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    public int getLocationX() {
        return location[0];
    }
    
    public int getLocationY() {
        return location[1];
    }
   
    public TableParts(Color c, int x, int y) {
        this.location[0] = x;
        this.location[1] = y;
        setFill(c);        
        setHeight(this.height);
        setWidth(this.width);
        relocate(x*50, y*50);;
    }   
    
}
