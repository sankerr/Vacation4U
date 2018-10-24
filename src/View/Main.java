package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import Controller.IController;

public class Main extends Application implements Initializable {

    private IController controller;

    // images
    public ImageView img_logo;
    // buttons
    public Button btn_login;
    public Button btn_sign_up;
    // text fields
    public TextField txt_id_user;
    public TextField txt_id_password;
    public TextField txt_user_first_name;
    public TextField txt_user_last_name;
    public TextField txt_new_username;
    public TextField txt_user_city;
    public TextField txt_new_user_password;
    // date picker
    public DatePicker date_picker;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Vication4U");
        primaryStage.setScene(new Scene(root, 600, 450));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void initialize(URL location, ResourceBundle resources) {
        setImage(img_logo,"Resources/logo.jpeg");
        btn_sign_up.setDisable(true);
    }
    //login button function
    public void login () {

    }

    //sign up button function
    public void signUp () {

    }


    // this function will set the logo when app starts
    public void setImage(ImageView imageView, String filePath) {
        File file = new File(filePath);
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }

}