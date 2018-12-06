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
    
    int cont, contFinal;
    public StormPiece(String path, TableParts t, int team) throws FileNotFoundException {
        super(path, t, team);
    }
    
    
    @Override
    public boolean movePiece(GridPane p,TableParts[][] table ,int x ,int y) {
            if(calculateMovePiece(table,x,y)){
            p.getChildren().remove(this);
            p.add(this,x,y);
            t.setPiece(null);
            if(table[x][y].getPiece()!=null){
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

    @Override
    protected boolean attackMove(GridPane p,TableParts[][] table ,int x ,int y) {
        if(calculeteAttackMove(table , x , y)){
            int xInit = t.getLocationX(); 
            int yInit = t.getLocationY();
            int i=xInit, j=yInit;
            
            if(cont==1){
                if(table[x-1][y-1].getPiece()!=null){ //7
                    p.getChildren().remove(table[x-1][y-1].getPiece());
                }
                if(table[x][y-1].getPiece()!=null){ //8
                    p.getChildren().remove(table[x][y-1].getPiece());
                }
                if(table[x+1][y-1].getPiece()!=null){ //9
                    p.getChildren().remove(table[x+1][y-1].getPiece());
                }
                if(table[x-1][y].getPiece()!=null){ //4
                    p.getChildren().remove(table[x-1][y].getPiece());
                }
                if(table[x+1][y].getPiece()!=null){ //6
                    p.getChildren().remove(table[x+1][y].getPiece());
                }
                if(table[x-1][y+1].getPiece()!=null){ //1
                    p.getChildren().remove(table[x-1][y+1].getPiece());
                }
                if(table[x][y+1].getPiece()!=null){ //2
                    p.getChildren().remove(table[x][y+1].getPiece());
                }
                if(table[x-1][y+1].getPiece()!=null){ //3
                    p.getChildren().remove(table[x-1][y+1].getPiece());
                }
            }

        }
        return false;
    }

    @Override
    protected boolean calculeteAttackMove(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX(); //Line
        int yInit = t.getLocationY(); //Colune
        int i=xInit, j=yInit;
        
        if(x==i && y==j){
            return table[x-1][y-1].getPiece()!=null || table[x][y-1].getPiece()!=null || table[x+1][y-1].getPiece()!=null || table[x-1][y].getPiece()!=null || table[x+1][y].getPiece()!=null || table[x-1][y+1].getPiece()!=null || table[x][y+1].getPiece()!=null || table[x-1][y+1].getPiece()!=null;
        }else return false;
        
    }
    
}