package ex1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public abstract class Piece extends ImageView{
    //the part piece
    protected int team;
    //the position: location[0] = x e location[1]=y
    protected int location[]= new int[2];    
    //protected String nome;
    /*enables and disables the piece*/
    protected boolean move_status ;
    
    protected String path;
    
    //protected int hp, hit ;
    public Piece(String path, int x, int y, int team){
        try{
            FileInputStream input = new FileInputStream("src/images/millenium_falcon.png");
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);
        }catch(FileNotFoundException e) {
            System.out.println("Warning! Path : "+ path + ".");
            System.out.println(e.getMessage());
        }      
        location[0]= x;
        location[y]= y;
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

    public int[] getLocation() {
        return location;
    }

    
    
    public void setLocation(TableParts t) {
        this.location[0] = t.getLocationX();
        this.location[1] = t.getLocationY();
        t.setPiece(this);
    }

    
    //function to move
    public abstract boolean movePiece(TableParts t);
    //function to validate the movement of the piece
    protected abstract boolean calculateMovePiece(int x, int y);
    //function to attack
    protected abstract boolean attackMove(TableParts t);
    //function to validate the attack of the piece
    protected abstract boolean calculeteAttackMove();
}
