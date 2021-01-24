package practice.arrays;

import java.util.PriorityQueue;
import java.util.Queue;
/*
* Move all the negative elements to one side of the array
 *
* */
public class _5MoveAllNegativeOneSide {
    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        while (pq.size() != 0) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();
        int j = -1;
        int[] a = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
//        for (int i = 0; i < a.length; i++) {
//            if(i != 0 && a[i] < 0) {
//                int temp = a[i];
//                a[i] = a[j];
//                a[j] = temp;
//                if(a[j + 1] > 0) {
//                    j = j + 1;
//                } else {
//                    j = i;
//                }
//            } else if (a[i] > 0 && j == -1){
//                j = i;
//            }
//        }
        int k=0,temp;
        for(int i=0; i < a.length; j++) {
            if(a[i] < 0){
                if(i != k) {
                    temp = a[i];
                    a[i] = a[k];
                    a[k] = temp;
                }
                k++;
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
