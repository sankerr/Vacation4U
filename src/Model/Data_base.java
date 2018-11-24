package Model;

import java.sql.*;
import java.util.*;

public class Data_base {

    private String db_Name;
    private int Vacation_idx;

    public Data_base(String fileName) {
        db_Name = fileName;
        Vacation_idx = getLastIDX()+1;
        String url = "jdbc:sqlite:" + fileName;
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public String getVacation_idx(){
        Vacation_idx++;
        return ""+(Vacation_idx - 1);
    }

    public void createUsersTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + this.db_Name);
            stmt = c.createStatement();
            String sql = "CREATE TABLE USERS " +
                    "(User_name VARCHAR(20) PRIMARY KEY UNIQUE NOT NULL," +
                    " Password VARCHAR(8) NOT NULL, " +
                    " Birthday DATE NOT NULL, " +
                    " First_name VARCHAR(20) NOT NULL, " +
                    " Last_name VARCHAR(20) NOT NULL, " +
                    " City VARCHAR(30) NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            try {
                c.close();
                stmt.close();
            } catch (SQLException e1) {

            }
        }
    }

    public void createVacationTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + this.db_Name);
            stmt = c.createStatement();
            String sql = "CREATE TABLE VACATION " +
                    "(Vacation_IDX INTEGER PRIMARY KEY UNIQUE NOT NULL," +
                    " User_name VARCHAR(20) NOT NULL, " +
                    " FlyFrom VARCHAR(30) NOT NULL, " +
                    " Dest VARCHAR(30) NOT NULL, " +
                    " Start_date DATE NOT NULL, " +
                    " End_date DATE NOT NULL, " +
                    " Flight_company VARCHAR(20) NOT NULL, " +
                    " Price INTEGER NOT NULL, " +
                    " Num_of_ticket INTEGER NOT NULL, " +
                    " Luggage VARCHAR(15) NOT NULL, " +
                    " ticket_type VARCHAR(15) NOT NULL, " +
                    " To_way INTEGER NOT NULL, " +
                    " Vacation_type VARCHAR(30) NOT NULL, " +
                    " Sleep_included INTEGER NOT NULL, " +
                    " Sleep_rank INTEGER NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            try {
                c.close();
                stmt.close();
            } catch (SQLException e1) {

            }
        }
    }


    public void createPaymentTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + this.db_Name);
            stmt = c.createStatement();
            String sql = "CREATE TABLE PAYMENT " +
                    "(Payment_IDX INTEGER PRIMARY KEY UNIQUE NOT NULL," +
                    " User_name_seller VARCHAR(20) NOT NULL, " +
                    " User_name_buyer VARCHAR(20) NOT NULL, " +
                    " Finel_Price INTEGER NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            try {
                c.close();
                stmt.close();
            } catch (SQLException e1) {

            }
        }
    }


    public boolean Insert(String table, String[] values) {
        Connection c = null;
        Statement stmt = null;

        try {
            String sql = "";
            if (table == "USERS")
                sql = "INSERT INTO USERS (User_name,Password,Birthday,First_name,Last_name,City) VALUES (";
            else if (table == "VACATION") {
                sql = "INSERT INTO VACATION (Vacation_IDX,User_name,FlyFrom,Dest,Start_date,End_date," +
                        "Flight_company,Price,Num_of_ticket,Luggage,ticket_type,To_way," +
                        "Vacation_type,Sleep_included,Sleep_rank) VALUES (";
            }
            for(int i=0;i<values.length-1;i++) {
                sql += "'" + values[i] + "', ";
            }
            sql+="'"+values[values.length-1]+"');";
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + this.db_Name);
            c.setAutoCommit(false);
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {

            try {
                c.close();
                stmt.close();
            } catch (SQLException e1) {

            }
            return false;
        }
        return true;
    }

    public ArrayList<String[]> Read(String table, String col, String id) {
        Connection c = null;
        PreparedStatement stmt = null;
        ArrayList<String[]> ans = new ArrayList<String[]>();

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + this.db_Name);
            c.setAutoCommit(false);

            String sql = "SELECT * FROM "+table+" WHERE "+col+"=?;";
            stmt = c.prepareStatement(sql);
            {
                // set the value
                stmt.setString(1, id);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    String user_Name = rs.getString("User_name");
                    String password = rs.getString("Password");
                    String b_Date = rs.getString("Birthday");
                    String f_Name = rs.getString("First_name");
                    String l_Name = rs.getString("Last_name");
                    String city = rs.getString("City");

                    String[] str = {user_Name, password, ""+b_Date, f_Name, l_Name, city};
                    ans.add(str);
                    //ans += user_Name + " " + password + " " + b_Date + " " + f_Name + " " + l_Name + " " + city+"\n\r";
                }
                rs.close();
                stmt.close();
                c.close();
            }
        } catch (Exception e) {
            //System.err.println(e.getClass().getName() + ": " + e.getMessage());

        }

        return ans;
    }

    public boolean Update(String table, String newCol, String newVal, String colId, String id) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + this.db_Name);
            c.setAutoCommit(false);
            stmt = c.createStatement();
            id="'"+id+"'";
            newVal="'"+newVal+"'";
            String sql = "UPDATE "+table+" set "+newCol+" = "+newVal+" where "+colId+"="+id+";";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();


        } catch (Exception e) {
            //System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean Delete(String table, String col, String id){
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + this.db_Name);
            c.setAutoCommit(false);
            id="'"+id+"'";
            stmt = c.createStatement();
            String sql = "DELETE from "+table+" where "+col+"="+id+";";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            try {
                c.close();
                stmt.close();
            } catch (SQLException e1) {

            }
        }
        return false;
    }


    public boolean checkPassword(String user_name, String password){
        ArrayList<String[]> select =  this.Read("USERS", "User_name", user_name);
        if (select.size()>0 && select.get(0)[1].equals(password))
            return true;
        else
            return false;
    }

    public int getLastIDX(){
        Connection c = null;
        Statement stmt = null;
        int max = 0;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + this.db_Name);
            c.setAutoCommit(false);

            String sql = "SELECT * FROM VACATION;";
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int Vacation_IDX = Integer.parseInt(rs.getString("Vacation_IDX"));
                if (Vacation_IDX>max)
                    max = Vacation_IDX;
            }
            rs.close();
            stmt.close();
            c.close();


        } catch (Exception e) {
            //System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return max;
    }
}
