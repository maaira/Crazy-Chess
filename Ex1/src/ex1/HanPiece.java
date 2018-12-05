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
                if(i==x && j==y)return true;
                if(table[i][j].getPiece()!=null)return false;
                cont++;
            }
            
            return false;
            
        }
        if (i+3==x && j-3==y){
            while(cont<3){
                i++;
                j--;
                
                if(i==x && j==y)return true;

                if(table[i][j].getPiece()!=null)return false;
                cont++;
            }
           return false;
            
        }
        if (i-3==x && j+3==y){
            while(cont<3){
                i--;
                j++;
                if(i==x && j==y)return true;
                if(table[i][j].getPiece()!=null)return false;
                cont++;
            }
            return false;
            
        }
        if (i-3==x && j-3==y){
            while(cont<3){
                i--;
                j--;
                if(i==x && j==y)return true;
                if(table[i][j].getPiece()!=null)return false;
                cont++;
            }
            return false;
            
        }
           
        return false;
    } 
    
    @Override
    protected boolean attackMove(GridPane p,TableParts[][] table ,int x ,int y) {
        if(calculeteAttackMove(table , x , y)){   
            if(table[x][y].getPiece()!=null){
                p.getChildren().remove(table[x][y].getPiece());
                return true;
            }else return false;
             
        }
        return false;
    }
    

    @Override
    public boolean movePiece(GridPane p,TableParts[][] table ,int x ,int y) {
        if(calculateMovePiece(table,x,y)){
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
    protected boolean calculeteAttackMove(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        
        if(i<=x && j<=y)return SEAttack(table,x,y);//sudeste
        if(i>=x && j<=y)return SOAttack(table,x,y);//sudoeste
        if(i>=x && j>=y)return NOAttack(table,x,y);//noroeste
        if(i<=x && j>=y)return NEAttack(table,x,y);//nordeste
        return false;
    }
    
    private boolean SEAttack(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        while(i<=13 && j<=13 ){
            i++;
            j++;            
            if(i==x && j==y)return true;
            if(i>13 || j>13)return false;
            if(i>x || j>y)return false;
            if(table[i][j].getPiece()!=null)return false;
        }
        return false;
    }

    private boolean SOAttack(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        while(i>=0 && j<=13 ){
            i--;
            j++;            
            if(i==x && j==y)return true;
            //if(i>13 || j>13)return false;
            //if(i>x || j>y)return false;
            if(table[i][j].getPiece()!=null)return false;
        }
        return false;
    }

    private boolean NOAttack(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        while(i>=0 && j>=0 ){
            i--;
            j--;            
            if(i==x && j==y)return true;
            //if(i<13 || j>13)return false;
            //if(i>x || j>y)return false;
            if(table[i][j].getPiece()!=null)return false;
        }
        
        return false;
    }

    private boolean NEAttack(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        while(i<=13 && y>=0){
            i++;
            j--;
            if(i==x && j==y)return true;
            //if(i>13 || j<0)return false;
            //if(i>x || j<y)return false;
            if(table[i][j].getPiece()!=null)return false;
        }
        return false;
    }

}