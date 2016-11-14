package by.bsu.kbrs;

 import by.bsu.kbrs.dao.fullQuestion.JdbcFullQuestionDao;
 import by.bsu.kbrs.dao.shortQuestion.JdbcShortQuestionDao;
 import by.bsu.kbrs.json.ShortQuestion;
 import org.springframework.context.ConfigurableApplicationContext;
 import org.springframework.context.support.ClassPathXmlApplicationContext;

 import java.util.List;

         /**
  + * Created by wladek on 10/26/16.
  + */
public class Main {
     public static void main(String[] args){
         ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         JdbcShortQuestionDao jdbcShortQuestionDao = (JdbcShortQuestionDao) context.getBean("jdbcShortQuestionDao");
         List<ShortQuestion> shortQuestionList = jdbcShortQuestionDao.getList();
         System.out.println(shortQuestionList.toString());

         JdbcFullQuestionDao jdbcFullQuestionDao = (JdbcFullQuestionDao) context.getBean("jdbcFullQuestionDao");
         System.out.println(jdbcFullQuestionDao.getById(1).toString());
    }
}