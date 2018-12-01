package ex1;

import java.io.FileNotFoundException;

/**
 *
 * @author Maíra
 */

public class Pion extends Piece{

    public Pion(String path, TableParts t, int team, boolean status) throws FileNotFoundException {
        super(path, t, team);
        this.setMove_status(status);
    }

    

    @Override
    public boolean movePiece(TableParts[][] table, int x, int y) {
        if(calculateMovePiece(table,x,y)){
            t=table[x][y];
            
            return true;
        }
        return false;
        
    }

    @Override
    protected boolean calculateMovePiece(TableParts[][] table, int x, int y) {
        if(getTeam()==0){
            if(getMove_status() && getTeam()==0){
                return firtsMove0(table, x, y);
            }else{
                return move0(table, x, y);
            } 
        }else{
            if(getMove_status()){
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
        if(xInit!=x || yInit+2<=y)return false;
        else{
            int cont=1;
            while(cont<=2){
                if(table[i][j+cont].getPiece()==null){
                    cont++;
                }else return false;
            }
            if(table[i][j+cont]==table[x][y]){
                this.setMove_status(false);
                return true;
            }
        }
        return false;
    }
    
    private boolean move0(TableParts[][] table, int x, int y){
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        
        if(table[xInit][yInit+1]==table[x][y])return true;
        return false;
    }
    
    
    @Override
    protected boolean attackMove(TableParts[][] table, int x, int y) {
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
        else{
            int cont=1;
            while(cont<=2){
                if(table[i][j-cont].getPiece()==null){
                    cont++;
                }else return false;
            }
            if(table[i][j+cont]==table[x][y]){
                this.setMove_status(false);
                return true;
            }
        }
        return false;
    }

}