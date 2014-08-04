package gdgquiz.gdgsp.org.br.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import gdgquiz.gdgsp.org.br.bo.GameBO;
import gdgquiz.gdgsp.org.br.domain.Question;

public class QuestionActivity extends Activity {
    private static final String TAG = QuestionActivity.class.getSimpleName();
    private Question question;
    private TextView descricao;
    private Button buttonResponder;
    private RadioGroup radioGroupRespostas;
    private RadioButton radioResposta1;
    private RadioButton radioResposta2;
    private RadioButton radioResposta3;
    private RadioButton radioResposta4;
    private GameBO gameBO;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);
        gameBO = new GameBO(this);
        question = gameBO.getNextQuestion();
        Log.d(TAG, "Questão: " + question.getId());

        buttonResponder = (Button) findViewById(R.id.buttonResponder);
        descricao = (TextView) findViewById(R.id.textViewDescricao);

        radioGroupRespostas = (RadioGroup) findViewById(R.id.radioGroupResposta);
        radioResposta1 = (RadioButton) findViewById(R.id.radioButtonResposta1);
        radioResposta2 = (RadioButton) findViewById(R.id.radioButtonResposta2);
        radioResposta3 = (RadioButton) findViewById(R.id.radioButtonResposta3);
        radioResposta4 = (RadioButton) findViewById(R.id.radioButtonResposta4);

        populateQuestion(question);

        buttonResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "buttonResponder.setOnClickListener - START");

                if(gameBO.validateAnswer(question, radioGroupRespostas.getCheckedRadioButtonId())){
                    question = gameBO.getNextQuestion();
                    count++;
                    if(question != null){
                        Toast.makeText(getBaseContext(), getString(R.string.resposta_certa), Toast.LENGTH_SHORT).show();
                        populateQuestion(question);

                    }else{
                        resultGame(true, count);
                    }
                }else{
                    resultGame(false, count);
                }

                Log.d(TAG, "buttonResponder.setOnClickListener - FINISH");
            }
        });
    }

    private void resultGame(boolean victory, int pCount) {
        Intent resultIntent = new Intent(getBaseContext(), ResultActivity.class);
        resultIntent.putExtra(ResultActivity.VICTORY, victory);
        resultIntent.putExtra(ResultActivity.COUNT, pCount);
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(resultIntent);
        finish();
    }

    private void populateQuestion(Question q){

        descricao.setText(q.getDescription());
        radioResposta1.setText(q.getAnswers().get(0).getDescription());
        radioResposta1.setId((int) q.getAnswers().get(0).getId());

        radioResposta2.setText(q.getAnswers().get(1).getDescription());
        radioResposta2.setId((int) q.getAnswers().get(1).getId());

        radioResposta3.setText(q.getAnswers().get(2).getDescription());
        radioResposta3.setId((int) q.getAnswers().get(2).getId());

        radioResposta4.setText(q.getAnswers().get(3).getDescription());
        radioResposta4.setId((int) q.getAnswers().get(3).getId());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pergunta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
