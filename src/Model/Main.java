package Model;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) throws ParseException {
        Data_base d = new Data_base("V4u.db");
        d.createUsersTable();
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1991, 5-1, 4);
        String[] val = {"sankerr", "1234", "1991-05-04", "Roee", "Sanker", "Dimona"};
        d.Insert("USERS", val);
        calendar.set(1991, 5-1, 6);
        //d.Insert("USERS", "VALUES ('bahadas', '233456777', " + calendar.getTimeInMillis() + ", 'Hadas', 'Ben Ari', 'Beer Sheva');");

        System.out.println(d.checkPassword("sankerr", "rsHba45911"));

        ArrayList<String[]> select = d.Read("USERS","City","Dimona");
        for (String[] str:select){
            for (String s:str){
                System.out.print(s+" ");
            }
            System.out.println();
        }

        d.Update("USERS", "City", "Beer Sheva","User_name", "sankerr");
        //d.Delete("USERS", "User_name", "sankerr");
        select = d.Read("USERS","City","Beer Sheva");
        for (String[] str:select){
            for (String s:str){
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }
}