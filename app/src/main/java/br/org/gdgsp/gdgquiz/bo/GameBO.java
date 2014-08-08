package br.org.gdgsp.gdgquiz.bo;

import android.content.Context;

import java.util.LinkedList;

import br.org.gdgsp.gdgquiz.domain.Answer;
import br.org.gdgsp.gdgquiz.domain.Question;

/**
 * Classe que contém toda a logica do jogo, como validar a resposta, determinar se o jogo acabou com vitoria ou derrota.
 *
 * Created by pveronezi on 29/07/14.
 */
public class GameBO {
    /**
     * Contexto da aplicação.
     */
    private Context context;

    /**
     * Lista de questão usada no jogo atual.
     */
    private LinkedList<Question> questions;

    /**
     * Construtor que recebe um contexto.
     * @param context
     */
    public GameBO(Context context) {
        this.context = context;
    }

    /**
     * Responsável por criar uma lista de questões caso não exista e
     * se já existir retorna a próxima questão, ae que não tenha questão
     * e retorn null.
     *
     * @return próxima questão ou null se acabaram as questões.
     */
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

    /**
     * Valida uma questão baseado no id de uma resposta.
     *
     * @param question Questão a ser validada.
     * @param idAnswer Id da resposta selecionada.
     * @return true se a resposta for certa.
     */
    public boolean validateAnswer(Question question, int idAnswer){
        for (Answer tempAnswer : question.getAnswers()) {
            if (tempAnswer.isRightAnswer() &&
                    (idAnswer == tempAnswer.getId())) {
             return true;
            }
        }
        return false;
    }

    /**
     * Reinicia o jogo, limpando a lista e populando de novo.
     */
    public void resetGame(){
        if (questions == null){
            questions = new LinkedList<Question>();
        }

        questions.clear();
        questions.addAll(new QuestionBO(context).getAllQuestao());
    }

}
