package practice.searchingAndSorting;

import java.util.Arrays;

public class _17SortBySetBitCount {
    // O(nLogN),O(1)

    static void sortBySetBitCount(Integer arr[], int n)
    { 
        // Arrays.sort(arr,new Comparator<Integer>() {
        //     public int compare(Integer a,Integer b) {
        //         int c1 = countBit(a);
        //         int c2 = countBit(b);
        //         if(c1 <= c2){
        //             return 1;
        //         }
        //         return -1;
        //     }
        // });
        Arrays.sort(arr,(a, b) -> -Integer.compare(Integer.bitCount(a), Integer.bitCount(b)));
    } 
    static int countBit(final int a) {
        int n = new Integer(a);
        int count = 0;
        while(n != 0) {
            int rsb = n & -n;
            n = n - rsb;
            count++;
        }
        return count;
    }
}
