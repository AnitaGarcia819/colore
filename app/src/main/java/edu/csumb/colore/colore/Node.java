package edu.csumb.colore.colore;

/**
 * Created by anitagarcia on 5/5/16.
 */
public class Node {
    private int priorityValue;
    private int frequency;
    private int color;
    public Node(int initPriorityValue, int frequency, int initColor){
        priorityValue = initPriorityValue;
        setFrequency(frequency);
        setColor(initColor);
    }
    public int getPriorityValue(){
        return priorityValue;
    }
    public int getFrequency(){
        return frequency;
    }
    public int getColor() {return color;}
    public void setPriorityValue(int priorityValue){
        this.priorityValue = priorityValue;
    }
    public void setFrequency(int frequency){
        this.frequency = frequency;
    }
    public void setColor(int color){
        this.color = color;
    }
    public String toString(){
        return "Value: " + priorityValue + " Frequency: " + frequency + " Color: " + color + " /n";
    }
}
