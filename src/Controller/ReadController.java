package Controller;

import Model.IModel;
import Model.Model;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ReadController implements Observer{

    //Objects
    private Stage stage;
    private IModel model;

    // text fields
    public TextField txt_username;
    // buttons
    public Button btn_search;

    public void SearchUser() {
        String userName = txt_username.getText();
        if((userName != null) && (!userName.equals(""))){//if the user wrote something:
            model.search(userName);
        }
        else {//if the text field is empty:
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("you need to fill the text field");
            alert.showAndWait();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            if(((Object[])arg)[0].equals("read")){
                ArrayList<String[]> select = (ArrayList<String[]>)((Object[])arg)[1];
                if(select.size() > 0) {//if we found the user we search:
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("User Info");
                    alert.setHeaderText("Search result");

                    //getting the data from the array list
                    String data = "";
                    for (String[] str:select){
                        for (String s:str){
                            data = data + s + " ";
                        }
                        data = data + "\n\r";
                    }

                    alert.setContentText(data);
                    alert.showAndWait();
                }
                else {//if the select returned null row:
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("User Info");
                    alert.setHeaderText("User not found");
                    alert.showAndWait();
                }
            }
        } catch (Exception e){

        }

    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setModel(IModel model){
        this.model = model;
    }


}
