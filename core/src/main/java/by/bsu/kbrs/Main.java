package by.bsu.kbrs;

 import by.bsu.kbrs.dao.fullQuestion.JdbcFullQuestionDao;
 import by.bsu.kbrs.dao.shortQuestion.JdbcShortQuestionDao;
 import by.bsu.kbrs.json.FullQuestion;
 import by.bsu.kbrs.json.ShortQuestion;
 import org.springframework.context.ConfigurableApplicationContext;
 import org.springframework.context.support.ClassPathXmlApplicationContext;

 import java.sql.Date;
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

         FullQuestion fullQuestion;
         jdbcFullQuestionDao.insert(fullQuestion= new FullQuestion(0,0, 2, " ", "kdas klasd lk;a sdlas daksl; dkla;sk;dl aksl;kd l;askl d;kasl;d kals;kd la;skdl uai wuih qwhue q",
                                    new Date(new java.util.Date().getTime())));
         System.out.println("where added "+ fullQuestion.getQuestionId());

         fullQuestion = jdbcFullQuestionDao.getById(fullQuestion.getQuestionId());
         System.out.println(fullQuestion.getQuestionId());

         jdbcFullQuestionDao.remove(fullQuestion);
         System.out.println("where deleted "+ fullQuestion.getQuestionId());

    }
}
