package org.example;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


@Service
public class InMemoryScanEge implements Converting {
  public List<Dao>getStats() throws FileNotFoundException {
      try(Scanner sc = new Scanner(new File("C:\\Users\\hacer\\MavenProjects\\EgeAnalysis\\src\\main\\resources\\EgeAnswer.txt"))){
          sc.useDelimiter("\\A");
          String result = sc.hasNext() ? sc.next() : "";
          List<Dao>dao = convertCsvToLines(result);
          return dao.stream().toList();
      }catch (Exception e){
          e.printStackTrace();
      }
      return Collections.emptyList();
  }

    public List<Dao> convertCsvToLines(String input) {
       List<Dao>list = new ArrayList<>();
       String[]lines = input.split("\n");
       for (int i = 0; i<lines.length; i++){
          list.add(convertLinesToMeaning(lines[i]));
       }
       return list;
    }

    public Dao convertLinesToMeaning(String line) {
      String[]info = line.split(" - ");
      return new Dao(info[0],info[1].substring(0,info[1].length()-1));
    }
}
