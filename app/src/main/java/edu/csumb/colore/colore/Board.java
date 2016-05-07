package edu.csumb.colore.colore;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class Board extends AppCompatActivity {
    private Intent i;
    private Bundle extraInfo = new Bundle();
    private int CURRENT_LEVEL;
    private int NUM_OF_COMMANDS;
    private HeapTree colorList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            CURRENT_LEVEL  = extras.getInt("CURRENT_LEVEL");
            NUM_OF_COMMANDS =  extras.getInt("NUM_OF_COMMANDS");
        }
        colorList = new HeapTree(NUM_OF_COMMANDS);

        Log.d("onCreate", "CURRENT LEVEL (BOARD)"+ CURRENT_LEVEL +
        "NUM_OF_COMMANDS" + NUM_OF_COMMANDS);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               newLevel();

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void newLevel(){
        // Check if game is over

        // Sends data to Board Activity
        Intent i = new Intent(getBaseContext(), Level.class);
        extraInfo = new Bundle();
        extraInfo.putInt("NEW_LEVEL", CURRENT_LEVEL + 1);
        extraInfo.putInt("NEW_COMMANDS", NUM_OF_COMMANDS + 1);
        i.putExtras(extraInfo);
        startActivity(i);
    }

}
