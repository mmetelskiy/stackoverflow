package by.bsu.kbrs.entity;

/**
 * Created by wladek on 12/27/16.
 */
public class TokenInfo {

    private String role;
    private String token;

    public TokenInfo(String token, String role){
        setRole(role);
        setToken(token);
    }

    public TokenInfo(){}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
