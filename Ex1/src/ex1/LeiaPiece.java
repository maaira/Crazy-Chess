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

    
    protected boolean calculateMovePiece(TableParts[][]table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        
        int cont=0;     
        if(table[x][y]!=table[i+2][j+2] || table[x][y]!=table[i-2][j-2] || table[x][y]!=table[i-2][j+2] || table[x][y]!=table[i+2][j-2])return false;    
        
        /*if(i <= x && j <= y);//sudeste
        if(i <= x && j >= y);//nordeste
        if(i >= x && j >= y);//noroeste
        if(i >= x && j <= y);//noroeste
        while(cont <= 3){

                if(table[x][y] ==  table[i][j])return true;
                else if(i <= x && j <= y) {
                    if (table[i][j].getPiece()==null) {
                        
                    }else return false;
                }
                else if(i > x && j < y){
                    if (table[i][j].getPiece()== null) {
                        i = i+2;
                        j = j-2;
                    }else return false;

                }
                else if(i < x && j > y){
                    if (table[i][j].getPiece() == null) {
                        i = i-2;
                        j = j+2;
                    }else return false;

                }
                else if(i > x && j > y){
                    if (table[i][j].getPiece() == null) {
                        i = i+2;
                        j = j+2;
                    }else return false;
                }
                else return false;
                cont++;


            }
        }*/
        return false;
    
}


    

    

    @Override
    protected boolean calculeteAttackMove(TableParts[][] table, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   

    @Override
    public boolean movePiece(TableParts[][] table, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean attackMove(TableParts[][] table, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
