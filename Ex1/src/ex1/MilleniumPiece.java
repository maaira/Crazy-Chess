
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
        
<<<<<<< HEAD
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
//        boolean key=true;
        int cont=0;
        if(table[i][j+1].getPiece()==null || table[i][j-1].getPiece()==null){
            if(y<j )j++;
            if(y>j )j--;
=======
        int xInit = t.getLocationX() ;
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        boolean key=true;
        int cont=0;
        
        while(key && cont<4){
            
            
            if(i<x && j<y) {
                if (table[i][j+1].getPiece()==null) {
                    i++;
                    j++;
                }else return false;
            }
            else if(i>x && j<y){
                if (table[i][j+1].getPiece()==null) {
                    i--;
                    j++;
                }else return false;

            }
            else if(i>x && j>y){
                if (table[i][j-1].getPiece()==null) {
                    i--;
                    j--;
                }else return false;

            }
            else if(i<x && j>y){
                if (table[i][j-1].getPiece()==null) {
                    i++;
                    j--;
                }else return false;
            }
            
            cont++;
            if(i==x && j==y)return true;
>>>>>>> 4b82bef98dd0be495e50b4ccb5c204e833ec3548
            
            while(cont<4){

                if(table[x][y]==table[i][j])return true;
                else if(i<x && j<y) {
                    if (table[i][j].getPiece()==null) {
                        i++;
                        j++;
                    }else return false;
                }
                else if(i>x && j<y){
                    if (table[i][j].getPiece()==null) {
                        i--;
                        j++;
                    }else return false;

                }
                else if(i>x && j>y){
                    if (table[i][j].getPiece()==null) {
                        i--;
                        j--;
                    }else return false;

                }
                else if(i<x && j>y){
                    if (table[i][j].getPiece()==null) {
                        i++;
                        j--;
                    }else return false;
                }
                else return false;
                cont++;


            }
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
<<<<<<< HEAD
        if(calculateMovePiece(table,x,y)){
            t=table[x][y];
=======
        if(!calculateMovePiece(table,x,y)){
            //t=table[x][y];
>>>>>>> 4b82bef98dd0be495e50b4ccb5c204e833ec3548
            
            return true;
        }
        return false;
    }

    @Override
    protected boolean calculeteAttackMove(TableParts[][] table, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
