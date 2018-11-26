
package ex1;

import java.io.FileNotFoundException;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Maira
 */
public class MilleniumPiece extends Piece{

    public MilleniumPiece(String path, TableParts t, int team) throws FileNotFoundException {
        super(path, t, team);
    }

     
    public boolean  Handler(TableParts[][] table ,int x ,int y){
        boolean  key=false;
        if(table[x][y].getPiece()==null){
            key = movePiece( table, x, y); 
        }
               
        else if(table[x][y].getPiece()!=null && table[x][y].getPiece().getTeam()==team){
            key = false;
        }
        else if((table[x][y].getPiece()!=null && table[x][y].getPiece().getTeam()!=team)) {
            key = attackMove( table, x , y);
        }   
        return key;
    }
         
    @Override
    protected boolean calculateMovePiece(TableParts[][] table ,int x ,int y) {
        
        int xInit = t.getLocationX() ;
        int yInit = t.getLocationY();
        int i=xInit+1, j=yInit+1;
        if(x>i && y>j){
            if(table[i][j+1].getPiece()==null){
                j++;
                while(i<=x){
                    while(j<=y){

                        if(table[x][j].getPiece()==null){
                            i++;
                            j++;
                        }else{
                            return false;
                        }
                    }
                }
            }
            return i==x && y==j+1;
        }
        else if(x>i && y<j){
            if(table[i][j-1].getPiece()==null){
                j--;
                while(i<=x){
                    while(j>=y){

                        if(table[x][j].getPiece()==null){
                            i++;
                            j--;
                        }else{
                            return false;
                        }
                    }
                }
            }
            return i==x && y==j+1;
        }
        
        else if(x<i && y<j){
            if(table[i][j-1].getPiece()==null){
                j--;
                while(i>=x){
                    while(j>=y){

                        if(table[x][j].getPiece()==null){
                            i--;
                            j--;
                        }else{
                            return false;
                        }
                    }
                }
            }
            return i==x && y==j;

        }
        else if(x<i && y>j){
            if(table[i][j+1].getPiece()==null){
                j++;
                while(i<=x){
                    while(j<=y){

                        if(table[x][j].getPiece()==null){
                            i--;
                            j++;
                        }else{
                            return false;
                        }
                    }
                }
            }
            return i==x && y==j;
        }
        return false;
        
                
                
        
        
       
    }

    @Override
    protected boolean attackMove(TableParts[][] t ,int x ,int y) {
        //if(!calculateMovePiece(t.getLocationX(),t.getLocationY()))return false;
        
        
        //setLocation(t);
        
        
        return true;
        
        
    }

    @Override
    public boolean movePiece(TableParts[][] table, int x, int y) {
        if(!calculateMovePiece(table,x,y)){
            t=table[x][y];
            
            return true;
        }
        return false;
    }

    @Override
    protected boolean calculeteAttackMove(TableParts[][] table, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
