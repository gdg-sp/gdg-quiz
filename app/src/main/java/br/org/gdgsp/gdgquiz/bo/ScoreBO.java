package br.org.gdgsp.gdgquiz.bo;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.org.gdgsp.gdgquiz.domain.Score;

/**
 * Created by pveronezi on 29/07/14.
 */
public class ScoreBO {
    /**
     * Contexto da aplicação.
     */
    private Context context;
    // TODO para teste depois remover
    private static List<Score> mockScores;

    public ScoreBO(Context context) {
        this.context = context;
    }

    /**
     * Retorna o score do jogo
     * @return lista de score
     */
    public List<Score> getAllScore(){
        // TODO para testes, depois implementar busca no banco
        if(mockScores != null){
            return mockScores;
        }
        mockScores = new ArrayList<Score>();
        Score tempScore;
        for (int i = 0; i<5; i++ ){
            tempScore = new Score();
            tempScore.setId(i);
            tempScore.setName("" + i + i + i);
            tempScore.setTime(i * 2);
            tempScore.setVictory(i % 2 == 0 ? true : false);
            mockScores.add(tempScore);
        }
        return mockScores;
    }

    /**
     * Salva um Score no sistema.
     * @param score Score a ser salvo
     * @return O Score com o Id populado.
     */
    public Score saveScore(Score score){
        // TODO para testes
        if(mockScores == null){
            mockScores = new ArrayList<Score>();
        }
        mockScores.add(score);
        return score;
    }
}
