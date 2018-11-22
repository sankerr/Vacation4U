package Controller;

import Model.IModel;
import javafx.scene.control.Alert;

import java.time.format.DateTimeFormatter;
import java.util.Observable;
import java.util.Observer;

public class VacationCreateController implements Observer {

    private IModel model;


    public void setModel(IModel model){
        this.model = model;
    }

    public void setUser_name(String user_name){ model.setUser_name(user_name); }

    public void createVacation () {
        String[] values = {};
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
