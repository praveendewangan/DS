package practice.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _20CheckIfArrayIsTackPermutationOfOther {
    // O(n),O(n)
    public static void main(String[] args)
    {
        // Input Queue
        int input[] = { 1, 2, 3 };
  
        // Output Queue
        int output[] = { 2, 1, 3 };
        int n = 3;
        if (checkStackPermutation(input, output, n))
            System.out.println("Yes");
        else
            System.out.println("Not Possible");
    }

    private static boolean checkStackPermutation(int[] a,int[] b,int n) {
        Queue<Integer> ip = new LinkedList<>();
        Queue<Integer> op = new LinkedList<>();
        for(int num : a) {
            ip.add(num);
        }
        for(int num : b) {
            op.add(num);
        }
        Stack<Integer> st = new Stack<>();

        while(!ip.isEmpty()) {
            int num = ip.remove();
            if(num == op.peek()) {
                op.remove();
                while(!st.isEmpty()) {
                    if(st.peek() == op.peek()) {
                        st.pop();
                        op.remove();
                    } else {
                        break;
                    }
                }
            } else {
                st.push(num);
            }
        }
        return (ip.isEmpty() && op.isEmpty());
    }
}
