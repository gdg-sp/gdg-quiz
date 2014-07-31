package gdgquiz.gdgsp.org.br.bo;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import gdgquiz.gdgsp.org.br.domain.Answer;
import gdgquiz.gdgsp.org.br.domain.Question;

/**
 * Created by pveronezi on 29/07/14.
 */
public class GameBO {
    private Context context;
    private LinkedList<Question> questions;

    public GameBO(Context context) {
        this.context = context;
    }

    public Question getNextQuestion(){
        if (questions == null){
            questions = new LinkedList<Question>();
            questions.addAll(new QuestionBO(context).getAllQuestao());
        }

        if (!questions.isEmpty()) {
            return questions.removeFirst();
        } else{
            return null;
        }
    }

    public boolean validateAnswer(Question question, int idAnswer){
        for (Answer tempAnswer : question.getAnswers()) {
            if (tempAnswer.isRightAnswer() &&
                    (idAnswer == tempAnswer.getId())) {
             return true;
            }
        }
        return false;
    }

    public void resetGame(){
        if (questions == null){
            questions = new LinkedList<Question>();
        }

        questions.clear();
        questions.addAll(new QuestionBO(context).getAllQuestao());
    }

}
