package ex1;


public abstract class Piece {
    //the part piece
    protected int team;
    //the position: location[0] = x e location[1]=y
    protected int location[]= new int[2];    
    //protected String nome;
    /*enables and disables the piece*/
    protected boolean move_status ;
    
    //protected int hp, hit ;
    
    
    public int getTeam() {
        return team;
    }

    public int[] getLocation() {
        return location;
    }

    public void setPosition(int[] position) {
        this.location = position;
    }
    
    public void setLocation(int x, int y) {
        this.location[0] = x;
        this.location[1] = y;
    }

    
    //function to move
    public abstract boolean movePiece(int x, int y);
    //function to validate the movement of the piece
    protected abstract boolean calculateMovePiece(int x, int y);
    //function to attack
    protected abstract boolean attackMove(int x, int y, Piece p, Player u, Player u2);
    //function to validate the attack of the piece
    protected abstract boolean calculeteAttackMove();
}
