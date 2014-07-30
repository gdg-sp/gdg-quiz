package gdgquiz.gdgsp.org.br.view;

import android.app.Activity;
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

import gdgquiz.gdgsp.org.br.bo.QuizBO;
import gdgquiz.gdgsp.org.br.domain.Questao;
import gdgquiz.gdgsp.org.br.domain.Resposta;

public class PerguntaActivity extends Activity {
    private static final String TAG = PerguntaActivity.class.getSimpleName();
    private Questao questao;
    private TextView descricao;
    private Button buttonResponder;
    private RadioGroup radioGroupRespostas;
    private RadioButton radioResposta1;
    private RadioButton radioResposta2;
    private RadioButton radioResposta3;
    private RadioButton radioResposta4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);
        // TODO para teste
        questao = new QuizBO(this).getAllQuestao().get(0);
        Log.d(TAG, "Questão: " + questao.getId());

        buttonResponder = (Button) findViewById(R.id.buttonResponder);
        descricao = (TextView) findViewById(R.id.textViewDescricao);

        radioGroupRespostas = (RadioGroup) findViewById(R.id.radioGroupResposta);
        radioResposta1 = (RadioButton) findViewById(R.id.radioButtonResposta1);
        radioResposta2 = (RadioButton) findViewById(R.id.radioButtonResposta2);
        radioResposta3 = (RadioButton) findViewById(R.id.radioButtonResposta3);
        radioResposta4 = (RadioButton) findViewById(R.id.radioButtonResposta4);

        descricao.setText(questao.getDescricao());
        radioResposta1.setText(questao.getRespostas().get(0).getDescricao());
        radioResposta1.setId((int) questao.getRespostas().get(0).getId());

        radioResposta2.setText(questao.getRespostas().get(1).getDescricao());
        radioResposta2.setId((int) questao.getRespostas().get(1).getId());

        radioResposta3.setText(questao.getRespostas().get(2).getDescricao());
        radioResposta3.setId((int) questao.getRespostas().get(2).getId());

        radioResposta4.setText(questao.getRespostas().get(3).getDescricao());
        radioResposta4.setId((int) questao.getRespostas().get(3).getId());

        buttonResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "buttonResponder.setOnClickListener - START");
                String resultado = "Resposta errada";
                for (Resposta tempResposta : questao.getRespostas()) {
                    if (tempResposta.isRespostaCerta() &&
                            (radioGroupRespostas.getCheckedRadioButtonId() == tempResposta.getId())) {
                        resultado = "Resposta Certa";
                        break;
                    }
                }

                Toast.makeText(getBaseContext(), resultado, Toast.LENGTH_LONG).show();
                Log.d(TAG, "buttonResponder.setOnClickListener - FINISH");
            }
        });
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
