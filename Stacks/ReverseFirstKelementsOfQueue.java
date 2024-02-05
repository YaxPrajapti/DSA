package Stacks;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

import Arrays.sort2DArray;

public class ReverseFirstKelementsOfQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(); 
        Integer[] arr = {1,2,3,4,5}; 
        q.addAll(Arrays.asList(arr));
        q = modifyQueue(q, 3);  
        for(Integer i : q){
            System.out.print(i + " ");
        }
    }
    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k){
        Queue<Integer> tempQueue = new LinkedList<>(); 
        Stack<Integer> tempStack = new Stack<>();
        for(int i = 0; i < k; i++){
            tempStack.push(q.poll()); 
        } 
        while (!q.isEmpty()) {
            tempQueue.add(q.poll()); 
        }
        while (!tempStack.isEmpty()) {
            q.add(tempStack.pop()); 
        }
        while (!tempQueue.isEmpty()) {
            q.add(tempQueue.poll()); 
        }
        return q; 
    }
}
