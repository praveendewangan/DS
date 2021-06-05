public class _1LargestMountainLC845 {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int max = 0;
        for(int i = 1; i < n-1;){
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                int j = i;
                int c = 1;
                while(j > 0 && arr[j] > arr[j-1]){
                    j--;
                    c++;
                }
                
                while(i < n-1 && arr[i] > arr[i+1]){
                    i++;
                    c++;
                }
                max = Math.max(max,c);
            } else {
                i++;
            }
        }
        return max;
    }
}
