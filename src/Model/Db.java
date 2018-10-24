package Model;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Db {

    private String db_Name;

    public Db(String fileName) {
        db_Name = fileName;
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
                    " Birthday INTEGER NOT NULL, " +
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

    public boolean Insert(String table, String val) {
        Connection c = null;
        Statement stmt = null;

        if (table == "USERS") {
            try {
                String sql = "INSERT INTO USERS (User_name,Password,Birthday,First_name,Last_name,City) " + val;
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
        return false;
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
                    Date b_Date = rs.getDate("Birthday");
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
            System.err.println(e.getClass().getName() + ": " + e.getMessage());

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
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
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
}
