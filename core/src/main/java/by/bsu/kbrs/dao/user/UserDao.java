package by.bsu.kbrs.dao.user;

import by.bsu.kbrs.json.User;
import by.bsu.kbrs.json.UserSimple;
import by.bsu.kbrs.tools.ShortQuestionMapper;
import by.bsu.kbrs.tools.UserMapper;
import by.bsu.kbrs.tools.UserSimpleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wladek on 12/27/16.
 */
@Component
public class UserDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //private List<User>

    public User getUserByName(String name){
        Map<String, Object> params = new HashMap<String, Object>();
        String SQL_SELECT = "SELECT users.user_name, users.user_password_hash, users.user_salt, roles.role_display_name FROM USERS INNER JOIN ROLES ON users.user_role_id = roles.role_id where users.user_name = '" + name +"'";
        List list = ((List<User>) namedParameterJdbcTemplate.query(SQL_SELECT, new UserMapper()));
        if(list.size() != 0){
            return (User)list.get(0);
        }else{
            return null;
        }
    }

    public List<UserSimple> getListOfUserRoles(){
        String SQL_SELECT = "SELECT users.user_name, roles.role_display_name FROM USERS INNER JOIN ROLES ON users.user_role_id = roles.role_id";
        return (List<UserSimple>) namedParameterJdbcTemplate.query(SQL_SELECT, new UserSimpleMapper());
    }

    public boolean changeRoleById(String name, String role){
        Map<String, Object> params = new HashMap<String, Object>();
        String SQL_UPDATE = "UPDATE roles SET role_display_name = '" + role + "' where role_id = (SELECT user_id FROM users where user_name = '" + name +"' LIMIT 1)";
        int index = namedParameterJdbcTemplate.update(SQL_UPDATE, params);
        if(index > 0 ){
            return true;
        }else{
            return false;
        }
    }


}
