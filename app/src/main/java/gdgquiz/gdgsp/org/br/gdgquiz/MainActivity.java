package gdgquiz.gdgsp.org.br.gdgquiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    private Button btnPlay;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

        btnPlay = (Button) findViewById(R.id.btnPllay);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent perguntaIntent = new Intent(context, PerguntaActivity.class);

                startActivity(perguntaIntent);


            }
        });


    }

    public static void showMessage(String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        Log.w("GDG-QUIZ", message);
    }

}
