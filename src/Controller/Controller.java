package Controller;

import Model.IModel;
import Model.Model;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.time.format.DateTimeFormatter;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

public class Controller implements IController, Observer {

    public IModel model;

    // buttons
    public javafx.scene.control.Button btn_login;
    public javafx.scene.control.Button btn_sign_up;
    // text fields
    public javafx.scene.control.TextField txt_id_user;
    public javafx.scene.control.PasswordField txt_id_password;
    public javafx.scene.control.TextField txt_user_first_name;
    public javafx.scene.control.TextField txt_user_last_name;
    public javafx.scene.control.TextField txt_new_username;
    public javafx.scene.control.TextField txt_user_city;
    public javafx.scene.control.PasswordField txt_new_user_password;
    // date picker
    public javafx.scene.control.DatePicker date_picker;

    public javafx.scene.image.ImageView img_logo;

    public void setModel(Model model){
        this.model = model;
        try {
            Image logo = new Image(Controller.class.getClassLoader().getResourceAsStream("about_company.jpg"));
            img_logo.setImage(logo);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onKeyReleasedLogin(){
        boolean releasedLogin = (txt_id_user.getText().isEmpty() || txt_id_password.getText().isEmpty());
        btn_login.setDisable(releasedLogin);
    }

    public void onKeyReleasedSignUp(){
        boolean releasedSignUp = (txt_user_first_name.getText().isEmpty() || txt_user_last_name.getText().isEmpty() ||
                txt_new_username.getText().isEmpty() || txt_user_city.getText().isEmpty() ||
                txt_new_user_password.getText().isEmpty() ||
                date_picker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).isEmpty());
        btn_sign_up.setDisable(releasedSignUp);

    }

    //login button function
    public void login () {
        model.login(txt_id_user.getText(), txt_id_password.getText());
    }

    //sign up button function
    public void signUp () {
        String[] values = {txt_new_username.getText() , txt_new_user_password.getText()
                , date_picker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                , txt_user_first_name.getText(), txt_user_last_name.getText(), txt_user_city.getText()};
        model.signUp(values);
    }

    @Override
    public void update(Observable o, Object arg) {
        switch((String)arg){
            case "login failed":
                showAlert("Login Error", "The user name or password is incorrect, please try again.");
                break;

            case "signUp failed":
                showAlert("signUp Error","");
                break;

            case "login succeeded":

            case "signUp succeeded":
        }
    }

    public void showAlert(String title, String headerText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        Optional<ButtonType> reasult = alert.showAndWait();
        if(reasult.get() == ButtonType.OK)
            alert.close();
    }
}
