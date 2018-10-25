package Model;

public interface IModel {

    void login(String userName , String userPassword);
    void signUp(String firstName, String lastName, String userName, String city, String password, String date);
}
