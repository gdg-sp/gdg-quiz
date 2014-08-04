package gdgquiz.gdgsp.org.br.view;

import android.app.Activity;
import android.app.SearchManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import gdgquiz.gdgsp.org.br.bo.ScoreBO;
import gdgquiz.gdgsp.org.br.domain.Score;

public class ResultActivity extends Activity {
    public static final String VICTORY = "victory";
    public static final String COUNT = "count";
    private static final String TAG = ResultActivity.class.getSimpleName();

    private Score score;
    private TextView labelResult;
    private TextView labelCount;
    private EditText letter1;
    private EditText letter2;
    private EditText letter3;
    private Button buttonFinish;
    private ScoreBO scoreBO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        labelResult = (TextView) findViewById(R.id.textViewResult);
        labelCount = (TextView) findViewById(R.id.textViewCount);
        letter1 = (EditText) findViewById(R.id.inputLetter1);
        letter2 = (EditText) findViewById(R.id.inputLetter2);
        letter3 = (EditText) findViewById(R.id.inputLetter3);
        buttonFinish = (Button) findViewById(R.id.buttonHome);


        boolean victory = getIntent().getBooleanExtra(VICTORY, false);
        int count = getIntent().getIntExtra(COUNT, 0);

        score = new Score();
        score.setVictory(victory);
        score.setQtdQuestions(count);


        String title = victory? "Parabéns": "Não foi dessa vez";
        labelResult.setText(title);
        labelCount.setText("Quantidade de acertos: " + count);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endGame();
                finish();

            }
        });

    }

    private void endGame() {
        String name = letter1.getText().toString() + letter2.getText().toString() + letter3.getText().toString();
        score.setName(name);

        scoreBO = new ScoreBO(this);
        scoreBO.saveScore(score);

        Log.d(TAG, "endGame() - score: " + score);

    }

    @Override
    public void onBackPressed() {
        endGame();
        super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.result, menu);
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
