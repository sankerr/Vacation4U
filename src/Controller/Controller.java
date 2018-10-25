package Controller;

import Model.IModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

public class Controller implements IController, Observer {

    public IModel iModel;

    // buttons
    public javafx.scene.control.Button btn_login;
    public javafx.scene.control.Button btn_sign_up;
    // text fields
    public javafx.scene.control.TextField txt_id_user;
    public javafx.scene.control.TextField txt_id_password;
    public javafx.scene.control.TextField txt_user_first_name;
    public javafx.scene.control.TextField txt_user_last_name;
    public javafx.scene.control.TextField txt_new_username;
    public javafx.scene.control.TextField txt_user_city;
    public javafx.scene.control.TextField txt_new_user_password;
    // date picker
    public javafx.scene.control.DatePicker date_picker;

    //login button function
    public void login () {
        //iModel.login(txt_id_user.getText(), txt_id_password.getText());


        try {
            //openning new Stage to show in
            Stage stage = new Stage();
            stage.setTitle("RUD");
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("Rud.fxml").openStream());
            Scene scene = new Scene(root, 400, 400);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //sign up button function
    public void signUp () {


    }

    public void update(Observable o, Object arg) {

        switch((String)arg){

            case "login failed":
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Login failed");
                Optional<ButtonType> reasult = alert.showAndWait();
                if(reasult.get() == ButtonType.OK)
                    alert.close();
        }
    }
}
