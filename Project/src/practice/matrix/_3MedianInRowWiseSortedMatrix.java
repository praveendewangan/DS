package practice.matrix;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _3MedianInRowWiseSortedMatrix {

    // Eficient approch O(n),O(n^2);

        
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    void add(int val){
        if(right.size() > 0 && val > right.peek()){
            right.add(val);
        } else {
            left.add(val);
        }
        
        if(left.size() - right.size() == 2) {
            right.add(left.remove());
        } else if(right.size() - left.size() == 2) {
            left.add(right.remove());
        }
    }
    
    int remove() {
        if(this.size() == 0) {
            return -1;
        } else if(left.size() >= right.size()){
            return left.remove();
        } else {
            return right.remove();
        }
    }
    int peek(){
        if(this.size() == 0) {
            return -1;
        } else if(left.size() >= right.size()){
            return left.peek();
        } else {
            return right.peek();
        }
    }
    int size(){
        return left.size() + right.size();
    }
int median(int matrix[][], int r, int c) {
    left = new PriorityQueue<>(Collections.reverseOrder());
    right = new PriorityQueue<>();
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++) {
            add(matrix[i][j]);
        }
    }
    return remove();
}



    // Broot Force O(n^2) ,O(r*c)
    int median1(int matrix[][], int r, int c) {
        int[] a = new int[r*c];
        int x = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++) {
                a[x] = matrix[i][j];
                x++;
            }
        }
        Arrays.sort(a);
        if(a.length % 2 == 0){
            return (a[a.length/2] + a[(a.length/2) - 1])/2;
        } else {
            return a[a.length/2];
        }
    }
}
