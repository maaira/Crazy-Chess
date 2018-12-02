/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.FileNotFoundException;

/**
 *
 * @Bacon
 */
public class HanPiece extends Piece {
     public HanPiece(String path, TableParts t, int team) throws FileNotFoundException {
        super(path, t, team);
    }   
    
        
    
    @Override
    protected boolean calculateMovePiece(TableParts[][] table ,int x ,int y) {
        
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        int cont=0;
        //sudeste        
        if (i+3==x && j+3==y){
            while(cont<3){
                i++;
                j++;
                if(table[i][j].getPiece()!=null)return false;
                cont++;
            }
            if(i==x && j==y)return true;
            else return false;
            
        }
           
        return false;
    } 
        
    

    
    @Override
    protected boolean attackMove(TableParts[][] t ,int x ,int y) {
        return false;
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
    protected boolean calculeteAttackMove(TableParts[][] table, int x, int y) {
        return false;
    }

    
    
}

