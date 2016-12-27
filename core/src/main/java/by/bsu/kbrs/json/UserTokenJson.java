package by.bsu.kbrs.json;

import javax.jws.soap.SOAPBinding;
import java.util.StringTokenizer;

/**
 * Created by wladek on 12/27/16.
 */
public class UserTokenJson {

    private String username;
    private String role;
    private String token;

    public UserTokenJson(){}
    public UserTokenJson(String username, String role, String token){
        setRole(role);
        setToken(token);
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
