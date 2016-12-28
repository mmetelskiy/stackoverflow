package by.bsu.kbrs.entity;

/**
 * Created by wladek on 12/27/16.
 */
public class User {

    private String name;
    private String role;

    private String hashPassword;
    private String salt;

    public User(){}

    public User(String name, String role, String hashPassword, String salt){
        setHashPassword(hashPassword);
        setName(name);
        setRole(role);
        setSalt(salt);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
