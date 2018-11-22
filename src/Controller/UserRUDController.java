package Controller;

import Model.IModel;
import Model.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class UserRUDController implements Observer{

    private IModel model;
    private UserReadController userReadController;
    private UserUpdateController userUpdateController;
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

    public void setUser_name(String user_name){ model.setUser_name(user_name); }

    public void setController(Controller controller){ this.controller = controller; }

    public void EditProfile() {
        try {
            //openning new Stage to show in
            Stage stage = new Stage();
            stage.setTitle("Edit Profile");
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("/View/UserUpdate.fxml").openStream());
            root.setStyle("-fx-background-color: white");
            Scene scene = new Scene(root, 600, 500);
            stage.setScene(scene);

            //loading the controllers of the new stage:
            if(userUpdateController == null){
                userUpdateController = fxmlLoader.getController();
                ((Model)model).addObserver(userUpdateController);
            }
            else {
                ((Model)model).deleteObserver(userUpdateController);
                userUpdateController = fxmlLoader.getController();
                ((Model)model).addObserver(userUpdateController);
            }
            userUpdateController.setModel(model);
            userUpdateController.setLogo();

            //call the function that shows the details of the user
            userUpdateController.searchUser(model.getUser_name());

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
            Parent root = fxmlLoader.load(getClass().getResource("/View/UserRead.fxml").openStream());
            root.setStyle("-fx-background-color: white");
            Scene scene = new Scene(root, 500, 180);
            stage.setScene(scene);

            //loading the controllers of the new stage:
            if(userReadController == null){
                userReadController = fxmlLoader.getController();
                ((Model)model).addObserver(userReadController);
            }
            else {
                ((Model)model).deleteObserver(userReadController);
                userReadController = fxmlLoader.getController();
                ((Model)model).addObserver(userReadController);
            }
            userReadController.setModel(model);

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
                model.deleteUser(model.getUser_name());
            } });

    }

    public void sign_out(){
        if(userReadController != null)
            ((Model)model).deleteObserver(userReadController);
        if(userUpdateController != null)
            ((Model)model).deleteObserver(userUpdateController);
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
                sign_out();
            }
        } catch (Exception e) {

        }
    }

    private void openMainView(){
        try {
            Stage stage = new Stage();
            stage.setTitle("Vacation4U");
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
            controller.setRUDController(this);
            controller.setLogo();
            stage.show();
        } catch (IOException e) {

        }
    }

}
