package edu.csumb.colore.colore;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    private static String[] colors = {"red", "blue", "green","yellow","orange","X", "Y", "Z", "9"};
    private ArrayList<Integer> commandList = new ArrayList<Integer>();
  //  private ArrayList<String> colorList = new ArrayList<String>();
    private HashMap<Integer, ArrayList<Integer>> tileFrequency = new HashMap<Integer, ArrayList<Integer>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        heapTree = new HeapTree();
        heapTree.updateSize(numOfCommands);

        // Sends data to Board Activity
        i = new Intent(this, Board.class);
        extraInfo = new Bundle();
        extraInfo.putDouble("currentLevel", currentLevel);
        i.putExtras(extraInfo);

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
        String color;
        int priorityValue;
        int frequency;

        generateTileFrequency();
        // Select random color && select # of values
        for(int i = 0; i < numOfCommands; i++){
            priorityValue =  getRandomNumber();
            while(commandList.contains(priorityValue)){
                priorityValue = getRandomNumber();
            }
            commandList.add(priorityValue);
            color = colors[priorityValue];
            frequency = tileFrequency.get(numOfCommands).get(i);
            heapTree.add(priorityValue, frequency, color);
        }
    }
    public int getRandomNumber(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(NUM_TILES + 1);// 0 - 9
    }
    public int getRandomTileNumber(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(THRESHOLD) + 1; //  1 - threshold
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
                break;
            case 2:
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
    public void displayLevel(){
        TextView levelTextView = (TextView) findViewById(R.id.level_text);
        levelTextView.setText("Level: " + currentLevel);
    }
    public void updateLevel(int newLevel){
        this.currentLevel = newLevel;
    }

}
