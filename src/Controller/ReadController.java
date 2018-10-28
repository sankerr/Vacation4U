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
    private IModel model;
    private String user_name;

    // text fields
    public javafx.scene.control.TextField txt_username;


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
                        for (int i=0;i<str.length;i++){
                            if(i!=1)
                                data = data + str[i] + " ";
                        }
                        data = data + "\n\r";
                    }

                    alert.setContentText(data);
                    alert.showAndWait();
                    Stage prim = (Stage) txt_username.getScene().getWindow();
                    prim.close();
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

    public void setModel(IModel model){
        this.model = model;
    }

    public void setUser_name(String user_name) {this.user_name = user_name; }


}
