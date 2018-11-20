
package ex1;

/**
 *
 * @author Maira
 */
public class stormPiece extends Piece{

    @Override
    public boolean movePiece(int x, int y) {
        if(!calculateMovePiece(x,y))return false;
        
        else setLocation(x,y);
        return false;
        
        
    }

    @Override
    protected boolean calculateMovePiece(int x, int y) {
        if((location[1]+1==y) && ((location[0]+1==x)|| (location[0]+2==x) || (location[0]+3==x) ) ) return true;
        if((location[1]+1==y) && ((location[0]-1==x)|| (location[0]-2==x) || (location[0]-3==x) ) ) return true;
        if((location[1]-1==y) && ((location[0]+1==x)|| (location[0]+2==x) || (location[0]+3==x) ) ) return true;
        if((location[1]-1==y) && ((location[0]-1==x)|| (location[0]-2==x) || (location[0]-3==x) ) ) return true;
        else return false;
       
    }

    @Override
    protected boolean attackMove(int x, int y, Piece p, Player u, Player u2) {
        if(!calculateMovePiece(x,y))return false;
        
        
       setLocation(x,y);
        if(u.getPiece().contains(p)){
             u.getPiece().remove(p);
             u2.getPiecesAttacked().add(p);
            
        } 
        
        return true;
        
        
    }

    @Override
    protected boolean calculeteAttackMove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
