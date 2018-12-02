
package ex1;

import java.util.ArrayList;

public class Player {
    private ArrayList piece;
    private ArrayList piecesAttacked;
    private int team;
    private  int round = 0;

    public ArrayList getPiece() {
        return piece;
    }

    public ArrayList getPiecesAttacked() {
        return piecesAttacked;
    }

    public int getTeam() {
        return team;
    }

    public Player(String nome, ArrayList piece, int team) {
        this.piece = piece;
        this.team = team;
    }
    
    public boolean emptyPiece(){
        return piece.isEmpty() && round!=0;
    }
    
    
    
}
