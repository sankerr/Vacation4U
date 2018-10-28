package Controller;

import Model.IModel;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.time.format.DateTimeFormatter;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

public class UpdateController implements Observer{

    private IModel model;
    private String user_name;

    public javafx.scene.control.Button btn_edit;
    public javafx.scene.control.TextField txt_username;
    public javafx.scene.control.TextField txt_password;
    public javafx.scene.control.TextField txt_firstname;
    public javafx.scene.control.TextField txt_lastname;
    public javafx.scene.control.TextField txt_city;
    public javafx.scene.control.DatePicker datePicker_date_of_birth;

    public void setModel(IModel model){
        this.model = model;
    }

    public void setUser_name(String user_name){ this.user_name = user_name; }

    public void edit(){
        if(txt_username.getText().isEmpty() && txt_password.getText().isEmpty() &&
                txt_firstname.getText().isEmpty() && txt_lastname.getText().isEmpty() &&
                txt_city.getText().isEmpty() && datePicker_date_of_birth.valueProperty().isNull().get()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edir Error");
            alert.setHeaderText("You must enter at least one update parameter");
            Optional<ButtonType> reasult = alert.showAndWait();
            if(reasult.get() == ButtonType.OK)
                alert.close();
        }
        else if(!txt_username.getText().isEmpty() && !model.searchUserName(txt_username.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edir Error");
            alert.setHeaderText("The username already exists in the system\r\n" +
                    "Please select a different username");
            Optional<ButtonType> reasult = alert.showAndWait();
            if(reasult.get() == ButtonType.OK)
                alert.close();
        }
        else {
            String[] data = new String[7];
            data[0] = this.user_name;
            if(!txt_username.getText().isEmpty())
                data[1] = txt_username.getText();
            else
                data[1]="";

            if(!txt_password.getText().isEmpty())
                data[2] = txt_password.getText();
            else
                data[2]="";

            if(!txt_firstname.getText().isEmpty())
                data[3] = txt_firstname.getText();
            else
                data[3]="";

            if(!txt_lastname.getText().isEmpty())
                data[4] = txt_lastname.getText();
            else
                data[4]="";

            if(!txt_city.getText().isEmpty())
                data[5] = txt_city.getText();
            else
                data[5]="";

            if(datePicker_date_of_birth.valueProperty().isNotNull().get())
                data[6] = datePicker_date_of_birth.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            else
                data[6]="";

            model.updateUserData(data);
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            if (((Object[]) arg)[0].equals("user update")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update user info");
                alert.setHeaderText("Update succeeded");
                alert.showAndWait();
            }
        } catch (Exception e){

        }
    }
}
