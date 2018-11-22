package Model;

import java.util.ArrayList;

import java.util.Observable;

public class Model extends Observable implements IModel {

    private Data_base db;
    private String user_name;

    public Model(){
        db = new Data_base("V4u.db");
        db.createUsersTable();
        db.createVacationTable();
        db.createPaymentTable();
    }

    @Override
    public void login(String userName, String userPassword) {

        boolean login = db.checkPassword(userName, userPassword);
        if(login){
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

    @Override
    public void signUp(String[] values){
        if(db.Insert("USERS", values)) {
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
        ArrayList<String[]> select = db.Read("USERS","User_name", userToSearch);
        Object[] args = {"read", select};
        setChanged();
        notifyObservers(args);
    }

    @Override
    public void deleteUser(String userName) {
        db.Delete("USERS","User_name",userName);
        //notify to the RUD Controller that the user deleted so the user
        //will exit to the main menu
        setChanged();
        Object[] args = {"user deleted"};
        notifyObservers(args);

    }

    @Override
    public void updateUserData(String[] updateData){
        if(!updateData[2].equals(""))
            db.Update("USERS", "Password", updateData[2], "User_name", updateData[0]);
        if(!updateData[3].equals(""))
            db.Update("USERS", "First_name", updateData[3], "User_name", updateData[0]);
        if(!updateData[4].equals(""))
            db.Update("USERS", "Last_name", updateData[4], "User_name", updateData[0]);
        if(!updateData[5].equals(""))
            db.Update("USERS", "City", updateData[5], "User_name", updateData[0]);
        if(!updateData[6].equals(""))
            db.Update("USERS", "Birthday", updateData[6], "User_name", updateData[0]);
        if(!updateData[1].equals(""))
            db.Update("USERS", "User_name", updateData[1], "User_name", updateData[0]);

        setChanged();
        Object[] args = {"user update"};
        notifyObservers(args);
    }

    @Override
    public boolean searchUserName(String userToSearch){
        ArrayList<String[]> select = db.Read("USERS","User_name", userToSearch);
        return select.isEmpty();
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


    // this function returns arraylist of all details that belongs to the user
    public ArrayList<String[]> bringDetailsOfUser (String user){
        ArrayList<String[]> ans = new ArrayList<String[]>();
        ans = db.Read("USERS","User_name", user);
        return ans;
    }
}
