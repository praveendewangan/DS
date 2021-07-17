package practice.arrays;

public class _23SubarrayProductMax{
    long maxProduct(int[] arr, int n) {
        long product = arr[0];
        long min = arr[0];
        long max = arr[0];
        for(int i=1; i < n; i++){
            // if(arr[i] < 0) {
            //     long temp = min;
            //     min = max;
            //     max = temp;
            // }
            // max = Math.max(arr[i],max*arr[i]);
            // min = Math.min(arr[i],min*arr[i]);
            // if(max > product){
            //     product = max;
            // }

            if(arr[i] == 0) {
                max = 1;
                min = 1;
                continue;
            } else {
                long temp = Math.max(arr[i],Math.max(max*arr[i],min*arr[i]));
                min = Math.min(arr[i],Math.min(max*arr[i],min*arr[i]));
                max = temp;
            }
            if(max > product){
                product = max;
            }
        }
        return product;
    }
}