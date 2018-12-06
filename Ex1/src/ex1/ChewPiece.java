package ex1;

import java.io.FileNotFoundException;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Pedro
 */
public class ChewPiece extends Piece{
    public ChewPiece(String path, TableParts t, int team) throws FileNotFoundException {
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
    protected boolean calculateMovePiece(TableParts[][] table ,int x ,int y) {
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        
              if(i>x && j<y){
            return InferiorEsq(table,x,y);
        }else if(i<x && j<y){
            return InferiorDir(table, x, y);
        }else if(i>x && j>y){
            return SuperiorEsq(table, x, y);
        }else if(i<x && j>y){
            return SuperiorDir(table, x, y);
        }else if(i<x && j==y){
            return Direita(table, x, y);
        }else if(i>x && j==y){
            return Esquerda(table, x, y);
        }else if(i==x && j>y){
            return Cima(table, x, y);
        }else if(i==x && j<y){
            return Baixo(table, x, y);
        }
        
        
        
        return false;
    }
    
      private boolean InferiorEsq(TableParts[][] table ,int x ,int y){
        System.out.println("Inferior Esq");
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        int cont=0;
        
        if(x<i-5 && y>j+5){
            System.out.println("Mais De 5 Casas");
            return false;
        }
        
        //ParteInferiorEsquerda
        
            while(cont<5){
            j++;
            i++;
            if(table[i][j].getPiece()==null){
            }else{
                if(table[i][j].getPiece().getTeam() != team){
                    return true;
                }else{
                  return false;  
                }
                
            }
             cont++;
            }  
            return true;
      }
        //MovimentoInferiorDireita
        private boolean InferiorDir(TableParts[][] table ,int x ,int y){
        System.out.println("Inferior Direita");
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        int cont=0;
        
        if(x>i+5 && y>j+5){
            System.out.println("Mais De 5 Casas");
            return false;
        }
        
         while(cont<5){
            j++;
            i++;
            if(table[i][j].getPiece()==null){
            }else{
                if(table[i][j].getPiece().getTeam() != team){
                    return true;
                }else{
                  return false;  
                }
                
            }
             cont++;
            }  
            return true;
        }
        
        //MovimentoSuperiorEsquerdo
         private boolean SuperiorEsq(TableParts[][] table ,int x ,int y){
        
             System.out.println("Movimento Superior Esquerdo");
                 int xInit = t.getLocationX();
                 int yInit = t.getLocationY();
                    int i=xInit, j=yInit;
                    int cont=0;
        
        if(x<i-5 && y<j-5){
            System.out.println("Mais De 5 Casas");
            return false;
        }
            while(cont<5){
            j--;
            i--;
            if(table[i][j].getPiece()==null){
            }else{
                if(table[i][j].getPiece().getTeam() != team){
                    return true;
                }else{
                  return false;  
                }
                
            }
             cont++;
            }  
            return true;
        }
        
        //MovimentoSuperiorDireito
         private boolean SuperiorDir(TableParts[][] table ,int x ,int y){
         System.out.println("Movimento Superior Direito");
                 int xInit = t.getLocationX();
                 int yInit = t.getLocationY();
                    int i=xInit, j=yInit;
                    int cont=0;
        
        if(x>i+5 && y<j-5){
            System.out.println("Mais De 5 Casas");
            return false;
        }
        
           while(cont<5){
            j--;
            i++;
            if(table[i][j].getPiece()==null){
            }else{
                if(table[i][j].getPiece().getTeam() != team){
                    return true;
                }else{
                  return false;  
                }
                
            }
             cont++;
            }  
            return true;
         }
           
         
    //pra direita
    private boolean Direita(TableParts[][] table ,int x ,int y){
        System.out.println("Direita");
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        int cont=0;
        
        if(x>i+5){
            System.out.println("Mais De 5 Casas");
            return false;
        }
        
        //PraDireita
        //if(i<x && j==y){
        while(cont<5){
            i++;
            if(table[i][j].getPiece()==null) {
            } else {
                return false;
                }
             cont++;
            }
        return true;
        }
        //PraEsquerda
        //if(i>x && j==y)
        private boolean Esquerda(TableParts[][] table ,int x ,int y){
            System.out.println("Esquerda");
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        int cont=0;
        
        if(x<i-5){
            System.out.println("Mais De 5 Casas");
            return false;
        }
        
        while(cont<5){
            i--;
            if(table[i][j].getPiece()==null){
            }else{
                if(table[i][j].getPiece().getTeam() != team){
                    return true;
                }else{
                  return false;  
                }
                
            }
             cont++;
            }  
            return true;
        }
        //PraCima
        //if(i==x && j>y){
        
        private boolean Cima(TableParts[][] table ,int x ,int y){
        
            System.out.println("CIma");
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        int cont=0;
        
        if(y<j-5){
            System.out.println("Mais De 5 Casas");
            return false;
        }
            
            while(cont<5){
            j--;
            if(table[i][j].getPiece()==null){
            }else{
                if(table[i][j].getPiece().getTeam() != team){
                    return true;
                }else{
                  return false;  
                }
                
            }
             cont++;
            }  
            return true;
        }
        
        //PraBaixo
        //if(i==x && j<y){
        private boolean Baixo(TableParts[][] table ,int x ,int y){
        
            System.out.println("Baixo");
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        int cont=0;
        
        if(y>j+5){
            System.out.println("Mais De 5 Casas");
            return false;
        }
            
            while(cont<5){
            j++;
            if(table[i][j].getPiece()==null){
            }else{
                if(table[i][j].getPiece().getTeam() != team){
                    return true;
                }else{
                  return false;  
                }
                
            }
             cont++;
            }  
            return true;
        }
        
        //RONALDO NEM VAI VER :D;
        


    @Override
    protected boolean calculeteAttackMove(TableParts[][] table, int x, int y) {
       System.out.println("RRRAARRWHHGWWR");
        int xInit = t.getLocationX();
        int yInit = t.getLocationY();
        int i=xInit, j=yInit;
        
        
        if(x != i+1 || x != i-1){
            System.out.println("Limite De Distância é de 1 casa");
            return false;
        }else{
            if(table[x][y].getPiece()==null){
                System.out.println("SEM PEÇA PRA SOCAR");
                return false;
            }else{
                return true;
            }
        }
    
    
    }

    @Override
    protected boolean attackMove(GridPane p, TableParts[][] table, int x, int y) {
        if(calculateMovePiece(table, x, y) && table[x][y].getPiece().getTeam()!=team){
            p.getChildren().remove(table[x][y].getPiece());
            table[x][y].setPiece(null);
            return true;
        }
        return false;
    }
    
}