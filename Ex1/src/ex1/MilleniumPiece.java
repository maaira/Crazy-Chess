
package ex1;

import java.io.FileNotFoundException;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Maira
 */
public class MilleniumPiece extends Piece{

    public MilleniumPiece(String path, TableParts t, int team) throws FileNotFoundException {
        super(path, t, team);
    }   
        
    
    @Override
    protected boolean calculateMovePiece(TableParts[][] table ,int x ,int y) {
        
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        
        if(i<=x && j<=y)return SEMove(table,x,y);//sudeste
        if(i>=x && j<=y)return SOMove(table,x,y);//sudoeste
        if(i>=x && j>=y)return NOMove(table,x,y);//noroeste
        if(i<=x && j>=y)return NEMove(table,x,y);//nordeste

        return false;
    }        
    
    private boolean SEMove(TableParts[][] table ,int x ,int y){
        System.out.println("sudeste");
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit+1;
        if(table[i][j].getPiece()==null){
            int cont=0;
            while(cont<=4){
                if(table[i][j]==table[x][y])return true;
                if (table[i][j].getPiece()==null) {
                        i++;
                        j++;
                    }else return false;
                cont++;
            }
            return false;
        
        }
        return false;
    }
    
    private boolean SOMove(TableParts[][] table ,int x ,int y){
        System.out.println("sudoeste");
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        if(table[i][j+1].getPiece()==null){
            j++;
            int cont=0;
            while(cont<=4){
                if(table[i][j]==table[x][y])return true;
                if (table[i][j].getPiece()==null) {
                        i--;
                        j++;
                    }else return false;
                cont++;
            }
            return false;
        
        }
        return false;
    }
    
    private boolean NOMove(TableParts[][] table ,int x ,int y){
        System.out.println("noroeste");
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        if(table[i][j-1].getPiece()==null){
            j--;
            int cont=0;
            while(cont<=4){
                if(table[i][j]==table[x][y])return true;
                
                else if (table[i][j].getPiece()==null) {
                        i--;
                        j--;
                    }else return false;
                cont++;
            }
            return false;
        
        }else return false;
        
    }
    
    private boolean NEMove(TableParts[][] table ,int x ,int y){
        System.out.println("nordeste");
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        if(table[i][j-1].getPiece()==null){
            j--;
            int cont=0;
            while(cont<=4){
                if(table[i][j]==table[x][y])return true;
                if (table[i][j].getPiece()==null) {
                        i++;
                        j--;
                    }else return false;
                cont++;
            }
            return false;
        
        }
        return false;
    }
    
    @Override
    protected boolean attackMove(GridPane p,TableParts[][] table ,int x ,int y) {             
        if(calculeteAttackMove(table , x , y)){
        
        }    
        return false;
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