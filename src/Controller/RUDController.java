package Controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RUDController {
/*
    // buttons
    public Button btn_delete;
    public Button btn_edit;
    public Button btn_search;
    public Button btn_about;
*/

    public void EditProfile(ActionEvent actionEvent) {
    }

    public void SearchFunction(ActionEvent actionEvent) {
        try {
            //openning new Stage to show in
            Stage stage = new Stage();
            stage.setTitle("Search User");
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("Read.fxml").openStream());
            Scene scene = new Scene(root, 600, 650);
            stage.setScene(scene);

            //loading the controllers of the new stage:
            ReadController read = fxmlLoader.getController();
            //setGameController(game);
            //read.setAll(stage, this);

            stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void DeleteUser(ActionEvent actionEvent) {
    }
}
