package ex1;

import ex1.ChewPiece;
import ex1.DarthPiece;
import ex1.HanPiece;
import ex1.HorsePiece;
import ex1.LeiaPiece;
import ex1.MilleniumPiece;
import ex1.Piece;
import ex1.Pion;
import ex1.Player;
import ex1.StormPiece;
import ex1.TableParts;
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
import javax.swing.JOptionPane;

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
    int round=0;
    public static int cont = 0;
    
    private GridPane Cemitery(){ //GENERATION OF THE CEMETERY
        /*
        NÃO FOI UTILIZADO/IMPLEMENTADO O CEMITÉRIO NO XADREZ
        */
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
    
    private void setMoveStatus(){ //GAMES ALTERNATION + SKILL COUNTER
        if(round%2==0){
            player1.moveStatus(true);
            player2.moveStatus(false);
        }else{
            player1.moveStatus(false);
            player2.moveStatus(true);
        }
        if(round%8==0 && cont<1){
            cont++;
        }
    }
    
    private void makeCemitery(){//MAKE THE CEMETERY
        /*
        NÃO FOI UTILIZADO/IMPLEMENTADO O CEMITÉRIO NO XADREZ
        */
        cemitery_left = Cemitery();
        cemitery_right = Cemitery();
        bpMain.setLeft(cemitery_left);
        bpMain.setRight(cemitery_right);
        
    }
    
    private void setPlayer(){ //CREATION OF TIME
        player1 = new Player("m",0);
        player2 = new Player("c",1);
    
    }
    
    public void setTable() throws FileNotFoundException{ //MAKE THE TABLE
        setPlayer();
        makeTable();
        setMoveStatus();        
        makeCemitery();
        
    }
    
    private void Round(){ //DID ROUND FOR PLAYER
        player1.setRoundGame(round);
        player2.setRoundGame(round);
    }
    
    private void makeTable() throws FileNotFoundException { //MAKE TABLE
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
    
    private void Move(){ //MAIN MOVEMENT METHOD
        System.out.println("Move.");
        initPositionX =  actualPiece.getTableParts().getLocationX();
        initPositionY =  actualPiece.getTableParts().getLocationY();
        finalPositionX = tclicked.getLocationX();
        finalPositionY = tclicked.getLocationY();
        System.out.println("("+finalPositionX+","+ finalPositionY+")");
        System.out.println("("+actualPiece.getTableParts().getLocationX()+","+ actualPiece.getTableParts().getLocationY());
        System.out.println("Move.");
        boolean t = actualPiece.getMove_status();
        if(actualPiece.getMove_status() ==true && actualPiece.movePiece(gridTab,table, finalPositionX, finalPositionY) ){
            System.out.println("("+actualPiece.getTableParts().getLocationX()+","+ actualPiece.getTableParts().getLocationY());
            System.out.println("Movimento Aceito.");
            round++;
            Round();
            setMoveStatus();
            CheckMove();
            Check();
        }else JOptionPane.showMessageDialog(null,"Movimetno invaldido.");
        reset();
    }    
    
    private void reset(){
        tclicked     = null;
        attackedPiece= null;
        actualPiece  = null;
    }
    
    private void Check(){ //CHECK THE WINNER
        if(player1.getPiece().isEmpty()){
            JOptionPane.showMessageDialog(null,"Jogador 2 Venceu! O imperio ganhou!");
        }else if(player2.getPiece().isEmpty()){
            JOptionPane.showMessageDialog(null,"Jogador 1 Venceu! A aliança venceu!");
        }
    }
    
    private void CheckMove(){ //CHECK THE MOVEMENT
        if(attackedPiece!=null && attackedPiece.getTeam()==0)player1.getPiece().remove(attackedPiece);
        if(attackedPiece!=null && attackedPiece.getTeam()==2)player2.getPiece().remove(attackedPiece);
    }
    
    private void Attack(){ //MAIS ATTACK METHOD
        System.out.println("Attack!"); 
        finalPositionX = attackedPiece.getTableParts().getLocationX();
        finalPositionY = attackedPiece.getTableParts().getLocationY();
        if(actualPiece.getMove_status() ==true && actualPiece.attackMove(gridTab,table,finalPositionX , finalPositionY)){
            table[finalPositionX][finalPositionY].setPiece(null);
            gridTab.getChildren().remove(attackedPiece);
            System.out.println("Attack realizado!"); 
            round++;
            Round();
            setMoveStatus();
            CheckMove();
            Check();
            cont--;
       }else JOptionPane.showMessageDialog(null,"Ataque invalido.");    
       reset();
    }
    
    private void addEventesToTable(TableParts t1){ //ADD EVENTS TO OBJECTS TABLE PARTS
        EventHandler<javafx.scene.input.MouseEvent> eventHandler; 
        eventHandler = new EventHandler<javafx.scene.input.MouseEvent>() { 
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
                }                
            }
        };
        t1.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandler);
    }
    
    private void addEventesToPiece(Piece p){ //ADD EVENTS TO PART
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
                }
            }
        };
        p.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandlerPiece);
    }
    
    private  void addPieces() throws FileNotFoundException{ //DECLARATION OF METHODS TO ADD PARTS
        addMilleniumFalcon();
        addLeiaPiece();
        addStormPiece();
        addHorse();
        addDarthPiece();
        addHanPiece();
        addChewPiece();
        addPion();
    }
    
    private void addDarthPiece() throws FileNotFoundException{
        
    /*
    -------------------------------------- GENERATION DARTH PIECE ------------------------------------
    */
        DarthPiece dv = new DarthPiece("images/Darth_Vader.jpeg", table[4][12], 1);
        gridTab.add(dv, 4, 12);
        table[4][12].setPiece(dv);
        addEventesToPiece(dv);
        player2.getPiece().add(dv);
        
        DarthPiece dv2 = new DarthPiece("images/Darth_Vader.jpeg", table[9][12], 1);
        gridTab.add(dv2, 9, 12);
        table[9][12].setPiece(dv2);
        addEventesToPiece(dv2);
        player2.getPiece().add(dv2);
        
        DarthPiece dv3 = new DarthPiece("images/Darth_Vader.jpeg", table[2][13], 1);
        gridTab.add(dv3, 2, 13);
        table[2][13].setPiece(dv3);
        addEventesToPiece(dv3);
        player2.getPiece().add(dv3);
        
        DarthPiece dv4 = new DarthPiece("images/Darth_Vader.jpeg", table[11][13], 1);
        gridTab.add(dv4, 11, 13);
        table[11][13].setPiece(dv4);
        addEventesToPiece(dv4);
        player2.getPiece().add(dv4);
        
        DarthPiece dv5 = new DarthPiece("images/Darth_Vader.jpeg", table[6][11], 1);
        gridTab.add(dv5, 6, 11);
        table[6][11].setPiece(dv5);
        addEventesToPiece(dv5);
        player2.getPiece().add(dv5);
        
        DarthPiece dv6 = new DarthPiece("images/Darth_Vader.jpeg", table[7][11], 1);
        gridTab.add(dv6, 7, 11);
        table[7][11].setPiece(dv6);
        addEventesToPiece(dv6);
        player2.getPiece().add(dv6);

        DarthPiece Y = new DarthPiece("images/Yoda.jpeg", table[4][1], 0);
        gridTab.add(Y, 4, 1);
        table[4][1].setPiece(Y);
        addEventesToPiece(Y);
        player1.getPiece().add(Y);
        
        DarthPiece Y2 = new DarthPiece("images/Yoda.jpeg", table[9][1], 0);
        gridTab.add(Y2, 9, 1);
        table[9][1].setPiece(Y2);
        addEventesToPiece(Y2);
        player1.getPiece().add(Y2);
        
        DarthPiece Y3 = new DarthPiece("images/Yoda.jpeg", table[2][0], 0);
        gridTab.add(Y3, 2, 0);
        table[2][0].setPiece(Y3);
        addEventesToPiece(Y3);
        player1.getPiece().add(Y3);
        
        DarthPiece Y4 = new DarthPiece("images/Yoda.jpeg", table[11][0], 0);
        gridTab.add(Y4, 11, 0);
        table[11][0].setPiece(Y4);
        addEventesToPiece(Y4);
        player1.getPiece().add(Y4);
        
        DarthPiece Y5 = new DarthPiece("images/Yoda.jpeg", table[6][2], 0);
        gridTab.add(Y5, 6, 2);
        table[6][2].setPiece(Y5);
        addEventesToPiece(Y5);
        player1.getPiece().add(Y5);
        
        DarthPiece Y6 = new DarthPiece("images/Yoda.jpeg", table[7][2], 0);
        gridTab.add(Y6, 7, 2);
        table[7][2].setPiece(Y6);
        addEventesToPiece(Y6);
        player1.getPiece().add(Y6);
    }
        
    /*
    -------------------------------------- GENERATION CHEW PIECE ------------------------------------
    */
    private void  addChewPiece() throws FileNotFoundException{
        ChewPiece c = new ChewPiece("images/Chewbacca.png", table[2][2], 0);
        gridTab.add(c, 2, 2);
        table[2][2].setPiece(c);
        addEventesToPiece(c);
        player1.getPiece().add(c);
                
        ChewPiece c1 = new ChewPiece("images/Chewbacca.png", table[3][2], 0);
        gridTab.add(c1, 3, 2);
        table[3][2].setPiece(c1);
        addEventesToPiece(c1);
        player1.getPiece().add(c1);
        
        ChewPiece c2 = new ChewPiece("images/Chewbacca.png", table[4][2], 0);
        gridTab.add(c2, 4, 2);
        table[4][2].setPiece(c2);
        addEventesToPiece(c2);
        player1.getPiece().add(c2);
                
        ChewPiece c3 = new ChewPiece("images/Chewbacca.png", table[9][2], 0);
        gridTab.add(c3, 9, 2);
        table[9][2].setPiece(c3);
        addEventesToPiece(c3);
        player1.getPiece().add(c3);
        
        ChewPiece c4 = new ChewPiece("images/Chewbacca.png", table[10][2], 0);
        gridTab.add(c4, 10, 2);
        table[2][2].setPiece(c4);
        addEventesToPiece(c4);
        player1.getPiece().add(c4);
        ChewPiece c5 = new ChewPiece("images/Chewbacca.png", table[11][2], 0);
        gridTab.add(c5, 11, 2);
        table[11][2].setPiece(c5);
        addEventesToPiece(c5);
        player1.getPiece().add(c);
        
        ChewPiece c6 = new ChewPiece("images/jarjar.jpeg", table[2][11], 1);
        gridTab.add(c6, 2, 11);
        table[2][11].setPiece(c6);
        addEventesToPiece(c6);
        player2.getPiece().add(c6);
                
        ChewPiece c7 = new ChewPiece("images/jarjar.jpeg", table[3][11], 1);
        gridTab.add(c7, 3, 11);
        table[3][11].setPiece(c7);
        addEventesToPiece(c7);
        player2.getPiece().add(c7);
        
        ChewPiece c8 = new ChewPiece("images/jarjar.jpeg", table[4][11], 1);
        gridTab.add(c8, 4, 11);
        table[4][11].setPiece(c8);
        addEventesToPiece(c8);
        player2.getPiece().add(c8);
                
        ChewPiece c9 = new ChewPiece("images/jarjar.jpeg", table[9][11], 1);
        gridTab.add(c9, 9, 11);
        table[9][11].setPiece(c9);
        addEventesToPiece(c9);
        player1.getPiece().add(c9);
        
        ChewPiece c10 = new ChewPiece("images/jarjar.jpeg", table[10][11], 1);
        gridTab.add(c10, 10, 11);
        table[10][11].setPiece(c10);
        addEventesToPiece(c10);
        player1.getPiece().add(c10);
        
        ChewPiece c11 = new ChewPiece("images/jarjar.jpeg", table[11][11], 1);
        gridTab.add(c11, 11, 11);
        table[11][11].setPiece(c11);
        addEventesToPiece(c11);
        player1.getPiece().add(c);
    }
    
    /*
    -------------------------------------- GENERATION MILLENIUM FALCON PIECE ------------------------------------
    */
    private void addMilleniumFalcon() throws FileNotFoundException{
        MilleniumPiece m = new MilleniumPiece("images/Millenium.jpeg", table[2][1], 0);
        gridTab.add(m, 2, 1);
        table[2][1].setPiece(m);
        addEventesToPiece(m);
        player1.getPiece().add(m);
        
        MilleniumPiece m2 = new MilleniumPiece("images/Millenium.jpeg", table[3][1], 0);
        gridTab.add(m2, 3, 1);
        table[3][1].setPiece(m2);
        addEventesToPiece(m2);
        player1.getPiece().add(m2);
        
        MilleniumPiece m3 = new MilleniumPiece("images/Millenium.jpeg", table[10][1], 0);
        gridTab.add(m3, 10, 1);
        table[10][1].setPiece(m3);
        addEventesToPiece(m3);
        player1.getPiece().add(m3);
        
        MilleniumPiece m4 = new MilleniumPiece("images/Millenium.jpeg", table[11][1], 0);
        gridTab.add(m4, 11, 1);
        table[11][1].setPiece(m4);
        addEventesToPiece(m4);
        player1.getPiece().add(m4);
        
        MilleniumPiece N = new MilleniumPiece("images/NaveImperial.jpeg", table[2][12], 1);
        gridTab.add(N, 2, 12);
        table[2][12].setPiece(N);
        addEventesToPiece(N);
        player2.getPiece().add(N);
        
        MilleniumPiece N2 = new MilleniumPiece("images/NaveImperial.jpeg", table[3][12], 1);
        gridTab.add(N2, 3, 12);
        table[3][12].setPiece(N2);
        addEventesToPiece(N2);
        player2.getPiece().add(N2);
        
        MilleniumPiece N3 = new MilleniumPiece("images/NaveImperial.jpeg", table[10][12], 1);
        gridTab.add(N3, 10, 12);
        table[10][12].setPiece(N3);
        addEventesToPiece(N3);
        player2.getPiece().add(N3);
        
        MilleniumPiece N4 = new MilleniumPiece("images/NaveImperial.jpeg", table[11][12], 1);
        gridTab.add(N4, 11, 12);
        table[11][12].setPiece(N4);
        addEventesToPiece(N4);
        player2.getPiece().add(N4);
    }
        
    /*
    -------------------------------------- GENERATION PION PIECE ------------------------------------
    */
    private void addPion() throws FileNotFoundException{
        Pion Pi = new Pion("images/R2D2.jpeg", table[0][0], 0);
        gridTab.add(Pi, 0, 0);
        table[0][0].setPiece(Pi);
        addEventesToPiece(Pi);
        player1.getPiece().add(Pi);
        
        
        Pion Pi2 = new Pion("images/R2D2.jpeg", table[13][0], 0);
        gridTab.add(Pi2, 13, 0);
        table[13][0].setPiece(Pi2);
        addEventesToPiece(Pi2);
        player1.getPiece().add(Pi2);
        
        Pion Pi3 = new Pion("images/R2D2.jpeg", table[1][0], 0);
        gridTab.add(Pi3, 1, 0);
        table[1][0].setPiece(Pi3);
        addEventesToPiece(Pi3);
        player1.getPiece().add(Pi3);
        
        Pion Pi4 = new Pion("images/R2D2.jpeg", table[12][0], 0);
        gridTab.add(Pi4, 12, 0);
        table[12][0].setPiece(Pi4);
        addEventesToPiece(Pi4);
        player1.getPiece().add(Pi4);
        
        Pion D = new Pion("images/Droid.jpeg", table[0][13], 1);
        gridTab.add(D, 0, 13);
        table[0][13].setPiece(D);
        addEventesToPiece(D);
        player2.getPiece().add(D);
        
        Pion D2 = new Pion("images/Droid.jpeg", table[13][13], 1);
        gridTab.add(D2, 13, 13);
        table[13][13].setPiece(D2);
        addEventesToPiece(D2);
        player2.getPiece().add(D2);
        
        Pion D3 = new Pion("images/Droid.jpeg", table[1][13], 1);
        gridTab.add(D3, 1, 13);
        table[1][13].setPiece(D3);
        addEventesToPiece(D3);
        player2.getPiece().add(D3);
        
        Pion D4 = new Pion("images/Droid.jpeg", table[12][13], 1);
        gridTab.add(D4, 12, 13);
        table[12][13].setPiece(D4);
        addEventesToPiece(D4);
        player2.getPiece().add(D4);
    }
        
    /*
    -------------------------------------- GENERATION HORSE PIECE ------------------------------------
    */
    private void addHorse() throws FileNotFoundException{
        HorsePiece H = new HorsePiece("images/POD1.jpeg", table[1][1], 0);
        gridTab.add(H, 1, 1);
        table[1][1].setPiece(H);
        addEventesToPiece(H);
        player1.getPiece().add(H);
        
        HorsePiece H2 = new HorsePiece("images/POD1.jpeg", table[0][1], 0);
        gridTab.add(H2, 0, 1);
        table[0][1].setPiece(H2);
        addEventesToPiece(H2);
        player1.getPiece().add(H2);
        
        HorsePiece H3 = new HorsePiece("images/POD1.jpeg", table[13][1], 0);
        gridTab.add(H3, 13, 1);
        table[13][1].setPiece(H3);
        addEventesToPiece(H3);
        player1.getPiece().add(H3);
        
        HorsePiece H4 = new HorsePiece("images/POD1.jpeg", table[12][1], 0);
        gridTab.add(H4, 12, 1);
        table[12][1].setPiece(H4);
        addEventesToPiece(H4);
        player1.getPiece().add(H4);
        
        HorsePiece H5 = new HorsePiece("images/POD1.jpeg", table[13][2], 0);
        gridTab.add(H5, 13, 2);
        table[13][2].setPiece(H5);
        addEventesToPiece(H5);
        player1.getPiece().add(H5);
        
        HorsePiece H6 = new HorsePiece("images/POD1.jpeg", table[0][2], 0);
        gridTab.add(H6, 0, 2);
        table[0][2].setPiece(H6);
        addEventesToPiece(H6);
        player1.getPiece().add(H6);
        
        HorsePiece H7 = new HorsePiece("images/POD2.jpeg", table[1][12], 1);
        gridTab.add(H7, 1, 12);
        table[1][12].setPiece(H7);
        addEventesToPiece(H7);
        player2.getPiece().add(H7);
        
        HorsePiece H8 = new HorsePiece("images/POD2.jpeg", table[0][12], 1);
        gridTab.add(H8, 0, 12);
        table[0][12].setPiece(H8);
        addEventesToPiece(H8);
        player2.getPiece().add(H8);
        
        HorsePiece H9 = new HorsePiece("images/POD2.jpeg", table[13][12], 1);
        gridTab.add(H9, 13, 12);
        table[13][12].setPiece(H9);
        addEventesToPiece(H9);
        player2.getPiece().add(H9);
        
        HorsePiece H10 = new HorsePiece("images/POD2.jpeg", table[12][12], 1);
        gridTab.add(H10, 12, 12);
        table[12][12].setPiece(H10);
        addEventesToPiece(H10);
        player2.getPiece().add(H10);
        
        HorsePiece H11 = new HorsePiece("images/POD2.jpeg", table[13][11], 1);
        gridTab.add(H11, 13, 11);
        table[13][11].setPiece(H11);
        addEventesToPiece(H11);
        player2.getPiece().add(H11);
        
        HorsePiece H12 = new HorsePiece("images/POD2.jpeg", table[0][11], 1);
        gridTab.add(H12, 0, 11);
        table[0][11].setPiece(H12);
        addEventesToPiece(H12);
        player2.getPiece().add(H12);
        
        HorsePiece H13 = new HorsePiece("images/POD2.jpeg", table[1][11], 1);
        gridTab.add(H13, 1, 11);
        table[1][11].setPiece(H13);
        addEventesToPiece(H13);
        player2.getPiece().add(H13);
        
        HorsePiece H14 = new HorsePiece("images/POD2.jpeg", table[12][11], 1);
        gridTab.add(H14, 12, 11);
        table[12][11].setPiece(H14);
        addEventesToPiece(H14);
        player2.getPiece().add(H14);
        
        HorsePiece H15 = new HorsePiece("images/POD1.jpeg", table[1][2], 0);
        gridTab.add(H15, 1, 2);
        table[1][2].setPiece(H15);
        addEventesToPiece(H15);
        player1.getPiece().add(H15);
        
        HorsePiece H16 = new HorsePiece("images/POD1.jpeg", table[12][2], 0);
        gridTab.add(H16, 12, 2);
        table[12][2].setPiece(H16);
        addEventesToPiece(H16);
        player1.getPiece().add(H16);
    }
        
    /*
    -------------------------------------- GENERATION LEIA PIECE ------------------------------------
    */
    private void addLeiaPiece() throws FileNotFoundException{
        LeiaPiece L = new LeiaPiece("images/Leia.png", table[4][0], 0);
        gridTab.add(L, 4, 0);
        table[4][0].setPiece(L);
        addEventesToPiece(L);
        player1.getPiece().add(L);
        
        LeiaPiece L2 = new LeiaPiece("images/Leia.png", table[6][0], 0);
        gridTab.add(L2, 6, 0);
        table[6][0].setPiece(L2);
        addEventesToPiece(L2);
        player1.getPiece().add(L2);
        
        LeiaPiece L3 = new LeiaPiece("images/Leia.png", table[7][0], 0);
        gridTab.add(L3, 7, 0);
        table[7][0].setPiece(L3);
        addEventesToPiece(L3);
        player1.getPiece().add(L3);
        
        LeiaPiece L4 = new LeiaPiece("images/Leia.png", table[9][0], 0);
        gridTab.add(L4, 9, 0);
        table[9][0].setPiece(L4);
        addEventesToPiece(L4);
        player1.getPiece().add(L4);
        
        LeiaPiece L5 = new LeiaPiece("images/Leia.png", table[5][2], 0);
        gridTab.add(L5, 5, 2);
        table[5][2].setPiece(L5);
        addEventesToPiece(L5);
        player1.getPiece().add(L5);
        
        LeiaPiece L6 = new LeiaPiece("images/Leia.png", table[8][2], 0);
        gridTab.add(L6, 8, 2);
        table[8][2].setPiece(L6);
        addEventesToPiece(L6);
        player1.getPiece().add(L6);
        
        LeiaPiece J = new LeiaPiece("images/jabba.jpeg", table[4][13], 1);
        gridTab.add(J, 4, 13);
        table[4][13].setPiece(J);
        addEventesToPiece(J);
        player2.getPiece().add(J);
        
        LeiaPiece J2 = new LeiaPiece("images/jabba.jpeg", table[6][13], 1);
        gridTab.add(J2, 6, 13);
        table[6][13].setPiece(J2);
        addEventesToPiece(J2);
        player2.getPiece().add(J2);
        
        LeiaPiece J3 = new LeiaPiece("images/jabba.jpeg", table[7][13], 1);
        gridTab.add(J3, 7, 13);
        table[7][13].setPiece(J3);
        addEventesToPiece(J3);
        player2.getPiece().add(J3);
        
        LeiaPiece J4 = new LeiaPiece("images/jabba.jpeg", table[9][13], 1);
        gridTab.add(J4, 9, 13);
        table[9][13].setPiece(J4);
        addEventesToPiece(J4);
        player2.getPiece().add(J4);
        
        LeiaPiece J5 = new LeiaPiece("images/jabba.jpeg", table[5][11], 1);
        gridTab.add(J5, 5, 11);
        table[5][11].setPiece(J5);
        addEventesToPiece(J5);
        player2.getPiece().add(J5);
        
        LeiaPiece J6 = new LeiaPiece("images/jabba.jpeg", table[8][11], 1);
        gridTab.add(J6, 8, 11);
        table[8][11].setPiece(J6);
        addEventesToPiece(J6);
        player2.getPiece().add(J6);
   }
        
    /*
    -------------------------------------- GENERATION STORM PIECE ------------------------------------
    */
    private void addStormPiece() throws FileNotFoundException{ // Generation StormPice
       StormPiece sP = new StormPiece("images/Stormtrooper.png", table[5][12], 1);
       gridTab.add(sP, 5, 12);
       table[5][12].setPiece(sP);
       addEventesToPiece(sP);
       player2.getPiece().add(sP);
       
       StormPiece sP2 = new StormPiece("images/Stormtrooper.png", table[6][12], 1);
       gridTab.add(sP2, 6, 12);
       table[6][12].setPiece(sP2);
       addEventesToPiece(sP2);
       player2.getPiece().add(sP2);
       
       StormPiece sP3 = new StormPiece("images/Stormtrooper.png", table[7][12], 1);
       gridTab.add(sP3, 7, 12);
       table[7][12].setPiece(sP3);
       addEventesToPiece(sP3);
       player2.getPiece().add(sP3);
       
       StormPiece sP4 = new StormPiece("images/Stormtrooper.png", table[8][12], 1);
       gridTab.add(sP4, 8, 12);
       table[8][12].setPiece(sP4);
       addEventesToPiece(sP4);
       player2.getPiece().add(sP4);
       
       StormPiece rP4 = new StormPiece("images/rebel.png", table[5][1], 0);
       gridTab.add(rP4, 5, 1);
       table[5][1].setPiece(rP4);
       player1.getPiece().add(rP4);
       
       StormPiece rP3 = new StormPiece("images/rebel.png", table[6][1], 0);
       gridTab.add(rP3, 6, 1);
       table[6][1].setPiece(rP3);
       addEventesToPiece(rP3);
       player1.getPiece().add(rP3);
       
       StormPiece rP = new StormPiece("images/rebel.png", table[7][1], 0);
       gridTab.add(rP, 7, 1);
       table[7][1].setPiece(rP);
       addEventesToPiece(rP);
       player1.getPiece().add(rP);
       
       StormPiece rP2 = new StormPiece("images/rebel.png", table[8][1], 0);
       gridTab.add(rP2, 8, 1);
       table[8][1].setPiece(rP2);
       addEventesToPiece(rP2);
       player1.getPiece().add(rP);
    }  
        
    /*
    -------------------------------------- GENERATION HAN PIECE ------------------------------------
    */
    private void addHanPiece() throws FileNotFoundException{
        HanPiece m = new HanPiece("images/han_solo.jpeg", table[3][0], 0);
        gridTab.add(m, 3, 0);
        table[3][0].setPiece(m);
        addEventesToPiece(m);
        player1.getPiece().add(m);
        
        HanPiece m2 = new HanPiece("images/han_solo.jpeg", table[10][0], 0);
        gridTab.add(m2, 10, 0);
        table[10][0].setPiece(m2);
        addEventesToPiece(m2);
        player1.getPiece().add(m2);
        
        HanPiece m3 = new HanPiece("images/han_solo.jpeg", table[5][0], 0);
        gridTab.add(m3, 5, 0);
        table[5][0].setPiece(m3);
        addEventesToPiece(m3);
        player1.getPiece().add(m3);
        
        HanPiece m4 = new HanPiece("images/han_solo.jpeg", table[8][0], 0);
        gridTab.add(m4, 8, 0);
        table[8][0].setPiece(m4);
        addEventesToPiece(m4);
        player1.getPiece().add(m4);
        
        HanPiece Lan = new HanPiece("images/Lando.jpeg", table[3][13], 1);
        gridTab.add(Lan, 3, 13);
        table[3][13].setPiece(Lan);
        addEventesToPiece(Lan);
        player2.getPiece().add(Lan);
        
        HanPiece Lan2 = new HanPiece("images/Lando.jpeg", table[10][13], 1);
        gridTab.add(Lan2, 10, 13);
        table[10][13].setPiece(Lan2);
        addEventesToPiece(Lan2);
        player2.getPiece().add(Lan2);
        
        HanPiece Lan3 = new HanPiece("images/Lando.jpeg", table[5][13], 1);
        gridTab.add(Lan3, 5, 13);
        table[5][13].setPiece(Lan3);
        addEventesToPiece(Lan3);
        player2.getPiece().add(Lan3);
        
        HanPiece Lan4 = new HanPiece("images/Lando.jpeg", table[8][13], 1);
        gridTab.add(Lan4, 8, 13);
        table[8][13].setPiece(Lan4);
        addEventesToPiece(Lan4);
        player2.getPiece().add(Lan4);
    }
}