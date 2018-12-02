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
        
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        int dx = 0, dy = 0;
        int n;
//        boolean key=true;
        if (x!=i && y!=j){
            dx=(x-i);
            dy=(y-j);
        if (dx<=3 && dx>=-3 && dy<=3 && dy>=-3){
            if (dy == dx || dy == -(dx)){
            if (dx > 0){
                if (dy > 0){
                    for (n = 0;n == dy;n++ ){   
                         if (table[i+n][j+n].getPiece()==null){
                             return true;
                         }
                    }
                
                }else if (dy < 0){
                    for (n = 0;n == dy;n-- ){
                        if (table[i-n][j+n].getPiece()==null){
                             return true;
                         }
                    }
                            }
            
    }
            if (dx < 0){
                if (dy > 0){
                    for (n = 0;n == dy;n++ ){
                        if (table[i-n][j+n].getPiece()==null){
                             return true;
                         }
                    }
                
        }else if (dy < 0){
                    for (n = 0;n == dy;n-- ){
                        if (table[i+n][j+n].getPiece()==null){
                             return true;
                         }
                    }
                            }
    }
    } //diagonal
    } //distancia
    } //inibir hori e vert
         return false;
    } //calculo
        
    

    
    @Override
    protected boolean attackMove(TableParts[][] t ,int x ,int y) {
        //if(!calculateMovePiece(t.getLocationX(),t.getLocationY()))return false;
        
        
        //setLocation(t);
        
        
        return true;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}

