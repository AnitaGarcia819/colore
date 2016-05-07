package edu.csumb.colore.colore;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Level extends AppCompatActivity {
    private static int currentLevel = 1;
    private int numOfCommands = 3;
    public static HeapTree heapTree;
    private Intent i;
    private Bundle extraInfo;
    private final int NUM_TILES = 9;
    private int THRESHOLD = NUM_TILES - (numOfCommands - 1);
    private ArrayList<Integer> commandList;
  //  private ArrayList<String> colorList = new ArrayList<String>();
    private HashMap<Integer, ArrayList<Integer>> tileFrequency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("onCreate", "called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        // Update level and num of commands
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
           currentLevel  = extras.getInt("NEW_LEVEL");
            numOfCommands = extras.getInt("NEW_COMMANDS");
        }

        Log.d("onCreate", "CURRENT LEVEL: (LEVEL) " + currentLevel + " NUM OF COMMANDS: " + numOfCommands);
        //Log.d("onCreate", "before " + tileFrequency.size() + " | " + commandList.size());

        // Clear tileFrequency
        tileFrequency = new HashMap<Integer, ArrayList<Integer>>();
        // Clear commandList
        commandList = new ArrayList<Integer>();
        Log.d("onCreate", "after " + tileFrequency.size() + " | " + commandList.size());

        heapTree = new HeapTree(numOfCommands);
        //heapTree.updateSize(numOfCommands);

        initializeCommandList();
        displayCommandList();
        //TO DO: init Hashmap with default array list


    }
    public void generateTileFrequency() {
        if(tileFrequency.get(numOfCommands) == null){
            tileFrequency.put(numOfCommands, new ArrayList<Integer>());
        }
        int tileFrequencyNumber = getRandomTileNumber();
        for (int i = 0; i < numOfCommands; i++) {
            while (tileFrequency.get(numOfCommands).contains(tileFrequencyNumber)) {
                tileFrequencyNumber = getRandomTileNumber();
            }
            tileFrequency.get(numOfCommands).add(tileFrequencyNumber);
        }
    }
    public void initializeCommandList(){
        int color;
        int priorityValue;
        int frequency;

        generateTileFrequency();
        // Select random color && select # of values

        for(int i = 0; i < numOfCommands; i++){
            color = getRandomColor();
            while(commandList.contains(color)){
                color = getRandomColor();
            }
            commandList.add(color);
            Log.d("COMMAND ", " " + i + commandList.get(i));
           // color = getRandomColor();
            frequency = tileFrequency.get(numOfCommands).get(i);
            Log.d("DATA", i + " " + frequency + " " + color);
            heapTree.add(i, frequency, color);
            displayColor(i, color);
        }

    }
    public int getRandomColor(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(NUM_TILES) + 1;// 1 - 9
    }
    public int getRandomNumber(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(NUM_TILES + 1);// 0 - 9
    }
    public int getRandomTileNumber(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(THRESHOLD) + 1; //  1 - threshold
    }
    public void displayColor(int i, int color){
        Button command_button = getButton(i);
        setColor(command_button, color);

    }
    public void setColor(Button b, int color){

        switch(color){
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
        }
    }
    public Button getButton(int button_position){

        switch(button_position){
            case 0:
                    return (Button) findViewById(R.id.command_button_0);

            case 1:
                    return (Button) findViewById(R.id.command_button_1);

            case 2:
                    return (Button) findViewById(R.id.command_button_2);

            case 3:
                    return (Button) findViewById(R.id.command_button_3);

            case 4:
                    return (Button) findViewById(R.id.command_button_4);

            case 5:
                    return (Button) findViewById(R.id.command_button_5);

            case 6:
                    return (Button) findViewById(R.id.command_button_6);

            case 7:
                    return (Button) findViewById(R.id.command_button_7);

            case 8:
                    return (Button) findViewById(R.id.command_button_8);

            default:
                return null;
        }
    }

    public void displayCommandList(){
        Button command_button_0 = (Button) findViewById(R.id.command_button_0);
        Button command_button_1 = (Button) findViewById(R.id.command_button_1);
        Button command_button_2 = (Button) findViewById(R.id.command_button_2);

        Button command_button_3 = (Button) findViewById(R.id.command_button_3);
        Button command_button_4 = (Button) findViewById(R.id.command_button_4);
        Button command_button_5 = (Button) findViewById(R.id.command_button_5);
        Button command_button_6 = (Button) findViewById(R.id.command_button_6);
        Button command_button_7 = (Button) findViewById(R.id.command_button_7);
        Button command_button_8 = (Button) findViewById(R.id.command_button_8);

        switch(currentLevel){
            case 1:
                switch(commandList.get(1)){
                    case 0:
                        command_button_1.setBackgroundColor(Color.YELLOW);
                        break;
                    case 1:
                        command_button_1.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        command_button_1.setBackgroundColor(Color.MAGENTA);
                        break;
                    case 3:
                        command_button_1.setBackgroundColor(Color.LTGRAY);
                        break;
                    case 4:
                        command_button_1.setBackgroundColor(Color.GREEN);
                        break;
                    case 5:
                        command_button_1.setBackgroundColor(Color.CYAN);
                        break;
                    case 6:
                        command_button_1.setBackgroundColor(Color.BLUE);
                    case 7:
                        command_button_1.setBackgroundColor(Color.BLACK);
                    case 8:
                        command_button_1.setBackgroundColor(Color.GRAY);
                        break;
                }
                switch(commandList.get(2)){
                    case 0:
                        command_button_2.setBackgroundColor(Color.YELLOW);
                        break;
                    case 1:
                        command_button_2.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        command_button_2.setBackgroundColor(Color.MAGENTA);
                        break;
                    case 3:
                        command_button_2.setBackgroundColor(Color.LTGRAY);
                        break;
                    case 4:
                        command_button_2.setBackgroundColor(Color.GREEN);
                        break;
                    case 5:
                        command_button_2.setBackgroundColor(Color.CYAN);
                        break;
                    case 6:
                        command_button_2.setBackgroundColor(Color.BLUE);
                    case 7:
                        command_button_2.setBackgroundColor(Color.BLACK);
                    case 8:
                        command_button_2.setBackgroundColor(Color.GRAY);
                        break;
                }
                break;
            case 2:
                switch(commandList.get(0)){
                    case 0:
                        command_button_0.setBackgroundColor(Color.YELLOW);
                        break;
                    case 1:
                        command_button_0.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        command_button_0.setBackgroundColor(Color.MAGENTA);
                        break;
                    case 3:
                        command_button_0.setBackgroundColor(Color.LTGRAY);
                        break;
                    case 4:
                        command_button_0.setBackgroundColor(Color.GREEN);
                        break;
                    case 5:
                        command_button_0.setBackgroundColor(Color.CYAN);
                        break;
                    case 6:
                        command_button_0.setBackgroundColor(Color.BLUE);
                    case 7:
                        command_button_0.setBackgroundColor(Color.BLACK);
                    case 8:
                        command_button_0.setBackgroundColor(Color.GRAY);
                        break;
                }
                switch(commandList.get(1)){
                    case 0:
                        command_button_1.setBackgroundColor(Color.YELLOW);
                        break;
                    case 1:
                        command_button_1.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        command_button_1.setBackgroundColor(Color.MAGENTA);
                        break;
                    case 3:
                        command_button_1.setBackgroundColor(Color.LTGRAY);
                        break;
                    case 4:
                        command_button_1.setBackgroundColor(Color.GREEN);
                        break;
                    case 5:
                        command_button_1.setBackgroundColor(Color.CYAN);
                        break;
                    case 6:
                        command_button_1.setBackgroundColor(Color.BLUE);
                    case 7:
                        command_button_1.setBackgroundColor(Color.BLACK);
                    case 8:
                        command_button_1.setBackgroundColor(Color.GRAY);
                        break;
                }
                switch(commandList.get(2)){
                    case 0:
                        command_button_2.setBackgroundColor(Color.YELLOW);
                        break;
                    case 1:
                        command_button_2.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        command_button_2.setBackgroundColor(Color.MAGENTA);
                        break;
                    case 3:
                        command_button_2.setBackgroundColor(Color.LTGRAY);
                        break;
                    case 4:
                        command_button_2.setBackgroundColor(Color.GREEN);
                        break;
                    case 5:
                        command_button_2.setBackgroundColor(Color.CYAN);
                        break;
                    case 6:
                        command_button_2.setBackgroundColor(Color.BLUE);
                    case 7:
                        command_button_2.setBackgroundColor(Color.BLACK);
                    case 8:
                        command_button_2.setBackgroundColor(Color.GRAY);
                        break;
                }
                switch(commandList.get(3)){
                    case 0:
                        command_button_3.setBackgroundColor(Color.YELLOW);
                        break;
                    case 1:
                        command_button_3.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        command_button_3.setBackgroundColor(Color.MAGENTA);
                        break;
                    case 3:
                        command_button_3.setBackgroundColor(Color.LTGRAY);
                        break;
                    case 4:
                        command_button_3.setBackgroundColor(Color.GREEN);
                        break;
                    case 5:
                        command_button_3.setBackgroundColor(Color.CYAN);
                        break;
                    case 6:
                        command_button_3.setBackgroundColor(Color.BLUE);
                    case 7:
                        command_button_3.setBackgroundColor(Color.BLACK);
                    case 8:
                        command_button_3.setBackgroundColor(Color.GRAY);
                        break;
                }

                command_button_3.setVisibility(View.VISIBLE);

                break;
            case 3:
                switch(commandList.get(0)){
                    case 0:
                        command_button_2.setBackgroundColor(Color.YELLOW);
                        break;
                    case 1:
                        command_button_2.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        command_button_2.setBackgroundColor(Color.MAGENTA);
                        break;
                    case 3:
                        command_button_2.setBackgroundColor(Color.LTGRAY);
                        break;
                    case 4:
                        command_button_2.setBackgroundColor(Color.GREEN);
                        break;
                    case 5:
                        command_button_2.setBackgroundColor(Color.CYAN);
                        break;
                    case 6:
                        command_button_2.setBackgroundColor(Color.BLUE);
                    case 7:
                        command_button_2.setBackgroundColor(Color.BLACK);
                    case 8:
                        command_button_2.setBackgroundColor(Color.GRAY);
                        break;
                }
                switch(commandList.get(1)){
                    case 0:
                        command_button_2.setBackgroundColor(Color.YELLOW);
                        break;
                    case 1:
                        command_button_2.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        command_button_2.setBackgroundColor(Color.MAGENTA);
                        break;
                    case 3:
                        command_button_2.setBackgroundColor(Color.LTGRAY);
                        break;
                    case 4:
                        command_button_2.setBackgroundColor(Color.GREEN);
                        break;
                    case 5:
                        command_button_2.setBackgroundColor(Color.CYAN);
                        break;
                    case 6:
                        command_button_2.setBackgroundColor(Color.BLUE);
                    case 7:
                        command_button_2.setBackgroundColor(Color.BLACK);
                    case 8:
                        command_button_2.setBackgroundColor(Color.GRAY);
                        break;
                }
                switch(commandList.get(2)){
                    case 0:
                        command_button_2.setBackgroundColor(Color.YELLOW);
                        break;
                    case 1:
                        command_button_2.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        command_button_2.setBackgroundColor(Color.MAGENTA);
                        break;
                    case 3:
                        command_button_2.setBackgroundColor(Color.LTGRAY);
                        break;
                    case 4:
                        command_button_2.setBackgroundColor(Color.GREEN);
                        break;
                    case 5:
                        command_button_2.setBackgroundColor(Color.CYAN);
                        break;
                    case 6:
                        command_button_2.setBackgroundColor(Color.BLUE);
                    case 7:
                        command_button_2.setBackgroundColor(Color.BLACK);
                    case 8:
                        command_button_2.setBackgroundColor(Color.GRAY);
                        break;
                }
                switch(commandList.get(3)){
                    case 0:
                        command_button_2.setBackgroundColor(Color.YELLOW);
                        break;
                    case 1:
                        command_button_2.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        command_button_2.setBackgroundColor(Color.MAGENTA);
                        break;
                    case 3:
                        command_button_2.setBackgroundColor(Color.LTGRAY);
                        break;
                    case 4:
                        command_button_2.setBackgroundColor(Color.GREEN);
                        break;
                    case 5:
                        command_button_2.setBackgroundColor(Color.CYAN);
                        break;
                    case 6:
                        command_button_2.setBackgroundColor(Color.BLUE);
                    case 7:
                        command_button_2.setBackgroundColor(Color.BLACK);
                    case 8:
                        command_button_2.setBackgroundColor(Color.GRAY);
                        break;
                }
                switch(commandList.get(4)){
                    case 0:
                        command_button_2.setBackgroundColor(Color.YELLOW);
                        break;
                    case 1:
                        command_button_2.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        command_button_2.setBackgroundColor(Color.MAGENTA);
                        break;
                    case 3:
                        command_button_2.setBackgroundColor(Color.LTGRAY);
                        break;
                    case 4:
                        command_button_2.setBackgroundColor(Color.GREEN);
                        break;
                    case 5:
                        command_button_2.setBackgroundColor(Color.CYAN);
                        break;
                    case 6:
                        command_button_2.setBackgroundColor(Color.BLUE);
                    case 7:
                        command_button_2.setBackgroundColor(Color.BLACK);
                    case 8:
                        command_button_2.setBackgroundColor(Color.GRAY);
                        break;
                }
                command_button_3.setVisibility(View.VISIBLE);
                command_button_4.setVisibility(View.VISIBLE);
                break;
           /* case 4:
                switch(commandList.get(0)){

                }
                switch(commandList.get(1)){

                }
                switch(commandList.get(2)){

                }
                switch(commandList.get(3)){

                }
                switch(commandList.get(4)){

                }
                switch(commandList.get(5)){

                }
                command_button_3.setVisibility(View.VISIBLE);
                command_button_4.setVisibility(View.VISIBLE);
                command_button_5.setVisibility(View.VISIBLE);
                break;
            case 5:
                switch(commandList.get(0)){

                }
                switch(commandList.get(1)){

                }
                switch(commandList.get(2)){

                }
                switch(commandList.get(3)){

                }
                switch(commandList.get(4)){

                }
                switch(commandList.get(5)){

                }
                command_button_3.setVisibility(View.VISIBLE);
                command_button_4.setVisibility(View.VISIBLE);
                command_button_5.setVisibility(View.VISIBLE);
                command_button_6.setVisibility(View.VISIBLE);
                break;
            case 6:
                command_button_3.setVisibility(View.VISIBLE);
                command_button_4.setVisibility(View.VISIBLE);
                command_button_5.setVisibility(View.VISIBLE);
                command_button_6.setVisibility(View.VISIBLE);
                command_button_7.setVisibility(View.VISIBLE);
                break;
            case 7:
                command_button_3.setVisibility(View.VISIBLE);
                command_button_4.setVisibility(View.VISIBLE);
                command_button_5.setVisibility(View.VISIBLE);
                command_button_6.setVisibility(View.VISIBLE);
                command_button_7.setVisibility(View.VISIBLE);
                command_button_8.setVisibility(View.VISIBLE);
                break;*/
            //TODO: GAME OVER?

        }
    }
    public void set(Button command_button, int color){

        switch(color){

            case 1:
                command_button = (Button) findViewById(R.id.command_button_0);
                command_button.setBackgroundColor(Color.YELLOW);
                break;
            case 2:
                command_button = (Button) findViewById(R.id.command_button_1);
                command_button.setBackgroundColor(Color.RED);
                break;
            case 3:
                command_button = (Button) findViewById(R.id.command_button_2);
                command_button.setBackgroundColor(Color.MAGENTA);
                break;
            case 4:
                command_button = (Button) findViewById(R.id.command_button_3);
                command_button.setBackgroundColor(Color.LTGRAY);
                break;
            case 5:
                command_button = (Button) findViewById(R.id.command_button_4);
                command_button.setBackgroundColor(Color.GREEN);
                break;
            case 6:
                command_button = (Button) findViewById(R.id.command_button_5);
                command_button.setBackgroundColor(Color.CYAN);
                break;
            case 7:
                command_button = (Button) findViewById(R.id.command_button_6);
                command_button.setBackgroundColor(Color.BLUE);
            case 8:
                command_button = (Button) findViewById(R.id.command_button_7);
                command_button.setBackgroundColor(Color.BLACK);
            case 9:
                command_button = (Button) findViewById(R.id.command_button_8);
                command_button.setBackgroundColor(Color.GRAY);
                break;
        }
    }
    public void displayLevel(){
        TextView levelTextView = (TextView) findViewById(R.id.level_text);
        levelTextView.setText("Level: " + currentLevel);
    }
    public void updateLevel(int newLevel){
        this.currentLevel = newLevel;
    }

    public void startGame(View v){
        Intent i = new Intent(getBaseContext(), Board.class);
        // Sends data to Board Activity
        extraInfo = new Bundle();
        extraInfo.putInt("CURRENT_LEVEL", currentLevel);
        extraInfo.putInt("NUM_OF_COMMANDS", numOfCommands);
        i.putExtras(extraInfo);
        startActivity(i);
    }

}
