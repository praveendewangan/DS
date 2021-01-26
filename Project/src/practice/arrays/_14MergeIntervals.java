package practice.arrays;

import java.util.Arrays;
import java.util.Stack;

public class _14MergeIntervals {
    public static void main(String[] args) {
        int[][] m = {{1,3},{2,6},{8,10},{15,18}};
        merge(m);
//        Output: [[1,6],[8,10],[15,18]]
    }
    public static int[][] merge(int[][] arr) {
        int len = arr.length;
        Pair[] pairs = new Pair[len];
        for(int i=0; i < len; i++){
            pairs[i] = new Pair(arr[i][0],arr[i][1]);
        }
        Arrays.sort(pairs);
        Stack<Pair> st = new Stack<>();
        for(int i=0; i < len; i++){
            if(i == 0){
                st.push(pairs[i]);
            } else {
                Pair top = st.peek();
                if(pairs[i].st > top.et){
                    st.push(pairs[i]);
                } else {
                    top.et = Math.max(pairs[i].et , top.et);
                }
            }
        }
        int[][] res = new int[st.size()][2];
        for(int i=st.size()-1;i >= 0;i--){
            Pair rm = st.pop();
            res[i][0] = rm.st;
            res[i][1] = rm.et;
        }
        return res;
    }

    public static class Pair implements Comparable<Pair>{
        int st;
        int et;

        Pair(int st,int et) {
            this.st = st;
            this.et = et;
        }

        public int compareTo(Pair o){
            if(this.st != o.st){
                return this.st - o.st;
            } else {
                return this.et - o.et;
            }
        }
    }
}
