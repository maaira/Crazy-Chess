
package ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;


public class TableController implements Initializable{
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML BorderPane bpMain;
    private final int linhas = 14;    
    private final int colunas = 14;
    private GridPane gridTab;
    private TableParts[][] table;
    
    private Piece actualPiece;
    private int initPositionX, initPositionY,finalPositionX,finalPositionY ;
    
    void montarGrid() throws FileNotFoundException{
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
                    t[i][j]= new TableParts( Color.DARKRED, i, j);
                    addEventesToTable(t[i][j]);
                    t[i][j].setPiece(null);
                }
                else {
                    t[i][j]= new TableParts(Color.BISQUE, i, j);
                    addEventesToTable(t[i][j]);
                    t[i][j].setPiece(null);
                }
                gridTab.add(t[i][j], j,i);            
                
                
            }
        }
        this.gridTab= gridTab;
        table = t;
        addPieces();
        bpMain.setCenter(gridTab);
    }
    void reset(){
         actualPiece=null;
         
         
    }
    public void addEventesToTable(TableParts t1){
        EventHandler<javafx.scene.input.MouseEvent> eventHandler = new EventHandler<javafx.scene.input.MouseEvent>() { 
            @Override
            public void handle(MouseEvent event) {
                System.out.println("You clicked me!"); 
                TableParts t= (TableParts) event.getSource();
                if(t.getPiece()!=null){
                    
                }else{                   
                    
                    finalPositionX = t.getLocationX();
                    finalPositionY = t.getLocationY();
                    if(actualPiece!=null){
                                                   
                        boolean key ;
                        key = actualPiece.movePiece(table, finalPositionX, finalPositionY);
                        if(actualPiece.movePiece(table, finalPositionX, finalPositionY)){
                            gridTab.getChildren().remove(actualPiece);
                            gridTab.add(actualPiece, finalPositionY, finalPositionX );
                            actualPiece.getTableParts().setPiece(null);
                            actualPiece.setTableParts(t);
                            t.setPiece(actualPiece);
                            System.out.println("Movimento Aceito.");
                        }else{
                            
                            System.out.println("Movimento Invalido");
                        }
                    }
                }
                
            }
   
   
        };
        t1.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandler);
    }
    
    public void addPieces() throws FileNotFoundException{
        addMilleniumFalcon();
        addLeiaPiece();
        addStormPiece();
    }
    
    public void addMilleniumFalcon() throws FileNotFoundException{
        MilleniumPiece m = new MilleniumPiece("images/millenium_falcon.png", table[1][1], 1);
        gridTab.add(m, 1, 1);
        table[1][1].setPiece(m);
        addEventesToPiece(m);
        
        MilleniumPiece m2 = new MilleniumPiece("images/millenium_falcon.png", table[5][5], 0);
        gridTab.add(m2, 5, 5);
        table[5][5].setPiece(m2);
        addEventesToPiece(m2);
    }
    
    public void addLeiaPiece() throws FileNotFoundException{
        LeiaPiece L = new LeiaPiece("images/Leia.png", table[2][2], 1);
        gridTab.add(L, 2, 2);
        table[2][2].setPiece(L);
        addEventesToPiece(L);
        
        LeiaPiece L2 = new LeiaPiece("images/Leia.png", table[10][0], 0);
        gridTab.add(L2, 10, 0);
        table[10][0].setPiece(L2);
        addEventesToPiece(L2);
   }
    
    private void addStormPiece() throws FileNotFoundException{ // Generation StormPice
       StormPiece sP = new StormPiece("images/Stormtrooper.png", table[11][6], 0);
       gridTab.add(sP, 11, 6);
       table[11][6].setPiece(sP);
       addEventesToPiece(sP);
       StormPiece sP2 = new StormPiece("images/Stormtrooper.png", table[11][9], 1);
       gridTab.add(sP2, 11, 9);
       table[11][9].setPiece(sP2);
       addEventesToPiece(sP2);
    }
    
   public void addEventesToPiece(Piece p){
        EventHandler<javafx.scene.input.MouseEvent> eventHandlerPiece = new EventHandler<javafx.scene.input.MouseEvent>() { 
            @Override
            public void handle(MouseEvent event) {
                System.out.println("You clicked a Piece!"); 
                actualPiece = p;
            }
   
   
        };
        p.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandlerPiece);
    }
    
}
