package Model;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) throws ParseException {
        Db d = new Db("V4u.db");
        d.createUsersTable();
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1991, 5-1, 4);
        d.Insert("USERS", "VALUES ('sankerr', 'rsHba45911', " + calendar.getTimeInMillis() + ", 'Roee', 'Sanker', 'Dimona');");
        calendar.set(1991, 5-1, 6);
        d.Insert("USERS", "VALUES ('bahadas', '233456777', " + calendar.getTimeInMillis() + ", 'Hadas', 'Ben Ari', 'Beer Sheva');");

        System.out.println(d.checkPassword("sankerr", "rsHba45911"));

        ArrayList<String[]> select = d.Read("USERS","City","Beer Sheva");
        for (String[] str:select){
            for (String s:str){
                System.out.print(s+" ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
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