package gdgquiz.gdgsp.org.br.bo;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import gdgquiz.gdgsp.org.br.domain.Score;

/**
 * Created by pveronezi on 29/07/14.
 */
public class ScoreBO {
private Context context;

    public ScoreBO(Context context) {
        this.context = context;
    }

    public List<Score> getAllScore(){

        // TODO para testes, depois implementar busca no banco
        List<Score> result = new ArrayList<Score>();
        Score tempScore;
        for (int i = 0; i<10; i++ ){
            tempScore = new Score();
            tempScore.setId(i);
            tempScore.setNome("" + i + i + i);
            tempScore.setTempo(i * 2);
            tempScore.setVitoria(i%2 == 0? true:false);
            // tempScore.setImagem();

            result.add(tempScore);
        }

        return result;
    }
}
