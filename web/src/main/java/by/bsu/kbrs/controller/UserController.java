package by.bsu.kbrs.controller;

import by.bsu.kbrs.dao.token.TokenDao;
import by.bsu.kbrs.dao.user.UserDao;
import by.bsu.kbrs.entity.TokenInfo;
import by.bsu.kbrs.entity.User;
import by.bsu.kbrs.json.UserTokenJson;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wladek on 12/27/16.
 */
@RestController
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private TokenDao tokenDao;

    @RequestMapping(value = "/access", method = RequestMethod.GET)
    public @ResponseBody String authorization(HttpServletRequest request, HttpServletResponse response){
        String authorization= request.getHeader("authorization");
        String decodedBase64  = new String(Base64Utils.decodeFromString(authorization.split(" ")[1]));
        String username = decodedBase64.split(":")[0];
        String password = decodedBase64.split(":")[1];
        User user = userDao.getUserByName(username);
        if(user == null){
            response.setStatus(404);
            return "this is no such user";
        }
        password += user.getSalt();
        int passHash = password.hashCode();

        int pass = Integer.parseInt(user.getHashPassword());
        TokenInfo tokenInfo;
        if(pass == passHash){
            if(tokenDao.checkTokenForUser(username)){
                tokenInfo = tokenDao.getTokenInfoForUserByName(username);
            }else{
                String token = tokenDao.setTokenForUser(username);
                tokenInfo = new TokenInfo(token, user.getRole());
            }
            response.setContentType("application/json");
            response.setStatus(200);
            Gson gson = new Gson();
            String json = gson.toJson(tokenInfo);
            return json;
        }else {
            response.setStatus(403);
            return "incorrect password";
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody String getUserList(HttpServletRequest request, HttpServletResponse response){
        String authorization = request.getHeader("Authorization");
        String token = authorization.split(" ")[1];
        TokenInfo tokenInfo = tokenDao.getTokenInfoForUser(token);
        if(tokenInfo != null && tokenInfo.getRole().compareTo("ADMIN") == 0 ){
            response.setContentType("application/json");
            response.setStatus(200);
            Gson gson = new Gson();
            String json = gson.toJson(userDao.getListOfUserRoles());
            return json;
        }else{
            response.setStatus(403);
            return "you have no rights";
        }
    }

    @RequestMapping(value = "/users/role", method = RequestMethod.POST)
    public @ResponseBody String setNewRole(HttpServletRequest request, HttpServletResponse response, @RequestParam String username, @RequestParam String role){
        String authorization = request.getHeader("Authorization");
        String token = authorization.split(" ")[1];
        TokenInfo tokenInfo = tokenDao.getTokenInfoForUser(token);
        if(tokenInfo != null && tokenInfo.getRole().compareTo("ADMIN") == 0 ){
            response.setStatus(200);
            userDao.changeRoleById(username, role);
            return "changed";
        }else{
            response.setStatus(403);
            return "you have no rights";
        }
    }

}
