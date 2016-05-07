package edu.csumb.colore.colore;

import java.util.Stack;

/**
 * Created by anitagarcia on 5/5/16.
 */
public class Node {
    private int priorityValue;
    private int frequency;
    private int color;

    private Stack<Integer> colors;

    public Node(){
        this.priorityValue = -1;
        this.color = -1;
        this.frequency = -1;
        colors = new Stack<Integer>();
    }
    public Node(int initPriorityValue, int initColor, int frequency){
        this.priorityValue = initPriorityValue;
        this.color = initColor;
        this.frequency = frequency;
        colors = new Stack<Integer>();
    }
    public void addColor(int color){
        colors.push(color);
    }
    public void deleteColor(int color){
        if(!colors.isEmpty())
            colors.pop();
    }
    public int getColor(int color){
        if(!colors.isEmpty())
            return colors.peek();
        return -1;
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
        return "Value: " + priorityValue + " Frequency: " + frequency + " Color(#): " + color + " /n";
    }
}
