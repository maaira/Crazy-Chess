
package ex1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class TableController implements Initializable{
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML BorderPane bpMain;
    private int linhas=14, colunas=14;    
    
    
    
    void montarGrid(){
        GridPane gridTab = new GridPane();
        
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
                final Rectangle r = new Rectangle(50, 50);
                final TableParts table = new TableParts();
                if((i%2==0 && j%2!=0) || (i%2!=0 && j%2==0)) 
                    r.setFill(Color.BLACK);
                else 
                    r.setFill(Color.WHITE);
                
                table.setRectangle(r);
                gridTab.add(table, j,i);
                r.setOnMouseClicked((event) -> {
                    
                });
            }
        }
        
        bpMain.setCenter(gridTab);
    }
    
   


    
}
