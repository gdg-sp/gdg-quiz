package br.org.gdgsp.gdgquiz.bo;

import android.content.Context;

import java.util.LinkedList;

import br.org.gdgsp.gdgquiz.domain.Answer;
import br.org.gdgsp.gdgquiz.domain.Question;

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
