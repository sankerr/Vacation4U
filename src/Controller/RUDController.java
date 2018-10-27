package Controller;

import Model.IModel;
import Model.Model;
import View.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Observer;
import java.util.ResourceBundle;

public class RUDController implements Observer{

    private IModel model;
    private String user_name;
    private ReadController readController;
    private UpdateController updateController;

    /*
    // buttons
    public Button btn_delete;
    public Button btn_edit;
    public Button btn_search;
    public Button btn_about;
*/

    public void EditProfile(ActionEvent actionEvent) {
        try {
            //openning new Stage to show in
            Stage stage = new Stage();
            stage.setTitle("Edit Profile");
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("/View/Update.fxml").openStream());
            root.setStyle("-fx-background-color: white");
            Scene scene = new Scene(root, 600, 500);
            stage.setScene(scene);

            //loading the controllers of the new stage:
            UpdateController updateController = fxmlLoader.getController();
            this.updateController = updateController;
            updateController.setModel(model);
            ((Model)model).addObserver(updateController);
            updateController.setStage(stage);

            stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SearchFunction() {
        try {
            //openning new Stage to show in
            Stage stage = new Stage();
            stage.setTitle("Search");
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("/View/Read.fxml").openStream());
            root.setStyle("-fx-background-color: white");
            Scene scene = new Scene(root, 500, 180);
            stage.setScene(scene);

            //loading the controllers of the new stage:
            ReadController readController = fxmlLoader.getController();
            this.readController = readController;
            readController.setModel(model);
            ((Model)model).addObserver(readController);
            readController.setStage(stage);

            stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void DeleteUser(ActionEvent actionEvent) {
    }



    @Override
    public void update(java.util.Observable o, Object arg) {

    }

    public void setModel(IModel model) { this.model = model; }

    public void setUser_name(String user_name){ this.user_name = user_name; }
}
