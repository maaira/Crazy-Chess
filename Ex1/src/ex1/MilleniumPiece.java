
package ex1;

import java.io.FileNotFoundException;

/**
 *
 * @author Maira
 */
public class MilleniumPiece extends Piece{

    public MilleniumPiece(String path, TableParts t, int team) throws FileNotFoundException {
        super(path, t, team);
    }

    @Override
    public boolean movePiece(TableParts[][] t) {
        //if(!calculateMovePiece(t[][].getLocationX(),t[].getLocationY()))return false;
        
        //else setLocation(t);
        return false;
        
        
    }

    protected boolean calculateMovePiece(TableParts[][] table ,int x ,int y) {
        
        int xInit = t.getLocationX() ;
        int yinit = t.getLocationY();
        int i = 0;
        while(i<4){
            
        }
                
                
        //if((yinit+1==y) && ( xInit==x)) return true;
        //if((yinit-1==y) && ((xInit==x)) )return true;
        //if((yinit+2==y) && ((xInit+1==x) ||(xInit-1==x)) )return true;
        //if((yinit-2==y) && ((xInit+1==x) ||(xInit-1==x)) )return true;
        //if((yinit+3==y) && ((xInit+2==x)|| (xInit-2==x)) ) return true;
        //if((yinit-3==y) && ((xInit+2==x)|| (xInit-2==x)) ) return true;
        //if((yinit+4==y) && ((xInit==x)|| (xInit==x)) ) return true;
        //if((yinit-4==y) && ((xInit==x)|| (xInit==x)) ) return true;
        
        return false;
        
       
    }

    @Override
    protected boolean attackMove(TableParts[][] t) {
        //if(!calculateMovePiece(t.getLocationX(),t.getLocationY()))return false;
        
        
        //setLocation(t);
        
        
        return true;
        
        
    }

    @Override
    protected boolean calculeteAttackMove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean calculateMovePiece(TableParts t, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
