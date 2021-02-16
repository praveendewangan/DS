package practice.searchingAndSorting;

import java.util.Arrays;

public class _13CountTripletWIthSumSmallerThanGivenValue {
    // O(n^2),O(1)
    long countTriplets(long arr[], int n,int sum)
    {
        Arrays.sort(arr);
        int count = 0;
        for(int i=0;i<n-2;i++){
            int j = i+1;
            int k = n-1;
            while(j < k){
                int total = (int) arr[i] + (int) arr[j] + (int) arr[k];
                if(total >= sum){
                    k--;
                } else {
                    // Total count i,j and between j & k
                    count += (k - j); 
                    j++;
                }
            }
        }
        return (long)count;
    }
}
