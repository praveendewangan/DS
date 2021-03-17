package practice.greedy;

import java.util.Arrays;

public class _1NMeetingsInOneRoom {
    // O(nLogn),O(n)
    static class Pair implements Comparable<Pair>{
        int start;
        int end;
        int idx;
        Pair(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }
        public int compareTo(Pair o){
            if(this.end < o.end) {
                return -1;
            } else if(this.end > o.end) {
                return 1;
            } else if(this.idx < o.idx){
                return -1;
            } else {
                return 1;
            }
        }
    }
    public static int maxMeetings(int start[], int end[], int n) {
        Pair[] pairs = new Pair[n];
        for(int i=0;i<n;i++){
            pairs[i] = new Pair(start[i],end[i],i);
        }
        Arrays.sort(pairs);
        int count = 1;
        int endtime = pairs[0].end;
        for(int i=1;i<n;i++) {
            if(pairs[i].start > endtime){
                endtime = pairs[i].end;
                count++;
            }
        }
        return count;
    }
}
