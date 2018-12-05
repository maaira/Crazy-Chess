
package ex1;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseButton;
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
    private final int linhas = 14;    
    private final int colunas = 14;
    private GridPane gridTab, cemitery_left, cemitery_right;
    private TableParts[][] table;
    private TableParts tclicked;
    private Piece actualPiece, attackedPiece;
    private int initPositionX, initPositionY,finalPositionX,finalPositionY ;
    private Player player1,player2;
    
    private GridPane Cemitery(){
        GridPane tery = new GridPane();
        TableParts t [][]= new TableParts[14][3];
        for(int i=0;i<14;i++){
            RowConstraints con = new RowConstraints();            
            con.setPrefHeight(50);            
            tery.getRowConstraints().add(con);
        }
        
        for(int i=0;i<3;i++){
            ColumnConstraints con = new ColumnConstraints();
            con.setPrefWidth(50);
            tery.getColumnConstraints().add(con);
        }
        
        for(int i=0; i<14; i++){
            for(int j=0;j<3;j++){               
                final Rectangle r = new Rectangle(50, 50);              
                r.setFill(Color.BLACK);
                tery.add(r, j,i);        
                                
            }
        }
        
        
        return tery;
        
    }
    
    void makeCemitery(){
        cemitery_left = Cemitery();
        cemitery_right = Cemitery();
        bpMain.setLeft(cemitery_left);
        bpMain.setRight(cemitery_right);
        
    }
    
    void setPlayer(String p1,String p2){
         
        
    
    }
    
    void setTable() throws FileNotFoundException{
        makeTable();
        
        makeCemitery();
        
    }
    void makeTable() throws FileNotFoundException {
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
                    t[j][i]= new TableParts( Color.GRAY, j, i);
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
    
    private void Move(){
        System.out.println("Move.");
        initPositionX =  actualPiece.getTableParts().getLocationX();
        initPositionY =  actualPiece.getTableParts().getLocationY();
        finalPositionX = tclicked.getLocationX();
        finalPositionY = tclicked.getLocationY();
        System.out.println("("+finalPositionX+","+ finalPositionY+")");
        System.out.println("("+actualPiece.getTableParts().getLocationX()+","+ actualPiece.getTableParts().getLocationY());
        System.out.println("Move.");
        
        if(actualPiece.movePiece(gridTab,table, finalPositionX, finalPositionY) ){
            
            System.out.println("("+actualPiece.getTableParts().getLocationX()+","+ actualPiece.getTableParts().getLocationY());
                       
            
            System.out.println("Movimento Aceito.");
                        
                            
                            
        }else System.out.println("Movimento Invalido."); 
        reset();
    }    
    
    
    void reset(){
        tclicked     = null;
        attackedPiece= null;
        actualPiece  = null;
    }
    private void Attack(){        
            
        System.out.println("Attack!"); 
        finalPositionX = attackedPiece.getTableParts().getLocationX();
        finalPositionY = attackedPiece.getTableParts().getLocationY();
        if(actualPiece.attackMove(gridTab,table,finalPositionX , finalPositionY)){
            table[finalPositionX][finalPositionY].setPiece(null);
            gridTab.getChildren().remove(attackedPiece);
             System.out.println("Attack realizado!"); 
       }else System.out.println("Attack invalido!");     
            
        
        reset();
        
    }
    
    public void addEventesToTable(TableParts t1){
        EventHandler<javafx.scene.input.MouseEvent> eventHandler = new EventHandler<javafx.scene.input.MouseEvent>() { 
            @Override
            public void handle(MouseEvent event) { 
                tclicked= (TableParts) event.getSource();
                System.out.println(tclicked.getLocationX()+" , "+tclicked.getLocationY()); 
                if(tclicked.getPiece()!=null)System.out.println("Has Piece."); 
                if(event.getButton()== MouseButton.PRIMARY){
                    System.out.println("Primary.");
                    if(actualPiece!=null)Move();
                }
                if(event.getButton()== MouseButton.SECONDARY){
                    
                    if(actualPiece!=null && attackedPiece!=null){
                        Attack();
                    }
                    else System.out.println("Ataque invalido");
                }                
                
            }             
   
   
        };
        t1.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandler);
    }
    
    public void addEventesToPiece(Piece p){
        EventHandler<javafx.scene.input.MouseEvent> eventHandlerPiece = new EventHandler<javafx.scene.input.MouseEvent>() { 
            @Override
            public void handle(MouseEvent event) {
                System.out.println("You clicked a Piece!"); 
                if(event.getButton()== MouseButton.PRIMARY){
                    if(actualPiece==null)actualPiece=p;
                    else{
                        attackedPiece = p;
                        tclicked = attackedPiece.getTableParts();
                        Move();
                    }
                    
                }
                if(event.getButton()== MouseButton.SECONDARY){
                    if(actualPiece!=null)attackedPiece=p;
                    if(actualPiece!=null && attackedPiece!=null){
                        Attack();
                    }
                    else System.out.println("Ataque invalido");
                }
                
            }
   
   
        };
        p.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandlerPiece);
    }
    
    public void addPieces() throws FileNotFoundException{
        addMilleniumFalcon();
        addLeiaPiece();
        addStormPiece();
        addHorse();
        addDarthPiece();
        addHanPiece();
        //addPion();
        
    }
    
    public void addDarthPiece() throws FileNotFoundException{
        DarthPiece dv = new DarthPiece("images/Darth_Vader.jpeg", table[0][5], 1);
        gridTab.add(dv, 0, 5);
        table[0][5].setPiece(dv);
        addEventesToPiece(dv);
        
        DarthPiece dv2 = new DarthPiece("images/Darth_Vader.jpeg", table[0][8], 0);
        gridTab.add(dv2, 0, 8);
        table[0][8].setPiece(dv2);
        addEventesToPiece(dv2);
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
    
    public void addPion() throws FileNotFoundException{
        Pion m = new Pion("images/pion.png", table[0][0], 0);
        gridTab.add(m, 0, 0);
        table[0][0].setPiece(m);
        addEventesToPiece(m);
        
        Pion m2 = new Pion("images/pion.png", table[12][12], 1);
        gridTab.add(m2, 12, 12);
        table[12][12].setPiece(m2);
        addEventesToPiece(m2);
    }
    
    public void addHorse() throws FileNotFoundException{
        HorsePiece m = new HorsePiece("images/horse.png", table[7][7], 1);
        gridTab.add(m, 7, 7);
        table[7][7].setPiece(m);
        addEventesToPiece(m);
        
        HorsePiece m2 = new HorsePiece("images/horse.png", table[8][8], 0);
        gridTab.add(m2, 8, 8);
        table[8][8].setPiece(m2);
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
       StormPiece sP = new StormPiece("images/Stormtrooper.png", table[11][8], 0);
       gridTab.add(sP, 11, 8);
       table[11][8].setPiece(sP);
       addEventesToPiece(sP);
       
       StormPiece rP = new StormPiece("images/rebel.png", table[11][9], 1);
       gridTab.add(rP, 11, 9);
       table[11][9].setPiece(rP);
       addEventesToPiece(rP);
    }  
    
   public void addHanPiece() throws FileNotFoundException{
        HanPiece m = new HanPiece("images/han_solo.jpeg", table[9][6], 1);
        gridTab.add(m, 9, 6);
        table[9][6].setPiece(m);
        addEventesToPiece(m);
        
        HanPiece m2 = new HanPiece("images/han_solo.jpeg", table[1][5], 0);
        gridTab.add(m2, 1, 5);
        table[1][5].setPiece(m2);
        addEventesToPiece(m2);
    }
    
    
   
}
