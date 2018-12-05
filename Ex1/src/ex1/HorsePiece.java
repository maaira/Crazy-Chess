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

    public HorsePiece(String path, TableParts t, int team) throws FileNotFoundException {
        super(path, t, team);
    }

    @Override
    public boolean movePiece(GridPane p,TableParts[][] table ,int x ,int y) {
        
        if(calculateMovePiece( table, x,  y)){
            t=table[x][y];
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
        if(table[i+1][j+2]==table[x][y] || table[i+2][j+1]==table[x][y] )return true;
        return false;
    }

    private boolean SOMove(TableParts[][] table, int x, int y) {
       
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        if(table[i-1][j+2]==table[x][y] || table[i-2][j+1]==table[x][y] )return true;
        return false;
    }

    private boolean NEMove(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        if(table[i+1][j-2]==table[x][y] || table[i+2][j-1]==table[x][y] )return true;
        return false;
    }

    private boolean NOMove(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        if(table[i-1][j-2]==table[x][y] || table[i-2][j-1]==table[x][y] )return true;
        return false;   
    }
    
}
