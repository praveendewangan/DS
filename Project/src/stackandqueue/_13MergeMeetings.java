package stackandqueue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
* 1. You are given a number n, representing the number of time-intervals.
2. In the next n lines, you are given a pair of space separated numbers.
3. The pair of numbers represent the start time and end time of a meeting (first number is start time and second number is end time)
4. You are required to merge the meetings and print the merged meetings output in increasing order of start time.

E.g. Let us say there are 6 meetings
1 8
5 12
14 19
22 28
25 27
27 30

Then the output of merged meetings will belongs
1 12
14 19
22 30

Note -> The given input maynot be sorted by start-time.
*
* Constraints
    1 <= n <= 10^4
    0 <= ith start time < 100
    ith start time < ith end time <= 100
*
    Sample Input
        6
        22 28
        1 8
        25 27
        14 19
        27 30
        5 12
    Sample Output
        1 12
        14 19
        22 30
* */
public class _13MergeMeetings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = scn.nextInt();
            a[i][1] = scn.nextInt();
        }
        mergeOverlapping(a);
    }

    private static void mergeOverlapping(int[][] a) {
        Pair[] pairs = new Pair[a.length];
        for (int i = 0; i < a.length; i++) {
            pairs[i] = new Pair(a[i][0],a[i][1]);
        }
        Arrays.sort(pairs);
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < pairs.length; i++) {
            if(i == 0) {
                st.push(pairs[i]);
            } else {
                Pair top = st.peek();
                if(pairs[i].st > top.et) {
                    st.push(pairs[i]);
                } else {
                    top.et = Math.max(top.et,pairs[i].et);
                }
            }
        }
        Stack<Pair> rs = new Stack<>();
        while (st.size() > 0) {
            rs.push(st.pop());
        }
        while (rs.size() > 0) {
            Pair p = rs.pop();
            System.out.println(p.st + " - " + p.et);
        }
    }

    public static class Pair implements Comparable<Pair>{
        int st;
        int et;

        Pair(int st,int et) {
            this.st = st;
            this.et = et;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.st != o.st) {
                return this.st - o.st;
            } else {
                return this.et - o.et;
            }
        }
    }
}
