

// import java.sql.Connection;
// import java.sql.ResultSet;
// import java.sql.Statement;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;
// import java.sql.PreparedStatement;

// import mistrymart_DBUtil.DBconnection;
// import mistrymart_POJO.ProductPOJO;
// import mistrymart_POJO.UserProfile;

// public class orderDAO {
//     public static String getNextOrderId() throws SQLException {
//         Connection connection = DBconnection.getConnection();
//         Statement statement = connection.createStatement();
//         ResultSet resultset = statement.executeQuery("select max(order_id) from orders");
//         resultset.next();
//         String orderid = resultset.getString(1);
//         if (orderid == null) {
//             return "O-101";
//         }
//         int orderno = Integer.parseInt(orderid.substring(2));
//         orderno = orderno + 1;
//         return "O-" + orderno;

//     }

//     public static boolean addOrder(ArrayList<ProductPOJO> al, String orderId) throws SQLException {
//         Connection connection = DBconnection.getConnection();
//         PreparedStatement ps = connection.prepareStatement("insert into orders values (?,?,?,?)");
//         int count = 0;
//         for (ProductPOJO pojo : al) {
//             ps.setString(1, orderId);
//             ps.setString(2, pojo.getProductId());
//             ps.setInt(3, pojo.getQuantity());
//             ps.setString(4, UserProfile.getUserid());
//             ps.executeUpdate();
//             count = count + 1;
//         }
//         return count == al.size();
//     }

//     public static List<String> getAllOrderId() throws SQLException {
//         Connection connection = DBconnection.getConnection();
//         Statement st = connection.createStatement();
//         ResultSet rs = st.executeQuery("Select order_id from orders order by order_id");
//         ArrayList<String> allId = new ArrayList<>();
//         while (rs.next()) {
//             allId.add(rs.getString(1));
//         }
//         return allId;
//     }
//     public static List<Object[]> getOrderDetails(int orderId) throws SQLException {
//         List<Object[]> data = new ArrayList<>();
//         Connection connection = DBconnection.getConnection();

//         String query = "SELECT p_id, p_name, p_companyname, p_price, our_price, quantity, tax " +
//                        "FROM Orders JOIN Products ON Orders.p_id = Products.p_id " +
//                        "WHERE Orders.order_id = ?";

//         PreparedStatement stmt = connection.prepareStatement(query);
//             stmt.setInt(1, orderId);
//             ResultSet rs = stmt.executeQuery();

//             while (rs.next()) {
//                 data.add(new Object[]{
//                     rs.getInt("p_id"),
//                     rs.getString("p_name"),
//                     rs.getString("p_companyname"),
//                     rs.getDouble("p_price"),
//                     rs.getDouble("our_price"),
//                     rs.getInt("quantity"),
//                     rs.getDouble("tax")
//                 });
//             }

//         return data;
//     }

// }
package mistrymart_DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import mistrymart_DBUtil.DBconnection;
import mistrymart_POJO.ProductPOJO;
import mistrymart_POJO.UserProfile;



public class orderDAO {

    // ComboBox ke liye sare Order IDs laana
    public static List<String> getAllOrderId() throws SQLException {
        List<String> orderIds = new ArrayList<>();
        Connection connection = DBconnection.getConnection();

        String query = "SELECT DISTINCT order_id FROM Orders ORDER BY order_id";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String id = rs.getString("order_id");
            // Manager ko "O-101" type show karna hai
            orderIds.add(id);
        }

        return orderIds;
    }
    public static boolean addOrder(ArrayList<ProductPOJO> al, String orderId) throws SQLException {
        Connection connection = DBconnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("insert into orders values (?,?,?,?)");
        int count = 0;
        for (ProductPOJO pojo : al) {
            ps.setString(1, orderId);
            ps.setString(2, pojo.getProductId());
            ps.setInt(3, pojo.getQuantity());
            ps.setString(4, UserProfile.getUserid());
            ps.executeUpdate();
            count = count + 1;
        }
        return count == al.size();
    }

    public static String getNextOrderId() throws SQLException {
        Connection connection = DBconnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("select max(order_id) from orders");
        resultset.next();
        String orderid = resultset.getString(1);
        if (orderid == null) {
            return "O-101";
        }
        int orderno = Integer.parseInt(orderid.substring(2));
        orderno = orderno + 1;
        return "O-" + orderno;

    }
    // Selected order ki details
public static List<Object[]> getOrderDetails(String orderId) throws SQLException {
    List<Object[]> data = new ArrayList<>();
    Connection connection = DBconnection.getConnection();

    // Query me har column ke aage table ka naam likha hai
    // Maan rahe hain ki 'quantity' Orders table me hai aur baaki sab Products table me.
    String query = "SELECT Products.p_id, Products.p_name, Products.p_companyname, " +
                   "Products.p_price, Products.our_price, Orders.quantity, Products.p_tax " +
                   "FROM Orders JOIN Products ON Orders.p_id = Products.p_id " +
                   "WHERE Orders.order_id = ?";

    PreparedStatement stmt = connection.prepareStatement(query);
    stmt.setString(1, orderId);
    ResultSet rs = stmt.executeQuery();

    while (rs.next()) {
        data.add(new Object[]{
            rs.getString("p_id"),
            rs.getString("p_name"),
            rs.getString("p_companyname"),
            rs.getDouble("p_price"),
            rs.getDouble("our_price"),
            rs.getInt("quantity"), // Yeh Orders table se aa raha hai
            rs.getDouble("p_tax")
        });
    }

    return data;
}
    // new for genearate orderlist for receptionist
    public static List<String> getOrderIdByReceptionist(String receptionistId) throws SQLException {
    Connection conn = DBconnection.getConnection();
    PreparedStatement ps = conn.prepareStatement("SELECT order_id FROM orders WHERE userid=?");
    ps.setString(1, receptionistId);
    ResultSet rs = ps.executeQuery();

    List<String> orderIds = new ArrayList<>();
    while (rs.next()) {
        orderIds.add(rs.getString(1)); 
    }
    return orderIds;
}

}
