package br.org.gdgsp.gdgquiz.bo;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.org.gdgsp.gdgquiz.domain.Answer;
import br.org.gdgsp.gdgquiz.domain.Question;

/**
 * Regras de negócio relacionado as questões do quiz como CRUD, listagem e etc
 *
 * Created by pveronezi on 31/07/14.
 */
public class QuestionBO {
    private static final String TAG = QuestionBO.class.getSimpleName();

    /**
     * Contexto da aplicação.
     */
    private Context context;

    /**
     * Construtor que recebe um contexto da aplicação
     *
     * @param context
     */
    public QuestionBO(Context context) {
        this.context = context;
    }

    /**
     * Lista todas as questões do sistema.
     *
     * @return A lista de questões do quiz.
     */
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
