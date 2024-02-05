package Greedy;

import java.util.Arrays;

public class FractionalKnapsack {
    static class Item{
        int value;
        int weight;
        Item(int value, int weight){
            this.value = value;
            this.weight = weight;
        }
    }
    static class Tuple implements Comparable<Tuple>{
        int value,weight;
        double valuePerWeight;
        Tuple(int value, int weight, double valuePerWeight){
            this.value = value;
            this.weight = weight;
            this.valuePerWeight = valuePerWeight;
        }
        @Override
        public int compareTo(Tuple o) {
            return Double.compare(this.valuePerWeight, o.valuePerWeight);
        }
    }
    public static void main(String[] args) {
        int N = 2;
        int W = 50;
        int[] value = {60,100};
        int[] weight = {10,20};
        Item[] items = new Item[value.length];
        for(int i = 0; i < items.length; i++){
            items[i] = new Item(value[i], weight[i]);
        }
        double totalWeight = fractionalKnapsack(W, items, N);
        System.out.println("value = " + totalWeight);
    }
    public static double fractionalKnapsack(int W, Item[] arr, int n){
        Tuple[] tuples = new Tuple[arr.length];
        for(int i = 0; i < tuples.length; i++){
            tuples[i] = new Tuple(arr[i].value, arr[i].weight, (double) arr[i].value /(double) arr[i].weight);
        }
        Arrays.sort(tuples);
        int i = tuples.length-1;
        double value = 0;
        while (i >= 0 && W > 0){
            Tuple tuple = tuples[i];
            // if we can pick this tuple
            if(W - tuple.weight >= 0){
                W = W - tuple.weight;
                value += tuple.value;
            }
            // if we can't pick. We will pick fractional
            else {
                double valueOfFraction = tuple.valuePerWeight*W;
                W -= tuple.weight;
                value += valueOfFraction;
            }
            i--;

        }
        return value;
    }

}
