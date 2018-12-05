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
 * @author Yasmim
 */
public class LeiaPiece extends Piece{

    public LeiaPiece(String path, TableParts t, int team) throws FileNotFoundException {
        super(path, t, team);
    }

    
   
//Movimento: anda duas casas para frente e duas para o lado

    @Override
    protected boolean calculateMovePiece(TableParts[][]table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;       
             
        //if((i+2!=x && j+2!=y) ||(i-2!=x && j+2!=y)|| (i+2!=x && j-2!=y) || (i-2!=x && j-2!=y))return false;  
        if(i<=x && j<=y)return SEMove(table,x,y);//sudeste
        if(i>=x && j<=y)return SOMove(table,x,y);//sudoeste
        if(i>=x && j>=y)return NOMove(table,x,y);//noroeste
        if(i<=x && j>=y)return NEMove(table,x,y);//nordeste        
        
       

                /*if(x==i && j==y)return true;
                if(i <= x && j <= y) {//sudeste
                    if(cont<2){
                        if (table[i][j].getPiece()==null) {
                            j++;
                        }else return false;
                    }else{
                        if (table[i][j].getPiece()==null) {
                            i++;
                        }else return false;
                    }
                    
                }
                else if(i >= x && j <= y){//noroeste
                    if (table[i][j].getPiece()== null) {
                        i = i+2;
                        j = j-2;
                    }else return false;

                }
                else if(i <= x && j >= y){//nordeste
                    if (table[i][j].getPiece() == null) {
                        i = i-2;
                        j = j+2;
                    }else return false;

                }
                else if(i > x && j > y){//sudoeste
                    if (table[i][j].getPiece() == null) {
                        i = i+2;
                        j = j+2;
                    }else return false;
                }
                else return false;
                cont++;


            }*/
       
        
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
        
        if((i+2!=x && j+2!=y))return false;
        
        else{
            
            j++;
            int cont=0;
            if (table[i][j].getPiece()!=null)return false;
            while(cont<=3){           
                if(i==x && j==y)return true;
                if(cont<1){
                    if (table[i][j].getPiece()==null) {j++;}
                    else return false;
                }else{
                    if (table[i][j].getPiece()==null) {i++;}
                    else return false;
                
                }
                
                cont++;  
            }
        }
        
        return false;
    }

    private boolean SOMove(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        
        if((i-2!=x && j+2!=y))return false;
        
        else{
            
            j++;
            int cont=0;
            if (table[i][j].getPiece()!=null)return false;
            while(cont<=3){           
                if(i==x && j==y)return true;
                if(cont<1){
                    if (table[i][j].getPiece()==null) {j++;}
                    else return false;
                }else{
                    if (table[i][j].getPiece()==null) {i--;}
                    else return false;
                
                }
                
                cont++;  
            }
        }
        
        return false;
    }

    private boolean NOMove(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        
        if((i-2!=x && j-2!=y))return false;
        
        else{
            
            j--;
            int cont=0;
            if (table[i][j].getPiece()!=null)return false;
            while(cont<=3){           
                if(i==x && j==y)return true;
                if(cont<1){
                    if (table[i][j].getPiece()==null) {j--;}
                    else return false;
                }else{
                    if (table[i][j].getPiece()==null) {i--;}
                    else return false;
                
                }
                
                cont++;  
            }
        }
        
        return false;
    }

    private boolean NEMove(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        
        if((i+2!=x && j-2!=y))return false;
        
        else{
            
            j--;
            int cont=0;
            if (table[i][j].getPiece()!=null)return false;
            while(cont<=3){           
                if(i==x && j==y)return true;
                if(cont<1){
                    if (table[i][j].getPiece()==null) {j--;}
                    else return false;
                }else{
                    if (table[i][j].getPiece()==null) {i++;}
                    else return false;
                
                }
                
                cont++;  
            }
        }
        
        return false;
    }
        
    
}


    

    

    

