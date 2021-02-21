package practice.searchingAndSorting;

public class _18MinSwapToSortArray {
    // O(n^2),O(1)
    public int minSwaps(int nums[])
    {
        int count = 0;
        int n = nums.length;
        for(int i=0;i<n-1;i++) {
            int val = nums[i];
            int k = -1;
            for(int j = i+1;j<n;j++){
                if(val > nums[j]){
                    val = nums[j];
                    k = j;
                }
            }
            if(k != -1) {
                int t = nums[k];
                nums[k] = nums[i];
                nums[i] = t;
                count++;
                k = -1;
                
            }
        }
        return count;
    }
}
