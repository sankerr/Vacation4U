package Controller;

import Model.IModel;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Controller implements IController{

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
        iModel.login(txt_id_user.getText(), txt_id_password.getText());
    }

    //sign up button function
    public void signUp () {


    }
}
