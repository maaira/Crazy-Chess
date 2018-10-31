
package chess;

import java.util.ArrayList;

public class Player {
    ArrayList piece;
    ArrayList piecesAttacked;
    int team;
    int round = 0;

    public Player(ArrayList piece, int team) {
        this.piece = piece;
        this.team = team;
    }
    
    public boolean emptyPiece(){
        return piece.isEmpty() && round!=0;
    }
    
    
    
}
