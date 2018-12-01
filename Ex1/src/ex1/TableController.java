
package ex1;

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
    
    private Piece actualPiece, attackedPiece;
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
                    t[j][i]= new TableParts( Color.DARKRED, j, i);
                    addEventesToTable(t[j][i]);
                    t[j][i].setPiece(null);
                }
                else {
                    t[j][i]= new TableParts(Color.BISQUE, j, i);
                    addEventesToTable(t[j][i]);
                    t[j][i].setPiece(null);
                }
                gridTab.add(t[j][i], j,i);            
                
                
            }
        }
        this.gridTab= gridTab;
        table = t;
        addPieces();
        bpMain.setCenter(gridTab);
    }
    
    
    public void addEventesToTable(TableParts t1){
        EventHandler<javafx.scene.input.MouseEvent> eventHandler = new EventHandler<javafx.scene.input.MouseEvent>() { 
            @Override
            public void handle(MouseEvent event) {
                System.out.println("You clicked me!"); 
                TableParts t= (TableParts) event.getSource();
                if(attackedPiece!=null && attackedPiece.getTeam()!=actualPiece.getTeam() ){
                    
                    
                }else{                   
                    System.out.println("Move.");
                    finalPositionX = t.getLocationX();
                    finalPositionY = t.getLocationY();
                    System.out.println("("+finalPositionX+","+ finalPositionY+")");
                    if(actualPiece!=null && actualPiece.movePiece(table, finalPositionX, finalPositionY) ){
                        System.out.println("("+actualPiece.getTableParts().getLocationX()+","+ actualPiece.getTableParts().getLocationY());
                        
                        gridTab.getChildren().remove(actualPiece);
                        gridTab.add(actualPiece, finalPositionX, finalPositionY );
                        actualPiece.getTableParts().setPiece(null);
                        actualPiece.setTableParts(t);
                        table[finalPositionX][finalPositionY].setPiece(actualPiece);
                        actualPiece=null;
                        System.out.println("Movimento Aceito.");
                        
                            
                            
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
        MilleniumPiece m = new MilleniumPiece("images/millenium_falcon.png", table[6][6], 1);
        gridTab.add(m, 6, 6);
        table[6][6].setPiece(m);
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
                if(actualPiece==null)actualPiece = p;
                else attackedPiece =p;
            }
   
   
        };
        p.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandlerPiece);
    }
    
   
}
