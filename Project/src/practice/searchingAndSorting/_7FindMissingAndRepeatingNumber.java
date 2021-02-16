package practice.searchingAndSorting;

public class _6FindMissingAndRepeatingNumber {
    int[] findTwoElement(int arr[], int n) {
        int x = 0;
        int y = 0;
        int xor = 0;
        for(int i=0;i<n;i++) {
            xor ^= arr[i]; 
        }
        for(int i=1;i<=n;i++) {
            xor ^= i;
        }
        int rsb = xor & -xor;
        for(int val : arr){
            if((val & rsb) == 0) {
                x ^= val;
            } else {
                y ^= val;
            }
        }
        for(int i=1;i<=n;i++){
            if((i & rsb) == 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        for(int val : arr) {
            if(val == y) {
                int temp = x;
                x = y;
                y = temp;
            }
        }
        
        
        return new int[]{x,y};
    }
}
