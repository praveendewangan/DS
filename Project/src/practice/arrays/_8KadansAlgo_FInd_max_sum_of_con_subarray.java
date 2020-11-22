package practice.arrays;


/*Input:
        N = 4
        arr[] = {-1,-2,-3,-4}
  Output: -1
        Explanation: Max subarray sum is -1
        of element (-1)*/
public class _8KadansAlgo_FInd_max_sum_of_con_subarray {
    public static void main(String[] args) {
        int n = 5;
        int[] a = {1 ,2 ,3 ,-2 ,5};

        int msf = Integer.MIN_VALUE;
        int meh = 0;
        for (int i = 0; i < n; i++) {
            meh = meh + a[i];
            if(meh < a[i]) {
                meh = a[i];
            }
            if(msf < meh) {
                msf = meh;
            }
        }
        System.out.println(msf);
    }
}
