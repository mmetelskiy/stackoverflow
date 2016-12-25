package by.bsu.kbrs.entity;

/**
 * Created by wladek on 12/3/16.
 */
public class User {

    private String userName;
    private String userPassword;
    private String userRole;

    public User(String userName, String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(String userName, String userPassword, String userRole){
        this(userName, userPassword);
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
