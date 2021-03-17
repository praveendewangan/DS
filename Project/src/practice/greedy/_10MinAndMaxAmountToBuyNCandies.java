package practice.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class _10MinAndMaxAmountToBuyNCandies {
    // O(nlogn),O(1)
    static ArrayList<Integer> candyStore(int candies[],int N,int K){
        Arrays.sort(candies);
        int min = 0;
        int n1 = N;
        for(int i=0;i<n1;i++){
            min += candies[i];
            n1 = n1 - K;
        }
        
        int max = 0;
        int n2 = N;
        int index = 0;
        for(int i=n2-1;i >= index;i--){
            max = max + candies[i];
            index = index + K;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(min);
        list.add(max);
        return list;
    }
}
