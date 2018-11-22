package Model;

import java.util.ArrayList;

public interface IModel {

    void login(String userName , String userPassword);
    void signUp(String[] values);
    void search(String userName);
    void deleteUser(String userName);
    void updateUserData(String[] updateData);
    boolean searchUserName(String userName);
    String getUser_name();
    void setUser_name(String user_name);
    ArrayList<String[]> bringDetailsOfUser (String user);

    void createVacation(String[] values);
}
