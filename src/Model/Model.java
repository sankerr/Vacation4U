package Model;

import java.util.Observable;

public class Model extends Observable implements IModel {

    public Data_base db;

    public Model(){
        db = new Data_base("V4u.db");
    }


    public void login(String userName, String userPassword) {

        boolean login = db.checkPassword(userName, userPassword);
        if(login)
            notifyObservers("login succeeded");
        else
            notifyObservers("login failed");
    }

    public void signUp() {

    }
}
