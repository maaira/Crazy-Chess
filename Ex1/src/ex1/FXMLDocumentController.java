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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Pedro Felipe
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    Parent root;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Table.fxml"));
            root = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);            
            stage.setTitle("Table");
            stage.setScene(new Scene(root, 50*14, 50*14));

            TableController controller = fxmlLoader.<TableController>getController();
            controller.montarGrid();
           

            stage.show();
            // Esconde a janela atual
            
                   
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
