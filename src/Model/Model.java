package Model;

import Controller.Controller;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Observable;
import java.util.Optional;

public class Model extends Observable implements IModel {

    public Data_base db;
    public String userName;

    public Model(){
        db = new Data_base("V4u.db");
        db.createUsersTable();
    }


    public void login(String userName, String userPassword) {

        boolean login = db.checkPassword(userName, userPassword);
        if(login){
            this.userName = userName;
            setChanged();
            notifyObservers("login succeeded");
        }
        else{
            setChanged();
            notifyObservers("login failed");
        }

    }

    public void signUp(String[] values){

        if(db.Insert("USERS", values)) {
            this.userName = values[0];
            setChanged();
            notifyObservers("signUp succeeded");
        }
        else{
            setChanged();
            notifyObservers("signUp failed");
        }

    }
}
