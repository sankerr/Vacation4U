package Controller;

import Model.IModel;

import java.util.Observable;
import java.util.Observer;

public class VacationPanelController implements Observer {

    private IModel model;
    private String userName;

    @Override
    public void update(Observable o, Object arg) {

    }

    public void setModel(IModel model) {
        this.model = model;
    }
}
