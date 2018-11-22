
package ex1;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class TableController implements Initializable{
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML BorderPane bpMain;
    private int linhas=14, colunas=14;    
    private GridPane gridTab;
    private TableParts[][] table;
    void montarGrid(){
        GridPane gridTab = new GridPane();
        
        TableParts t [][]= new TableParts[14][14];
        
        for (int i = 0; i <= linhas; i++) {
            
            RowConstraints con = new RowConstraints();
            
            con.setPrefHeight(50);
            
            gridTab.getRowConstraints().add(con);
            
        }       
        
        for (int i = 0; i <= colunas; i++) {
            
            ColumnConstraints con = new ColumnConstraints();
            
            con.setPrefWidth(50);
            
            gridTab.getColumnConstraints().add(con);
            
        }
        
        for(int i=0; i<linhas; i++){
            for(int j=0;j<colunas;j++){               
                              
                if((i%2==0 && j%2!=0) || (i%2!=0 && j%2==0)){ 
                    t[i][j]= new TableParts("src/images/millenium_falcon.png", Color.BLACK, i, j);
                    addEventesToTable(t[i][j]);
                }
                else {
                    t[i][j]= new TableParts("src/images/millenium_falcon.png",Color.GHOSTWHITE, i, j);
                    addEventesToTable(t[i][j]);
                }
                gridTab.add(t[i][j], j,i);            
                
                
            }
        }
        this.gridTab= gridTab;
        table = t;
        //addPieces();
        bpMain.setCenter(gridTab);
    }
    
    public void addEventesToTable(TableParts t){
        EventHandler<javafx.scene.input.MouseEvent> eventHandler = new EventHandler<javafx.scene.input.MouseEvent>() { 
            @Override
            public void handle(MouseEvent event) {
                System.out.println("You clicked me!"); 
                t.getLocationX();
            }
   
   
        };
        t.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandler);
    }
    
    public void addPieces(){
        addMilleniumFalcon();
    }
    
    public void addMilleniumFalcon(){
        String path = "src/images/millenium_falcon.png";
        Image img = new Image(path);
        //team 1 
        MilleniumPiece falcon  = new MilleniumPiece(path,0,0,0);
        //team 2
        MilleniumPiece falcon2 = new MilleniumPiece(path,5,14,1);
        //seta a peça e o imagem da peça
        table[0][0].setFill(new ImagePattern(img));        
        table[10][10].setFill(new ImagePattern(img));
        table[0][0].setPiece(falcon);
        table[10][10].setPiece(falcon2);
    }

    
}
