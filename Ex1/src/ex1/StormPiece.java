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
 * @author Caique
 */
public class StormPiece extends Piece{
    
     /*
    --------------------------------------------CONSTRUCTOR----------------------------------------------------------
    */

    public StormPiece(String path, TableParts t, int team) throws FileNotFoundException {
        super(path, t, team);
    }
    
    /*
    -----------------------------------------MOVEMENT-------------------------------------------------------------
    */
    
    @Override
    public boolean movePiece(GridPane p,TableParts[][] table ,int x ,int y) {
            if(calculateMovePiece(table,x,y)){
            p.getChildren().remove(this);
            p.add(this,x,y);
            if(table[x][y].getPiece()!=null){
                p.getChildren().remove(table[x][y].getPiece());
            }
            table[x][y].setPiece(this);
            t = table[x][y];      
                
            return true;
        }
        return false;
    }
    
    /*
    --------------------------------------CALCULATE / CHECK MOVEMENT--------------------------------------------
    */

    @Override
    protected boolean calculateMovePiece(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX(); //Line
        int yInit = t.getLocationY(); //Colune
        int i=xInit, j=yInit;
        
        //Time 1 = From bottom to top
        if(this.team == 1){ // Check for the left diagonal 
            if(x == i-1 && y == j-1){
                if(table[i-1][j-1].getPiece()==null){
                    System.out.println("Movendo pra diagonal esquerda");
                    return true;
                }
                return false;
            }
            if(x == i && y == j-1){ //Check forward
                if(table[i][j-1].getPiece()==null){
                    System.out.println("Movendo pra frente");
                    return true;
                }
                return false;
            }
            if(x == i+1 && y == j-1){ //Checking for the right diagonal
                if(table[i+1][j-1].getPiece()==null){
                    System.out.println("Movendo pra diagonal direita");
                    return true;
                }
                return false;
            }
            if(x == i && y == j+1){ //Backward check
                if(table[i][j+1].getPiece()==null){
                    System.out.println("Movendo pra trás");
                    return true;
                }
                return false;
            }
            return false;
        }
        
        //Time 0 = From top to bottom
        if(this.team == 0){ // Check for the left diagonal 
            if(x == i-1 && y == j+1){
                if(table[i-1][j+1].getPiece()==null){
                    System.out.println("Movendo pra diagonal esquerda");
                    return true;
                }
                return false;
            }
            if(x == i && y == j+1){ //Check forward
                if(table[i][j+1].getPiece()==null){
                    System.out.println("Movendo pra frente");
                    return true;
                }
                return false;
            }
            if(x == i+1 && y == j+1){
                if(table[i+1][j+1].getPiece()==null){ //Checking for the right diagonal
                    System.out.println("Movendo pra diagonal direita");
                    return true;
                }
                return false;
            }
            if(x == i && y == j-1){ //Backward check
                if(table[i][j-1].getPiece()==null){
                    System.out.println("Movendo pra trás");
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
    
    /*
    -----------------------------------ATTACK-------------------------------------------------------------------
    */

    @Override
    protected boolean attackMove(GridPane p,TableParts[][] table ,int x ,int y) {
        return calculeteAttackMove(table , x , y);
    }
    
    /*
    ------------------------------------CALCULATE / CHECK ATTACK---------------------------------------------------------
    */

    @Override
    protected boolean calculeteAttackMove(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX(); //Line
        int yInit = t.getLocationY(); //Colune
        int i=xInit, j=yInit;
        /*
        Pode ser feita uma verificação em um else dento de calculateMovePiece e aqui fazer a ação de remover a peça;
        Vai ter que ser feita uma verifição por time (0 e 1);
        */
        return false;
    }
    
    /*
    ------------------------------------CALCULATE / CHECK ATTACK---------------------------------------------------------
    */
    
    protected void CalculateAttackAbility(){
        
    }
}