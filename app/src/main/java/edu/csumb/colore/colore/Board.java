package edu.csumb.colore.colore;

import java.util.ArrayList;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public class Board extends AppCompatActivity {
    HeapTree colorList;
    ArrayList<Integer> used = new ArrayList<>();
    ArrayList<Integer> board = new ArrayList<>();
    //HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    ArrayList<Node> heap = new ArrayList<>();

    private Intent i;
    private Bundle extraInfo = new Bundle();
    private int CURRENT_LEVEL;
    private int NUM_OF_COMMANDS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            CURRENT_LEVEL  = extras.getInt("CURRENT_LEVEL");
            NUM_OF_COMMANDS =  extras.getInt("NUM_OF_COMMANDS");
        }
        Log.d("onCreate", "CURRENT LEVEL (BOARD)"+ CURRENT_LEVEL +
        "NUM_OF_COMMANDS" + NUM_OF_COMMANDS);
        colorList = new HeapTree(NUM_OF_COMMANDS);


        Log.d("DISPLAY: HEAP", "HEAP");
        colorList.display();

       Log.d("COLOR_LIST:" , String.valueOf(colorList));
        Log.d("NUM_COMMANDS: " , String.valueOf(NUM_OF_COMMANDS));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               newLevel();

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    /*
        for(int i =0 ; i < 10; i++) {
            board.add(0);
        }


        Log.d("HEAP: " , String.valueOf(heap.get(1).getFrequency()));
        int position;
        for(int node = 0; node < heap.size(); node++) {
            for(int numTimes = 0; numTimes < heap.get(node).getFrequency(); numTimes++) {
                position = getRandomNum();

                    while (used.contains(position)) {
                        position = getRandomNum();

                    }
                Log.d("POSITION: " ,String.valueOf(position));
                Log.d("COLOR: " , String.valueOf(heap.get(node).getColor()));
                    used.add(position);
                    board.set(position, heap.get(node).getColor());
                    addButton(position, heap.get(node).getColor());
            }
        }
        Log.d("Used: " , String.valueOf(used));
        Log.d("COLORS: ", String.valueOf(board));*/
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

    public void buttonColor(Button b, int color){
            switch (color) {
                case 1:
                    b.setBackgroundColor(Color.YELLOW);
                    break;
                case 2:
                    b.setBackgroundColor(Color.RED);
                    break;
                case 3:
                    b.setBackgroundColor(Color.MAGENTA);
                    break;
                case 4:
                    b.setBackgroundColor(Color.LTGRAY);
                    break;
                case 5:
                    b.setBackgroundColor(Color.GREEN);
                    break;
                case 6:
                    b.setBackgroundColor(Color.CYAN);
                    break;
                case 7:
                    b.setBackgroundColor(Color.BLUE);
                    break;
                case 8:
                    b.setBackgroundColor(Color.BLACK);
                    break;
                case 9:
                    b.setBackgroundColor(Color.GRAY);
                    break;
                default:
                    b.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
                    break;
            }
        }

    public void addButton(int position, int color) {
        Button b;
        switch (position) {
            case 1:
                b = (Button)findViewById(R.id.button1);
                buttonColor(b, color);
                break;
            case 2:
                b = (Button)findViewById(R.id.button2);
                buttonColor(b, color);
                break;
            case 3:
                b = (Button)findViewById(R.id.button3);
                buttonColor(b, color);
                break;
            case 4:
                b = (Button)findViewById(R.id.button4);
                buttonColor(b, color);
            case 5:
                b = (Button)findViewById(R.id.button5);
                buttonColor(b, color);
                break;
            case 6:
                b = (Button)findViewById(R.id.button6);
                buttonColor(b, color);
                break;
            case 7:
                b = (Button)findViewById(R.id.button7);
                buttonColor(b, color);
                break;
            case 8:
                b = (Button)findViewById(R.id.button8);
                buttonColor(b, color);
                break;
            case 9:
                b = (Button)findViewById(R.id.button9);
                buttonColor(b, color);
            default:
                break;
        }
    }

    public int getRandomNum() {
        Random rand = new Random();
        return rand.nextInt(9) +1;
    }
    public void buttonPressed(View v) {
        Button b;
        switch (v.getId()) {
            case R.id.button1:
                b = (Button) findViewById(R.id.button1);
                b.setBackgroundColor(Color.WHITE);
                break;
            case R.id.button2:
                b = (Button) findViewById(R.id.button2);
                b.setBackgroundColor(Color.WHITE);
                break;
            case R.id.button3:
                b = (Button) findViewById(R.id.button3);
                b.setBackgroundColor(Color.WHITE);
                break;
            case R.id.button4:
                b = (Button) findViewById(R.id.button4);
                b.setBackgroundColor(Color.WHITE);
                break;
            case R.id.button5:
                b = (Button) findViewById(R.id.button5);
                b.setBackgroundColor(Color.WHITE);
                break;
            case R.id.button6:
                b = (Button) findViewById(R.id.button6);
                b.setBackgroundColor(Color.WHITE);
                break;
            case R.id.button7:
                b = (Button) findViewById(R.id.button7);
                b.setBackgroundColor(Color.WHITE);
                break;
            case R.id.button8:
                b = (Button) findViewById(R.id.button8);
                b.setBackgroundColor(Color.WHITE);
            case R.id.button9:
                b = (Button) findViewById(R.id.button9);
                b.setBackgroundColor(Color.WHITE);
                break;
            default:
                break;
        }
    }
}
