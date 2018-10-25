package Model;

import Controller.Controller;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Observable;
import java.util.Optional;

public class Model extends Observable implements IModel {

    public Data_base db;
    public String userName;
    //public Controller controller;

    public Model(){
        db = new Data_base("V4u.db");
    }


    public void login(String userName, String userPassword) {

        boolean login = db.checkPassword(userName, userPassword);
        if(login){
            this.userName = userName;
            notifyObservers("login succeeded");
        }
        else{
            setChanged();
            notifyObservers("login failed");
        }

    }

    public void signUp(String firstName, String lastName, String userName, String city, String password, String date){

        if(db.Insert("USERS", userName+password+date+firstName+lastName+city)) {
            this.userName = userName;
            notifyObservers("signUp succeeded");
        }
        else{
            setChanged();
            notifyObservers("signUp failed");
        }
    }
}
