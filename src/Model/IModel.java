package Model;

public interface IModel {

    void login(String userName , String userPassword);
    void signUp(String[] values);
    void search(String userName);
}
