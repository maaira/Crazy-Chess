package ex1;

import java.io.FileNotFoundException;
import javafx.scene.layout.GridPane;


/**
 *
 * @author Maíra
 */

public class Pion extends Piece{
    boolean Fristmove;
    public Pion(String path, TableParts t, int team) throws FileNotFoundException {
        super(path, t, team);
        Fristmove = true;
    }

    

    @Override
    public boolean movePiece(GridPane p,TableParts[][] table ,int x ,int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
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
    protected boolean calculateMovePiece(TableParts[][] table, int x, int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        if(team == 0){
            if(x == i && y == j+2){
                return FristMove0(table, x,y);
            }
            if(x == i && y == j+1){
                return Cima0(table,x,y);
            }  
            if(x == i+1 && x == i-1){
                return Diagonalizando0(table, x, y);
            }
        
        }else{
           if(x == i && y == j-2){
                return FristMove1(table, x,y);
            } 
            if(x == i && y == j-1){
                return Cima1(table,x,y);
            } 
            if(x == i+1 && x == i-1){
                return Diagonalizando1(table, x, y);
            }
        }
        
        return false;
        
    }
    
    
    
     protected boolean FristMove0(TableParts[][] table, int x, int y){
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        int cont = 0 ;
        
            if(Fristmove){
                
                if(y==j+2){
                    while(cont <= 1){
                        j++;
                        cont ++;
                        if(table[i][j].getPiece()==null){
                        }else return false;
                    }
                    
                }
            }else return false;
        Fristmove=false;
        return true;
     }
    
     protected boolean FristMove1(TableParts[][] table, int x, int y){
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        int cont = 0 ;
        if(Fristmove){
                
                if(y==j-2){
                    while(cont <= 1){
                        j--;
                        if(table[i][j].getPiece()==null){
                        }else return false;
                    }
                }
        }else return false;
        Fristmove=false;
        return true;
     }
    
     protected boolean Cima0(TableParts[][] table, int x, int y){
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        
        if(y==j+1){
            j++;
            if(table[i][j].getPiece()==null){
            }else return false;   
        }
        Fristmove = false;
        return true;
     }
     
     
     protected boolean Cima1(TableParts[][] table, int x, int y){
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        
         if(y==j-1){
            j--;
            if(table[i][j].getPiece()==null){
            }else return false;
        }
        Fristmove = false;
        return true;
     }
    
      protected boolean Diagonalizando0(TableParts[][] table, int x, int y){
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        
        if(x == i+1 || y == j+1){
            i++;
            j++;
            if(table[i][j].getPiece().getTeam() != team){
             if(table[i][j].getPiece()!=null){
                Fristmove = false;
                return true;
            }else return false;   
            }
            
        }
        if(x == i-1 || y == j+1){
            i--;
            j++;
            if(table[i][j].getPiece().getTeam() != team){
              if(table[i][j].getPiece()!=null){
                Fristmove = false;
                return true;
            }else return false;  
            }
            
        }
        return false;
      }
      
      
      protected boolean Diagonalizando1(TableParts[][] table, int x, int y){
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        
        if(x == i+1 || y == j-1){
            i++;
            j--;
            if(table[i][j].getPiece().getTeam() != team){
               if(table[i][j].getPiece()!=null){
                Fristmove = false;
                return true;
            }else return false; 
            }
            
        }
        if(x == i-1 || y == j-1){
            i--;
            j--;
            if(table[i][j].getPiece().getTeam() != team){
              if(table[i][j].getPiece()!=null){
                Fristmove = false;
                return true;
            }else return false;  
            }
            
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

    

}