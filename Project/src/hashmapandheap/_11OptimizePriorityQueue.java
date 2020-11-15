package hashmapandheap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class _11OptimizePriorityQueue {
    private static class PriorityQueue<T> {
        List<T> data;
        Comparator comp;
        public PriorityQueue(){
            data = new ArrayList<>();
            comp = null;
        }
        public PriorityQueue(Comparator comp){
            data = new ArrayList<>();
            this.comp = comp;
        }
        private boolean isSmaller(int i, int j) {
            if (comp == null) {
                Comparable ith = (Comparable) data.get(i);
                Comparable jth = (Comparable) data.get(j);
                if(ith.compareTo(jth) < 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                T ith =  data.get(i);
                T jth =  data.get(j);
                if(comp.compare(ith,jth) < 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        public PriorityQueue(T[] arr){
            data = new ArrayList<>();
            for (T val : arr) {
                data.add(val);
            }
            for (int i = data.size() / 2 - 1 ; i >= 0 ; i--) {
                downheapify(i);
            }
        }

        public void add(T val){
            data.add(val);
            upheapify(size() - 1);
        }
        private void upheapify(int i) {
            if(i == 0) {
                return;
            }
            int pi = (i - 1) / 2;
            if(isSmaller(i,pi)) {
                swap(i,pi);
                upheapify(pi);
            }
        }
        private void swap(int i,int j){
            T ith = data.get(i);
            T jth = data.get(j);
            data.set(i,jth);
            data.set(j,ith);
        }
        public T remove() {
            if(data.size() == 0) {
                System.out.println("Under flow");
                return null;
            }
            swap(0,data.size() - 1);
            T val = data.remove(data.size() - 1);
            downheapify(0);
            return val;
        }
        private void downheapify(int pi) {

            int min = pi;
            int li = 2 * pi + 1;
            if(li < data.size() && isSmaller(li,min)) {
                min = li;
            }

            int ri = 2 * pi + 2;
            if(ri < data.size() && isSmaller(ri,pi)) {
                min = ri;
            }

            if(min != pi) {
                swap(pi,min);
                downheapify(min);
            }
        }
        public T peek() {
            if(data.size() == 0) {
                System.out.println("Under flow");
                return null;
            }
            return data.get(0);
        }
        public int size() {
            return data.size();
        }
    }
    public static void main(String[] args) throws IOException {}
}
