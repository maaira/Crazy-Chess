/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.FileNotFoundException;

/**
 *
 * @author Aluno
 */
public class LeiaPiece extends Piece{

    public LeiaPiece(String path, TableParts t, int team) throws FileNotFoundException {
        super(path, t, team);
    }

    
    public boolean movePiece(TableParts t) {
        if(!calculateMovePiece(t.getLocationX(),t.getLocationY()))return false;
        
        //else setLocation(t);
        return false;
    }
//Movimento: anda duas casas para frente e duas para o lado

    
    protected boolean calculateMovePiece(int x, int y) {
        return false;
/*       if((location[1]+1==y) && ( location[0]==x)) return true;
        if((location[1]+2==y) && ((location[0]==x)))return true;
        if((location[1]+2==y) && ((location[0]+1==x))) return true;
        if((location[1]+2==y) && ((location[0]-1==x))) return true;
        if((location[1]+2==y) && ((location[0]+2==x))) return true;
        if((location[1]+2==y) && ((location[0]-2==x))) return true; 
        
        else return false;
    }*/
//Ataque: atira para as quatro direções (N, S, L, O)
    
}

    
    protected boolean attackMove(TableParts t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean calculeteAttackMove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean movePiece(TableParts[][] t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean calculateMovePiece(TableParts t ,int x ,int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean attackMove(TableParts[][] t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
