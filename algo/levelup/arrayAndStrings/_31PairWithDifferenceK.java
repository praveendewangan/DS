import java.util.*;

public class _31PairWithDifferenceK {
    public boolean findPair(int arr[], int size, int n)
    {
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        while(i < size && j < size) {
            
            int dif = arr[j] - arr[i];
            if(i != j && dif == n){
                return true;
            } else if(dif > n) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }
}
