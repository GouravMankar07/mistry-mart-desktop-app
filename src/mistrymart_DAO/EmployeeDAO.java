package mistrymart_DAO;


import mistrymart_DBUtil.DBconnection;
import mistrymart_POJO.EmployeePOJO;
import java.util.List;


import java.util.ArrayList;

import java.sql.*;

public class EmployeeDAO {
    public static String getNextEmpId()throws SQLException{
      Connection connection=DBconnection.getConnection();
       Statement statement=(Statement) connection.createStatement();
       ResultSet resultset=statement.executeQuery("select max(empid) from employees");
       resultset.next();
       String empid=resultset.getString(1);
       int empno=Integer.parseInt(empid.substring(1));
       empno=empno+1;
       return "E"+empno;

    }
    public static boolean addEmployee(EmployeePOJO emp)throws SQLException{
        Connection connection=DBconnection.getConnection();
        PreparedStatement ps=connection.prepareStatement("insert into employees values (?,?,?,?)");
        ps.setString(1, emp.getEmpid());
        ps.setString(2, emp.getEmpname());
        ps.setString(3, emp.getJob());
        ps.setInt(4, emp.getSalary());
        int result=ps.executeUpdate();
        return result==1;
    }
    public static List<EmployeePOJO> getAllEmployee()throws SQLException{
     Connection connection=DBconnection.getConnection();
     Statement st=connection.createStatement();
     ResultSet rs=st.executeQuery("Select * from employees order by empid");
     ArrayList <EmployeePOJO> Employeelist=new ArrayList<>();
     while (rs.next()) {
        EmployeePOJO employeePOJO=new EmployeePOJO();
        employeePOJO.setEmpid(rs.getString(1));
        employeePOJO.setEmpname(rs.getString(2));
        employeePOJO.setJob(rs.getString(3));
        employeePOJO.setSalary(rs.getInt(4));
        Employeelist.add(employeePOJO);
     }
     return Employeelist;
    }
    public static List<String> getAllEmpId()throws SQLException{
        Connection connection=DBconnection.getConnection();
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery("Select empid from employees order by empid");
        ArrayList<String> allId=new ArrayList<>();
        while (rs.next()) {
            allId.add(rs.getString(1));
        }
        return allId;
    }
    public static EmployeePOJO findEmpById(String empid)throws SQLException{
        Connection connection=DBconnection.getConnection();
        PreparedStatement ps=connection.prepareStatement("Select * from employees where empid=?");
        ps.setString(1, empid);
        ResultSet rs=ps.executeQuery();
        rs.next();
        EmployeePOJO employeePOJO=new EmployeePOJO();
        employeePOJO.setEmpid(rs.getString(1));
        employeePOJO.setEmpname(rs.getString(2));
        employeePOJO.setJob(rs.getString(3));
        employeePOJO.setSalary(rs.getInt(4));
        return employeePOJO;
    }
    
    public static boolean updateEmployee(EmployeePOJO e)throws SQLException{
        Connection connection=DBconnection.getConnection();
        PreparedStatement ps=connection.prepareStatement("Update employees set empname=?,job=?,salary=? where empid=?");
        ps.setString(1, e.getEmpname());
        ps.setString(2, e.getJob());
        ps.setInt(3, e.getSalary());
        ps.setString(4, e.getEmpid());
        int x=ps.executeUpdate();
        if (x==0) {
            return false;
        }
        else{
            boolean result=UserDAO.isUserPresent(e.getEmpid());
            if (result==false) {
                return true;
            }
       
        ps=connection.prepareStatement("Update employees set username=?,usertype=? where empid=?");
        ps.setString(1, e.getEmpname());
        ps.setString(2, e.getJob());
        ps.setString(3, e.getEmpid());
        int y=ps.executeUpdate();
        return y==1;
     }
    }
    public static boolean deleteEmployee(String empid)throws SQLException{
        Connection connection=DBconnection.getConnection();
        PreparedStatement ps=connection.prepareStatement("Delete from employees where empid=?");
        ps.setString(1, empid);
        int x=ps.executeUpdate();
        return x==1;
    }
}
