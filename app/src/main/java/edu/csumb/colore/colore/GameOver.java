package edu.csumb.colore.colore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GameOver extends AppCompatActivity {
    private int points;
    private String gameLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        Intent intentExtras = getIntent();
        Bundle extras = intentExtras.getExtras();

        if(!extras.isEmpty()) {
            points = extras.getInt("POINTS");
            gameLevel = extras.getString("level");
            Log.d("Game Level: " , gameLevel);
        }
        setLevel();
    }
    public void setLevel() {
        TextView t = (TextView) findViewById(R.id.level_text);
        t.setText("LEVEL: " + gameLevel);
    }
    public void playAgain(View v){
        Intent i = new Intent(getBaseContext(), Level.class);
        startActivity(i);
        finish();
    }
}
