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
            
            /*
            Os números que estão nos comentários serve para se guiar pelo teclado número
            do notebook e saber qual casa será usada em vista que a Storm
            esteja no número 5;
            */
            
            if(TableController.cont>=1){
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
                TableController.cont--;
            }

        }
        return false;
    }
    
    /*
    --------------------------------------CALCULETE ATTACK ------------------------------------
    */

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

/*
RASCUNHO DOS MÉTODOS GENÉRICOS:

    int xInit = t.getLocationX(); 
    int yInit = t.getLocationY(); 
    int i=xInit, j=yInit;

    if(x == i && y == j){
        if(x == i-1 && y == j-1){
            if(table[i-1][j-1].getPiece()!=null){
//                    table[i-1][j-1].getPiece().REMOVERESSAPORRA;
//                    p.getChildren().remove(table[x][y].getPiece());
            }
        }
        if(x == i && y == j-1){
            if(table[i][j-1].getPiece()!=null){

            }
        }
        if(x == i+1 && y == j-1){
            if(table[i+1][j-1].getPiece()!=null){

            }
        }
        if(x == i-- && y == j){
            if(table[i-1][j].getPiece()!=null){

            }
        }
        if(x == i++ && y == j){
            if(table[i+1][j].getPiece()!=null){

            }
        }
        if(x == i-- && y == j++){
            if(table[i-1][j+1].getPiece()!=null){

            }
        }
        if(x == i && y == j++){
            if(table[i][j+1].getPiece()!=null){

            }
        }
        if(x == i-- && y == j++){
            if(table[i-1][j+1].getPiece()!=null){

            }
        }
        return true;
    } else return false;

    ---------------------------------------------------------------------------------

    int xInit = t.getLocationX();
    int yInit = t.getLocationY();
    int i=xInit, j=yInit;
    if (x<=i+1 && if x>=i-1 && if x<=j+1 && if x>=j-1) return true
    return false;

    ---------------------------------------------------------------------------------

    protected boolean attackMove(GridPane p,TableParts[][] table ,int x ,int y) {
        if(calculeteAttackMove(table , x , y))for (n=i-1;n=i+1;n++){
            for (m=j-1;m=j+1;m++){
		if (n!=i && m!=j){
                    if(table[n][m].getPiece()!=null){
                        p.getChildren().remove(table[x][y].getPiece());
                        return true;
                    }else return false;
		}
            }
        }else return false;
    }
    return false;

    ----------------------------------------------------------------------------------

    protected boolean attackMove(GridPane p,TableParts[][] table ,int x ,int y) {
        if(calculeteAttackMove(table , x , y)){   
            if(table[x][y].getPiece()!=null){
                p.getChildren().remove(table[x][y].getPiece());
                return true;
            }else return false;
             
        }
        return false;
    }

    ----------------------------------------------------------------------------------

    if(calculeteAttackMove(table , xAux , yAux)){
                if(x == i-1 && y == j-1){
                    if(table[i-1][j-1].getPiece()!=null){ //7
                        p.getChildren().remove(table[i-1][j-1].getPiece());
                    }
                }
                if(x == i && y == j-1){
                    if(table[i][j-1].getPiece()!=null){ //8
                        p.getChildren().remove(table[i][j-1].getPiece());
                    }
                }
                if(x == i+1 && y == j-1){
                    if(table[i+1][j-1].getPiece()!=null){ //9
                        p.getChildren().remove(table[i+1][j-1].getPiece());
                    }
                }
                if(x == i-- && y == j){
                    if(table[i-1][j].getPiece()!=null){ //4
                        p.getChildren().remove(table[i-1][j].getPiece());
                    }
                }
                if(x == i++ && y == j){
                    if(table[i+1][j].getPiece()!=null){ //6
                        p.getChildren().remove(table[i+1][j].getPiece());
                    }
                }
                if(x == i-- && y == j++){
                    if(table[i-1][j+1].getPiece()!=null){ //1
                        p.getChildren().remove(table[i-1][j+1].getPiece());
                    }
                }
                if(x == i && y == j++){
                    if(table[i][j+1].getPiece()!=null){ //2
                        p.getChildren().remove(table[i][j+1].getPiece());
                    }
                }
                if(x == i-- && y == j++){
                    if(table[i-1][j+1].getPiece()!=null){ //3
                        p.getChildren().remove(table[i-1][j+1].getPiece());
                    }
                }
            return true;
        }

        -----------------------------------------------------------------------------

	if(calculeteAttackMove(table , x , y)){
            if((x == i-1 && y == j-1) || (x == i && y == j-1) || (x == i+1 && y == j-1) || (x == i-- && y == j) || (x == i++ && y == j) || (x == i-- && y == j++) || (x == i && y == j++) || (x == i-- && y == j++)){
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
            return true;
        }

        ---------------------------------------------------------------------------

        for (n=i-1;n==i+1;n++){
            for (m=j-1;m==j+1;m++){
		if (n!=i && m!=j){
                    if(table[n][m].getPiece()!=null){
                        p.getChildren().remove(table[n][m].getPiece());
                        return true;
                    }else return false;
		}
            }
        }
*/