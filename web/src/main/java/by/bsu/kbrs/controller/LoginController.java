package by.bsu.kbrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Scanner;

/**
 * Created by wladek on 10/18/16.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {


    @RequestMapping(method = RequestMethod.GET)
    public void getLogin(HttpServletResponse response) throws IOException {
        Scanner scanner= new Scanner(new File("/Users/wladek/IdeaProjects/KBRS_LAB1/web/src/main/webapp/WEB-INF/staticPages/login.html"));
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        while(scanner.hasNext()){
            pw.println(scanner.nextLine());
        }
        pw.close();
    }
}
