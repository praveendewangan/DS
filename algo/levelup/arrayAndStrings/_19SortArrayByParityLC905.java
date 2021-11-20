import java.util.*;

public class _19SortArrayByParityLC905 {

    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    
    public static void sortArrayByParity(int[] nums) {
        int i = 0;
        int j = 0;
        while(i < nums.length) {
            if(nums[i] % 2 == 1) {
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
    }

    //// ~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        sortArrayByParity(arr);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}