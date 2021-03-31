package practice.stackAndQueue;

import java.util.*;

public class _26InterleaveQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        int len = q.size();
        int nh = (len+1)/2;
        Queue<Integer> lq = new ArrayDeque<>();
        Queue<Integer> rq = new ArrayDeque<>();
        while(nh != 0) {
            lq.add(q.remove());
            nh--;
        }

        while (q.size() != 0) {
            rq.add(q.remove());
        }

        while(lq.size() != 0 && rq.size() != 0){
            q.add(lq.remove());
            q.add(rq.remove());
        }

        while(lq.size() != 0) {
            q.add(lq.remove());
        }

        while(rq.size() != 0) {
            q.add(rq.remove());
        }
        System.out.println(q);
    }       
}
