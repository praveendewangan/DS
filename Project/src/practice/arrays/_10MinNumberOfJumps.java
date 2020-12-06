package practice.arrays;



/*Given an array of integers where each element represents the max number of steps that can be made forward from that element. Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.

    Input:
        The first line contains an integer T, depicting total number of test cases.  Then following T lines contains a number n denoting the size of the array. Next line contains the sequence of integers a1, a2, ..., an.

    Output:
        For each testcase, in a new line, print the minimum number of jumps. If answer is not possible print -1.

        Constraints:
        1 ≤ T ≤ 100
        1 ≤ N ≤ 107
        0 <= ai <= 107

Example:
    Input:
        2
        11
        1 3 5 8 9 2 6 7 6 8 9
        6
        1 4 3 2 6 7
    Output:
        3
        2*/
public class _10MinNumberOfJumps {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int n = 11;
        System.out.println(minJump(a,n));
    }
    private static int minJump(int[] a ,int n) {
        int maxR = a[0];
        int step = a[0];
        int jump = 1;
        if(n == 1) {
            return 0;
        } else if(a[0] == 0) {
            return -1;
        } else {
            for (int i = 1; i < n; i++) {
                if(i == n-1) {
                    return jump;
                }
                maxR = Math.max(maxR,i+a[i]);
                step--;
                if(step == 0) {
                    jump++;
                    if(i >= maxR) {
                        return -1;
                    }
                    step = maxR-i;
                }
            }
        }
        return -1;
    }
}
