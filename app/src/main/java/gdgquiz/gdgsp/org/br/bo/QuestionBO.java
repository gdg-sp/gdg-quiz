package gdgquiz.gdgsp.org.br.bo;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import gdgquiz.gdgsp.org.br.domain.Answer;
import gdgquiz.gdgsp.org.br.domain.Question;

/**
 * Created by pveronezi on 31/07/14.
 */
public class QuestionBO {
    private static final String TAG = QuestionBO.class.getSimpleName();
    private Context context;

    public QuestionBO(Context context) {
        this.context = context;
    }

    public List<Question> getAllQuestao(){
        Log.d(TAG, "List<Question> getAllQuestao - START");
        // TODO para testes, depois implementar busca no banco
        List<Question> result = new ArrayList<Question>();
        Question tempQuestion;
        Answer tempAnswer;
        for (int i = 0; i<10; i++ ){
            tempQuestion = new Question();
            tempQuestion.setAnswers(new ArrayList<Answer>());
            for(int j = 0; j <5; j++){
                tempAnswer = new Answer();
                tempAnswer.setId(j);
                tempAnswer.setDescription("Answer " + i + j);
                tempAnswer.setRightAnswer(j == 0 ? true : false);
                tempQuestion.getAnswers().add(tempAnswer);
            }

            tempQuestion.setId(i);
            tempQuestion.setDescription("PERGUNTA " + i + " asdfa s s a e we q ead fadfas dfas das dsa s f asd fasd f a" +
                    "asdf asd asd fasdfasd fad fasdf as s asd fasd asdf s s s fa s f as  as dfasd]" +
                    "asdfasdja qjn e kje kjbkjb kljberklj kje kj ");

            result.add(tempQuestion);
        }

        Log.d(TAG,"List<Question> getAllQuestao - FINISH");
        return result;

    }
}
