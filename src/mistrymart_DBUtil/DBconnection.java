package mistrymart_DBUtil;

import java.sql.*;

import javax.swing.JOptionPane;

public class DBconnection {
    private static Connection conn;
    static
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/grocery";
            String user = "root";
            String password = "2580";
            conn=DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Connected Successfully to DB");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error! in loading in Driver","Driver Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error in DB: " + ex.getMessage());
            ex.printStackTrace();
            System.exit(1);
        }
    }
    public static Connection getConnection() {
        return conn;
    }
    public static void closeConnection(){
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "Connected close Successfully"); 

         } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error! in closing connection","DB Error!",JOptionPane.ERROR_MESSAGE); 
        }
    }
}

