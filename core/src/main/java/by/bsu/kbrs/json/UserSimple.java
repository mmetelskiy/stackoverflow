package by.bsu.kbrs.json;

/**
 * Created by wladek on 12/27/16.
 */
public class UserSimple {
    private String username;
    private String role;

    public UserSimple(){}

    public UserSimple(String username, String role){
        setRole(role);
        setUsername(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
