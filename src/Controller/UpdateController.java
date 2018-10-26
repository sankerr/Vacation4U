package Controller;

import Model.IModel;
import Model.Model;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class UpdateController implements Observer{

    //Objects
    private Stage stage;
    private IModel model;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setModel(Model model){
        this.model = model;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
