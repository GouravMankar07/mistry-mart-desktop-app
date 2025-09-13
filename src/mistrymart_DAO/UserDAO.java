package mistrymart_DAO;
import mistrymart_POJO.EmployeePOJO;
import mistrymart_POJO.UserProfile;
import mistrymart_POJO.Userpojo;
import java.sql.*;

// import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
// import com.mysql.cj.xdevapi.PreparableStatement;

import mistrymart_DBUtil.DBconnection;

public class UserDAO {
    public static boolean validateUser(Userpojo user)throws SQLException{
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from users where userid=? and password=? and usertype=?");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUsertype());
        ResultSet rs=ps.executeQuery();
        if (rs.next()) {
            UserProfile.setUsername(rs.getString(5));
            return true;
        }
        return false;
    }
    public static boolean isUserPresent(String empid)throws SQLException{
        Connection connection=DBconnection.getConnection();
        PreparedStatement ps=connection.prepareStatement("Select 1 from users where emprid=?");
        ResultSet rs=ps.executeQuery();
        ps.setString(1, empid);
        return rs.next();
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
}
