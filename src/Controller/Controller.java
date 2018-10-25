package Controller;

import Model.IModel;
import Model.Model;
import javafx.scene.control.*;
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

    public void setModel(Model model){
        this.model = model;
    }
    //login button function
    public void login () {
        model.login(txt_id_user.getText(), txt_id_password.getText());
    }

    //sign up button function
    public void signUp () {
        model.signUp(txt_user_first_name.getText() , txt_user_last_name.getText()
                , txt_new_username.getText() , txt_user_city.getText(), txt_new_user_password.getText(),
                date_picker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    @Override
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
