/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Pedro Felipe
 */
public class FXMLDocumentController implements Initializable {
    @FXML private TextField txtuser1;
    @FXML private TextField txtuser2;

    private Label label;
    Parent root;
    String nome1, nome2;
    
    private boolean user(){
        nome1 = "Maíra";
        nome2 = "Marcus";      
        nome1 = txtuser1.getText();
        nome2 = txtuser2.getText();
        System.out.println(nome1);
        System.out.println(nome2);
        return true;
    }
    
    private void Message(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Player");
        alert.setHeaderText("Enter the players names!");
       
    }
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        try {
            user();
            if(nome1!=null || nome2!=null){
                //System.out.println(nome1);
                //System.out.println(nome2);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Table.fxml"));
                root = (Parent)fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                //stage.initStyle(StageStyle.UNDECORATED);           
                stage.setTitle("Table");          
                stage.setScene(new Scene(root, 50*20, 50*14));            
                TableController controller = fxmlLoader.<TableController>getController();            
                controller.setTable();
                stage.show();
            }
            
            
            
            
            
            
                   
        }
        catch (IOException e) {
            e.printStackTrace();
            label.setText("Erro ao chamar a Table!" + e.getMessage());
        }
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
}