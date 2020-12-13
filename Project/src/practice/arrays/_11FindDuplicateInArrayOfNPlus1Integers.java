package practice.arrays;


/*Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

        There is only one duplicate number in nums, return this duplicate number.

        Follow-ups:

        How can we prove that at least one duplicate number must exist in nums?
        Can you solve the problem without modifying the array nums?
        Can you solve the problem using only constant, O(1) extra space?
        Can you solve the problem with runtime complexity less than O(n2)?


        Example 1:

        Input: nums = [1,3,4,2,2]
        Output: 2*/
public class _11FindDuplicateInArrayOfNPlus1Integers {
    public static void main(String[] args) {
        int[] a = {3,1,3,4,2,2};
        int n = a.length;

        for (int i = 0; i < n; i++) {
            if(a[Math.abs(a[i])-1] >= 0) {
                a[Math.abs(a[i]) - 1] = - a[Math.abs(a[i]) - 1];
            } else {
                System.out.println(Math.abs(a[i]));
            }
        }
    }
}
