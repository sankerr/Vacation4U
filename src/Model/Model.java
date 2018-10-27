package Model;

import java.util.ArrayList;

import java.util.Observable;

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
            Object[] args = {"login succeeded"};
            setChanged();
            notifyObservers(args);
        }
        else{
            Object[] args = {"login failed"};
            setChanged();
            notifyObservers(args);
        }

    }

    public void signUp(String[] values){
        if(db.Insert("USERS", values)) {
            this.userName = values[0];
            Object[] args = {"signUp succeeded"};
            setChanged();
            notifyObservers(args);
        }
        else{
            Object[] args = {"signUp failed"};
            setChanged();
            notifyObservers(args);
        }

    }

    @Override
    public void search(String userToSearch) {
        ArrayList<String[]> select = db.Read("USERS","User_name",userToSearch);
        Object[] args = {"read", select};
        setChanged();
        notifyObservers(args);
    }
}
