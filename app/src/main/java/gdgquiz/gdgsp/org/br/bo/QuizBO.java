package gdgquiz.gdgsp.org.br.bo;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import gdgquiz.gdgsp.org.br.domain.Questao;
import gdgquiz.gdgsp.org.br.domain.Resposta;

/**
 * Created by pveronezi on 29/07/14.
 */
public class QuizBO {
    private static final String TAG = QuizBO.class.getSimpleName();
    private Context context;

    public QuizBO(Context context) {
        this.context = context;
    }

    public List<Questao> getAllQuestao(){
        Log.d(TAG,"List<Questao> getAllQuestao - START");
        // TODO para testes, depois implementar busca no banco
        List<Questao> result = new ArrayList<Questao>();
        Questao tempQuestao;
        Resposta tempResposta;
        for (int i = 0; i<10; i++ ){
            tempQuestao = new Questao();
            tempQuestao.setRespostas(new ArrayList<Resposta>());
            for(int j = 0; j <5; j++){
                tempResposta = new Resposta();
                tempResposta.setId(j);
                tempResposta.setDescricao("Resposta " + i+j);
                tempResposta.setRespostaCerta(j==0?true:false);
                tempQuestao.getRespostas().add(tempResposta);
            }

            tempQuestao.setId(i);
            tempQuestao.setDescricao("PERGUNTA "+ i +" asdfa s s a e we q ead fadfas dfas das dsa s f asd fasd f a" +
                    "asdf asd asd fasdfasd fad fasdf as s asd fasd asdf s s s fa s f as  as dfasd]" +
                    "asdfasdja qjn e kje kjbkjb kljberklj kje kj ");

            result.add(tempQuestao);
        }

        Log.d(TAG,"List<Questao> getAllQuestao - FINISH");
        return result;

    }
}
