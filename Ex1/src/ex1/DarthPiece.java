/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.FileNotFoundException;

/**
 *
 * @author win7
 */
public class DarthPiece extends Piece{
    public DarthPiece(String path, TableParts t, int team) throws FileNotFoundException {
        super(path, t, team);
    }

    @Override
    public boolean movePiece(TableParts[][] table, int x, int y) {
       if(  calculateMovePiece(table,x,y)){
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
        
        if(i<=x && j<=y){
            return BaixoDireita(table,x,y);
        }else if(i>=x && j<=y){
            return BaixoEsquerda(table,x,y);
        }else if(i<=x && j>=y){
            return CimaDireita(table,x,y);
        }else if(i>=x && j>=y){
            return CimaEsquerda(table,x,y);
        }
        
        return false;
        
    }
    
    protected boolean BaixoDireita(TableParts[][] table, int x, int y){
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        int cont = 0;
        if(i == 11 || i == 12){
            return false;
        }
        if(x!=i+1 && y!=j+5){
            return false;
        }
        
        while(cont < 5){
                
            if(cont<=2){
                j++;
                i++;
                if(table[i][j].getPiece()==null){
                }else return false;
            }else{
                j++;
                i--;
                if(table[i][j].getPiece()==null){
                }else return false;
            }
            cont++;   
        }
        
        return true;
    }
    
    
    protected boolean BaixoEsquerda(TableParts[][] table, int x, int y){
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        int cont = 0;
        if(i == 1 || i == 2){
            return false;
        }
        
        if(x!=i-1 && y!=j+5){
            return false;
        }
        
        while(cont < 5){
                
            if(cont<=2){
                j++;
                i--;
                if(table[i][j].getPiece()==null){
                }else return false;
            }else{
                j++;
                i++;
                if(table[i][j].getPiece()==null){;
                }else return false;
            }
            cont++;
        }
        
        return true;
    }
    
    
    protected boolean CimaDireita(TableParts[][] table, int x, int y){
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        int cont = 0;
        if(i == 11 || i == 12){
            return false;
        }
        
        if(x!=i+1 && y!=j-5){
            return false;
        }
        
        while(cont < 5){
                
            if(cont<=2){
                j--;
                i++;
                if(table[i][j].getPiece()==null){
                }else return false;
            }else{
                j--;
                i--;
                if(table[i][j].getPiece()==null){
                }else return false;
            }
            cont++;
        }
        
        return true;
    }
    
    
    protected boolean CimaEsquerda(TableParts[][] table, int x, int y){
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        int cont = 0;
        if(i == 1 || i == 2){
            return false;
        }
        
        if(x!=i-1 && y!=j-5){
            return false;
        }
        
        while(cont < 5){
                
            if(cont<=2){
                j--;
                i--;
                if(table[i][j].getPiece()==null){
                }else return false;
            }else{
                j--;
                i++;
                if(table[i][j].getPiece()==null){
                }else return false;
            }
            cont++;
        }
        
        return true;
    }
    

    @Override
    protected boolean attackMove(TableParts[][] table, int x, int y) {
        return false;
    }

    @Override
    protected boolean calculeteAttackMove(TableParts[][] table, int x, int y) {
        return false;
    }
}
