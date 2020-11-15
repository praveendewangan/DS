package hashmapandheap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _9PriorityQueueUsingHeap {
    private static class PriorityQueue {
        List<Integer> data;
        public PriorityQueue(){
            data = new ArrayList<>();
        }

        public PriorityQueue(int[] arr){
            data = new ArrayList<>();
            for (int val : arr) {
                data.add(val);
            }
            for (int i = data.size() / 2 - 1 ; i >= 0 ; i--) {
                downheapify(i);
            }
        }

        public void add(int val){
            data.add(val);
            upheapify(size() - 1);
        }
        private void upheapify(int i) {
            if(i == 0) {
                return;
            }
            int pi = (i - 1) / 2;
            if(data.get(i) < data.get(pi)) {
                swap(i,pi);
                upheapify(pi);
            }
        }
        private void swap(int i,int j){
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i,jth);
            data.set(j,ith);
        }
        public int remove() {
            if(data.size() == 0) {
                System.out.println("Under flow");
                return -1;
            }
            swap(0,data.size() - 1);
            int val = data.remove(data.size() - 1);
            downheapify(0);
            return val;
        }
        private void downheapify(int pi) {

            int min = pi;
            int li = 2 * pi + 1;
            if(li < data.size() && data.get(li) < data.get(min)) {
                min = li;
            }

            int ri = 2 * pi + 2;
            if(ri < data.size() && data.get(ri) < data.get(min)) {
                min = ri;
            }

            if(min != pi) {
                swap(pi,min);
                downheapify(min);
            }
        }
        public int peek() {
            if(data.size() == 0) {
                System.out.println("Under flow");
                return -1;
            }
            return data.get(0);
        }
        public int size() {
            return data.size();
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue pq = new PriorityQueue();
        String str = br.readLine();
        while (str.equals("quit") == false) {
            if(str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                pq.add(val);
            } else if(str.startsWith("remove")) {
                int val = pq.remove();
                if(val != -1) {
                    System.out.println(val);
                }
            } else if(str.startsWith("peek")) {
                int val = pq.peek();
                if(val != -1) {
                    System.out.println(val);
                }
            } else if(str.startsWith("size")) {
                System.out.println(pq.size());
            }
            str = br.readLine();
        }
    }
}
