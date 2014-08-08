package br.org.gdgsp.gdgquiz.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.org.gdgsp.gdgquiz.bo.ScoreBO;
import br.org.gdgsp.gdgquiz.domain.Score;
import ly.count.android.api.Countly;

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

        // Inicia o count.ly
        Countly.sharedInstance().init(this, "https://cloud.count.ly", "6c5155943353eebcb773a3d1352eb17b02641240");

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


        String title = victory? getString(R.string.congratulations): getString(R.string.was_not_this_time);
        labelResult.setText(title);
        labelCount.setText(getString(R.string.hits) + count);
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

        // Informa o count.ly
        if(score.isVictory()){
            Countly.sharedInstance().recordEvent("Victory", 1);
        } else{
            Countly.sharedInstance().recordEvent("Defeated", 1);
        }

        scoreBO = new ScoreBO(this);
        scoreBO.saveScore(score);

        Log.d(TAG, "endGame() - score: " + score);

    }

    @Override
    protected void onStart() {
        super.onStart();
        // Inicia o count.ly
        Countly.sharedInstance().onStart();
    }

    @Override
    protected void onStop() {
        // para o count.ly
        Countly.sharedInstance().onStop();
        super.onStop();
    }

    @TargetApi(Build.VERSION_CODES.ECLAIR)
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
