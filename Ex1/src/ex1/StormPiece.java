/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.FileNotFoundException;

/**
 *
 * @author Caique
 */
public class StormPiece extends Piece{

    public StormPiece(String path, TableParts t, int team) throws FileNotFoundException {
        super(path, t, team);
    }

    @Override
    public boolean Handler(TableParts[][] table, int x, int y) {
        System.out.println("");
        return false;
    }

    @Override
    public boolean movePiece(TableParts[][] table, int x, int y) {
        if(!calculateMovePiece(table,x,y))return false;
        
        else return false;
    }

    @Override
    protected boolean calculateMovePiece(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        int cont=0;
        
        if(team == 2){
            
//            if((table[i-1][j+1]))
            
//            if((location[1]+1==y) && (location[0]-1==x)){ //Front and left
//                if((location[1]+1 <= 14) && ((location[0]-1 >= 14))) return true;
//            }
//            if((location[1]+1==y)){ //Only Front
//                if(location[1]+1 <= 14) return true;
//            }
//            if((location[1]+1==y) && (location[0]+1==x)){ //Front and Right
//                if((location[1]+1 <= 14) && (location[0]+1 <= 14)) return true;
//            }
//            if(location[1]-1==y){ //Retreat
//                if(location[1]-1 >= 14) return true;
//            }
//            return false;
//        }
//        
//        if(team == 1){
//            if(location[1]+1==y){ //Retreat
//                if(location[1]+1 >= 14) return true;
//            }
//            if((location[1]-1==y)&& (location[0]-1==x)){ //Front and Left
//                if((location[1]+1 >= 14) && (location[0]+1 >= 14)) return true;
//            }
//            if(location[1]-1==y){ //Only front
//                if(location[1]+1 >= 14) return true;
//            }
//            if((location[1]-1==y)&& (location[0]+1==x)){ //Front and Right
//                if((location[1]-1 >= 14) && (location[0]+1 <= 14)) return true;
//            }
//            return false;
//            }
//        return false;
//        
//        return false;
    }

    /*@Override
    protected boolean attackMove(TableParts[][] table, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean calculeteAttackMove(TableParts[][] table, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
        return false;
 
}

    @Override
    protected boolean attackMove(TableParts[][] table, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean calculeteAttackMove(TableParts[][] table, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
