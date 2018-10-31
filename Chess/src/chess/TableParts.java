
package chess;

public class TableParts {
    private Piece piece;
    private int location[]= new int[2];

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }
    
    
    
}
