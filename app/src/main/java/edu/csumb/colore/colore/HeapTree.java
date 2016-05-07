package edu.csumb.colore.colore;

/**
 * Created by anitagarcia on 5/5/16.
 */
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

    public static boolean isHeap(){
        for(int i = SIZE/2; i > 0 ; i--){
            // Checks last parent node
            // Will only check left child if # of elements (nodes + 1) is odd
            if(i == SIZE/2 && SIZE % 2 == 0){
                // If left child is larger than parent, return false
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
    public HeapTree(){

    }

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
    }
    public static void display(){
        for(int i = 1; i < heap.size(); i++){
            System.out.print(heap.get(i));
        }
        System.out.println();
    }
    public static void add(int nodeValue, int frequency, int color){

        heap.add(new Node(nodeValue, frequency, color));
        SIZE++;
        heapify();
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
}