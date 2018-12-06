package ex1;

import java.io.FileNotFoundException;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Maira
 */
public abstract class Piece extends ImageView{
    //the part piece
    protected int team;
    protected Player pl;
    //the position: location[0] = x e location[1]=y
    protected TableParts t;    
    //protected String nome;
    /*enables and disables the piece*/
    protected boolean move_status ;
    
    protected String path;
    
    int round;
    
    void setRound(int i){
        round = i;
    }
    //protected int hp, hit ;
    public Piece(String path, TableParts t, int team) throws FileNotFoundException{
        super(path);                        
        this.t = t;
        this.team = team;
        setTam();
    }

    public boolean getMove_status() {
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
    

    
    //function to move
    public abstract boolean movePiece(GridPane p,TableParts[][] table ,int x ,int y);
    //function to validate the movement of the piece
    protected abstract boolean calculateMovePiece(TableParts[][] table ,int x ,int y);
    //function to attack
    protected abstract boolean attackMove(GridPane p,TableParts[][] table ,int x ,int y);
    //function to validate the attack of the piece
    protected abstract boolean calculeteAttackMove(TableParts[][] table ,int x ,int y);

    
}