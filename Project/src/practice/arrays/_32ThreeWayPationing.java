package practice.arrays;

public class _32ThreeWayPationing {
    public void threeWayPartition(int arr[], int a, int b)
    {
        int l = 0;
        int r = arr.length-1;
        for(int i=0; i<=r;i++) {
            if(arr[i] < a) {
                int temp = arr[i];
                arr[i] = arr[l];
                arr[l] = temp;
                l++;
            } else if(arr[i] > b) {
                int temp = arr[i];
                arr[i] = arr[r];
                arr[r] = temp;
                r--;
                i--;
            }
        }
    }
}
