package br.org.gdgsp.gdgquiz.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.org.gdgsp.gdgquiz.bo.ScoreBO;
import br.org.gdgsp.gdgquiz.domain.Score;


public class MainActivity extends Activity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private Button btnPlay;
    private ListView listScore;
    private List<Score> scoreList;
    private ScoreBO scoreBO;
    private ListViewScoreAdapter listViewScoreAdapter;

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
        listViewScoreAdapter = new ListViewScoreAdapter(this, scoreList);
        listScore.setAdapter(listViewScoreAdapter);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent perguntaIntent = new Intent(getBaseContext(), QuestionActivity.class);
                startActivity(perguntaIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        scoreList = scoreBO.getAllScore();
        listViewScoreAdapter.notifyDataSetChanged();

    }

}
