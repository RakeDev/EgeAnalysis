package org.example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.io.FileNotFoundException;
import java.util.List;


public class App
{
    public static void main( String[] args ) throws FileNotFoundException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        InMemoryScanEge inMemoryScanEge = applicationContext.getBean(InMemoryScanEge.class);
        InMemoryScanWork inMemoryScanWork = applicationContext.getBean(InMemoryScanWork.class);
        List<Dao>dao = inMemoryScanEge.getStats();
        List<Dao>dao1 = inMemoryScanWork.getStats();
          int counter = 0;
          for(int i = 0; i<dao.size();i++){
              Dao daoFirst = dao.get(i);
              Dao daoSecond = dao1.get(i);
              if(daoFirst.equals(daoSecond)){
                  counter += daoSecond.getScoreForAnswer(daoSecond.getQuestions());
              }
          }
        System.out.println(counter);

    }
}
