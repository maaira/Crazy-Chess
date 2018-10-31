
package chess;


public class Table {
    private int size_x, size_y;
    private final TableParts[][] table = new TableParts[size_x][size_y];

    public Table(int x, int y) {
        this.size_x = x;
        this.size_y = y;
    }
    
    
    
}
