package Controller;

import Model.IModel;
import javafx.scene.control.Alert;

import java.time.format.DateTimeFormatter;
import java.util.Observable;
import java.util.Observer;

public class VacationCreateController implements Observer {

    private IModel model;

    public javafx.scene.control.TextField txt_from;
    public javafx.scene.control.TextField txt_to;
    public javafx.scene.control.TextField txt_flightCmp;
    public javafx.scene.control.TextField txt_numOfTrav;
    public javafx.scene.control.TextField txt_price;

    public void setModel(IModel model){
        this.model = model;
    }

    public void setUser_name(String user_name){ model.setUser_name(user_name); }

    /*public void onKeyReleasedSignUp(){
        boolean releasedSignUp = (txt_user_first_name.getText().isEmpty() || txt_user_last_name.getText().isEmpty() ||
                txt_new_username.getText().isEmpty() || txt_user_city.getText().isEmpty() ||
                txt_new_user_password.getText().isEmpty() ||
                date_picker.getValue() == null);
        btn_sign_up.setDisable(releasedSignUp);

    }*/

    public void createVacation () {
        String[] values = {model.getVacation_idx(), model.getUser_name(), };
        model.createVacation(values);
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            if (((Object[]) arg)[0].equals("")) {

            }
        } catch (Exception e){

        }
    }
}
