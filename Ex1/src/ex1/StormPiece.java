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
        int xInit = t.getLocationX(); 
        int yInit = t.getLocationY(); 
        int i=xInit, j=yInit;
        
        //Time 1 = From bottom to top
        if(this.team == 1){ // Check for the left diagonal 
            if(x == i-1 && y == j-1){
                if(table[i-1][j-1].getPiece()==null){
                    System.out.println("Movendo pra diagonal esquerda");
                    return true;
                }else if(table[i-1][j-1].getPiece()!=null && table[i-1][j-1].getPiece().getTeam()==0)return true;
                return false;
            }
                
            
            if(x == i && y == j-1){ //Check forward
                if(table[i][j-1].getPiece()==null){
                    System.out.println("Movendo pra frente");
                    return true;
                }else if(table[i][j-1].getPiece()!=null && table[i][j-1].getPiece().getTeam()==0)return true;
                return false;
            }
            if(x == i+1 && y == j-1){ //Checking for the right diagonal
                if(table[i+1][j-1].getPiece()==null){
                    System.out.println("Movendo pra diagonal direita");
                    return true;
                }else if(table[i+1][j-1].getPiece()!=null && table[i+1][j-1].getPiece().getTeam()==0)return true;
                return false;
            }
            if(x == i && y == j+1){ //Backward check
                if(table[i][j+1].getPiece()==null){
                    System.out.println("Movendo pra trás");
                    return true;
                }else if(table[i][j+1].getPiece()!=null && table[i][j+1].getPiece().getTeam()==0)return true;
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
                }else if(table[i-1][j+1].getPiece()==null && table[i-1][j+1].getPiece().getTeam()==1)return true;
                return false;
            }
            if(x == i && y == j+1){ //Check forward
                if(table[i][j+1].getPiece()==null){
                    System.out.println("Movendo pra frente");
                    return true;
                }else if(table[i][j+1].getPiece()!=null && table[i][j+1].getPiece().getTeam()==1)return true;
                return false;
            }
            if(x == i+1 && y == j+1){
                if(table[i+1][j+1].getPiece()==null){ //Checking for the right diagonal
                    System.out.println("Movendo pra diagonal direita");
                    return true;
                }else if(table[i+1][j+1].getPiece()!=null && table[i+1][j+1].getPiece().getTeam()==1)return true;
                return false;
            }
            if(x == i && y == j-1){ //Backward check
                if(table[i][j-1].getPiece()==null){
                    System.out.println("Movendo pra trás");
                    return true;
                }else if(table[i][j-1].getPiece()!=null && table[i][j-1].getPiece().getTeam()==1)return true;
                return false;
            }
            return false;
        }
        return false;
    }
    
    /*
    -----------------------------------ATTACK-------------------------------------------------------------------
    */
    //Método inutilizável para a peça StormPiec
    @Override
    protected boolean attackMove(GridPane p,TableParts[][] table ,int x ,int y) { //Método inutilizável para a peça StormPiec
        int xInit = t.getLocationX(); 
        int yInit = t.getLocationY();
        int i=xInit, j=yInit, m = 0, n = 0;
        //Método inutilizável para a peça StormPiec
        if((x<=i+1) && (x>=i-1) && (x<=j+1) && (x>=j-1)) return true;
        else return false;
        //Método inutilizável para a peça StormPiec
    }
    /*
    ------------------------------------CALCULATE / CHECK ATTACK---------------------------------------------------------
    */
    //Método inutilizável para a peça StormPiec
    @Override
    protected boolean calculeteAttackMove(TableParts[][] table, int x, int y) { //Método inutilizável para a peça StormPiec
        int xInit = t.getLocationX(); 
        int yInit = t.getLocationY(); 
        int i=xInit, j=yInit;
        //Método inutilizável para a peça StormPiec
        return table[i-1][j-1].getPiece()!=null || table[i][j-1].getPiece()!=null || table[i+1][j-1].getPiece()!=null || table[i-1][j].getPiece()!=null || table[i+1][j].getPiece()!=null || table[i-1][j+1].getPiece()!=null || table[i][j+1].getPiece()!=null || table[i-1][j+1].getPiece()!=null;
    }
    //Método inutilizável para a peça StormPiec
    /*
    ------------------------------------CALCULATE / CHECK ATTACK---------------------------------------------------------
    */
    
    protected void AttackAbility(TableParts[][] table, GridPane p){
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;

        if(table[i-1][j-1].getPiece()!=null){ //7
            p.getChildren().remove(table[i-1][j-1].getPiece());
        }
        if(table[i][j-1].getPiece()!=null){ //8
            p.getChildren().remove(table[i][j-1].getPiece());
        }
        if(table[i+1][j-1].getPiece()!=null){ //9
            p.getChildren().remove(table[i+1][j-1].getPiece());
        }
        if(table[i-1][j].getPiece()!=null){ //4
            p.getChildren().remove(table[i-1][j].getPiece());
        }
        if(table[i+1][j].getPiece()!=null){ //6
            p.getChildren().remove(table[i+1][j].getPiece());
        }
        if(table[i-1][j+1].getPiece()!=null){ //1
            p.getChildren().remove(table[i-1][j+1].getPiece());
        }
        if(table[i][j+1].getPiece()!=null){ //2
            p.getChildren().remove(table[i][j+1].getPiece());
        }
        if(table[i-1][j+1].getPiece()!=null){ //3
            p.getChildren().remove(table[i-1][j+1].getPiece());
        }
    }
}