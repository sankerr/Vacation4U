package Controller;

import Model.IModel;
import Model.Model;
import View.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class RUDController implements Observer{

    private IModel model;
    private String user_name;
    private ReadController readController;
    private UpdateController updateController;
    private Controller controller;

    public javafx.scene.control.MenuBar menu;
    public javafx.scene.image.ImageView iv_about;


    public void setModel(IModel model) { this.model = model; }

    public void setAbout(){
        try {
            Image logo = new Image(Controller.class.getClassLoader().getResourceAsStream("about_company.jpg"));
            iv_about.setImage(logo);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUser_name(String user_name){ this.user_name = user_name; }

    public void setController(Controller controller){ this.controller = controller; }

    public void EditProfile() {
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
            if(updateController == null){
                updateController = fxmlLoader.getController();
                ((Model)model).addObserver(updateController);
            }
            else {
                ((Model)model).deleteObserver(updateController);
                updateController = fxmlLoader.getController();
                ((Model)model).addObserver(updateController);
            }
            updateController.setModel(model);
            updateController.setLogo();
            updateController.setUser_name(user_name);

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
            if(readController == null){
                readController = fxmlLoader.getController();
                ((Model)model).addObserver(readController);
            }
            else {
                ((Model)model).deleteObserver(readController);
                readController = fxmlLoader.getController();
                ((Model)model).addObserver(readController);
            }
            readController.setModel(model);

            stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {

        }
    }

    public void DeleteUser() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure you want to delete your user?");
        ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("No, Sorry", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(yesButton,noButton);

        //checking what the player choose
        alert.showAndWait().ifPresent((buttonType) -> {
            if(buttonType == yesButton){
                model.deleteUser(user_name);
                Stage prim = (Stage) menu.getScene().getWindow();
                prim.close();
            } });

    }

    public void sign_out(){
        Stage prim = (Stage) menu.getScene().getWindow();
        prim.close();
        openMainView();
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            Object obj = ((Object[])arg)[0];
            String str = (String)obj;
            if(str.equals("user deleted")) {
                Stage prim = (Stage) menu.getScene().getWindow();
                prim.close();
                openMainView();
            }
        } catch (Exception e) {

        }
    }

    private void openMainView(){
        try {
            Stage stage = new Stage();
            stage.setTitle("Vication4U");
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("/View/sample.fxml").openStream());
            Scene scene = new Scene(root, 600, 450);
            stage.setScene(scene);
            root.setStyle("-fx-background-color: white");
            stage.setResizable(false);
            //-------
            if(controller == null){
                controller = fxmlLoader.getController();
                ((Model)model).addObserver(controller);
            }
            else {
                ((Model)model).deleteObserver(controller);
                controller = fxmlLoader.getController();
                ((Model)model).addObserver(controller);
            }
            controller.setModel(model);
            controller.setLogo();
            stage.show();
        } catch (IOException e) {

        }
    }

}
