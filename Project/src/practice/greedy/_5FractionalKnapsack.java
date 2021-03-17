package practice.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class _5FractionalKnapsack {
    // O(nlogn),O(1)
    static class Item {
        int value;
        int weight;
    }
    double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr,new Comparator<Item>(){
           public int compare(Item a,Item b) {
               double n1 = (double)(a.value) / (double)(a.weight); 
               double n2 = (double)(b.value) / (double)(b.weight);
               if(n1 > n2) {
                   return -1;
               } else if(n1 < n2) {
                   return 1;
               } else {
                   return 0;
               }
           } 
        });
        int curWeight = 0;
        double finalValue = 0.0;
        for(int i=0;i<n;i++) {
            if(curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalValue += arr[i].value;
            } else {
                int remain = W - curWeight;
                finalValue += ((double)arr[i].value / 
                (double)arr[i].weight) * (double)remain;
                break;
            }
        }
        return finalValue;
    }
}
