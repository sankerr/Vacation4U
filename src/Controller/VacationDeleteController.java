package Controller;

import Model.IModel;
import Model.Model;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VacationDeleteController implements Observer{

    public javafx.scene.control.TextField txt_idxOfVacation;
    private IModel model;
    public Button btn_submit;

    public void setModel(IModel model) {
        this.model = model;
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            Object obj = ((Object[])arg)[0];
            String str = (String)obj;
            if(str.equals("vacation deleted")) {
                exitDeletePanel();
            }else if(str.equals("delete vacation failed")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("delete vacation failed please try again later");
                alert.showAndWait();
            }

        } catch (Exception e) {

        }
    }

    private void exitDeletePanel() {
        //Stage stage = (Stage) btn_submit.getScene().getWindow();
        //stage.close();
    }

    public void deleteVacation(ActionEvent actionEvent) {
        String deleteMe = txt_idxOfVacation.getText();

        //if the user wrote something:
        if((deleteMe != null) && (!deleteMe.equals(""))) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure you want to delete this vacation?");
            ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType noButton = new ButtonType("No, Sorry", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().setAll(yesButton, noButton);

            //checking what the user choosed
            alert.showAndWait().ifPresent((buttonType) -> {
                if (buttonType == yesButton) {
                    model.deleteVacation(deleteMe);
                }
            });
        }
        else {//if the text field is empty:
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("You need to fill the number of vacation you want to delete!");
            alert.showAndWait();
        }

    }
}
