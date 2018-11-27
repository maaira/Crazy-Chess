package ex1;

import java.io.FileNotFoundException;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public abstract class Piece extends ImageView{
    //the part piece
    protected int team;
    //the position: location[0] = x e location[1]=y
    protected TableParts t;    
    //protected String nome;
    /*enables and disables the piece*/
    protected boolean move_status ;
    
    protected String path;
    @FXML ImageView png;
    
    //protected int hp, hit ;
    public Piece(String path, TableParts t, int team) throws FileNotFoundException{
        super(path);                        
        this.t = t;
        this.team = team;
        setTam();
    }

    public boolean isMove_status() {
        return move_status;
    }

    public void setMove_status(boolean move_status) {
        this.move_status = move_status;
    }    
    
    public int getTeam() {
        return team;
    }
    
    public TableParts getTableParts() {
        return t;
    }
    
    public void setTableParts(TableParts t) {
       this.t = t;
    }
    
    private void setTam(){
        this.fitHeightProperty().set(50);
        this.fitWidthProperty().set(50);
    }
    /*public int[] getLocation() {
        return location;
    }

    
    
    public void setLocation(TableParts t) {
        this.location[0] = t.getLocationX();
        this.location[1] = t.getLocationY();
        t.setPiece(this);
    }*/

    public abstract boolean Handler(TableParts[][] table ,int x ,int y);
    //function to move
    public abstract boolean movePiece(TableParts[][] table ,int x ,int y);
    //function to validate the movement of the piece
    protected abstract boolean calculateMovePiece(TableParts[][] table ,int x ,int y);
    //function to attack
    protected abstract boolean attackMove(TableParts[][] table ,int x ,int y);
    //function to validate the attack of the piece
    protected abstract boolean calculeteAttackMove(TableParts[][] table ,int x ,int y);
}
