package gdgquiz.gdgsp.org.br.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import gdgquiz.gdgsp.org.br.bo.ScoreBO;
import gdgquiz.gdgsp.org.br.domain.Score;


public class MainActivity extends Activity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private Button btnPlay;
    private ListView listScore;
    private ListAdapter listScoreAdapter;
    private List<Score> scoreList;
    private ScoreBO scoreBO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.btnPlay);

        listScore = (ListView) findViewById(R.id.listViewScore);
        TextView textViewTituloLista = new TextView(this);
        textViewTituloLista.setText(getString(R.string.score));
        listScore.addHeaderView(textViewTituloLista);
        scoreBO = new ScoreBO(this);
        scoreList = scoreBO.getAllScore();
        ListViewScoreAdapter listViewScoreAdapter = new ListViewScoreAdapter(this, scoreList);
        listScore.setAdapter(listViewScoreAdapter);



        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent perguntaIntent = new Intent(getBaseContext(), QuestionActivity.class);

                startActivity(perguntaIntent);


            }
        });


    }

    public void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        Log.w(TAG, message);
    }

}
