package mistrymart_DAO;
import java.sql.*;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;



import java.util.HashMap;


import mistrymart_DBUtil.DBconnection;
import mistrymart_POJO.ReceptionistPOJO;
import mistrymart_POJO.Userpojo;

public class ReceptionistDAO {
    public static Map<String,String> getNonRegisterdReceptionits() throws SQLException{
       Connection connection=DBconnection.getConnection();
       Statement st=connection.createStatement();
       ResultSet rs=st.executeQuery("select empid,empname from employees where job='Receptionist' and empid not in(select empid from users where usertype='Receptionist')");
       HashMap <String,String> ReceptionistList= new HashMap<>();
       while (rs.next()) {
        String id=rs.getString(1);
        String name=rs.getString(2);
        ReceptionistList.put(id, name);
       }
       return ReceptionistList;
    }
    public static boolean AddReceptionist(Userpojo user) throws SQLException{
       Connection connection=DBconnection.getConnection();
       PreparedStatement ps=connection.prepareStatement("insert into users values(?,?,?,?,?)");
       ps.setString(1, user.getUserId());
       ps.setString(2, user.getEmpid());
       ps.setString(3, user.getPassword());
       ps.setString(4, user.getUsertype());
       ps.setString(5, user.getUserName());
       int result=ps.executeUpdate();
       return result==1;
    }
    public static List<ReceptionistPOJO> getAllReceptionistDetails() throws SQLException{
      Connection connection=DBconnection.getConnection();
      Statement st=connection.createStatement();
      ResultSet rs=st.executeQuery("Select users.empid,empname,userid,job,salary from users,employees where usertype='Receptionist'and users.empid=employees.empid");
      ArrayList<ReceptionistPOJO> al=new ArrayList<>();
      while (rs.next()) {
         ReceptionistPOJO receptionistPOJO=new ReceptionistPOJO();
         receptionistPOJO.setEmpid(rs.getString(1));
         receptionistPOJO.setEmpname(rs.getString(2));
         receptionistPOJO.setUserid(rs.getString(3));
         receptionistPOJO.setJob(rs.getString(4));
         receptionistPOJO.setSalary(rs.getDouble(5));
         al.add(receptionistPOJO);
      }
      return al;
    }
    public static Map<String,String> getAllReceptionistID() throws SQLException{
      Connection connection=DBconnection.getConnection();
      Statement st=connection.createStatement();
      ResultSet rs=st.executeQuery("select userid,username from users where usertype='Receptionist' order by userid");
      HashMap <String,String> ReceptionistList= new HashMap<>();
      while (rs.next()) {
       String id=rs.getString(1);
       String name=rs.getString(2);
       ReceptionistList.put(id, name);
      }
      return ReceptionistList;
    }
   public static boolean updatePassword(String userid , String pwd) throws SQLException{
      Connection connection=DBconnection.getConnection();
      PreparedStatement ps=connection.prepareStatement("update users set password=? where userid=?");
      ps.setString(1, pwd);
      ps.setString(2, userid);
      return ps.executeUpdate()==1;

   }
   public static List<String> getAllReceptionistUserID() throws SQLException{
      Connection connection=DBconnection.getConnection();
      Statement st=connection.createStatement();
      ResultSet rs=st.executeQuery("Select userid from users where usertype='Receptionist'order by userid");
      List <String> ReceptionistList= new ArrayList<>();
      while (rs.next()) {
         String id=rs.getString(1);
         ReceptionistList.add(id);
        }
        return ReceptionistList;
   }
   public static boolean deleteReceptionist(String userid) throws SQLException{
      Connection connection=DBconnection.getConnection();
      PreparedStatement ps=connection.prepareStatement("delete from users where userid=?");
      ps.setString(1, userid);
      return ps.executeUpdate()==1;
   }
}
