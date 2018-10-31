package chess;


public abstract class Piece {
    //the part piece
    protected int team;
    //the position: location[0] = x e location[1]=y
    protected int location[]= new int[2];    
    protected String nome;
    /*enables and disables the piece*/
    protected boolean move_status ;
    
    
    public int getTeam() {
        return team;
    }

    public int[] getPosition() {
        return location;
    }

    public void setPosition(int[] position) {
        this.location = position;
    }
    
    public void setPosition(int x, int y) {
        this.location[0] = x;
        this.location[0] = y;
    }

    public String getNome() {
        return nome;
    }  
    //function to move
    public abstract boolean movePiece();
    //function to validate the movement of the piece
    protected abstract boolean calculateMovePiece();
    //function to attack
    protected abstract boolean attackMove();
    //function to validate the attack of the piece
    protected abstract boolean calculeteAttackMove();
}
