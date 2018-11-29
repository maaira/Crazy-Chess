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
    public boolean movePiece(TableParts[][] table, int x, int y) {
        if(calculateMovePiece(table,x,y)){
            t=table[x][y];
            
            return true;
        }
        return false;
    }

    @Override
    protected boolean calculateMovePiece(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX(); //Line
        int yInit = t.getLocationY(); //Colune
        int i=xInit, j=yInit;
        int cont=0;
        
        if(team == 1){
            if(table[i-1][j-1].getPiece()==null || table[i-1][j].getPiece()==null || table[i-1][j+1].getPiece()==null || table[i+1][j].getPiece()==null){
                
            }else return false;
        }
        
        if(team == 0){
            if(table[i+1][j-1].getPiece()==null || table[i+1][j].getPiece()==null || table[i+1][j+1].getPiece()==null || table[i-1][j].getPiece()==null){
                
            }else return false;
        }
        
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
