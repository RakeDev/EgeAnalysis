package org.example;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Map;
@Component
public class Dao {

 private static Map<String,String>rightAnswers;
    @Value("#{${rightAnswers}}")
    public void setRightAnswers(Map<String, String> rightAnswers) {
        Dao.rightAnswers = rightAnswers;
    }

    private String questions;
    private String answer;
    public Dao(String questions, String answer){
        this.questions = questions;
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dao dao = (Dao) o;

        if (!questions.equals(dao.questions)) return false;
        return answer.equals(dao.answer);
    }

    @Override
    public int hashCode() {
        int result = questions.hashCode();
        result = 31 * result + answer.hashCode();
        return result;
    }

    public Dao(){

    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Dao{" +
                "questions='" + questions + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
    public int getScoreForAnswer(String question){
    return Integer.parseInt(rightAnswers.get(question));
    }
}
