package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ReadController {
    // text fields
    public TextField txt_username;
    // buttons
    public Button btn_search;

    public void SearchUsr(ActionEvent actionEvent) {
        String userName = txt_username.getText();
        if(userName != null){//if the user wrote something:



            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("User Info");
            alert.setContentText("bla blaaaaaaa");
            alert.showAndWait();
        }
        else {//if the text field is empty:
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("you need to fill the text field");
            alert.showAndWait();
        }

    }
}
