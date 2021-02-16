package practice.searchingAndSorting;

import java.util.ArrayList;

public class _2ValueEqualToIndexValue {
    // O(n),O(1)
    ArrayList<Integer> valueEqualToIndex(int arr[], int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while(i < n) {
            if(arr[i]-1 == i) {
                list.add(arr[i]);
            }
            i++;
        }
        return list;
    }   
}
