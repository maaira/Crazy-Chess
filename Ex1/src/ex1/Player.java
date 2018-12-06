
package ex1;

import java.util.ArrayList;

public class Player {
    private ArrayList<Piece> piece = new ArrayList<>();
    private final int team;
    private  int round = 0;
    
    public void setRound(int i){
        round = i;
    }
    public void moveStatus(boolean status){
        for(Piece pe : piece ){
            pe.setMove_status(status);
        }
    }
    public ArrayList getPiece() {
        return piece;
    }
    
    public void setRoundGame(int status){
        for(Piece pe : piece ){
            pe.setRound(status);
        }
    }
    

    public int getTeam() {
        return team;
    }

    public Player(String nome,int team) {
        this.piece = piece;
        this.team = team;
    }
    
    public boolean emptyPiece(){
        return piece.isEmpty() && round!=0;
    }
    
    
    
}
