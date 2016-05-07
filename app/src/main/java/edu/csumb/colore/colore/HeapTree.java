package edu.csumb.colore.colore;

/**
 * Created by anitagarcia on 5/5/16.
 */
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * Title: Heap.java
 * Abstract: This program will
 * verify if an array representation of a
 * heap tree is in fact a heap tree or not.
 * The heap array will be filled in with
 * values from a file. The user will be
 * able to add to the heap tree, while still
 * ensuring that the tree is a heap and they will be
 * able to delete the max while still ensuring it is a heap tree.
 * Author: Anita Garcia
 * ID: 7777
 * Date: 4/15/16
 */

public class HeapTree {

    private static ArrayList<Node> heap = new ArrayList<Node>();
    private static int SIZE = 0;
    private static int numOfCommands = 0;
    public HeapTree(int numOfNodes){
        numOfCommands = numOfNodes;
        heap.add(new Node());

    }

    public static boolean isHeap(){
        for(int i = SIZE/2; i > 0 ; i--){
            // Checks last parent node
            // Will only check left child if # of elements (nodes + 1) is odd
            if(i == SIZE/2 && SIZE % 2 == 0){
                // If left child is larger than parent, return false
                   // Log.d("isHeap", " "+ heap.size() + " vs. "+ i * 2);
                    if(heap.get(i * 2).getPriorityValue() > heap.get(i).getPriorityValue()){
                        return false;
                    }

            }
            // Check if right or left child is larger than parent
            else if(heap.get(i * 2 + 1).getPriorityValue() > heap.get(i).getPriorityValue()
                    || heap.get(i * 2 ).getPriorityValue() > heap.get(i).getPriorityValue()){
                return false;
            }
        }
        return true;
    }

        /*
    public static void heapify(){
        while(!isHeap()){
            for(int i = SIZE/2; i > 0 ; i--){
                // Checks last parent node
                // Will only check left child if # of elements (nodes + 1) is odd
                if(i == SIZE/2 && SIZE % 2 == 0){
                    // If left child is larger than parent, return false
                    if(heap.get(i * 2).getPriorityValue() > heap.get(i).getPriorityValue()){
                        // Swap with parent
                        int temp = heap.get(i * 2).getPriorityValue();
                        heap.set(i * 2,heap.get(i));
                        heap.get(i).setPriorityValue(temp);
                        //heap.set(i,temp);
                    }
                }
                // Check if right or left child is larger than parent
                else if(heap.get(i * 2 + 1).getPriorityValue() > heap.get(i).getPriorityValue()
                        || heap.get(i * 2).getPriorityValue() > heap.get(i).getPriorityValue()){
                    // Find biggest of the two and swap with parent
                    // If left is larger, swap with parent
                    if(heap.get(i * 2).getPriorityValue() > heap.get(i * 2 + 1).getPriorityValue()){
                        int temp = heap.get(i * 2).getPriorityValue();
                        heap.set(i * 2,heap.get(i));
                        //heap.set(i,temp);
                        heap.get(i).setPriorityValue(temp);
                    }
                    // If left is larger, swap with parent
                    else if (heap.get(i * 2 + 1).getPriorityValue() > heap.get(i * 2).getPriorityValue()){
                        int temp = heap.get(i * 2 + 1).getPriorityValue();
                        heap.set((i * 2 + 1),heap.get(i));
                        //heap.set(i,temp);
                        heap.get(i).setPriorityValue(temp);
                    }
                }

            }// Ends for loop
        }// Ends while loop
    }*/
    public static void heapify(){
        while(!isHeap()){
            for(int i = SIZE/2; i > 0 ; i--){
                // Checks last parent node
                // Will only check left child if # of elements (nodes + 1) is odd
                if(i == SIZE/2 && SIZE % 2 == 0){
                    // If left child is larger than parent, return false
                    if(heap.get(i * 2).getPriorityValue() > heap.get(i).getPriorityValue()){
                        // Swap with parent
                        Node temp = heap.get(i * 2);
                        heap.set(i * 2,heap.get(i));
                        heap.set(i, temp);
                        //heap.remove(i * 2);
                    }
                }
                // Check if right or left child is larger than parent
                else if(heap.get(i * 2 + 1).getPriorityValue() > heap.get(i).getPriorityValue()
                        || heap.get(i * 2).getPriorityValue() > heap.get(i).getPriorityValue()){
                    // Find biggest of the two and swap with parent
                    // If left is larger, swap with parent
                    if(heap.get(i * 2).getPriorityValue() > heap.get(i * 2 + 1).getPriorityValue()){
                        Node temp = heap.get(i * 2);
                        heap.set(i * 2,heap.get(i));
                        heap.set(i,temp);
                    }
                    // If left is larger, swap with parent
                    else if (heap.get(i * 2 + 1).getPriorityValue() > heap.get(i * 2).getPriorityValue()){
                        Node temp = heap.get(i * 2 + 1);
                        heap.set((i * 2 + 1),heap.get(i));
                        heap.set(i,temp);
                    }
                }

            }// Ends for loop
        }// Ends while loop
    }

    public static void add(int priorityVaule, int color, int frequency){
        Log.d("SIZE(under the hood): ", " " + SIZE);
        heap.add(new Node(priorityVaule, color, frequency));
        SIZE++;
        // Add colors into stack
        for(int i = 0; i < frequency; i++){
            heap.get(SIZE).addColor(color);
        }
        Log.d("add (beforeHeapify)"," "+ heap.get(SIZE) );
        display();
        Log.d("add (success)", "===================");

        heapify();
        display();
        Log.d("add (afterHeapify)"," "+ heap.get(SIZE) );

    }
    public static void deleteMax(){
        if(SIZE >=1){
            heap.set(1, heap.get(SIZE));
            heap.remove(SIZE);
            SIZE--;
            heapify();
        }
        else{
            System.out.println("Sorry, no more nodes to delete");
        }
    }
    public static void updateSize(int newSize){
        SIZE = newSize;
    }
    public static void getFrequency(){

    }
    public static void display(){
        Log.d("SIZE: ", " " + SIZE);
        for(int i = 0; i <= SIZE; i++){
            Log.d("NODE["+i+"]: ", " " + heap.get(i));
        }
        Log.d("HEAP SIZE: ", " " + heap.size());

    }
    public int getSize(){
        return SIZE;
    }
    public void reset(){
        for(int i = 0; i <= SIZE; i++){
            heap.set(i, new Node());
        }
    }
}