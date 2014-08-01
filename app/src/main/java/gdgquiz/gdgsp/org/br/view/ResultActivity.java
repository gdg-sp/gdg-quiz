package gdgquiz.gdgsp.org.br.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import gdgquiz.gdgsp.org.br.domain.Score;
import gdgquiz.gdgsp.org.br.view.R;

public class ResultActivity extends Activity {
    private Score score;
    private TextView labelResult;
    private static String RESULT = "result";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        labelResult = (TextView) findViewById(R.id.textViewResult);
        //boolean result = getIntent().getBooleanExtra("result");
       //String title = result? "Parabéns": "Não foi dessa vez";
       // labelResult.setText(title);

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
