
package ex1;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import ex1.Piece;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class TableParts extends ImageView{
    private Piece piece;
    private Image picture;
   
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

//    public void setLocation(int[] location) {
//        this.location = location;
//    }
    
    public void setLocation(int x, int y) {
        this.location[0] = x;
        this.location[1] = y;
    }    

    
    
    
    
}
