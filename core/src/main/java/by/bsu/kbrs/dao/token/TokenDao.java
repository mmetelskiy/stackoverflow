package by.bsu.kbrs.dao.token;

import by.bsu.kbrs.entity.TokenInfo;
import by.bsu.kbrs.tools.TokenInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by wladek on 12/27/16.
 */
@Component
public class TokenDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private int tokenSize = 16;

    public boolean checkTokenForUser(String username){
        String SQL_CHECK = "SELECT COUNT(token_id) FROM tokens LEFT JOIN users on token_user_id=user_id WHERE user_name=:user_name";
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("user_name", username);
        Integer count = namedParameterJdbcTemplate.queryForObject(SQL_CHECK, params, Integer.class);
        return count > 0 ? true : false;
    }

    public TokenInfo getTokenInfoForUserByName(String username){
        String SQL_GET_TOKEN_INFO_BY_USERNAME = "SELECT role_display_name, token FROM roles INNER JOIN users ON user_role_id = role_id INNER JOIN tokens ON token_user_id = user_id WHERE user_name = :user_name";
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("user_name", username);
        List<TokenInfo> listTokenInfo = (List<TokenInfo>) namedParameterJdbcTemplate.query(SQL_GET_TOKEN_INFO_BY_USERNAME, map, new TokenInfoMapper());
        if(listTokenInfo.size() > 0){
            return listTokenInfo.get(0);
        }else {
            return null;
        }
    }

    public TokenInfo getTokenInfoForUser(String token){
        String SQL_GET_TOKEN_INFO = "SELECT role_display_name FROM roles INNER JOIN users ON user_role_id = role_id INNER JOIN tokens ON token_user_id = user_id WHERE token = :token";
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("token", token);
        String role =  namedParameterJdbcTemplate.queryForObject(SQL_GET_TOKEN_INFO, map, String.class);
        return (role != null || role.length() > 0) ? new TokenInfo(token, role) : null;
    }

    public String setTokenForUser(String username){
        String token = getRandomToken(tokenSize);
        String SQL_INSERT_TOKEN = "INSERT INTO tokens (token_user_id, token) VALUES ((SELECT user_id FROM users WHERE user_name = :user_name LIMIT 1), :token)";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("token_user_name", username);
        params.put("token", token);
        namedParameterJdbcTemplate.update(SQL_INSERT_TOKEN, params);
        return token;
    }

    private String getRandomToken(int size) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < size; i++){
            int way = random.nextInt(2);
            switch (way){
                case 0:
                    way = 48 + random.nextInt(10);
                    break;
                case 1:
                    way = 65 + random.nextInt(26);
                    break;
            }
            stringBuilder.append((char) way);
        }
        return stringBuilder.toString();
    }

}
