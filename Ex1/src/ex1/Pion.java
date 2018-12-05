package ex1;

import java.io.FileNotFoundException;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Maíra
 */

public class Pion extends Piece{
    boolean move;
    public Pion(String path, TableParts t, int team) throws FileNotFoundException {
        super(path, t, team);
        move = true;
    }

    

    @Override
    public boolean movePiece(GridPane p,TableParts[][] table ,int x ,int y) {
        if(calculateMovePiece(table,x,y)){
            t=table[x][y];
            
            return true;
        }
        return false;
        
    }

    @Override
    protected boolean calculateMovePiece(TableParts[][] table, int x, int y) {
        if(getTeam()==0){
            if(move){
                move=false;
                return firtsMove0(table, x, y);
            }else{
                return move0(table, x, y);
            } 
        }else{
            if(move){
                move=false;
                return firtsMove1(table, x, y);
            }else{
                return move1(table, x, y);
            }  

        }
        
        
        
    }
    
    private boolean firtsMove0(TableParts[][] table, int x, int y){
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        if(i!=x || j+2<y)return false;
        if(i==x && j+2<=y)return true;
        else return false;
        }
    
    private boolean move0(TableParts[][] table, int x, int y){
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        
        if(table[xInit][yInit+1]==table[x][y])return true;
        return false;
    }
    
    private boolean move1(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        
        if(table[xInit][yInit-1]==table[x][y])return true;
        return false;
    }

    private boolean firtsMove1(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        
        if(xInit!=x || yInit+2<=y)return false;
        if(i!=x || j-2>y)return false;
        if(i==x && j-2<=y)return true;
        
        return false;
        
    }
    
    @Override
    protected boolean attackMove(GridPane p,TableParts[][] table ,int x ,int y) {
        if(calculeteAttackMove(table, x, y)){
            t = table[x][y];
            return true;
        }
        return false;
    }

    @Override
    protected boolean calculeteAttackMove(TableParts[][] table, int x, int y) {
        if(getTeam()==0)return table[t.getLocationX()+1][t.getLocationY()+1]==table[x][y] || table[x][y]==table[t.getLocationX()-1][t.getLocationY()+1];
        else return table[t.getLocationX()-1][t.getLocationY()-1]==table[x][y] || table[x][y]==table[t.getLocationX()+1][t.getLocationY()-1];
        
    }

    

}