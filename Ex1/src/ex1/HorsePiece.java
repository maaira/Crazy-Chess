/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.FileNotFoundException;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Maíra
 */
public class HorsePiece extends Piece {
    int hit = 1;
    public HorsePiece(String path, TableParts t, int team) throws FileNotFoundException {
        super(path, t, team);
    }

    @Override
    public boolean movePiece(GridPane p,TableParts[][] table ,int x ,int y) {
        
        if(calculateMovePiece( table, x,  y)){
            t.setPiece(null);
            p.getChildren().remove(this);
            p.add(this,x,y);
            if(table[x][y].getPiece()!=null && table[x][y].getPiece().getTeam()!=team){
                p.getChildren().remove(table[x][y].getPiece());
            }
            table[x][y].setPiece(this);
            t = table[x][y];      
            return true;
        }
        return false;
        
    }

    @Override
    protected boolean calculateMovePiece(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        
        if(i<=x && j<=y)return SEMove(table,x,y);//sudeste
        if(i>=x && j<=y)return SOMove(table,x,y);//sudoeste
        if(i>=x && j>=y)return NOMove(table,x,y);//noroeste
        if(i<=x && j>=y)return NEMove(table,x,y);//nordeste
        return false;
        
    }

    @Override
    protected boolean attackMove(GridPane p,TableParts[][] table ,int x ,int y) {
        return false;
    }

    @Override
    protected boolean calculeteAttackMove(TableParts[][] table, int x, int y) {
        return false;
    }

    private boolean SEMove(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        if((i+1==x && j+2==y)|| (i+2==x && j+1==y) )return true;
        return false;
    }

    private boolean SOMove(TableParts[][] table, int x, int y) {
       
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        if((i-1==x && j+2==y)|| (i-2==x && j+1==y) )return true;
        
        return false;
    }

    private boolean NEMove(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        if((i+1==x && j-2==y)|| (i+2==x && j-1==y) )return true;
        
        return false;
    }

    private boolean NOMove(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        if((i-1==x && j-2==y)|| (i-2==x && j-1==y) )return true;
        
        return false;   
    }
    
}
