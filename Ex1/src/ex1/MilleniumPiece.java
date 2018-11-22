
package ex1;

/**
 *
 * @author Maira
 */
public class MilleniumPiece extends Piece{

    public MilleniumPiece(String path, int x, int y, int team) {
        super(path, x, y, team);
    }

    @Override
    public boolean movePiece(TableParts t) {
        if(!calculateMovePiece(t.getLocationX(),t.getLocationY()))return false;
        
        else setLocation(t);
        return false;
        
        
    }

    @Override
    protected boolean calculateMovePiece(int x, int y) {
        
        if((location[1]+1==y) && ( location[0]==x)) return true;
        if((location[1]-1==y) && ((location[0]==x)) )return true;
        if((location[1]+2==y) && ((location[0]+1==x) ||(location[0]-1==x)) )return true;
        if((location[1]-2==y) && ((location[0]+1==x) ||(location[0]-1==x)) )return true;
        if((location[1]+3==y) && ((location[0]+2==x)|| (location[0]-2==x)) ) return true;
        if((location[1]-3==y) && ((location[0]+2==x)|| (location[0]-2==x)) ) return true;
        if((location[1]+4==y) && ((location[0]+3==x)|| (location[0]-3==x)) ) return true;
        if((location[1]-4==y) && ((location[0]+3==x)|| (location[0]-3==x)) ) return true;
        
        else return false;
       
    }

    @Override
    protected boolean attackMove(TableParts t) {
        if(!calculateMovePiece(t.getLocationX(),t.getLocationY()))return false;
        
        
        setLocation(t);
        
        
        return true;
        
        
    }

    @Override
    protected boolean calculeteAttackMove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
