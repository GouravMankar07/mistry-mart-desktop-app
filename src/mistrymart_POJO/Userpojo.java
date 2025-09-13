package mistrymart_POJO;

public class Userpojo {

    @Override
    public String toString() {
        return "Userpojo{" + "userId=" + userId + ", empid=" + empid + ", password=" + password + ", usertype=" + usertype + ", userName=" + userName + '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    private String userId;
    private String empid;
    private String password;
    private String usertype;
    private String userName;
}
