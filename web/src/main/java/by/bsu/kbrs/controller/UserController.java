package by.bsu.kbrs.controller;

import by.bsu.kbrs.dao.user.UserDao;
import by.bsu.kbrs.json.User;
import by.bsu.kbrs.json.UserSimple;
import by.bsu.kbrs.json.UserTokenJson;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by wladek on 12/27/16.
 */
@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/access", method = RequestMethod.GET)
    public @ResponseBody String authorization(HttpServletRequest request, HttpServletResponse response){
        String authorization= request.getHeader("authorization");
        String decodedBase64  = new String(Base64Utils.decodeFromString(authorization.split(" ")[1]));
        String username = decodedBase64.split(":")[0];
        String password = decodedBase64.split(":")[1];
        response.setContentType("application/json");
        User user = userDao.getUserByName(username);
        if(user == null){
            response.setStatus(404);
            return "this is no such user";
        }
        password += user.getSalt();
        int passHash = password.hashCode();

        int pass = Integer.parseInt(user.getHashPassword());

        if(pass == passHash){

            response.setStatus(200);
            Gson gson = new Gson();
            String json = gson.toJson(new UserTokenJson(user.getName(), user.getRole(), user.getName()+":"+user.getRole()));
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
        String role = token.split(":")[1];
        response.setContentType("application/json");
        if(role == "ADMIN"){
            response.setStatus(200);
            Gson gson = new Gson();
            String json = gson.toJson(userDao.getListOfUserRoles());
            return json;
        }else{
            response.setStatus(403);
            return "you have no rights";
        }

    }

}
